package javaerrorandexceptions.maintask;

import javaerrorandexceptions.maintask.entity.*;

import java.util.ArrayList;
import java.util.List;

public class UniversityService {
    public static List<Student> getAllStudents(University university) {
        List<Student> allStudents = new ArrayList<>();
        for (Faculty faculty : university.getFaculties()) {
            for (Group group : faculty.getGroups()) {
                allStudents.addAll(group.getStudents());
            }
        }
        return allStudents;
    }

    public static List<Group> getAllGroups(University university) {
        List<Group> allGroups = new ArrayList<>();
        for (Faculty faculty : university.getFaculties()) {
            allGroups.addAll(faculty.getGroups());
        }
        return allGroups;
    }

    public static double calculateStudentAverageGrade(Student student) {
        double average = 0;
        for (Integer value : student.getGrades().values()) {
            average += value;
        }
        average /= student.getGrades().size();
        return average;
    }

    public static double calculateGroupAverageGrade(Group group, DisciplineNames discipline) {
        double average = 0;
        int count = 0;
        for (Student student : group.getStudents()) {
            if (student.getGrades().containsKey(discipline)) {
                average += student.getGrades().get(discipline);
                count++;
            }
        }
        average /= count;
        return average;
    }

    public static double calculateAverageGradeByUniversity(List<Student> students, DisciplineNames discipline) {
        double average = 0;
        int count = 0;
        for (Student student : students) {
            if (student.getGrades().containsKey(discipline)) {
                average += student.getGrades().get(discipline);
                count++;
            }
        }
        average /= count;
        return average;
    }
}
