package ru.maxima.booklibrary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.booklibrary.entity.User;
import ru.maxima.booklibrary.repository.BookRepository;
import ru.maxima.booklibrary.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/*
 * Сервис для работы с пользователями
 *
 * @author Sindicat
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public List<User> getAllUsersWithBooks() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setBooks(bookRepository.findByUserId(user.getId()));
        }
        return users;
    }

    @Transactional
    public User createUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Пользователь с таким именем уже существует.");
        }
    }

    @Transactional
    public Optional<User> getUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return userRepository.findByUsername(user.getUsername());
        } else {
            throw new UsernameNotFoundException("Пользователь с таким именем не существует.");
        }
    }
}
