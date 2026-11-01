import java.util.Scanner;

public class prep14 {
    //find LCM of two numbers
    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public static int findlcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i]=sc.nextInt();
        }
        int lcm=arr[0];
        for(int i=0; i<arr.length; i++){
            lcm=findlcm(lcm, arr[i]);
        }
        System.out.print("lcm "+lcm);

    }
}
