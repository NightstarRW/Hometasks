package javacollections.optionaltask.taskseven;

import java.util.Stack;

public class BracketsChecker {

    private BracketsChecker() {
    }

    public static boolean validate(String input) {
        Stack<Character> stack = new Stack<>();
        for (char symbol : input.toCharArray()) {
            if (isClosingBracket(symbol) && stack.isEmpty()) {
                return false;
            }
            if (isOpeningBracket(symbol)) {
                stack.push(symbol);
            }
            if (isClosingBracket(symbol)) {
                if (isPair(stack.peek(), symbol)) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isClosingBracket(char bracket) {
        return ")}]".indexOf(bracket) != -1;
    }

    private static boolean isOpeningBracket(char bracket) {
        return "({[".indexOf(bracket) != -1;
    }

    private static boolean isPair(char opening, char closing) {
        return opening == '(' && closing == ')' || opening == '['
                && closing == ']' || opening == '{' && closing == '}';
    }
}
