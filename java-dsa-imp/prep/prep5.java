import java.util.Scanner;

public class prep5 {
    //check weither it is prime number or not
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean isprime=true;
        if(n<=1) isprime=false;
        for(int i=2; i*i<=n;i++){
            if(n%i==0){
                isprime=false;
                break;
            }else{
                isprime=true;
            }
        }
        System.out.print(isprime);
    }
}
