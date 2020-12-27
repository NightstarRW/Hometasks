package javafundamentals.maintasks;

import java.util.Scanner;

public class TaskOne {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please, enter your name: ");
        String username = SCANNER.next();
        System.out.println("Hello, " + username + "!");
    }
}
