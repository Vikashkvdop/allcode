package TargetHundred;

import java.util.LinkedList;
import java.util.Queue;

public class day10c {
    //Implement a stack using two queues
    public static class StackUsingQueue{
        private Queue<Integer> q1=new LinkedList<>();
        private Queue<Integer>q2=new LinkedList<>();

        // push element to stack
        public void push(int x){
            //step1 add to q2
            q2.add(x);
            //step2 add all element q1 to q2
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            //swap q1 and q2
            Queue<Integer> temp=q1;
            q1=q2;
            q2=temp;
        }
        // pop
        public int pop(){
            if (q1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }else{
                return q1.remove();
            }
        }
        //get top element
        public int top(){
            if (q1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return q1.peek();
        }
        //isEmpty
        public boolean isEmpty(){
            return q1.isEmpty(); 
        }
        //display
        public void display(){
            if (q1.isEmpty()) {
                System.out.println("Queue is empty");
            }else{
                for(int val:q1){
                    System.out.println(val+" ");
                }
            }
            System.out.println();
        }
    }public static void main(String[] args) {
        StackUsingQueue stack=new StackUsingQueue();
        stack.push(4);
        stack.push(5);
        stack.push((6));
        stack.display();
        stack.pop();
        stack.display();
        System.out.println(stack.top());
    }
}
