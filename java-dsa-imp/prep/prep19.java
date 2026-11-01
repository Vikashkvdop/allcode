import java.util.Scanner;

//write a program to  move all zero in last of array
public class prep19 {
    public static void moveAllZero(int[] arr){
        int n=arr.length;
        int j=0;
        for(int i=j+1; i<n; i++){
            if (arr[i]!=0) {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
        return;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        moveAllZero(arr);
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}
