import java.util.Scanner;

public class prep7 {
    //maximum sum subarray - kadane's algorithm
    public static int maxSubArraySum(int[] arr){
        int maxSum=arr[0];
        int currSum=arr[0];
        for(int i=1; i<arr.length; i++){
            currSum=Math.max(arr[i], currSum+arr[i]);
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("max sum "+maxSubArraySum(arr));
    }
}
