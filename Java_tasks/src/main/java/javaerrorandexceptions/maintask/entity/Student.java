package javaerrorandexceptions.maintask.entity;

import java.util.Map;
import java.util.Objects;

public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private Map<DisciplineNames, Integer> grades;

    public Student(int studentId, String firstName, String lastName, Map<DisciplineNames, Integer> grades) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
        return studentId == student.studentId && Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstName, lastName, grades);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("studentId=").append(studentId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", grades=").append(grades);
        sb.append('}');
        return sb.toString();
    }
}
