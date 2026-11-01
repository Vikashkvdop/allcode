package TargetHundred;

import java.util.Stack;

public class day11 {
    //Next greater element
    /*Given an array of integers, for each element, find the next greater element to its right.
    If no such element exists, output -1 for that index.
    Input: arr = [4, 5, 2, 25]
    Output: 5 25 25 -1 */
    public static void printNextGreaterElement(int[] arr){
        int n=arr.length;
        int[] result=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=n-1; i>=0; i--){
            while (!stack.isEmpty() && stack.peek()<=arr[i]) {
                stack.pop();
            }
            result[i]=stack.isEmpty() ? -1:stack.peek();

            stack.push(arr[i]);
        }
        System.out.print("Result=");
        for(int val:result){
            System.out.print(val+" ");
        }

        System.out.println();
    }

    //Evaluate postfix expression
    /*input String:2 3 1 * + 9 -
      output: 2 + (3 * 1) - 9 = -4 */
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (String token : expression.split("\\s+")) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                // Operator: pop two elements
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            }
        }

        return stack.pop();  // Final result
    }

    // Helper to check if a string is numeric
    private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    // Helper to apply operator
    private static int applyOperator(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;  // Assumes b ≠ 0
            case "%": return a % b;
            case "^": return (int)Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Unsupported operator: " + op);
        }
    } 

    // Function to reverse the stack
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();            // Step 1: Pop the top
        reverseStack(stack);              // Step 2: Reverse the rest
        insertAtBottom(stack, top);       // Step 3: Insert popped at bottom
    }

    // Helper to insert element at bottom
    public static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);            // Base case
            return;
        }

        int top = stack.pop();            // Pop until stack is empty
        insertAtBottom(stack, value);     // Recursive insert at bottom
        stack.push(top);                  // Push all popped elements back
    }
    public static void main(String[] args) {
        // int[] arr={4,5,2,25};
        // printNextGreaterElement(arr);

        // String postfix = "2 3 1 * + 9 -";  // Equivalent to (2 + (3 * 1)) - 9
        // int result = evaluatePostfix(postfix);
        // System.out.println("Result: " + result);  // Output: -4

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack: " + stack);

        reverseStack(stack);

        System.out.println("Reversed Stack: " + stack);


    }
}
