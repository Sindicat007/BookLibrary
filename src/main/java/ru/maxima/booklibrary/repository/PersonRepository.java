package ru.maxima.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxima.booklibrary.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
