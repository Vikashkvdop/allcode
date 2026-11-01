package Linkedlist;

public class DetectLoop {
    public static class Node{
        int data; 
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    
    // function to detect cycle or loop in linkedlist
    public static boolean isLoop(){
        Node slow=head;
        Node fast=head;
        while (fast !=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow) {
                return true;
            }
        }
        return false;
    }

    //Remove loop
    public static void removeLoop() {
        Node slow = head;
        Node fast = head;
        boolean loop = false;
    
        // Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loop = true;
                break;
            }
        }
    
        if (!loop) return;
    
        // Case 1: Loop starts at head
        if (slow == head) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
            return;
        }
    
        // Case 2: General case
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
    
        // Remove loop
        prev.next = null;
    }
    
    

    public static void main(String[] args) {
        head=new Node(1);
        head.next= new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=head;
        System.out.println(isLoop());
        removeLoop();
        System.out.println(isLoop());

    }
}
