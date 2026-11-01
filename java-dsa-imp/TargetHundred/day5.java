package TargetHundred;

import java.util.Arrays;

public class day5 {
    //Reverse string
    public static void reverseString(String str){
        for(int i=str.length()-1; i>=0;i--){
            System.out.print(str.charAt(i));
        }
    }
    //another method
    public static String reverseString1(String str){
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

    //Check if a string is palindrome
    public static boolean isPalindrome(String str){
        int left=0,right=str.length()-1;
        while (left<right) {
            if (str.charAt(left)!=str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //Find duplicate characters in a string
    public static void findDuplicates(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);  // Sorts the characters alphabetically

        System.out.println("Duplicate characters:");
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                System.out.println(chars[i]);
                // Skip over all occurrences of this character
                while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                    i++;
                }
            }
        }
    }

    //check if two string are anagrams
    public static boolean isAnagram(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) return false;

        // Convert both strings to char arrays and sort
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        // Compare sorted arrays
        return Arrays.equals(sArr, tArr);
    }

    //Remove duplicate from a string
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            boolean found = false;

            // Check if current character already exists in result
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == current) {
                    found = true;
                    break;
                }
            }

            // Append only if not found
            if (!found) {
                result.append(current);
            }
        }

        return result.toString();
    }

    //another method
      public static String removeDuplicates1(String str) {
        boolean[] seen = new boolean[256]; // Assuming ASCII characters
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!seen[ch]) {
                seen[ch] = true;
                result.append(ch);
            }
        }

        return result.toString();
    }


    public static void main(String[] args) {
        //String str="helloworld";
        //reverseString(str);
        //System.out.print(reverseString1(str));

        // String str="carrtac";
        // System.out.print(isPalindrome(str));

        // String str="applel";
        // findDuplicates(str);

        // String str1="listen";
        // String str2="silent";
        // System.out.print(isAnagram(str1, str2));

        String str="raccar";
        System.out.print(removeDuplicates(str));
    }
}
