package Linkedlist;

public class BasicOPeration {
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

    //print linked list
    public static void printLinkedlist(){
        Node temp=head;
        if (head==null) {
            System.out.print("Linkedlist is empty");
        }
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    // add new at first 
    public static void addFirst(int data){
        Node newNode=new Node(data);
        if (head==null) {
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    // add new node at last of the linked list
    public static void addAtLast(int data){
        Node newNode=new Node(data);
        if (head==null) {
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    // add new node at n postions
    public static void addAt(int index,int data){
        Node newNode= new Node(data);
        if (head==null) {
            head=newNode;
            return;
        }
        Node temp=head;
        int i=0;
        while (i<index-1) {
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    // Remove head 
    public static void removeHead(){
        head=head.next;
    }
    // remove node at given position
    public static void removeNode(int index){
        if (head==null) {
            System.out.println("LinkedList is empty");
            return;
        }
        int size=size();
        if (size==1) {
            head=tail=null;
        }
        Node temp=head;
        int i=0;
        while (i<index-1) {
            temp=temp.next;
            i++;
        }
       
        temp.next=temp.next.next;
    }
    // print size of linked list
    public static int size(){
        if (head==null) {
            System.out.println("Linked list is empty");
        }
        Node temp=head;
        int i=0;
        while (temp!=null) {
            temp=temp.next;
            i++;
        }
        return i;
    }

    // Searching in linkedlist
    public static int keySearch(int key){
        Node temp=head;
        int i=0;
        while (temp!=null) {
            if (temp.data==key) {
                return i;
            }
            i++;
            temp=temp.next;
        }
        return -1;
    }
    public static void main(String[] args) {
        addFirst(1);
        addFirst(3);
        addFirst(5);
        printLinkedlist();
        addAtLast(9);
        printLinkedlist();
        addAt(2, 12);
        printLinkedlist();
        removeHead();
        printLinkedlist();
        removeHead();
        printLinkedlist();
        addFirst(8);
        addFirst(7);
        addAt(3, 66);
        printLinkedlist();
        removeNode(3);
        printLinkedlist();
        removeNode(1);
        printLinkedlist();
        // System.out.println(size());
       System.out.println(keySearch(1));
       
    }
}
