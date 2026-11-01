package TargetHundred;

public class day1 {
    //Find the maximum and minimum element in an array
    public static int maxElement(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if (arr[i]>=max) {
                max=arr[i];
            }
        }
        return max;
    }

    //Reverse the array
    public static void reverseArray(int[] arr){
        int last=arr.length-1;
        int first=0;
        while (first<last) {
            int temp=arr[last];
            arr[last]=arr[first];
            arr[first]=temp;
            first++;
            last--;
        }
        
    }
    //Check if the array is sorted
    public static boolean isSorted(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            if (arr[i]>arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    //Left rotate an array by one place
    public static void leftRotateByOnePlace(int arr[]){
        if (arr.length==0) {
            return;
        }
        int first=arr[0];
        for(int i=0; i<arr.length-1; i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=first;
    }
    //Left rotate an array by d places
    public static void reverse(int arr[],int start,int end){
        while (start<end) {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void leftRotate(int[] arr,int d){
        int n=arr.length;
        if(n==0 || d%n==0) return;
        d=d%n;
        reverse(arr, 0, d-1);

        reverse(arr, d, n-1);

        reverse(arr, 0, n-1);
    }
    public static void main(String[] args) {
        // int[] arr={1,-9,32,0,5};
        // System.out.println(maxElement(arr));
        // reverseArray(arr);
        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i]+" ");
        // }

        int nums[]={1,2,3,4,5,8};
        // System.out.println(isSorted(nums));
        // leftRotateByOnePlace(nums);
        // for(int i=0; i<nums.length; i++){
        //     System.out.print(nums[i]+" ");
        // }
        int d=2;
        leftRotate(nums, d);
        for(int arr:nums){
            System.out.print(arr+" ");
        }
    }
}
