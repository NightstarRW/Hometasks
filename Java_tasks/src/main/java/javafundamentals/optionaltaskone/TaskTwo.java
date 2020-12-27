package javafundamentals.optionaltaskone;

import java.util.*;
import java.util.stream.Collectors;

public class TaskTwo {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter numbers, space separated: ");
        List<String> increasingString = Arrays.stream(SCANNER.nextLine().split(" "))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        List<String> decreasingString = new ArrayList<>(increasingString);
        Collections.reverse(decreasingString);

        System.out.println("Numbers in increasing length order:" + increasingString);
        System.out.println("Numbers in decreasing length order:" + decreasingString);
    }
}
