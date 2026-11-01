package TargetHundred;

public class day10 {
    //Implement stack using array
    public static class Stack {
        private int maxSize;   // Maximum size of the stack
        private int top;       // Index of the top element
        private int[] stackArray;

        // Constructor to initialize stack
        public Stack(int size) {
            maxSize = size;
            stackArray = new int[maxSize];
            top = -1;  // Stack is initially empty
        }

        // Push an element onto the stack
        public void push(int value) {
            if (isFull()) {
                System.out.println("Stack Overflow! Cannot push " + value);
            } else {
                top++;
                stackArray[top] = value;
                System.out.println(value + " pushed to stack.");
            }
        }

        // Pop the top element from the stack
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow! Nothing to pop.");
                return -1; // Or throw an exception
            } else {
                int popped = stackArray[top];
                top--;
                return popped;
            }
        }

        // Peek the top element without removing it
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty. Nothing to peek.");
                return -1;
            } else {
                return stackArray[top];
            }
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return top == -1;
        }

        // Check if the stack is full
        public boolean isFull() {
            return top == maxSize - 1;
        }

        // Display the elements in the stack
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
            } else {
                System.out.print("Stack elements: ");
                for (int i = 0; i <= top; i++) {
                    System.out.print(stackArray[i] + " ");
                }
                System.out.println();
            }
        }

        // Main method to test the stack
        public static void main(String[] args) {
            Stack stack = new Stack(5);  // Stack with capacity 5

            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.display();

            System.out.println("Top element is: " + stack.peek());
            System.out.println("Popped element is: " + stack.pop());

            stack.display();
        }
    }

}
