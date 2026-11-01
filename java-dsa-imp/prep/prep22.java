

/*  An intelligence agency has received reports about some threats. the reports consist of numbers in a mystrious method.
    There is a number N and another number R . Those numbers are studied thoroughly and it is cocluded that all digits of number N are summed up
    and this action is performed R number of times. the resultant is also a single digit that is yet to be deciphered.
    the task here is to find the single digit sum of the given number N by repeating the action R number of times
    if the value of R is 0 print output as 0
    input - 99 value of N
            3 value of R
    output 9 
 */

import java.util.Scanner;

public class prep22 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        int sum=0;
        while (n>0) {
            sum+=n%10;
            n/=10;
        }
        sum=sum*r;
        // while (sum>10) {
        //     int ans=0;
        //     while (sum>0) {
        //         ans+=sum%10;
        //         sum/=10;
        //     }
        //     sum=ans;
        // }
        // there is shortcut number of finding sum of digit till become single digit
        //digital root formula
        int result=(int)(1+(sum-1)%9);
        System.out.print(result);
    }
}
