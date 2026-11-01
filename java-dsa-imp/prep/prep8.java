import java.util.Scanner;

public class prep8 {
    //check weither armstrong number
    public static int countDigit(int n){
        int count=0;
        while(n>0){
            n/=10;
            count++;
        }
        return count;
    }
    public static boolean isArmstrong(int n){
        int digits=countDigit(n);
        int original=n;
        int sum=0;
        while (n>0) {
            int digit=n%10;
            sum+=Math.pow(digit, digits);
            n/=10;
        }
        return original==sum;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print(isArmstrong(n));
        
        
    }
}
