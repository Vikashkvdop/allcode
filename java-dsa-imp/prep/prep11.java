import java.util.Scanner;

public class prep11 {
    //given an integer n count the number of 1's in its binary represetation. This is also knownnas hamming weight
    //or population count
    //0101- 2 sets bit
    // 0111-3 sets bit
    public static int countSetBits(int n){
        int count=0;
        while (n!=0) {
            n=n &(n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print(countSetBits(n));
    }
}
