package javaio.maintask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Tree {
    public static void main(String[] args) throws IOException {
        String inputArgs = Arrays.toString(args)
                .replace("[", "")
                .replace("]", "");
        System.out.println("Entered argument: " + inputArgs);
        File inputtedFile = new File(inputArgs);
        Path inputPath = Paths.get(inputArgs);

        if (inputtedFile.isDirectory()) {
            System.out.println("It's a directory path.");
            CustomFileVisitor customFileVisitor = new CustomFileVisitor(inputPath);
            Files.walkFileTree(inputPath, customFileVisitor);
            File outputResult = new File("src/main/java/javaio/data" + File.separator + "tree.txt");

            try (FileWriter fileWriter = new FileWriter(outputResult)) {
                fileWriter.write(CustomFileVisitor.output);
                System.out.println("Directory data is written to file. File directory: " + outputResult.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (inputtedFile.isFile() && inputtedFile.getName().endsWith(".txt")) {
            System.out.println("It's a file path\n");
            List<String> fileContent = Files.readAllLines(inputPath, Charset.defaultCharset());
            countingAndPrint(fileContent);
        } else {
            throw new InvalidPathException(inputArgs, "It's not a path, or '.txt' file!");
        }
    }

    private static void countingAndPrint(List<String> strings) {
        int packagesCounter = 0;
        int filesCounter = 0;
        int fileNameLength = 0;
        int filesInPackageCounter;

        for (String string : strings) {
            if (string.contains("|--")) {
                packagesCounter++;
            } else if (string.contains("|") && !string.contains("--")) {
                filesCounter++;
                fileNameLength += (string.replace(" ", "").length() - 1);
            }
        }
        fileNameLength /= filesCounter;
        filesInPackageCounter = filesCounter / (packagesCounter + 1);

        System.out.println("Packages quantity: " + packagesCounter + "\nFiles quantity: " + filesCounter +
                "\nAverage filenames length: " + fileNameLength + "\nAverage files quantity in package: "
                + filesInPackageCounter);
    }
}
