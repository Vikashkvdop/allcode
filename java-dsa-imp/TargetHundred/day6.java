package TargetHundred;

public class day6 {

    //Count vowels, consonants, digits, and special characters
    public static void countCharacters(String str) {
        int vowels = 0, consonants = 0, digits = 0, specialChars = 0;

        str = str.toLowerCase(); // Case-insensitive comparison

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (!Character.isWhitespace(ch)) {
                specialChars++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + specialChars);
    }

    //Convert a string to lowercase/uppercase
    public static String toLower(String str) {
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            // Check if character is uppercase
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char)(ch + 32)); // Convert to lowercase
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
    public static String toUpper(String str) {
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            // Check if character is lowercase
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32)); // Convert to uppercase
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    //Print all substrings of a string
    public static void printSubstrings(String str) {
        int n = str.length();

        for (int i = 0; i < n; i++) { // Start index
            for (int j = i + 1; j <= n; j++) { // End index (exclusive)
                System.out.println(str.substring(i, j));
            }
        }
    }
    public static void printSubstrings1(String str) {
        char[] chars = str.toCharArray(); // Convert string to char array

        for (int i = 0; i < chars.length; i++) {           // Start index
            for (int j = i; j < chars.length; j++) {       // End index
                // Manually print characters from i to j
                for (int k = i; k <= j; k++) {
                    System.out.print(chars[k]);
                }
                System.out.println(); // Newline after each substring
            }
        }
    }

    //largest common prefix
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                // If index out of bounds or mismatch
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0]; // Whole first string is the prefix
    }


    //Implement strstr (substring search)
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int hLen = haystack.length();
        int nLen = needle.length();

        if (nLen > hLen) return -1;

        for (int i = 0; i <= hLen - nLen; i++) {
            int j;
            for (j = 0; j < nLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nLen) {
                return i; // Match found at index i
            }
        }

        return -1; // No match found
    }

    public static void main(String[] args) {
        // String input = "Hello World! 123";
        // countCharacters(input);

        // String original = "Hello world! Java123";
        // String upper = toUpper(original);

        // System.out.println("Original:  " + original);
        // System.out.println("Uppercase: " + upper);

        // String original = "Hello WORLD! Java123";
        // String lower = toLower(original);

        // System.out.println("Original:  " + original);
        // System.out.println("Lowercase: " + lower);

        // String input = "abc";
        // printSubstrings1(input);


        // String[] input = {"flower", "flow", "flight"};
        // System.out.println("Longest Common Prefix: " + longestCommonPrefix(input));

        String haystack = "helloox";
        String needle = "oo";
        System.out.println("Index: " + strStr(haystack, needle)); 
    
    }
}
