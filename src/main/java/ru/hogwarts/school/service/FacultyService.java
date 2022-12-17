package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.ObjectNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Collection<Faculty> gerAll() {
        return this.facultyRepository.findAll();
    }

    public Faculty create(Faculty faculty) {
        return this.facultyRepository.save(faculty);
    }

    public Faculty update(Long id, Faculty faculty) {
        Faculty dbFaculty = this.facultyRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        dbFaculty.setName(faculty.getName());
        dbFaculty.setColor(faculty.getColor());
        return this.facultyRepository.save(dbFaculty);
    }

    public Faculty remove(long id) {
        Faculty dbFaculty = this.facultyRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        this.facultyRepository.delete(dbFaculty);
        return dbFaculty;
    }

    public Faculty finByNameOrColor(String nameOrColor) {
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(nameOrColor, nameOrColor).orElseThrow(ObjectNotFoundException::new);

    }
}