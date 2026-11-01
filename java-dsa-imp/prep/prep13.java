import java.util.Scanner;

public class prep13 {
    //find gcd by recursive method;
    public static int findgcd(int a, int b){
        if(b==0) return a;
        return findgcd(b,a%b);
    }
    //find gcd by iterative method
    public static int gcdIterative(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i]=sc.nextInt();
        }
        int gcd=arr[0];
        for(int i=0; i<arr.length; i++){
            gcd=findgcd(gcd, arr[i]);
        }
        System.out.print("gcd "+gcd);
    }
}
