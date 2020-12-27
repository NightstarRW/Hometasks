package javafundamentals.optionaltaskone;

import java.util.Scanner;

public class TaskThree {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter numbers, space separated: ");
        String inputNumbers = SCANNER.nextLine();
        String[] numbersArray = inputNumbers.split(" ");

        int average = 0;
        for (String number : numbersArray) {
            average += number.length();
        }
        average /= numbersArray.length;

        System.out.println("Average length: " + average);
        System.out.println("Numbers, with length less than average: ");
        for (String number : numbersArray) {
            if (number.length() < average) {
                System.out.println(number + ", length: " + number.length());
            }
        }
        System.out.println("Numbers, with length more than average: ");
        for (String number : numbersArray) {
            if (number.length() > average) {
                System.out.println(number + ", length: " + number.length());
            }
        }
    }
}
