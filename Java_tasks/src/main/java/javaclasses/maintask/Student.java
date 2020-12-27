package javaclasses.maintask;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Student {
    private int studentID;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate dateOfBirthday;
    private String address;
    private String phoneNumber;
    private String faculty;
    private int course;
    private int group;

    public Student(int studentID, String firstName, String lastName, String middleName, LocalDate dateOfBirthday,
                   String address, String phoneNumber, String faculty, int course, int group) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirthday = dateOfBirthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID &&
                course == student.course &&
                group == student.group &&
                firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) &&
                middleName.equals(student.middleName) &&
                dateOfBirthday.equals(student.dateOfBirthday) &&
                address.equals(student.address) &&
                Objects.equals(phoneNumber, student.phoneNumber) &&
                Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, firstName, lastName, middleName, dateOfBirthday, address, phoneNumber,
                faculty, course, group);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("\nStudent: {");
        sb.append("ID: ").append(studentID);
        sb.append(", First name: ").append(firstName);
        sb.append(", Last name: ").append(lastName);
        sb.append(", Middle name: ").append(middleName);
        sb.append(", Date of birthday: ").append(dateOfBirthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        sb.append(", Address: ").append(address);
        sb.append(", Phone number: ").append(phoneNumber);
        sb.append(", Faculty: ").append(faculty);
        sb.append(", Course: ").append(course);
        sb.append(", Group: ").append(group);
        sb.append("} \n");
        return sb.toString();
    }
}