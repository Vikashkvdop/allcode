package TargetHundred;

import java.util.*;


public class day7 {
    //Longest palindrome in a string
    
    public static void findLongestPalindrome(String str) {
        if (str == null || str.length() < 1) {
            System.out.println("No palindrome");
            return;
        }

        int start = 0, end = 0;

        for (int i = 0; i < str.length(); i++) {
            int len1 = expandAroundCenter(str, i, i);       // Odd length palindrome
            int len2 = expandAroundCenter(str, i, i + 1);   // Even length palindrome
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        String longestPalindrome = str.substring(start, end + 1);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    //Check if a string contains all unique characters
    public static boolean isUniqueCharacters(String str){
        char[] chars=new char[str.length()];
        chars=str.toCharArray();
        Arrays.sort(chars);
        for(int i=1; i<chars.length; i++){
            if (chars[i]==chars[i-1]) {
                return false;
            }
        }
        return true;
    }

    //Replace spaces with %20 (URLify)
    public static String urlify(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                result.append("%20");
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    // by using built-in function
    public static String urlify1(String str) {
        if (str == null) return null;

        // Trim leading/trailing spaces and replace internal spaces
        return str.trim().replaceAll(" ", "%20");
    }

    //Implement atoi (string to integer)
    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;

        int i = 0, n = s.length();
        int sign = 1;
        long result = 0;

        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert digits to integer
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            result = result * 10 + digit;

            // 4. Check for overflow
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign * result);
    }

    //First non-repeating character
    public static Character firstNonRepeatingChar(String str) {
        if (str == null || str.isEmpty()) return null;

        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find first character with frequency 1
        for (char c : str.toCharArray()) {
            if (freqMap.get(c) == 1) {
                return c;
            }
        }

        return null; // or throw exception or return '-1' if required
    }

    public static void main(String[] args) {
        // String str="loan";
        // System.out.print(isUniqueCharacters(str));

        // String str1="rabacar";
        // findLongestPalindrome(str1);

        // String str="i am vikash";
        // System.out.print(urlify(str));

        System.out.println(myAtoi("42"));             // 42
        System.out.println(myAtoi("   -42"));         // -42
        System.out.println(myAtoi("4193 with words"));// 4193
        System.out.println(myAtoi("words 987"));      // 0
        System.out.println(myAtoi("-91283472332"));   // -2147483648 (clamped)

        System.out.println(firstNonRepeatingChar("leetcode"));      // l
        System.out.println(firstNonRepeatingChar("loveleetcode"));  // v
        System.out.println(firstNonRepeatingChar("aabbcc"));
    }
}
