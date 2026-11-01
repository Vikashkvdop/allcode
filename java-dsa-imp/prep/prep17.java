import java.util.Scanner;

public class prep17 {
    //convert binary to decimal
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String binary=sc.next();

        int decimal=0;
        for(int i=0; i<binary.length(); i++){
            char bit=binary.charAt(i);
            decimal=decimal*2+(bit-'0');
        }
        System.out.print(decimal);
        sc.close();

    }
}
