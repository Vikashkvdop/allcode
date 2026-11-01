package Linkedlist;


public class MergeSort {
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
    //merge sort
    private static Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow; //mid
    }
    private static Node merge(Node head1,Node head2){
        Node mergedll=new Node(-1);
        Node temp=mergedll;
        while (head1!=null && head2!=null) {
            if (head1.data<=head2.data) {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while (head1!=null) {
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while (head2!=null) {
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedll.next;
    }
    public static Node mergeSort(Node head){
        if (head==null || head.next==null) {
            return head;
        }
        //find mid
        Node mid=getMid(head);
        //left and right
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);
        //merge 
        return merge(newLeft, newRight);
    }
    public static void printLinkedlist(){
        Node temp=head;
        if (head==null) {
            System.out.print("LinkedList is empty");
            return;
        }
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("NULL");
    }
    public static void main(String[] args) {
        head=new Node(6);
        head.next=new Node(2);
        head.next.next=new Node(9);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(8);
       
       head= mergeSort(head);
        printLinkedlist();
    }
}
