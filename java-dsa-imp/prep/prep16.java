import java.util.Scanner;

public class prep16 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder binary=new StringBuilder();
        if(n==0){
            System.out.print("0");
        }
        while (n>0) {
            int remainder=n%2;
            binary.append(remainder);
            n/=2;
        }
        System.out.print(binary.reverse());
    }
    
}
