import java.util.HashMap;
import java.util.Scanner;

/* Jack is always excited about sunday. Its is favourite day when he gets to play all day. And goes to cycling
   with his friends. so every time when the months starts he count the number of sunday he will get enjoy. considering the month
   can start with any day, be it sunday, monday.. Or so on.
   count the number of sunday jack will get within n number of days
   Eample input - mon(denoting start of month) 
          input 13 input integer denoting the number of days from the start of month
          output- 1 (number of sunday in given days)*/

public class prep18 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int n=sc.nextInt();

        HashMap<String,Integer> map=new HashMap<>();
        map.put("sun",0);
        map.put("mon",1);
        map.put("tue",2);
        map.put("wed",3);
        map.put("thu",4);
        map.put("fri",5);
        map.put("sat",6);

        int start= map.get(str.substring(0, 3));
        int ans=0;
        int firstSunday=(7-start)%7;
        if(firstSunday<n){
            ans=1+(n-firstSunday-1)/7;
        }
        System.out.print(ans);

        
        
    }
}
