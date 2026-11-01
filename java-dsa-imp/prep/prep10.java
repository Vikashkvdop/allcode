import java.util.Scanner;

public class prep10 {
    //check given number is power of two or not
    public static boolean isPowerOfTwo(int n){
        if(n<=0) return false;
        return (n&(n-1))==0;
    }
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print(isPowerOfTwo(n));
    }
}
