import java.util.Scanner;


public class prep12 {
    //Find the only non-repeating element
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i]=sc.nextInt();
        }
        int result=0;
        for(int num:arr){
            result^=num;
        }
        System.out.print(result);
    }
}
