package ru.maxima.booklibrary.controller;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.maxima.booklibrary.config.PostgresDbTestcontainers;
import ru.maxima.booklibrary.entity.Book;
import ru.maxima.booklibrary.service.BookService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Тестирование контроллера для работы с книгами")
public class TestBookController extends PostgresDbTestcontainers {


    @Autowired
    private BookController bookController;

    @Test
    @DisplayName("Получение всех книг")
    void testGetAllBooks() {

        List<Book> books = bookController.getAllBooks().getBody();

        assertThat(books).isNotNull();
        assertEquals(3, books.size());
    }

    @Test
    @DisplayName("Получение книги по id")
    void testGetTaskById() {

        Book bookById = bookController.getBookById(2L).getBody().orElse(null);
        assertThat(bookById).isNotNull();
        assertEquals(2, bookById.getId());

    }

    @Test
    @DisplayName("Добавление книги")
    void testAddBook() {

        Book book = new Book();
        book.setName("Book test");
        book.setAuthor("Author test");
        book.setYearOfPublication(2020);
        bookController.addBook(book);

        assertThat(book).isNotNull();
        assertEquals(4, book.getId());
    }

    @Test
    @DisplayName("Удаление книги")
    void testDeleteBook() {
        if (bookController.deleteBookById(3L).getStatusCode().is2xxSuccessful()) {
            assertEquals(2, bookController.getAllBooks().getBody().size());
        }
    }
}
