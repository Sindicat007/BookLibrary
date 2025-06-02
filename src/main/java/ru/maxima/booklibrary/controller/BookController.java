package ru.maxima.booklibrary.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.maxima.booklibrary.entity.Book;
import ru.maxima.booklibrary.service.BookService;

import java.net.URI;
import java.util.List;

/*
 * Контроллер для работы с книгами.
 *
 * @author Sindicat
 */
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/coverBook/{id}")
    public ResponseEntity<String> getCoverBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookCover(id));
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/assign/{id}")
    public ResponseEntity<String> assignBookToCurrentUser(@PathVariable("id") Long bookId) {
        log.info("Запрос на передачу книги с ID {} текущему пользователю", bookId);
        bookService.assignBookToCurrentUser(bookId);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Void> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity
                .created(URI.create("/books/" + book.getId()))
                .build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBookById(@PathVariable Long id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Book>> getBooksByUser(@PathVariable Long userId) {
        log.info("Запрос на получение книг для пользователя с ID {}", userId);
        return ResponseEntity.ok(bookService.getBooksByUser(userId));
    }


}
