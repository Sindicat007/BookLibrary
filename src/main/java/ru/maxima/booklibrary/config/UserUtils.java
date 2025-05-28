package ru.maxima.booklibrary.config;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

/*
 * Получение текущего пользователя и текущего времени
 *
 * @author Sindicat
 */
public class UserUtils {

    public static String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        }
        return principal.toString();
    }

    public static LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }
}
