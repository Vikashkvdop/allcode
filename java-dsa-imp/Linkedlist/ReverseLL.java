package Linkedlist;

public class ReverseLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static  Node head;
    public static Node tail;


    //Reverse the linked list
    public static void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
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
        System.out.print("NULL");
    }
    public static void main(String[] args) {
        head=new Node(1);
        head.next= new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        reverse();
        printLinkedList();
         
    }
}
