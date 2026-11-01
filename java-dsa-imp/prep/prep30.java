import java.util.Scanner;

public class prep30 {
    /* A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0
       for example, for x=7, the binay representation is 111 and we may choose any bit(including any leading zeros not shown) and flip it. We can flip the 
       first bit from the right to get 110, flip the second bit from the right to get 101
       flip the fifth bit from the right(a leading zero) to get 10111 etc.
       Given two integer start and goal return the minimum numnber of bit flips to 
       convert start to goal
       input: start=10,goal=7
       output: 3
    */
   public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int start=sc.nextInt();
    int goal=sc.nextInt();
    int res=start^goal;
    //System.out.print(Integer.bitCount(res));

    // another method to count set bit
    int count=0;
    while (res!=0) {
        res=res &(res-1);
        count++;
    }
    System.out.print(count);
   }
}
