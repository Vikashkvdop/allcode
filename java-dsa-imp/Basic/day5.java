package Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class day5 {
    //Write a program to find the minimum element in an array.
    public static int findSmallest(int nums[]){
        int min=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if (nums[i]<min) {
                min=nums[i];
            }
        }
        return min;
    }

    //Given an array of integers, write a program to find the average of all elements.
    public static int averageOfArray(int nums[]){
        int n=nums.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
        }
        return sum/n;
    }

    //Write a program to remove duplicates from an array.
    public static List<Integer> removeDuplicates(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        for (Integer num : list) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    // another method to remove duplicate 
    public static List<Integer> removeDuplicates1(List<Integer> list) {
        // LinkedHashSet preserves insertion order and removes duplicates
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        return new ArrayList<>(uniqueSet); // Convert back to list
    }

    // How do you shift all elements in an array by a certain number of positions?


    //Write a program to find the second largest element in an array.
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            System.out.println("Array must contain at least two elements.");
            return -1; // or throw exception
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element (all elements are equal).");
            return -1;
        }

        return secondLargest;
    }
    public static void main(String[] args) {
        // int nums[]={2,-4,1,0,2,10};
        // System.out.println(findSmallest(nums));

        // System.out.println(averageOfArray(nums));

         List<Integer> nums = new ArrayList<>(Arrays.asList(-4, 5, -2, -4, 3, 2, 1));

        List<Integer> noDuplicates = removeDuplicates(nums);

        System.out.println("List after removing duplicates: " + noDuplicates);
        


        int[] arr = {10, 20, 5, 8, 20, 3};
        int second = findSecondLargest(arr);
        if (second != -1) {
            System.out.println("Second largest element: " + second);
        }
        
    }
}
