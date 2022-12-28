package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findByAge(int age);

    List<Student> findByAgeBetween(int minAge, int maxAge);

    @Query(value = "SELECT count (*) FROM Student ", nativeQuery = true)
    Integer getAllByName();

    @Query(value = "SELECT avg (age) from student", nativeQuery = true)
    Integer findByAge();

    @Query(value = "SELECT * From student order by id desc limit 5", nativeQuery = true)
    List<Student> findStudentById();

}
