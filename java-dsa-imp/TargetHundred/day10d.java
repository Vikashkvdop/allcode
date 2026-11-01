package TargetHundred;

import java.util.Stack;



public class day10d {
    //Implement queue using two stack
    public static class QueueUsingStacks{
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();

        //push operation
        public void enqueue(int value){
            stack1.push(value);
        }
        //dequeue operation
        public int dequeue(){
            if (stack1.isEmpty()) {
                System.out.println("Queue underflow! or empty");
                return -1;
            }else{
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
            }
            return stack2.pop();
        }
        //peek
        public int peek(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }else{
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
            }
            return stack2.peek();
        }
        public boolean isEmpty(){
            return stack1.isEmpty() && stack2.isEmpty();
        }

        // Display queue elements
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }

            System.out.print("Queue elements (front to rear): ");

            // Print stack2 in order
            for (int i = stack2.size() - 1; i >= 0; i--) {
                System.out.print(stack2.get(i) + " ");
            }

            // Print stack1 in order
            for (int i = 0; i < stack1.size(); i++) {
                System.out.print(stack1.get(i) + " ");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
          QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        System.out.println("Front element: " + queue.peek());
    }
}
