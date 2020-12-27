package javaclasses.maintask;

import java.time.LocalDate;
import java.util.Scanner;

public class Runner {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Student[] stud = new Student[6];
        stud[0] = new Student(1, "Dmitriy", "Abramov", "Sergeevich", LocalDate.of(2001, 12, 7), "Lenina 44/2-57", "+375338878787", "Econom", 1, 113111);
        stud[1] = new Student(2, "Aleksey", "Mezik", "Olegovich", LocalDate.of(2003, 5, 14), "Moskovsky 32-13", "+375291121212", "Econom", 1, 113111);
        stud[2] = new Student(3, "Vadim", "Byanov", "Andreevich", LocalDate.of(1992, 4, 24), "Pushkina 12-14", "+375331441414", "Prog", 3, 115116);
        stud[3] = new Student(4, "Maksim", "Pesnarov", "Sergeevich", LocalDate.of(1998, 9, 13), "Pushkina 48-16", "+375331131313", "Art", 2, 114114);
        stud[4] = new Student(5, "Andrey", "Morisov", "Andreevich", LocalDate.of(1997, 4, 24), "Svoboda 13-4", "+375291101010", "Art", 2, 114114);
        stud[5] = new Student(6, "Oleg", "Smirnov", "Alekseevich", LocalDate.of(1988, 7, 15), "Brovki 4-11", "+375339909090", "Mus", 4, 116226);

        System.out.println("Enter a number to show: 1 for faculty students, 2 for faculty and course students, " +
                "3 for students, born after a set year, 4 for group list.");
        int sortingType = SCANNER.nextInt();

        switch (sortingType) {
            case 1:
                System.out.println("Enter a faculty: ");
                String faculty = SCANNER.next();
                System.out.println("Sorted by faculty: " + faculty);
                System.out.println(Sorter.byFaculty(stud, faculty));
                break;
            case 2:
                System.out.println("Enter a faculty: ");
                String facultyCaseTwo = SCANNER.next();
                System.out.println("Enter a course: ");
                int course = SCANNER.nextInt();
                System.out.println("Sorted by faculty: " + facultyCaseTwo + ", course: " + course);
                System.out.println(Sorter.byFacultyAndCourse(stud, facultyCaseTwo, course));
                break;
            case 3:
                System.out.println("Enter a year: ");
                int year = SCANNER.nextInt();
                LocalDate date = LocalDate.of(year, 1, 1);
                System.out.println("Students, born after " + date + ":");
                System.out.println(Sorter.byYear(stud, date));
                break;
            case 4:
                System.out.println("Enter a group: ");
                int group = SCANNER.nextInt();
                System.out.println("Group list:");
                System.out.println(Sorter.ByGroup(stud, group));
                break;
            default:
                throw new Exception("Number must be from 1 to 4!");
        }
    }
}
