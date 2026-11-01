package Basic;

import java.util.Scanner;

public class day3 {
    //Write a program to find largest number in Array ?
    public static int largest(int arr[]){
        int largest=0;
        for(int i=0; i<arr.length; i++){
            if (arr[i]>largest) {
                largest=arr[i];
            }
        }
        return largest;
    }

    // Write a program to check whether two Array are equal or not?
    public static boolean isEqualArray(int arr1[],int arr2[]){
        int n=arr1.length;
        int m=arr2.length;
        if (n!=m) {
            System.out.println("Arrays size is not equal");
            return false;
        }
        for(int i=0; i<n; i++){
            if (arr1[i]!=arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //Write a program to check string is palindrome or not ?
    public static boolean isPalindrome(String str){
        int left=0;
        int right=str.length()-1;
        while (left<right) {
            if (str.charAt(right)!=str.charAt(left)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Write a program that takes a year from the user and prints whether it is a leap year or not?
    public static boolean isLeapYear(int year){
        if (year%4==0) {
            if (year%100==0) {
                return (year%400==0);
            }else{
                return true;
            }
        }
        return false;
    }

    /*Write a program to make such a pattern like a pyramid with a number that repeats in the same row.
        1
       2 2
       3 3 3
      4 4 4 4
    */
    public static void printPyramid(int rows){
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=(rows-i); j++){
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
       // int arr1[]={5,61,2,63,-1};
        //System.out.println(largest(arr));
        //int arr2[]={5,61,2,63,-1};
        //System.out.println(isEqualArray(arr1, arr2));

        // String str="BAAbB";
        // System.out.println(isPalindrome(str));

        // Scanner sc=new Scanner(System.in);
        // System.out.println("Enter year");
        // int year=sc.nextInt();
        // if (isLeapYear(year)) {
        //     System.out.println(year+" is a leap year");
        // }else{
        //     System.out.println("This is not a leap year");
        // }

        printPyramid(5);
    }
}
