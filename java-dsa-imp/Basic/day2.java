package Basic;

public class day2 {

    // check prime number or not
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // divisible by a number other than 1 and itself
            }
        }
        return true;
    }

    // check vowel or consonant
    public static String checkVowelOrConsonant(char ch) {
        ch = Character.toLowerCase(ch);  // convert to lowercase

        if (!Character.isLetter(ch)) {
            return "Invalid input. Please enter an alphabet letter.";
        } 
        else if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return ch + " is a vowel.";
        } 
        else {
            return ch + " is a consonant.";
        }
    }
    //swap two number without using third variable
    public static void swap(int a,int b){
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("a="+a+","+"b="+b);
    }

    // write a program to find factorail number
    public static int findFactorail(int n){
        int fact=1;
        for(int i=1; i<=n; i++){
            fact*=i;
        }
        return fact;
    }

    // write a program to find perfect number
    /*What is a Perfect Number?
    A perfect number is a positive integer that is equal to the sum of its proper divisors (excluding itself).

    For example,
    6 is a perfect number because its divisors are 1, 2, 3 and
    1 + 2 + 3 = 6 */
    public static boolean isPerfect(int n) {
        if (n <= 1) {
            return false; // 1 and below are not considered perfect numbers
        }

        int sum = 0;

        // Find all divisors less than n and add them
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        // Check if sum of divisors equals the number itself
        return sum == n;
    }

    //Write a programe to print table of any given number 
    public static void printTable(int n){
        
        for(int i=1; i<=10; i++){
            System.out.println(n*i);
        }
    }

    //Write a program to check a person is able to vote or not
    public static void isAdult(int age){
        if (age>18) {
            System.out.println("He can vote");
        }else{
            System.out.println("He can not vote");
        }
    }
    
    //Write a programe to print foo if the number is divisible by 3 and print bar if the no. Is divisible by 5 and print foo bar if the no. Is divisible by 3 and 5
    public static void printFooBar(int n){
        if ((n%3==0)&& n%5==0) {
            System.out.println("FooBar");
        }else
        if (n%3==0) {
            System.out.println("Foo");
        } else
        if (n%5==0) {
            System.out.println("Bar");
        } else{
            System.out.println("Not valid ");
            
        }
        
    }

    public static void main(String[] args) {
        //System.out.println(isPrime(19));
        // char input='v';
        // System.out.println(checkVowelOrConsonant(input));
       // swap(4, 8);
       //System.out.println(findFactorail(5));
       //System.out.println(isPerfect(6));
       //printTable(10);
       //isAdult(21);
       printFooBar(2);
    }
}
