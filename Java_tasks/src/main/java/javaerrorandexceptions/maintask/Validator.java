package javaerrorandexceptions.maintask;

import javaerrorandexceptions.maintask.entity.Faculty;
import javaerrorandexceptions.maintask.entity.Group;
import javaerrorandexceptions.maintask.entity.Student;
import javaerrorandexceptions.maintask.entity.University;
import javaerrorandexceptions.maintask.entity.exception.*;

import java.util.List;

public class Validator {

    public static void disciplinesValidation(List<Student> students) {
        for (Student student : students) {
            if (student.getGrades().isEmpty()) {
                throw new GradesNotFoundException("Student has no disciplines! Student Id: " + student.getId());
            }
        }
    }

    public static void gradesValidation(List<Student> students) {
        for (Student student : students) {
            for (Integer grade : student.getGrades().values()) {
                if (grade > 10 || grade <= 0) {
                    throw new IllegalArgumentException("Grade not in range from 1 to 10! Value: " + grade);
                }
            }
        }
    }

    public static void groupsValidation(List<Group> groups) {
        for (Group group : groups) {
            if (group.getStudents().isEmpty()) {
                throw new StudentsNotFountException("Group are empty! Group number: " + group.getNumber());
            }
        }
    }

    public static void facultyValidation(List<Faculty> faculties) {
        for (Faculty faculty : faculties) {
            if (faculty.getGroups().isEmpty()) {
                throw new GroupsNotFoundException("Faculty contains no groups! Faculty name: " + faculty.getName());
            }
        }
    }

    public static void universityValidation(University university) {
        if (university.getFaculties().isEmpty()) {
            throw new FacultiesNotFoundException("University contains no faculties!");
        }
    }
}
