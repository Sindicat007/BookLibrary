package ru.maxima.booklibrary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maxima.booklibrary.entity.Book;
import ru.maxima.booklibrary.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

//    public List<Book> getAllBooks() {
//
//    }
}
