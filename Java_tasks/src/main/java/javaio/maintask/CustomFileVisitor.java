package javaio.maintask;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CustomFileVisitor extends SimpleFileVisitor<Path> {
    private static final String PREFIX = "|";
    private static final String DIRECTORY_PREFIX = "|--";
    public static String output = "";
    private static int level = 0;

    public CustomFileVisitor(Path path) {
    }

    public String indentation(int level) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < level; i++) {
            builder.append("  ");
        }
        return builder.toString();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) {
        output = output + PREFIX + indentation(level) + DIRECTORY_PREFIX + path.getFileName() + "\n";
        level++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
        output = output + PREFIX + indentation(level) + "  " + path.getFileName() + "\n";
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException exc) {
        level--;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException exc) throws IOException {
        return super.visitFileFailed(path, exc);
    }
}
