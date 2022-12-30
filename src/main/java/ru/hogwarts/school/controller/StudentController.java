package ru.hogwarts.school.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;


import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @Operation(summary = "Return all Students", tags = "Student")
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
    public Integer findByAge() {
        return studentService.findByAge();
    }

    @GetMapping("/student/getStudentById")
    public List<Student> getStudentById(){
        return studentService.getStudentById();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return this.studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        return this.studentService.editStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") long id) {
        studentService.removeStudent(id);
        return ResponseEntity.ok().build();
    }
}
