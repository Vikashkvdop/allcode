import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class prep6 {
    //Remove duplicate from array
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        Set<Integer> set=new LinkedHashSet<>();
        for(int num:arr){
            set.add(num);
            
        }
        System.out.print(set);

    }
}
