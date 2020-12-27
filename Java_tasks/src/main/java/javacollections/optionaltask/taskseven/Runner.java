package javacollections.optionaltask.taskseven;

public class Runner {
    private static final String SYMBOLS = ("(" + ")" + "[" + "]" + "{" + "}");

    public static void main(String[] args) {
        System.out.println("Brace placement is " + (BracketsChecker.validate(SYMBOLS) ? "correct" : "incorrect"));
    }
}
