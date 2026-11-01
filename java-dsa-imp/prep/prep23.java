
/* Given an array of integers where every element appears even number of times except one element
   which appears odd number of times, write a program to find that odd occurring element in O(log n) time
   .The equal element must appear in pairs in the array but there cannot be more than two consecutive occurrences of an element
   input- arr{1,1,2,2,3,4,4};
   output-3
 */

import java.util.Scanner;

public class prep23 {
    public static int findOdd(int[] arr){
        int n=arr.length;
        int start=0;
        int end=n-1;
        while (start<=end) {
            int mid=(start+end)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]) return arr[mid];

            //even length
            if (mid%2==0) {
                if (arr[mid-1]==arr[mid]) {
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if (arr[mid-1]==arr[mid]) {
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
    public static int findOddM2(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            // If pair is correct, move right
            if (arr[mid] == arr[mid + 1]) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }

        return arr[start];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.print(findOdd(arr));

    }
}
