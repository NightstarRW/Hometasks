package javaio.optionaltasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TaskFour {
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
            fileContent = Files.readAllLines(Paths.get(javaFile.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : fileContent) {
            editedFileContent.add(editString(line));
        }

        try (FileWriter fileWriter = new FileWriter(javaFile)) {
            for (String lines : editedFileContent) {
                fileWriter.write(lines + "\n");
            }
            System.out.println("File overwritten: " + javaFile.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String editString(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string);
        StringBuilder stringBuilder = new StringBuilder();
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            if (token.length() > 2) {
                stringBuilder.append(token.toUpperCase(Locale.ROOT)).append(" ");
            } else {
                stringBuilder.append(token).append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
