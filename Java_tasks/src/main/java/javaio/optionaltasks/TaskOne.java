package javaio.optionaltasks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TaskOne {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        if (!new File("src/main/java/javaio/data").exists()) {
            try {
                Files.createDirectories(Paths.get("src/main/java/javaio/data"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Created a new directory: src\\main\\java\\javaio\\data");
        }
        File numbersFile = new File("src/main/java/javaio/data" + File.separator + "numbers.txt");
        try {
            if (numbersFile.createNewFile()) {
                System.out.println("File created: " + numbersFile.getPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(RANDOM.nextInt(999));
        }
        try (FileWriter fileWriter = new FileWriter(numbersFile)) {
            for (Integer number : numbers) {
                fileWriter.write(number + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> numbersFromFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(numbersFile))) {
            String number;
            while ((number = reader.readLine()) != null) {
                numbersFromFile.add(Integer.parseInt(number));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(numbersFromFile);

        try (FileWriter fileWriter = new FileWriter(numbersFile)) {
            for (Integer number : numbersFromFile) {
                fileWriter.write(number + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}