package TargetHundred;

import java.util.Arrays;

public class day19 {
    //Check for prime number
    public static boolean isPrime(int n){
        if(n<=1) return false;

        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }

    // Recursive method to find GCD
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM using GCD
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    //Sieve of Eratosthenes
    public static void sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // Assume all are prime
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        // Loop up to square root of n
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as false
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Print all primes
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    //Find square root of a number (binary search)
    public static int squareRoot(int x) {
        if (x == 0 || x == 1) return x;

        int low = 1, high = x, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // To avoid overflow, cast to long
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid; // Possible answer, move right
                low = mid + 1;
            } else {
                high = mid - 1; // Move left
            }
        }

        return ans; // Floor value of sqrt(x)
    }



    public static void main(String[] args) {
        //System.out.println(isPrime(9));

        //int a=4, b=6;
        //System.out.println(gcd(a, b));
        //System.out.println(lcm(a, b));

        // int n=50;
        // sieveOfEratosthenes(n);

        int[] testCases = {0, 1, 4, 10, 25, 100, 2147395599};

        for (int x : testCases) {
            System.out.println("Square root of " + x + " = " + squareRoot(x));
        }
    }
}
