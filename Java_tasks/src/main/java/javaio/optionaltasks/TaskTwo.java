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

public class TaskTwo {
    public static void main(String[] args) {
        System.out.println("Enter '.java' file path: ");
        Path javaFilePath = Paths.get(new Scanner(System.in).next());
        File javaFile = new File(javaFilePath.toString());
        if (!javaFile.isFile() || !javaFile.getName().endsWith(".java")) {
            throw new InvalidPathException(javaFilePath.toString(), "It's not a '.java' file");
        }
        List<String> fileContent = new ArrayList<>();
        List<String> editedFileContent = new ArrayList<>();

        try {
            fileContent = Files.readAllLines(javaFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : fileContent) {
            if (line.contains("public") && !line.contains("class")) {
                String replaced = line.replace("public", "private");
                editedFileContent.add(replaced);
            } else {
                editedFileContent.add(line);
            }
        }

        try (FileWriter fileWriter = new FileWriter(javaFile)) {
            for (String string : editedFileContent) {
                fileWriter.write(string + "\n");
            }
            System.out.println("File overwritten: " + javaFilePath + "\nAll public fields changed to private.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
