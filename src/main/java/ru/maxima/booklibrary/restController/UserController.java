package ru.maxima.booklibrary.restController;

//import org.springframework.security.access.prepost.PreAuthorize;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maxima.booklibrary.entity.User;
//import ru.maxima.booklibrary.service.UserService;

import java.util.List;

/*
 * Контроллер, предназначенный для работы с пользователями.
 *
 * @author Sindicat
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/home")
    public String getUserData() {
        return "Hi user!";
    }

//    private final UserService userService;

//    @GetMapping
//    public List<User> getAllUsersWithBooks() {
//        return userService.getAllUsersWithBooks();
//    }
}
