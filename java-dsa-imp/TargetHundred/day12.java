package TargetHundred;

public class day12 {
    // Linear search
    public static int linearSearch(int[] arr,int target){
        for(int i=0; i<arr.length; i++){
            if (arr[i]==target) {
                return i;
            }
        }
        return -1;
    }

    //Binary search
    public static int binarySearch(int[] arr,int target){
        int start=0, end=arr.length-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (arr[mid]==target) {
                return mid;
            }else if(arr[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            } 
                
            
        }
        return -1;
    }
    //Recursive binary search
    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1; // Base case: target not found
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid; // Target found
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, end); // Search right half
        } else {
            return binarySearch(arr, target, start, mid - 1); // Search left half
        }
    }

    // Bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                // Swap if elements are in wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped, break (array is sorted)
            if (!swapped) break;
        }
    }

    //Selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the element at index i
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        // int[] arr={10,30,40,50};
        // int target=40;
        //System.out.println(linearSearch(arr,target));

        // System.out.println(binarySearch(arr, target));
        // System.out.println(binarySearch(arr, 50, 0, arr.length-1));

        int[] arr={3,2,8,-1,0};
        //bubbleSort(arr);
        selectionSort(arr);
        for(int val:arr){
            System.out.print(val+" ");
        }
    }
}
