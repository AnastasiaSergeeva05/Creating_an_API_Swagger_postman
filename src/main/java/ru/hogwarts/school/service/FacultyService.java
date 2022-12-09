package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.FacultyNotFoundException;
import ru.hogwarts.school.exception.StudentNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
@Service

public class FacultyService {

    private long counter = 0L;

    private final Map<Long, Faculty> facultys = new HashMap<>();


    public Faculty addFaculty(Faculty faculty) {
        Long newId = this.counter++;
        facultys.put(newId, faculty);
        return faculty;
    }

    public Faculty editFaculty(Long id, Faculty faculty) {
        if (this.facultys.containsKey(id)) {
            Faculty oldFaculty = this.facultys.get(id);
            oldFaculty.setColor(faculty.getColor());
            oldFaculty.setName(faculty.getName());
            return oldFaculty;

        } else {
            throw new FacultyNotFoundException();
        }
    }

    public Collection<Faculty> gerAll() {
        return this.facultys.values();
    }

    public Faculty getFaculty(long id) {
        if (this.facultys.containsKey(id)) {
            return this.facultys.get(id);
        } else {
            throw new FacultyNotFoundException();
        }
    }

    public void removeFaculty(long id) {
        if (this.facultys.containsKey(id)) {
            this.facultys.remove(id);
        } else {
            throw new FacultyNotFoundException();
        }
    }
}