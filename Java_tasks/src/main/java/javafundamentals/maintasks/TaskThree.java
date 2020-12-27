package javafundamentals.maintasks;

import java.util.Random;
import java.util.Scanner;

public class TaskThree {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static final int minValue = -999;
    private static final int maxValue = 999;

    public static void main(String[] args) {
        System.out.print("Enter the quantity of numbers: ");
        int quantity = SCANNER.nextInt();
        int[] numbers = new int[quantity];

        for (int i = 0; i < quantity; i++) {
            numbers[i] = RANDOM.nextInt(maxValue - minValue + 1) + minValue;
            System.out.print(numbers[i] + " ");
        }

        for (int i = 0; i < quantity; i++) {
            System.out.print("\n" + numbers[i]);
        }
    }
}
