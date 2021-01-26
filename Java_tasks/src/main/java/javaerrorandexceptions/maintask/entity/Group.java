package javaerrorandexceptions.maintask.entity;

import java.util.List;
import java.util.Objects;

public class Group {
    List<Student> students;
    private int number;
    private int course;

    public Group(List<Student> students, int number, int course) {
        this.students = students;
        this.number = number;
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return number == group.number && course == group.course && students.equals(group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, number, course);
    }

}
