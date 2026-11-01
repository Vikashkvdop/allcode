import java.util.Scanner;

public class prep26 {
    /* Problem statement
       A bus travels through several stations. At each station
       some passenger get off, some passenger get on
       find the maximum number of passengers in the bus at any time
       input format 
       first line: integer N (number of stops)
       Next N line contain two integer:
       passenger getting off
       passenger getting on. 
       print passengers
     */
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int currPassenger=0;
        int maxPassenger=0;
        for(int i=0; i<n; i++){
            int off=sc.nextInt();
            int on=sc.nextInt();
            currPassenger=currPassenger-off+on;
            maxPassenger=Math.max(currPassenger,maxPassenger);
        }
        System.out.print(maxPassenger);
    }
}
