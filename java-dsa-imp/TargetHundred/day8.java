package TargetHundred;

public class day8 {
    public static class Node{
        int data;
        Node next;
        public  Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;

    //Reverse a linked list
    public static void reverse(){
        Node prev=null;
        Node curr=head;
        Node next;

        if (head==null) {
            System.out.println("Linked list is empty");
            return;
        }
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;

    }
    public static void printLinkedList(){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
    //Detect a loop in a linked list
    public static boolean isLoop(){
        Node slow=head;
        Node fast=head;

        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast) {
                return true;
            }
        }
        return false;
    }

    //Find the middle of a linked list
    public static Node findMiddle(){
        if (head==null) {
            System.out.println("Linked list is empty");
            return null;
        }
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    //Remove duplicates from a sorted list
    public static void removeDuplicates(){
        if (head==null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node curr=head;
        while (curr!=null && curr.next!=null) {
            if (curr.data==curr.next.data) {
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }
        }
    }
    
    //Merge two sorted linked lists
    public static Node mergeSortedLists(Node l1, Node l2) {
        // Dummy node to simplify logic
        Node dummy = new Node(-1);
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach the remaining part
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        head=new Node(5);
        head.next=new Node(6);
        head.next.next=new Node(7);
        head.next.next.next=new Node(7);
        head.next.next.next.next=new Node(8);
        head.next.next.next.next.next=new Node(9);
        tail = head.next.next.next.next;

        // System.out.println("Original LinkedList");
        // printLinkedList();
        // System.out.println("Reversed Linked list");
        // reverse();
        // printLinkedList();

        //System.out.println(isLoop());

        // Node middle=findMiddle();
        // if (middle!=null) {
        //     System.out.println("Middle of linkedlist="+middle.data);
        // }

        // System.out.println("Original linked list");
        // printLinkedList();
        // removeDuplicates();
        // System.out.println("Duplicate removed linked list");
        // printLinkedList();

        // First sorted list: 1 -> 3 -> 5
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        // Second sorted list: 2 -> 4 -> 6
        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        Node mergedHead = mergeSortedLists(l1, l2);

        // Print merged list
        Node temp = mergedHead;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");

            
    }
}
