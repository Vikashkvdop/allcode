import java.util.Scanner;

public class prep3 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter array size ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int largest=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        for(int num:arr){
            if(num>largest){
                second=largest;
                largest=num;
            }else if(num>second && num!=largest){
                second=num;

            }
        }
        System.out.print("Second largest Number is= "+second);

    }
}
