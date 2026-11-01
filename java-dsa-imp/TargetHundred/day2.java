package TargetHundred;

import java.util.*;


public class day2 {
    //Move all negative numbers to beginning
    public static void moveAllNagativeToBeginning(int arr[]){
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    // another method
    public static void moveNegativeToBeginning2(int arr[]){
        int j=0;
        for(int i=0; i<arr.length; i++){
            if (arr[i]<0) {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
    }

    //Find the Kth max and min element
    public static void kthMax(int arr[],int k){
        int n=arr.length;
        if (k <= 0 || k > arr.length) {
            System.out.println("Invalid value of k");
            return;
        }
        Arrays.sort(arr);

        int kthMin=arr[k-1];
        int kthMax=arr[n-k];
        System.out.println("Kth min ="+kthMin);
        System.out.print("Kth max="+kthMax);
       
    }

    //Sort an array of 0s, 1s and 2s
    public static void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        //Dutch National Flag Algorithm

        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid]
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    // Swap arr[mid] and arr[high]
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    //Union and Intersection of two arrays
    public static void union(int arr1[],int arr2[]){
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0; i<arr1.length; i++){
            result.add(arr1[i]);
        }
        for(int j=0; j<arr2.length; j++){
            result.add(arr2[j]);
        }
        
        System.out.print(result+" ");
        
    }

    //intersection
    public static void intersection(int arr1[],int arr2[]){
        ArrayList<Integer>result=new ArrayList<>();
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                if (arr1[i]==arr2[j]) {
                result.add(arr1[i]);
            }
            }
        }
        System.out.print(result+" ");
    }

    //another method using hashset
    public static void findUnionAndIntersection(int[] arr1, int[] arr2) {
        Set<Integer> union = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();

        // Fill set1 with elements of arr1
        for (int num : arr1) {
            set1.add(num);
            union.add(num); // also build union
        }

        // Traverse arr2
        for (int num : arr2) {
            union.add(num); // build union
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }

        // Print results
        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }

    //Cyclically rotate an array by one
    public static void rotateByOne(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        int last = arr[n - 1];

        // Shift elements one step to the right
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        // Place last element at first position
        arr[0] = last;
    }

    public static void main(String[] args) {
        int arr[]={5,3,-2,-9,1};
       // moveAllNagativeToBeginning(arr);
    //    moveNegativeToBeginning2(arr);
    //    for(int i=0; i<arr.length; i++){
    //     System.out.print(arr[i]+" ");
    //    }


       ///kthMax(arr, 2);


    //    int nums[]={1,0,2,1,0,2};
    //    sort012(nums);
    //    for(int i=0; i<nums.length; i++){
    //     System.out.print(nums[i]+" ");
    //    }



    //int nums[]={1,2,3,5,9};
    // union(arr, nums);
    // intersection(arr, nums);
    //findUnionAndIntersection(arr, nums);

    rotateByOne(arr);
    for(int num:arr){
        System.out.print(num+" ");
    }

    }
}
