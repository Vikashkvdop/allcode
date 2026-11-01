package DailyPractice;



public class day1 {
    //write a program to check for palindrome
    public static boolean isPalindrome(int[] arr){
        int start=0,end=arr.length-1;
        while (start<end) {
            if (arr[start]!=arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    //write a program to check string is palindrome
    public static boolean isPalindromeString(String str){
        int start=0, end=str.length()-1;
        while (start<end) {
            if (str.charAt(start)!=str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    //write a program to check a number is palindrome 
    public static boolean isPalindromeNumber(int number){
        int original=number;
        int reversed=0;
        while (number>0) {
        int digit=number%10;
        reversed=(reversed*10)+digit;
        number=number/10;
        }

        return original==reversed;
        
    }
    //write a program to count digits
    public static int countDigits(int number){
        int count=0;
        while (number>0) {
            number=number/10;
            count++;
        }
        return count;
    }
    //Write a program to merge two strings
    public static String mergeString(String str1,String str2){
        return str1+str2;
    }

    //write a program to check array is sorted
    public static boolean isSorted(int[] arr){
        for(int i=1; i<arr.length-1; i++){
            if (arr[i]>arr[i+1]) {
                return false;
            }
        }
        return true;
    }
    //Wrtie a program to reverse linkedlist
    public static class listNode{
        int val;
        listNode next;
        public listNode(int val){
            this.val=val;
            
        }
    }
    public static listNode reverseList(listNode head){
        listNode curr=head;
        listNode prev=null;
        while (curr!=null) {
            listNode nextTemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }
        return prev;
    }
    public static void printList(listNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    //write a program to find the length of loop
    public static int findLoopLength(listNode head){
        listNode slow=head;
        listNode fast=head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast) {
                return countLength(slow);
            }
        }
        
        return 0;
    }
    public static int countLength(listNode Node){
        listNode temp=Node.next;
        int length=1;
        while (temp!=Node) {
            length++;
            temp=temp.next;
            
        }
        return length;
    }
    public static void main(String[] args) {
        // int[] arr={1,2,6,2,1};
        // System.out.println(isPalindrome(arr));


        // String str="carac";
        // System.out.println(isPalindromeString(str));

        // int number=121;
        // System.out.println(isPalindromeNumber(number));

        // int number=213423;
        // System.out.println(countDigits(number));

        // String str1="vikash";
        // String str2="verma";
        // System.out.println(mergeString(str1, str2));

        // int[] arr={1,5,3,4,8};
        // System.out.println(isSorted(arr));
        // Create linked list: 1 -> 2 -> 3 -> 4 -> null
        //listNode head = new listNode(1);
        // head.next = new listNode(2);
        // head.next.next = new listNode(3);
        // head.next.next.next = new listNode(4);

        // System.out.println("Original List:");
        // printList(head);

        // listNode reversed = reverseList(head);

        // System.out.println("Reversed List:");
        // printList(reversed);



        // Create nodes
        listNode head = new listNode(1);
        head.next = new listNode(2);
        head.next.next = new listNode(3);
        head.next.next.next = new listNode(4);
        head.next.next.next.next = new listNode(5);

        // Create loop: 5 → 3
        head.next.next.next.next.next = head.next.next;

        int loopLength = findLoopLength(head);

        if (loopLength > 0) {
            System.out.println("Loop detected. Length of loop = " + loopLength);
        } else {
            System.out.println("No loop detected.");
        }
    }
}
