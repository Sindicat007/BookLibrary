package ru.maxima.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.booklibrary.entity.User;

import java.util.Optional;

/*
 * Репозиторий для работы с пользователями.
 *
 * @author Sindicat
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
