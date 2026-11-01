

/* Before the outbreak of corona virus to the world,a meeting happened in room in wuhan. 
   A preson who attended that meeting had covid-19 and no one in the room knew about it.
   So everyone started shaking hands with everyone else in the room as a gesture of repect and after meeting 
   unfortunately every one got infected given the fact that any two presons shake hand exactly once, can you tell the
   total count of handshakes happened in that meeting
   input - the first line contains the numbers of test cases T, T lines follow
            Each line then contains an integer N the total number of people attended that meeting

   output- print the number of handshakes for each test cases in new line
 */

import java.util.Scanner;

public class prep24 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int handShakes=(n*(n-1))/2;
            System.out.println(handShakes);
        }
        return;
    }
}
