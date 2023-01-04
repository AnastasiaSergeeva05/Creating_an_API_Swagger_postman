package ru.hogwarts.school.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;


import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @Operation(summary = "Return all Students", tags = "student")
    public Collection<Student> getAll() {
        return this.studentService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Return by id Student", tags = "student")
    public Student getByid(@PathVariable("id") long id) {
        return this.studentService.getStudent(id);
    }

    @GetMapping("/age/{age}")
    public Collection<Student> getStudentByAge(@PathVariable("id") int age) {
        return this.studentService.getByAge(age);
    }


    @GetMapping("/age/between")
    public Collection<Student> findStudentByAge(@RequestParam("minAge") int minAge, @RequestParam("maxAge") int maxAge) {
        return this.studentService.findStudentByAge(minAge, maxAge);
    }

    @GetMapping("/student/getAll")
    public Integer getAllByName() {
        return studentService.getAllByName();
    }

    @GetMapping("/student/findByAge")
    @Operation(summary = "Find by age", tags = "student")
    public Integer findByAge() {
        return studentService.findByAge();
    }

    @GetMapping("/student/getStudentById")
    @Operation(summary = "Get student by id", tags = "student")
    public List<Student> getStudentById() {
        return studentService.getStudentById();
    }


    @GetMapping("/studentStartWitch")
    @Operation(summary = " Get student<A> ", tags = "student")
    public ResponseEntity<List<String>> getAllstudentStartWitchLetter(@RequestParam String letter) {
        return ResponseEntity.ok(studentService.getAllstudentStartWitchLetter(letter));
    }

    @GetMapping("/studentAverAgeAgeOfAllstudents")
    @Operation(summary = "Get all student Average", tags = "student")
    public ResponseEntity<Double>getAverageAgeOfAllStudents(){
        return ResponseEntity.ok(studentService.getAverageAgeOfAllStudents());
    }

    @PostMapping
    @Operation(summary = "Create Student", tags = "student")
    public Student createStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }


    @GetMapping("/returnInteger")
    @Operation(summary = "return Integer", tags = "student")
    Integer returnInteger() {
        return Stream.iterate(1, a -> a + 1).limit(1_000_000)
                .parallel().reduce(0, (a, b) -> a + b);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        return this.studentService.editStudent(id, student);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Student", tags = "student")
    public ResponseEntity deleteStudent(@PathVariable("id") long id) {
        studentService.removeStudent(id);
        return ResponseEntity.ok().build();
    }
}
