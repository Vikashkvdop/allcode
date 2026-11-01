import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class practice {

    public static String reverseString(String str){
        char[] result=str.toCharArray();
        int left=0,right=str.length()-1;
        while (left<right) {
            char temp=result[left];
            result[left]=result[right];
            result[right]=temp;
            left++;
            right--;
        }
        return new String(result);
    }

    public static boolean isPalindrome(String str){
        int left=0, right=str.length()-1;
        while (left<right) {
            if (str.charAt(left)!=str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //find largest element in array
    public static int findLargest(int[] arr){
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    //count vowels
    public static int countVowels(String str){
         str= str.toLowerCase();
        int count=0;
        int n=str.length();
        for(int i=0; i<n; i++){
            if (str.charAt(i)=='a' || (str.charAt(i)== 'e') || (str.charAt(i)== 'i') ||
            (str.charAt(i)== 'o')||(str.charAt(i)== 'u')) {
                count++;
            }
        }
        return count;
    }
    //Fibonacci series
    public static void fibonacci(int n){
        int a = 0, b = 1;

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }
    public static int findFibonacci(int n){
        if(n<=1){
            return n;
        }
        return findFibonacci(n-1)+findFibonacci(n-2);
    }

    //Given an array and a target sum, find indices of two numbers such that they add up to the target.
    public static int[] twoSum(int[] arr, int target){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int complement=target-arr[i];

            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(arr[i],i);
        }
        return new int[] {};
    }

    //Reverse sentence
    public static String reverseSentence(String sentence){
        if (sentence==null || sentence.trim().isEmpty()) {
            return sentence;
        }
        String[] words= sentence.trim().split("\\s+");
        StringBuilder result=new StringBuilder();

        for(int i=words.length-1; i>=0; i--){
            result.append(words[i]);
            if(i!=0){
                result.append(" ");
            }
        }
        return result.toString();
    }
    //find missing number
    public static int findMissingNumber(int[] arr){
        int sum=0;
        int n=arr.length+1;
        int total=n*(n+1)/2;
        for(int num:arr){
            sum+=num;
        }
        return total-sum;
    }

    //write code to count frequency
    public static void countFrequency(String str){
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0; i<str.length();i++){
            char ch=str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        for(Map.Entry<Character,Integer>entry:map.entrySet()){
            System.out.print(entry.getKey()+":"+entry.getValue()+" ");
        }
    }
    //find duplicates in array
    public static List<Integer> findDuplicates(int[] arr){
        Set<Integer> seen =new HashSet<>();
        List<Integer>duplicates=new ArrayList<>();
        for(int num:arr){
            if(!seen.add(num)){
                duplicates.add(num);
            }
        }
        return duplicates;
    }
    //merge two sorted array
    public static int[] mergeSortedArray(int[] arr1, int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;
        int i=0,j=0,k=0;
        int[] result=new int[n1+n2];
        while (i<n1 && j<n2) {
            if (arr1[i]<=arr2[j]) {
                result[k++]=arr1[i++];
            }else{
                result[k++]=arr2[j++];
            }
        }
        while (i<n1) {
            result[k++]=arr1[i++];
        }
        while (j<n2) {
            result[k++]=arr2[j++];
        }
        return result;
    }
    //check if subarray with 0 sum exists
    public static boolean subArrayWithZeroSum(int[] arr){
        Set<Integer>prefixSum=new HashSet<>();
        int sum=0;
        for(int num:arr){
            sum+=num;
            if (sum==0 || prefixSum.contains(sum)) {
                return true;
            }
            prefixSum.add(sum);
        }
        return false;
    }
    //find duplicates in string
    public static  void findDuplicateCharacters(String str){
        Map<Character,Integer>map=new HashMap<>();
        for(char c:str.toCharArray()){
            map.put(c,map.getOrDefault(c, 0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if (entry.getValue()>1) {
                System.out.println(entry.getKey()+":"+entry.getValue()); 
            }
        }
    }
    public static void main(String[] args) {
        String str="helloeb";
        findDuplicateCharacters(str);
        // countFrequency(str);
        int[] arr1={1,2,-3,5};
        //System.out.print(subArrayWithZeroSum(arr1));
        // int[] arr2={3,9,8,9};
        // int[] result=mergeSortedArray(arr1, arr2);
        // for(int num:result){
        //     System.out.print(num+" ");
        // }

        //System.out.print(findDuplicates(arr));
        //System.out.print(findFibonacci(10));
        //fibonacci(10);
        // int n=6;
        // for(int i=0; i<=n; i++){
        //     System.out.print(findFibonacci(i)+" ");
        // }
        // int[] num= twoSum(arr, 9);
        // System.out.print(num[0]+" "+num[1]);
    }

}
