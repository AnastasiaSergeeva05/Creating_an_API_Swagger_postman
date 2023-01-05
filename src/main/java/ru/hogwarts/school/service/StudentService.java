package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.ObjectNotFoundException;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    public List<String> getAllstudentStartWitchLetter(String letter) {
        LOG.info("Method was called getAllstudentStartWitchLetter ");
        return studentRepository.findAll()
                .parallelStream()
                .filter(student -> student.getName().startsWith(letter.toUpperCase()))
                .map(student -> student.getName().toUpperCase())
                .collect(Collectors.toList());


    }

    public Student addStudent(Student student) {
        LOG.info("Method was called addStudent");
        return this.studentRepository.save(student);
    }

    public Student editStudent(Long id, Student student) {
        LOG.info("Method was called editStudent");
        Student dbStudent =
                this.studentRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        dbStudent.setName(student.getName());
        dbStudent.setAge(student.getAge());
        return this.studentRepository.save(dbStudent);


    }

    public Collection<Student> getAll() {
        LOG.info("Method was called getAll");
        return studentRepository.findAll();
    }

    public Student getStudent(long id) {
        LOG.info("Method was called getStudent");
        return studentRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
    }

    public void removeStudent(long id) {
        LOG.info("Method was called removeStudent");
        studentRepository.deleteById(id);
    }

    public Collection<Student> getByAge(int age) {
        LOG.info("Method was called getByAge");
        return studentRepository.findByAge(age);

    }

    public Collection<Student> findStudentByAge(int minAge, int maxAge) {
        LOG.info("Method was called findStudentByAge");
        return this.studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public Integer getAllByName() {
        LOG.info("Method was called getAllName");
        return studentRepository.getAllByName();
    }


    public Integer findByAge() {
        LOG.info("Method was called findByAge");
        return studentRepository.findByAge();
    }

    public List<Student> getStudentById() {
        LOG.info("Method was called getStudentById");
        return studentRepository.findStudentById();
    }

    public double getAverageAgeOfAllStudents() {
        LOG.info("Method was called getAverageAgeOfAllStudents");
        return studentRepository.findAll()
                .stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
    }

    public void printStudentSinhronaized(Student student, Student student2) {
        System.out.println(student.getName());
        System.out.println(student2.getName());
    }

    public synchronized void printAllStudentSinhronaizedMethod() {
        List<Student> students = studentRepository.findAll();
        printStudentSinhronaized(students.get(1), students.get(2));

        new Thread(() -> {
            printStudentSinhronaized(students.get(3), students.get(4));
        }).start();

        new Thread(() -> {
            printStudentSinhronaized(students.get(5), students.get(6));
        }).start();

    }

    public void printAllStudentParalelMethod() {

        List<Student> students = studentRepository.findAll();
        printStudentParallel(students.get(0));
        printStudentParallel(students.get(1));

        new Thread(() -> {
            printStudentParallel(students.get(3));
            printStudentParallel(students.get(4));
        }).start();

        new Thread(() -> {
            printStudentParallel(students.get(5));
            printStudentParallel(students.get(6));
        }).start();

    }

    public void printStudentParallel(Student student) {
        System.out.println(student.getName());
   
    }
}
