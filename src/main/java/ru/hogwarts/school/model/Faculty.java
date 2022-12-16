package ru.hogwarts.school.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Faculty {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    private Student name;

    private String color;

    public Faculty(Student name, Long id, String color) {
        this.name = name;
        this.id = id;
        this.color = color;
    }

    public Faculty() {

    }

    public Student getName() {
        return name;
    }

    public void setName(Student name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) && Objects.equals(id, faculty.id) && Objects.equals(color, faculty.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, color);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name=" + name +
                ", id=" + id +
                ", color='" + color + '\'' +
                '}';
    }
}
