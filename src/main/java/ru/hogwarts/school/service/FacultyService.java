package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.ObjectNotFoundException;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    private static final Logger LOG = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Collection<Faculty> getAll() {
        LOG.info("Method was called getAll");
        return this.facultyRepository.findAll();
    }

    public Faculty create(Faculty faculty) {
        LOG.info("Method was called create");
        return this.facultyRepository.save(faculty);
    }

    public Faculty update(Long id, Faculty faculty) {
        LOG.info("Method was called update");
        Faculty dbFaculty = this.facultyRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        dbFaculty.setName(faculty.getName());
        dbFaculty.setColor(faculty.getColor());
        return this.facultyRepository.save(dbFaculty);
    }

    public Faculty remove(long id) {
        LOG.info("Method was called remove");
        Faculty dbFaculty = this.facultyRepository.findById(id).orElseThrow(ObjectNotFoundException::new);
        this.facultyRepository.delete(dbFaculty);
        return dbFaculty;
    }

    public Faculty finByNameOrColor(String nameOrColor) {
        LOG.info("Method was called finByNameOrColor");
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(nameOrColor, nameOrColor).orElseThrow(ObjectNotFoundException::new);

    }
}