package ru.maxima.booklibrary.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.maxima.booklibrary.entity.User;
import ru.maxima.booklibrary.repository.UserRepository;

import java.util.Optional;

/*
 * Кастомная реализация сервиса аутентификации пользователя.
 *
 * @author Sindicat
 */
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);

        return user.map(MyUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден: " + username));

    }
}
