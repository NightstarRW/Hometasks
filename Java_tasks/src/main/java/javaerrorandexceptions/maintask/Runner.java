package javaerrorandexceptions.maintask;

import javaerrorandexceptions.maintask.entity.*;

import java.util.*;

public class Runner {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final Map<DisciplineNames, Integer> STUD_ONE_GRADES = new HashMap<DisciplineNames, Integer>() {{
        put(DisciplineNames.MATHEMATICS, 9);
        put(DisciplineNames.PROGRAMMING, 5);
        put(DisciplineNames.DESIGN, 8);
        put(DisciplineNames.PHYSICS, 7);
    }};
    private static final Map<DisciplineNames, Integer> STUD_TWO_GRADES = new HashMap<DisciplineNames, Integer>() {{
        put(DisciplineNames.MATHEMATICS, 7);
        put(DisciplineNames.PROGRAMMING, 9);
        put(DisciplineNames.DESIGN, 8);
        put(DisciplineNames.PHYSICS, 8);
    }};
    private static final Map<DisciplineNames, Integer> STUD_THREE_GRADES = new HashMap<DisciplineNames, Integer>() {{
        put(DisciplineNames.MATHEMATICS, 8);
        put(DisciplineNames.PROGRAMMING, 10);
        put(DisciplineNames.DESIGN, 7);
        put(DisciplineNames.PHYSICS, 10);
    }};
    private static final Map<DisciplineNames, Integer> STUD_FOUR_GRADES = new HashMap<DisciplineNames, Integer>() {{
        put(DisciplineNames.BIOLOGY, 4);
        put(DisciplineNames.CHEMISTRY, 4);
        put(DisciplineNames.MATHEMATICS, 5);
        put(DisciplineNames.PHYSICS, 2);
    }};
    private static final Map<DisciplineNames, Integer> STUD_FIVE_GRADES = new HashMap<DisciplineNames, Integer>() {{
        put(DisciplineNames.BIOLOGY, 9);
        put(DisciplineNames.CHEMISTRY, 8);
        put(DisciplineNames.MATHEMATICS, 10);
        put(DisciplineNames.PHYSICS, 8);
    }};
    private static final Map<DisciplineNames, Integer> STUD_SIX_GRADES = new HashMap<DisciplineNames, Integer>() {{
        put(DisciplineNames.BIOLOGY, 4);
        put(DisciplineNames.CHEMISTRY, 7);
        put(DisciplineNames.MATHEMATICS, 8);
        put(DisciplineNames.PHYSICS, 9);
    }};
    private static final List<Student> STUDENTS_ONE = Arrays.asList(
            new Student(1, "Bob", "Daniels", STUD_ONE_GRADES),
            new Student(2, "Richard", "Roland", STUD_TWO_GRADES),
            new Student(3, "Andy", "Turner", STUD_THREE_GRADES)
    );
    private static final List<Student> STUDENTS_TWO = Arrays.asList(
            new Student(4, "John", "Smith", STUD_FOUR_GRADES),
            new Student(5, "Tom", "Carry", STUD_FIVE_GRADES),
            new Student(6, "William", "Gosling", STUD_SIX_GRADES)
    );
    private static final List<Group> GROUP_ONE = Collections.singletonList(
            new Group(STUDENTS_ONE, 111, 1)
    );
    private static final List<Group> GROUP_TWO = Collections.singletonList(
            new Group(STUDENTS_TWO, 113, 3)
    );
    private static final List<Faculty> FACULTIES = Arrays.asList(
            new Faculty(FacultyNames.CIT, GROUP_ONE),
            new Faculty(FacultyNames.CSAN, GROUP_TWO)
    );
    private static final University UNIVERSITY = new University("UUTICS", FACULTIES);

    public static void main(String[] args) {
        try {
            Validator.gradesValidation(UniversityService.getAllStudents(UNIVERSITY));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            Validator.disciplinesValidation(UniversityService.getAllStudents(UNIVERSITY));
            Validator.groupsValidation(UniversityService.getAllGroups(UNIVERSITY));
            Validator.facultyValidation(UNIVERSITY.getFaculties());
            Validator.universityValidation(UNIVERSITY);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println("Enter a number to show: 1 for student average grade, " +
                "2 for discipline average grade on group, 3 for discipline average grade on university ");
        int input = SCANNER.nextInt();
        switch (input) {
            case 1:
                System.out.println("Enter student id: ");
                int studentId = SCANNER.nextInt();
                for (Student student : UniversityService.getAllStudents(UNIVERSITY)) {
                    if (student.getStudentId() == studentId) {
                        UniversityService.calculateAndPrintStudentAverageGrade(student);
                    }
                }
                break;
            case 2:
                System.out.println("Enter the faculty: ");
                Enum<FacultyNames> facultyName = FacultyNames.valueOf(SCANNER.next());
                for (Faculty faculty : UNIVERSITY.getFaculties())
                    if (faculty.getFacultyName().equals(facultyName)) {
                        System.out.println("Enter the group number: ");
                        int groupNumber = SCANNER.nextInt();
                        for (Group group : faculty.getGroups()) {
                            if (group.getGroupNumber() == groupNumber) {
                                System.out.println("Enter the discipline: ");
                                DisciplineNames discipline = DisciplineNames.valueOf(SCANNER.next());
                                UniversityService.calculateAndPrintGroupAverageGrade(group, discipline);
                            }
                        }
                    }
                break;
            case 3:
                System.out.println("Enter the discipline: ");
                DisciplineNames discipline = DisciplineNames.valueOf(SCANNER.next());
                UniversityService.calculateAndPrintAverageGradeByUniversity(UniversityService
                        .getAllStudents(UNIVERSITY), discipline);
                break;
            default:
                throw new IllegalArgumentException("Number must be from 1 to 3!");
        }
    }
}
