import java.util.Stack;
import java.util.Scanner;

public class Main {

    // To find out the priority order of the operators.
    private static int operatorFinder(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // Start the loop for every single character.
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // If the character is a number, then append it to c.
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
                // If it's an open bracket, then push it into the stack.
                // If it's a closed bracket, pop all operators from the stack, and add it to the postfix expression
                // until an open parantheses is found. When that happens, pop it from the stack and remove it.
                // If the top element is empty or not a parantheses, return an error.
                // If it's an oprator, then operators of higher/equal priority aside from the current one is popped and
                // added to the postfix expression.
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid expression";
                } else {
                    stack.pop();
                }
            } else {
                // Pop all the remaining operators and add to postfix. Convert to a string, and return.
                while (!stack.isEmpty() && operatorFinder(c) <= operatorFinder(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Please enter a line you'd like convert: ");
        String expression = scn.nextLine();
        String postfix = infixToPostfix(expression);
        System.out.println("The expression in postfix is " + postfix);
    }
}