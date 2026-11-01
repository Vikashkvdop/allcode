package TargetHundred;

public class day13 {
    // Insertion sort
    public static void insertionSort(int[] arr){
        int n=arr.length;
        for(int i=1; i<n; i++){
            int key=arr[i];
            int j=i-1;

            while (j>=0 && arr[j]>key) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    //Merge sort
    public static void mergeSort(int[] arr,int si,int ei){
        if (si>=ei) {
            return;
        }
        int mid = si+(ei-si)/2;
        mergeSort(arr, si,mid);
        mergeSort(arr, mid+1, ei);
        conquer(arr,si,mid,ei);
    }
    public static void conquer(int[] arr,int si,int mid,int ei){
        int merged[]=new int[ei-si+1];
        int idx1=si;
        int idx2=mid+1;
        int x=0;
        while (idx1<=mid && idx2<=ei) {
            if (arr[idx1]<=arr[idx2]) {
                merged[x++]=arr[idx1++];
            }else{
                merged[x++]=arr[idx2++];
            }
        }
        while (idx1 <=mid) {
            merged[x++]=arr[idx1++];
        }
        while (idx2<=ei) {
            merged[x++]=arr[idx2++];
        }
        for(int i=0,j=si; i<merged.length; i++,j++){
            arr[j]=merged[i];
        }
    }
    // Quick sort
    public static void quickSort(int[] arr,int low,int high){
        if (low<high) {
            int pi=partition(arr,low,high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    public static int partition(int[] arr,int low,int high){
        int pivot=arr[high];
        int i=low-1;
        for(int j=low; j<high; j++){
            if (arr[j]<pivot) {
                i++;
                //swap
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        //swap with pivote
        i++;
        int temp=arr[i];
        arr[i]=arr[high];
        arr[high]=temp;
        return i;
    }

    //count sort
    public static void countSort(int[] arr){
        int largest=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            largest=Math.max(largest, arr[i]);
        }
        int count[]=new int[largest+1];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }
        //sorting
        int j=0;
        for(int i=0; i<count.length; i++){
            while (count[i]>0) {
                arr[j]=i;
                j++; count[i]--;
            }
        }
    }

    //Search in a rotated sorted array
    public static int search(int[] nums,int target){
        int start=0, end=nums.length-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if(nums[mid]== target) return mid;
            if(nums[start]<=nums[mid]){
                if (nums[start]<=target && target<=nums[end]) {
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //int[] arr={4,1,9,3,2,0};
        //insertionSort(arr);
        //mergeSort(arr, 0, arr.length-1);
        //quickSort(arr, 0, arr.length-1);
        // countSort(arr);
        // for(int val:arr){
        //     System.out.print(val+" ");
        // }

        int nums[]={4,5,6,7,0,1,2};
        System.out.println(search(nums, 7));
    }
}
