import java.util.Scanner;

public class prep20 {

    /* Given an integer array arr of size N the task is to find the count of elements whose value is greater
    than all of its prior elements
    Note:- 1st element of the array should be considered in the count of the result.
    for example. arr[]={7,4,8,2,9} output is 3
     */
    public static int countPriorElement(int[] arr){
        int n=arr.length;
        int maxLeft=arr[0];
        int count=1;
        for(int i=0; i<n; i++){
            if (arr[i]>maxLeft) {
                count++;
                maxLeft=arr[i];
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.print(countPriorElement(arr));

    }
}
