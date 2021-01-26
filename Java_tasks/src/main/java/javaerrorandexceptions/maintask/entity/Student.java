package javaerrorandexceptions.maintask.entity;

import java.util.Map;
import java.util.Objects;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private Map<DisciplineNames, Integer> grades;

    public Student(int id, String firstName, String lastName, Map<DisciplineNames, Integer> grades) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<DisciplineNames, Integer> getGrades() {
        return grades;
    }

    public void setGrades(Map<DisciplineNames, Integer> grades) {
        this.grades = grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, grades);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("studentId=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", grades=").append(grades);
        sb.append('}');
        return sb.toString();
    }
}
