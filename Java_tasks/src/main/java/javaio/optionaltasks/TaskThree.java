package javaio.optionaltasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
        System.out.println("Enter '.java' file path: ");
        Path javaFilePath = Paths.get(new Scanner(System.in).next());
        File javaFile = new File(javaFilePath.toString());
        if (!javaFile.isFile() || !javaFile.getName().endsWith(".java")) {
            throw new InvalidPathException(javaFilePath.toString(), "It's not a '.java' file");
        }
        File reversedJavaContent = new File("src/main/java/javaio/data/reversed.txt");
        List<String> fileContent = new ArrayList<>();
        List<String> reversedFileContent = new ArrayList<>();

        try {
            if (reversedJavaContent.createNewFile()) {
                System.out.println("File created: " + reversedJavaContent.getPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileContent = Files.readAllLines(javaFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : fileContent) {
            reversedFileContent.add(new StringBuilder(line).reverse().toString());
        }

        try (FileWriter fileWriter = new FileWriter(reversedJavaContent)) {
            for (String line : reversedFileContent) {
                fileWriter.write(line + "\n");
            }
            System.out.println("Reversed file content is written to file: " + reversedJavaContent.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
