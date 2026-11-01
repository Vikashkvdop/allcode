import java.util.Scanner;

public class prep29 {
    /* Given a non-empty array of integers nums every element appears twice except for one
      find that single element

      you must implement a solution with linear runtime complexity ans use only constant extra space
      input nums=[2,2,1]
      output: 1
      input nums=[4,1,2,1,2]
      output:4
    */
   public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0; i<n; i++){
        arr[i]=sc.nextInt();
    }

    int xor=0;
    for(int num:arr){
        xor^=num;
    }
    System.out.print(xor);
   }
}
