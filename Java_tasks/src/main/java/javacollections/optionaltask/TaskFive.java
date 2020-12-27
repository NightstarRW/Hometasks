package javacollections.optionaltask;

import java.util.ArrayList;
import java.util.List;

public class TaskFive {
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        elements.add(1);
        elements.add(-12);
        elements.add(-34);
        elements.add(-5);
        elements.add(33);
        elements.add(16);
        System.out.println(elements);

        for (Integer element : elements) {
            if (element >= 0) {
                sorted.add(element);
            }

        }
        for (Integer element : elements) {
            if (element < 0) {
                sorted.add(element);
            }
        }
        System.out.println("Sorted list: " + sorted);
    }
}
