package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.ObjectNotFoundException;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public Student editStudent(Long id, Student student) {
        Student dbStudent =
                this.studentRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        dbStudent.setName(student.getName());
        dbStudent.setAge(student.getAge());
        return this.studentRepository.save(dbStudent);


    }

    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getStudent(long id) {
        return studentRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public void removeStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getByAge(int age) {
        return studentRepository.findByAge(age);

    }

    public Collection<Student> findStudentByAge(int minAge, int maxAge) {
        return this.studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public Integer getAllByName() {
        return studentRepository.getAllByName();
    }


    public Integer findByAge() {
        return studentRepository.findByAge();
    }

    public List<Student> getStudentById() {
        return studentRepository.findStudentById();
    }
}
