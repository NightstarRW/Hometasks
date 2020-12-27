package javacollections.optionaltask;

import java.util.Scanner;
import java.util.Stack;

public class TaskTwo {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.print("Enter a number: ");
        int number = SCANNER.nextInt();

        while (number > 0) {
            stack.push(number % 10);
            number /= 10;
        }

        String outNumber = "";
        while (!stack.isEmpty()) {
            outNumber += stack.pop();
        }
        System.out.println(new StringBuilder(outNumber).reverse().toString());
    }
}
