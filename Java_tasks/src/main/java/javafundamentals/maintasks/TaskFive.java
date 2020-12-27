package javafundamentals.maintasks;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class TaskFive {
    private static final Calendar CALENDAR = Calendar.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.print("Enter a month number (1 - 12): ");
        int inputMonth = SCANNER.nextInt();

        if (inputMonth < 13 && inputMonth > 0) {
            CALENDAR.set(0, inputMonth, 0);
            SimpleDateFormat date = new SimpleDateFormat("MMMM", Locale.ENGLISH);
            String month = date.format(CALENDAR.getTime());
            System.out.println(month);
        } else {
            throw new Exception("Number must be from 1 to 12!");
        }
    }
}
