package javaclasses.maintask;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sorter {

    private Sorter() {
    }

    public static List<Student> byFaculty(Student[] students, String faculty) {
        List<Student> sorted = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty)) {
                sorted.add(student);
            }
        }
        if (sorted.isEmpty()) {
            System.out.println("There are no students at such a faculty");
        }
        return sorted;
    }

    public static List<Student> byFacultyAndCourse(Student[] students, String faculty, int course) {
        List<Student> sorted = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getCourse() == course) {
                sorted.add(student);
            }
        }
        if (sorted.isEmpty()) {
            System.out.println("There are no students at such a faculty and course");
        }
        return sorted;
    }

    public static List<Student> byYear(Student[] students, LocalDate dateOfBirthday) {
        List<Student> sorted = new ArrayList<>();
        for (Student student : students) {
            if (student.getDateOfBirthday().isAfter(dateOfBirthday)) {
                sorted.add(student);
            }
        }
        if (sorted.isEmpty()) {
            System.out.println("There are no students born after set year");
        }
        return sorted;
    }

    public static List<Student> ByGroup(Student[] students, int group) {
        List<Student> sorted = new ArrayList<>();
        for (Student student : students) {
            if (student.getGroup() == group) {
                sorted.add(student);
            }
        }
        if (sorted.isEmpty()) {
            System.out.println("There is no such a group, or group are empty");
        }
        return sorted;
    }
}
