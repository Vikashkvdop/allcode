package DailyPractice;

public class day6 {
    //write a program to convert decimal to binary
    public static String decimalToBinary(int number){
        if(number==0) return "0";
        StringBuilder binary=new StringBuilder();
        while(number>0){
            int remainder=number%2;
            binary.append(remainder);
            number/=2;
        }
        return binary.reverse().toString();
    }

    //Write a program to convert digits / numbers to words.



    //write a program for bubble sort
    public static void bubbleSort(int[] arr){
        int n=arr.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    //write a program for merge sort
    public static void divide(int[] arr,int start,int end){
        if (start>=end) {
            return;
        }
        
        int mid=start+(end-start)/2;
        divide(arr,start,mid);
        divide(arr,mid+1,end);
        conquer(arr,start,mid,end);

    }
    private static void conquer(int[] arr,int start,int mid,int end){
        int idx1=start;
        int idx2=mid+1;
        int x=0;
        
        int[] result=new int[end-start+1];
        while(idx1<=mid && idx2<=end){
            if (arr[idx1]<=arr[idx2]) {
                result[x++]=arr[idx1++];
            }else{
                result[x++]=arr[idx2++];
            }
        }
        while (idx1<=mid) {
            result[x++]=arr[idx1++];
        }
        while(idx2<=end){
            result[x++]=arr[idx2++];
        }
        for(int i=0, j=start; i<result.length; i++,j++){
            arr[j]=result[i];
        }
    }
    

    //write a program for selection sort
    public static void selectionSort(int[] arr){
        int n=arr.length;
        for(int i=0; i<n-1; i++){
            int minIndex=i;
            for(int j=i+1; j<n; j++){
                if (arr[j]<arr[minIndex]) {
                    minIndex=j;
                }
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
    }
    public static void main(String[] args) {
        // int number=3;
        // String str=decimalToBinary(number);
        // System.out.println(str);


        int[] arr={5,6,2,8,9};
        //bubbleSort(arr);
        //divide(arr, 0, arr.length-1);
        selectionSort(arr);
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}
