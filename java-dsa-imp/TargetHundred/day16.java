package TargetHundred;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class day16 {
    //1. Two Sum Problem
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // Not found
    }

    //Count frequency of elements
    public static void countFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times");
        }
    }

    //Longest consecutive subsequence
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        for (int num : set) {
            // only start counting if num-1 is not in set
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                // count how long the streak goes
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }

    //Check for pair with given sum
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    //Subarray with given sum (hash map approach)
    public static boolean hasSubarrayWithSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (currSum == k) {
                return true; // Subarray from 0 to i
            }

            if (map.containsKey(currSum - k)) {
                return true; // Subarray from map.get(...) + 1 to i
            }

            map.putIfAbsent(currSum, i);
        }

        return false;
    }

   public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    System.out.println(Arrays.toString(twoSum(nums, target))); // [0, 1]

    // int[] arr = {1, 3, 2, 1, 4, 3, 2, 1};
    // countFrequency(arr);

    // int[] arr = {100, 4, 200, 1, 3, 2};
    // System.out.println(longestConsecutive(arr)); 

    // int[] arr = {8, 4, 1, 6};
    // int target = 10;
    // System.out.println(hasPairWithSum(arr, target));

        int[] arr = {10, 15, -5, 15, -10, 5};
        int k = 20;
        System.out.println(hasSubarrayWithSum(arr, k)); 
   }
}
