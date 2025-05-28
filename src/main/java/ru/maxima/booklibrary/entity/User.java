package ru.maxima.booklibrary.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/*
 * Сущность Пользователя
 *
 * @author Sindicat
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private Integer age;
    private String email;
    private String phoneNumber;
    private String password;
    private String roles;
    private LocalDateTime createdAt;
    private LocalDateTime removedAt;
    private String createdUser;
    private String removedUser;

    @OneToMany(mappedBy = "user")
    private List<Book> books;

}
