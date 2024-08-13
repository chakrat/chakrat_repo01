import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOperator(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private int applyOperator(int a, int b, String operator) {
        System.out.println("Now in applyOperator: a="+a+",b="+b+" ,operator is "+operator);
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        String[] expression1 = {"2", "1", "+", "3", "*"};
        System.out.println("Result of expression 1: " + rpn.evalRPN(expression1)); // Output: 9

        String[] expression2 = {"4", "13", "5", "/", "+"};
        System.out.println("Result of expression 2: " + rpn.evalRPN(expression2)); // Output: 6

        String[] expression3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Result of expression 3: " + rpn.evalRPN(expression3)); // Output: 22
    }
}
