package ru.hogwarts.school.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;


    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping
    @Operation(summary = "Returns all faculty", tags = "faculty")
    public Collection<Faculty> getAllFacyltys() {
        return this.facultyService.getAll();
    }

    @GetMapping("/search/{searchString}")
    public Faculty findFacultyByNameorColor(@PathVariable("searchString") String searchString){
        return this.facultyService.finByNameOrColor(searchString);
    }

    @PostMapping
    @Operation(summary = "Create Faculty", tags = "faculty")
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return this.facultyService.create(faculty);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Faculty", tags = "faculty")
    public Faculty updateFaculty(@PathVariable("id") long id, @RequestBody Faculty faculty) {
        return this.facultyService.update(id, faculty);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete faculty", tags = "faculty")
    public Faculty removeFaculty(@PathVariable("id") Long id) {
        return facultyService.remove(id);
    }
}

