package DailyPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class day3 {
    //write a program to find greatest common divisor
    public static int findGCD(int a,int b){
        while (b!=0) {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
        
    }

    //write a program to check to string is anagram or not
    public static boolean isAnagram(String str1,String str2){
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();

        char[] ch1=str1.toCharArray();
        char[] ch2=str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        if(ch1.length!=ch2.length){
            return false;
        }
        return Arrays.equals(ch1,ch2);
    }

    //write a program to calculate frequency of characters in string
    public static void countFrequency(String str){
        Map<Character,Integer> freqMap=new HashMap<>();

        str=str.replaceAll(".\\s", "").toLowerCase();

        for(char ch:str.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch, 0)+1);
        }
        // Print frequencies
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    //write a program for bubble sort
    public static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if (arr[j]>arr[j+1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    

    //write a program to check whether a given year is leap year or not
    public static boolean isLeapYear(int n){
        if ((n%4==0 && n%100!=0 || (n%400==0))) {
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        //System.out.print(findGCD(48, 18));

        //System.out.println(isAnagram("silent", "listep"));

        // String str="helloe";
        // countFrequency(str);


        // int[] nums={5,6,1,3,4};
        // bubbleSort(nums);
        // for(int num:nums){
        //     System.out.print(num+" ");
        // }

        System.out.println(isLeapYear(1604));
    }
}
