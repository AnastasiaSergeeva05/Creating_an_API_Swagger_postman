package ru.hogwarts.school.model;

import java.util.Objects;

public class Faculty {

    private  Student name;
    private Long id;
    private String color;

    public Faculty(Student name, Long id, String color) {
        this.name = name;
        this.id = id;
        this.color = color;
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
