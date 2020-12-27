package javafundamentals.optionaltaskone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaskOne {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter numbers, space separated: ");
        String numbers = SCANNER.nextLine();

        List<String> sortedStrings = Arrays.stream(numbers.split(" "))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        int index = sortedStrings.size() - 1;
        String longestNumber = sortedStrings.get(index);
        System.out.println("Longest number: " + longestNumber);
        System.out.println("Length: " + longestNumber.length() + "\n");

        String shortestNumber = sortedStrings.get(0);
        System.out.println("Shortest number: " + shortestNumber);
        System.out.println("Length: " + shortestNumber.length());
    }
}
