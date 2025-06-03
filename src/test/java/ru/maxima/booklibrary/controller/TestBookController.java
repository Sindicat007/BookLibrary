package ru.maxima.booklibrary.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import ru.maxima.booklibrary.config.PostgresDbTestcontainers;
import ru.maxima.booklibrary.entity.Book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Тестирование контроллера для работы с книгами
 *
 * @author Sindicat
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Тестирование контроллера для работы с книгами")
@Import(PostgresDbTestcontainers.class)
public class TestBookController {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Получение всех книг")
    void testGetAllBooks() {

        var books = restTemplate.getForEntity(
                "http://localhost:8081/books",
                Book[].class
        );
        assertEquals(HttpStatus.OK, books.getStatusCode());
        Book[] booksArray = books.getBody();
        assertThat(booksArray).isNotNull();
        assertEquals(3, booksArray.length);
    }

}
