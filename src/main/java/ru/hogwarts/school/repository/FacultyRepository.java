package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Faculty;


import java.util.Optional;

@Repository

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Optional<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);

}
