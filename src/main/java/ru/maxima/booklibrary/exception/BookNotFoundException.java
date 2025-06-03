package ru.maxima.booklibrary.exception;

/*
 * Класс обработки ошибки при поиске книги
 *
 * @author Sindicat
 */
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Книга с id " + id + " не найдена");
    }
}
