package TargetHundred;

public class day20 {
    //Count digits in a number
    public static int countDigits(int number){
        //handle nagative number by converting in postive
        number=Math.abs(number);
        int count=0;
        if (number==0) {
            return 1;
        }
        while(number>0){
            count++;
            number/=10;
            
        }
        return count;
    }

    //Reverse digits of a number
    public static int reverseNumber(int numbers){
        int reversed=0;
        int sign=numbers<0 ?-1:1;

        numbers=Math.abs(numbers);
        while (numbers>0) {
            int digit=numbers%10;
            reversed=reversed*10+digit;
            numbers/=10;
        }
        return reversed*sign;
    }

    //Check Armstrong number
    /*Examples:
    153 → 1³ + 5³ + 3³ = 1 + 125 + 27 = 153 ✔️
    9474 → 9⁴ + 4⁴ + 7⁴ + 4⁴ = 9474 ✔️ */
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;

        // Step 1: Count number of digits
        int digits = countDigits(number);

        // Step 2: Calculate sum of digits raised to the power of digits
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        // Step 3: Compare sum with original number
        return sum == originalNumber;
    }

    //Check for palindrome number
    public static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;

        // Negative numbers are not palindromes
        if (number < 0) return false;

        while (number > 0) {
            int digit = number % 10;              // Get last digit
            reversed = reversed * 10 + digit;     // Build reversed number
            number /= 10;                         // Remove last digit
        }

        return original == reversed;  // Check if original and reversed are same
    }

    //Decimal to Binary Conversion
    public static String decimalToBinary(int number) {
        if (number == 0) return "0";

        StringBuilder binary = new StringBuilder();

        while (number > 0) {
            int remainder = number % 2;        // Get remainder (0 or 1)
            binary.append(remainder);          // Append it
            number = number / 2;               // Divide number by 2
        }

        return binary.reverse().toString();    // Reverse the string to get correct binary
    }

    public static void testBinary(int num) {
        System.out.println("Binary of " + num + " is: " + decimalToBinary(num));
    }

    public static void main(String[] args) {
        //System.out.println(countDigits(732089));

        //System.out.println(reverseNumber(-5432));

        //System.out.println(isArmstrong(153));

        //System.out.println(isPalindrome(121));


         // Test cases
        testBinary(0);     // "0"
        testBinary(5);     // "101"
        testBinary(10);    // "1010"
        testBinary(255);   // "11111111"
        testBinary(1);     // "1"
        testBinary(100);   // "1100100"
    

    
    }
}
