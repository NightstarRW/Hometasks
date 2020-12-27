package javacollections.optionaltask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TaskFour {
    private static final Comparator<String> LENGTH_COMPARATOR = Comparator.comparingInt(String::length);
    private static final String POEM =
                    "Here our soldiers stand from all around the world \n" +
                    "Waiting in a line to hear the battle cry \n" +
                    "All are gathered here victory is near \n" +
                    "The sound will fill the hall bringing power to us all \n" +
                    "We alone are fighting for metal that is true \n" +
                    "We own the right to live the fight we're here for all of you \n" +
                    "Now swear the blood upon your steel will never dry \n" +
                    "Stand and fight together beneath the battle sky! \n";

    public static void main(String[] args) {
        System.out.println("Poem example:\n" + POEM);
        List<String> lines = Arrays.asList(POEM.split("\n"));
        lines.sort(LENGTH_COMPARATOR);
        System.out.println("Sorted poem:");
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
