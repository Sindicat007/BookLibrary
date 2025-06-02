package ru.maxima.booklibrary.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import ru.maxima.booklibrary.config.PostgresDbTestcontainers;
import ru.maxima.booklibrary.entity.Book;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Тестирование репозитория для работы с книгами
 *
 * @author Sindicat
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Тестирование репозитория для работы с пользователями")
@Import(PostgresDbTestcontainers.class)
class TestBookRepository {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("Получение списка книг")
    void shouldGetList() {
        List<Book> books = bookRepository.findAll();

        assertThat(books).isNotEmpty();
        assertEquals(2, books.size());
    }

    @Test
    @DisplayName("Получение книги по id")
    void shouldGetBook() {
        Book book = bookRepository.findById(2L).orElse(null);

        assertThat(book).isNotNull();
        assertEquals(2, book.getId());
    }

    @Test
    @DisplayName("Получение книги по имени")
    void shouldGetByName() {
        Book book = bookRepository.findByName("Book 2").orElse(null);

        assertThat(book).isNotNull();
        assertEquals("Book 2", book.getName());
    }

}