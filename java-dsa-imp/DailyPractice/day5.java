package DailyPractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class day5 {
    //write a program to find all repeating element in array
    public static Map<Integer,Integer> findRepeatingElements(int[] arr){
       Map<Integer,Integer> freqMap=new HashMap<>();
        for(int num:arr){
            freqMap.put(num,freqMap.getOrDefault(num, 0)+1);
        }
        Map<Integer,Integer>result=new HashMap<>();
        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            if (entry.getValue()>1) {
                result.put(entry.getKey(),entry.getValue());
            }
        }
        return result;
    }

    //Write a program to find all symetric pairs in array
    public static void findSymmetricPairs(int[][] arr){
        Map<Integer,Integer>map=new HashMap<>();

        for(int[] num: arr){
            int first=num[0];
            int second=num[1];

            if (map.containsKey(second) && map.get(second)==first) {
                System.out.println("("+first+","+second+")");
            }else{
                map.put(first,second);
            }
        }
    }

    //write a program to remove duplicate from sorted array
    public static int removeDuplicate(int[] arr){
        int j=0;
        for(int i=1; i<arr.length; i++){
            if (arr[i]!=arr[j]) {
               
                j++;
                arr[j]=arr[i];
            }
        }
        return j+1;
    }

    //write a program to check is array is a subset of another array or not
    public static boolean isSubset(int[] arr1,int[] arr2){
        Set<Integer>set=new HashSet<>();

        for(int num:arr1){
            set.add(num);
        }

        for(int num:arr2){
            if (!set.contains(num)) {
                return false;
            }
        }
        return true;
    }

    //write a program to find sum of AP series
    public static int findSumOfAP(int[] arr){
        
        //sn=n/2(2a+(n-1)d)
        int n=arr.length;
        int a=arr[0];
        int d=arr[1]-arr[0];

        return (n*(2*a+(n-1)*d)/2);
    }    
    public static void main(String[] args) {
        // int[] num={8,2,8,1,2,6};
        // Map<Integer,Integer>repeatingFreqMap=findRepeatingElements(num);
        // System.out.println(repeatingFreqMap);


        // int[][] arr = {
        //     {1, 2},
        //     {3, 4},
        //     {5, 6},
        //     {2, 1},
        //     {6, 5},
        //     {4, 3}
        // };

        // findSymmetricPairs(arr);


        // int[] nums={1,2,3,3,5};
        // int length=removeDuplicate(nums);
        // for(int i=0; i<length; i++){
        //     System.out.print(nums[i]+" ");
        // }


        // int[] arr1={1,3,5,2,4};
        // int[] arr2={2,1,3,9};
        // System.out.println(isSubset(arr1, arr2));


        int[] arr={2,5,8,11,14};
        System.out.println(findSumOfAP(arr));
        
    }
}
