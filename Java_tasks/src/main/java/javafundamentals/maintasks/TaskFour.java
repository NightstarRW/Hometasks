package javafundamentals.maintasks;

import java.util.Arrays;

public class TaskFour {

    public static void main(String[] args) {
        int argsSum = 0;
        int argsMultiplication = 1;

        System.out.println("Arguments: " + Arrays.toString(args));
        for (String arg : args) {
            argsSum += Integer.parseInt(arg);
            argsMultiplication *= Integer.parseInt(arg);
        }

        System.out.println("Sum: " + argsSum);
        System.out.println("Multiplication: " + argsMultiplication);
    }
}
