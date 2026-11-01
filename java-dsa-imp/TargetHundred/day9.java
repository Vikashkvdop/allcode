package TargetHundred;



public class day9 {
    public static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value=value;
            
        }
        Node(int value, Node next) { this.value = value; this.next = next; }
    }
    public static Node head;
    public static Node tail;

    //Detect and remove loop
    public static Node removeLoop(Node head){
        if (head==null) {
            System.out.println("Linked list is empty");
            return null;
        }
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast) {
                fast.next.next=null;
            }
        }
        return head;
    }
    public static void printLinkedList(){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println("NULL");
    }

    //Add two numbers represented by linked lists
    /*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

     Constraints:
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    input
    l1 = 2 -> 4 -> 3   // represents 342
    l2 = 5 -> 6 -> 4   // represents 465

    output
    7 -> 0 -> 8        // represents 807

 */
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummyHead = new Node(0); // placeholder to return the result
        Node current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int value1 = (l1 != null) ? l1.value : 0;
            int value2 = (l2 != null) ? l2.value : 0;
            int sum = value1 + value2 + carry;

            carry = sum / 10;
            int digit = sum % 10;

            current.next = new Node(digit);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }

    //Intersection point of two linked lists
    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node a = headA;
        Node b = headB;

        // Traverse both lists, switch head when reaching the end
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;  // Can be null or intersection node
    }

    //Check if linked list is palindrome
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        // Step 3: Compare both halves
        while (secondHalf != null) {
            if (firstHalf.value != secondHalf.value) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;
    }

    //Find Nth node from end
    public static int findNthFromEnd(Node head, int n) {
        if (head == null) return -1;

        Node first = head;
        Node second = head;

        // Step 1: Move first n steps ahead
        for (int i = 0; i < n; i++) {
            if (first == null) return -1; // N > length
            first = first.next;
        }

        // Step 2: Move both pointers until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second.value;
    }


    public static int findSize(Node head){
        Node temp=head;
        int count=0;
        while (temp!=null) {
            count++;
            temp=temp.next;
        }
        return count;
    }
    public static void main(String[] args) {
        head=new Node(3);
        head.next=new Node(5);
        head.next.next=new Node(6);
        head.next.next.next=new Node(7);
        head.next.next.next.next=new Node(9);
        head.next.next.next.next.next=head.next.next;

        // System.out.println("Original Linked List");
        // printLinkedList();

        // removeLoop(head);
        // printLinkedList();

        // Node l1=new Node(2);
        // l1.next=new Node(4);
        // l1.next.next=new Node(2);

        // Node l2=new Node(1);
        // l2.next=new Node(2);
        // l2.next.next=new Node(0);
        
        // Node current=addTwoNumbers(l1,l2);
        // while (current!=null) {
        //     System.out.print(current.value+"->");
        //     current=current.next;
        // }
        // System.out.println("Null");


        // Creating an example:
        // List A: 1 -> 2 \
        //                 6 -> 7
        // List B:     3 /

        // Nodes
        // Node common = new Node(6, new Node(7));
        // Node headA = new Node(1, new Node(2, common));
        // Node headB = new Node(3, common);

        // Call
        // Node intersection = getIntersectionNode(headA, headB);
        // System.out.println("Intersection at node with value: " + (intersection != null ? intersection.value : "None"));


        Node temp=new Node(1);
        temp.next=new Node(2);
        temp.next.next=new Node(3);
        temp.next.next.next=new Node(2);
        temp.next.next.next.next=new Node(1);

        //System.out.println(isPalindrome(temp));
        System.out.println(findNthFromEnd(temp, 3));


       

    }
}
