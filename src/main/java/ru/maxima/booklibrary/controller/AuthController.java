package ru.maxima.booklibrary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.booklibrary.entity.User;
import ru.maxima.booklibrary.service.UserService;


/*
 * Контроллер авторизации
 *
 * @author Sindicat
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registredUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(registredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User userLogin = userService.getUser(user).get();
        return ResponseEntity.ok(userLogin);
    }
}
