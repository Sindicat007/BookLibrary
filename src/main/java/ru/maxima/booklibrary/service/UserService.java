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
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Пользователь с таким именем уже существует.");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Transactional
    public User getUser(User user) {
        return userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким именем не существует."));
    }

}

