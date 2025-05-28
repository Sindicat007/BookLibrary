package ru.maxima.booklibrary.restController;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Контроллер, предназначенный для работы с админами.
 *
 * @author Sindicat
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/home")
    public String getAdminData() {
        return "Hi admin";
    }
}
