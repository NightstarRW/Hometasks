package javafundamentals.optionaltasktwo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class TaskOne {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        System.out.println("Enter matrix size: ");
        int size = SCANNER.nextInt();
        System.out.println("Enter min value: ");
        int minValue = SCANNER.nextInt();
        System.out.println("Enter max value: ");
        int maxValue = SCANNER.nextInt();
        int[][] matrix = new int[size][size];

        System.out.println("Your matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = RANDOM.nextInt(maxValue - minValue + 1) + minValue;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Enter a column to sort: ");
        int column = SCANNER.nextInt();
        column--;
        sortAndPrintMatrix(matrix, column);
    }

    public static void sortAndPrintMatrix(int[][] matrix, final int column) {
        Arrays.sort(matrix, Comparator.comparingInt(o -> o[column]));
        System.out.println("Sorted matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
