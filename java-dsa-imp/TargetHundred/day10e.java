package TargetHundred;

import java.util.Stack;

public class day10e {
    //Check for balanced parentheses
    public static boolean isBalanced(String expr){
        Stack<Character> stack=new Stack<>();
        for(char ch: expr.toCharArray()){
            //push to stack open brackets
            if (ch=='(' || ch=='{' || ch=='[') {
                stack.push(ch);
            }else if (ch==')' || ch=='}' || ch==']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top=stack.pop();
                if (!isMatchingPair(top,ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private static boolean isMatchingPair(char open,char close){
        return(open=='(' && close==')') ||
              (open=='{' && close=='}') || (open=='[' && close==']');
    }
    public static void main(String[] args) {
        String expr1 = "{[()]}";
        String expr2 = "{[(])}";
        String expr3 = "((()))[]{}";

        System.out.println(expr1 + " => " + isBalanced(expr1));  // true
        System.out.println(expr2 + " => " + isBalanced(expr2));  // false
        System.out.println(expr3 + " => " + isBalanced(expr3));  // true
    }
}
