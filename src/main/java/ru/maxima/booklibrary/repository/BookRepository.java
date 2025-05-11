package ru.maxima.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.booklibrary.entity.Book;


public interface BookRepository extends JpaRepository<Book, Integer> {
}
