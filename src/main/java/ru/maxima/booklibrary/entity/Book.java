package ru.maxima.booklibrary.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/*
 * Сущность Книги
 *
 * @author Sindicat
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private Integer yearOfPublication;
    private String annotation;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime removedAt;
    private String createdUser;
    private String updatedUser;
    private String removedUser;
    private Integer howManyCopies;
    private Integer copiesAvailable;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
