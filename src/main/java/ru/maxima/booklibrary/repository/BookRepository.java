package ru.maxima.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.booklibrary.entity.Book;

import java.util.List;
import java.util.Optional;

/*
 * Репозиторий для работы с книгами.
 *
 * @author Sindicat
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByUserId(Long id);

    Optional<Book> findByName(String name);
}
