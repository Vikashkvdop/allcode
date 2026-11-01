import java.util.Scanner;

public class prep4 {
    //find missing number in sorted array
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int expectedSum=(n+1)*(n+2)/2;
        int actualSum=0;

        for(int i=0; i<n; i++){
            actualSum+=arr[i];
        }
        System.out.print(expectedSum-actualSum);
    }
}
