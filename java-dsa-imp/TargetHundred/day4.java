package TargetHundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class day4 {

    //Longest subarray with given sum
    public static int longestSubarrayWithSum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLength = i + 1;
            }

            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }

            // Only store the first occurrence of the sum
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    //Check if subarray with 0 sum exists
     public static boolean subarrayWithZeroSumExists(int[] arr) {
        Set<Integer> prefixSums = new HashSet<>();
        int sum = 0;

        for (int num : arr) {
            sum += num;

            if (sum == 0 || prefixSums.contains(sum)) {
                return true;  // Found a zero-sum subarray
            }

            prefixSums.add(sum);
        }

        return false;  // No zero-sum subarray found
    }

    //Find the first repeating element
    public static int firstRepeatingElement(int[] arr){
        int firstRepeating=-1;
        Set<Integer> seen=new HashSet<>();

        for(int i=arr.length-1; i>=0; i--){
            if (seen.contains(arr[i])) {
                firstRepeating=arr[i];
            }else{
                seen.add(arr[i]);
            }
        }
        return firstRepeating;
    }

    // Count frequency of elements
    public static void countFrequency(int[] arr){
        Arrays.sort(arr);
        int count=1;

        for(int i=1; i<arr.length; i++){
            if (arr[i]==arr[i-1]) {
                count++;
            }else{
                System.out.println(arr[i-1]+"->"+count);
                count=1;
            }
            
        }

        System.out.println(arr[arr.length-1]+"->"+count);
    }

    //another method
    public static void countFrequency2(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    //Rearrange array in alternating positive & negative
    public static void rearrangeAlternating(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : arr) {
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        int i = 0, p = 0, n = 0;

        // Alternate placing positive and negative
        while (p < pos.size() && n < neg.size()) {
            arr[i++] = pos.get(p++);
            arr[i++] = neg.get(n++);
        }

        // If any elements are left
        while (p < pos.size()) {
            arr[i++] = pos.get(p++);
        }

        while (n < neg.size()) {
            arr[i++] = neg.get(n++);
        }
    }



    public static void main(String[] args) {
        // int[] arr = {1, 2, 1, 1, 1};
        // int k = 3;
        // System.out.println(longestSubarrayWithSum(arr, k));


        // int[] arr1 = {4, 2, -3, 1, 6};
        // int[] arr2 = {1, 2, 3};

        // System.out.println(subarrayWithZeroSumExists(arr1));  // true
        // System.out.println(subarrayWithZeroSumExists(arr2));  // false

        // int nums[]={1,2,3,4,2,3,-1};
        // System.out.print(firstRepeatingElement(nums));

        //int arr[]={1,2,-1,2,10,10,-1,-1};
        //countFrequency(arr);
        //countFrequency2(arr);

        int[] arr = {1, 2, 3, -4, -1, 4};
        rearrangeAlternating(arr);
        System.out.println(Arrays.toString(arr));


    }
}
