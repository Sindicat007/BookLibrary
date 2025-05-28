package ru.maxima.booklibrary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.booklibrary.config.UserUtils;
import ru.maxima.booklibrary.entity.Book;
import ru.maxima.booklibrary.entity.User;
import ru.maxima.booklibrary.exception.BookNotFoundException;
import ru.maxima.booklibrary.repository.BookRepository;
import ru.maxima.booklibrary.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/*
 * Сервис для работы с книгами
 *
 * @author Sindicat
 */
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Transactional
    public void addBook(Book book) {
        Optional<Book> existingBook = bookRepository.findByName(book.getName());
        if (existingBook.isPresent()) {
            throw new IllegalArgumentException("Книга с названием '" + book.getName() + "' уже существует");
        }

        book.setCreatedUser(UserUtils.getCurrentUsername());
        book.setCreatedAt(UserUtils.getCurrentTime());
        bookRepository.save(book);
    }

    @Transactional
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public List<Book> getBooksByUser(Long userId) {
        if (userId == null) {
            throw new IllegalArgumentException("Не указан id пользователя");
        }
        return bookRepository.findByUserId(userId);
    }

    @Transactional
    public void deleteBookById(Long id) {
        Book book = findBookById(id);
        book.setRemovedAt(UserUtils.getCurrentTime());
        book.setRemovedUser(UserUtils.getCurrentUsername());
        bookRepository.deleteById(id);
    }

    @Transactional
    public Book getBookById(Long id) {
        return findBookById(id);
    }

    @Transactional
    public void assignBookToCurrentUser(Long id) {
        String username = UserUtils.getCurrentUsername();
        Book book = findBookById(id);
        User user = findByUsername(username);

        if (book.getUser() != null) {
            throw new IllegalArgumentException("Книга уже принадлежит пользователю " +
                    book.getUser().getUsername());
        }

        changeCopiesAvailable(book, user);
        bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Long id, Book book) {
        findBookById(id);
        book.setUpdatedAt(UserUtils.getCurrentTime());
        book.setUpdatedUser(UserUtils.getCurrentUsername());
        book.setId(id);
        bookRepository.save(book);
    }

    @Transactional
    public String getBookCover(Long id) {
        Book book = findBookById(id);
        return String.format("%s %s %d",
                book.getAuthor(),
                book.getName(),
                book.getYearOfPublication());

    }

    private Book findBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    private User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с username " + username + " не найден"));
    }

    private Book changeCopiesAvailable(Book book, User user) {
        if (book.getCopiesAvailable() > 0) {
            book.setCopiesAvailable(book.getCopiesAvailable() - 1);
            book.setUser(user);
            return book;
        } else {
            throw new IllegalArgumentException("Книга недоступна для выдачи");
        }
    }
}
