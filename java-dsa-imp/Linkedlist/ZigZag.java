package Linkedlist;

public class ZigZag {
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

    //zig zag for a linkedlist of form 1->2->3->4->5-n convert it into a zig zag form i.e 1->n->2->(n-1)->3->(n-2)
    public static void makeZigZag(){
        //find mid
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;
        //reverese 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nextL,nextR;
        //merge
        while (left!=null && right!=null) {
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;
            left=nextL;
            right=nextR;
        }
    }
    //print linkedlist
    public static void printLinkedlist(){
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

        makeZigZag();
        printLinkedlist();
    }
}
