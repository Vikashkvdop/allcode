package TargetHundred;

import java.util.*;


public class day3 {

    // Find the missing number in an array
    public static int findMissingNumber(int[] arr){
        int n=arr.length;
        int total=n*(n+1)/2;

        int sum=0;
        for (int i : arr) {
            sum+=i;
        }
        return total-sum;
    }

    // Find duplicates in an array
    public static  List<Integer> findDuplicates(int[] arr){
        Set<Integer> seen=new HashSet<>();
        List<Integer> duplicates=new ArrayList<>();
        for (int num:arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    // remove duplicates
    public static Set<Integer> removeDuplicates(int arr[]){
        Set<Integer> result=new HashSet<>();

        for (int num:arr) {
            result.add(num);
        }
        return result;
    }

    //Merge two sorted arrays
    public static int[] merge(int arr1[],int arr2[]){
        int n1=arr1.length;
        int n2=arr2.length;

        int i=0,j=0,k=0;
        int[] result=new int[n1+n2];

        while (i<n1 && j<n2) {
            if (arr1[i]<=arr2[j]) {
                result[k++]=arr1[i++];
            }else{
                result[k++]=arr2[j++];
            }
        }

        while (i<n1) {
            result[k++]=arr1[i++];
        }
        while (j<n2) {
            result[k++]=arr2[j++];
        }
        return result;
    }

    // Kadanes Algorithm (max subarray sum)
    public static int  maxSubarraySum(int arr[]){
        int maxSum=arr[0];
        int currentSum=arr[0];

        for(int i=1; i<arr.length; i++){
            currentSum=Math.max(arr[i], currentSum+arr[i]);
            maxSum=Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
    

    //Min/Max sum of n-1 elements
    public static void minMaxSum(int arr[]){
        int totalSum=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int num:arr){
            totalSum+=num;
            if(num<min) min=num;
            if(num>max) max=num;
        }

        long minSum=totalSum-max;
        long maxSum=totalSum-min;
        System.out.println("Min sum="+minSum);
        System.out.println("Max sum="+maxSum);

    }
    public static void main(String[] args) {
        // int nums[]={1,2,4,5,0};
        // System.out.print(findMissingNumber(nums));

        //int nums[]={2,3,3,6,0,-1,-1};
        //System.out.print(findDuplicates(nums));
        //System.out.print(removeDuplicates(nums));

    //     int arr1[]={1,2,3,5};
    //     int arr2[]={1,2,3,4,5};
    //    int[] mergedSorted= merge(arr1, arr2);
    //    System.out.print(Arrays.toString(mergedSorted));

    // int nums[]={1,2,-3,4};
    // System.out.print(maxSubarraySum(nums));

    int[] arr = {1, 2, 3, 4, 5};
    minMaxSum(arr);
    }
}
