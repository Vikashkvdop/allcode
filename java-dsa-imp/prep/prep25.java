import java.util.HashMap;
import java.util.Scanner;

public class prep25 {
    //Given an  array containg 0's and 1's find the maximun length of subarray whose cotaining equal number of 0's ans 1's
    
    public static int maxLengthSubarray(int[] arr){
        int maxLen=0;
        int n=arr.length;
        int sum=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                sum+=-1;
            }else{
                sum+=1;
            }

            if (map.containsKey(sum)) {
                int prevIndex=map.get(sum);
                maxLen=Math.max(maxLen,i-prevIndex);
            }else{
                map.put(sum,i);
            }
            
        }
        return maxLen;
    }
    
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.print(maxLengthSubarray(arr));
        
    }
}
