package javafundamentals.maintasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TaskTwo {

    public static void main(String[] args) {
        System.out.println("Arguments: " + Arrays.toString(args));
        List<String> arguments = Arrays.asList(args);
        Collections.reverse(arguments);
        for (String argument : arguments) {
            System.out.println(argument);
        }
    }
}
