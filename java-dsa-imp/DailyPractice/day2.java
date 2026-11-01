package DailyPractice;



public class day2 {
    //write a program to check prime number
    public static boolean isPrime(int n){
        if (n<=1) {
            return false;
        }
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
    //write a program to find the largest prime factor
    public static long largestPrimeFactor(int n){
        long largestFactor=-1;
        //divide out the 2 factor until nis odd
        if (n%2==0) {
            largestFactor=2;
            n/=2;
        }

        //try for odd numbers from 3
        for(long i=3; i*i<=n; i+=2){
            while (n%i==0) {
                largestFactor=i;
                n/=i;
            }
        }
        // If remaining n is a prime number > 2
        if (n > 2) {
            largestFactor = n;
        }

        return largestFactor;
    }

    //write a program to remove duplicates from sorted array
    public static int removeDuplicate(int[] nums){
        if (nums.length == 0) return 0;

        int i = 0; // slow pointer

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // move unique element forward
            }
        }

        return i + 1; // length of unique elements
    }
    //write a program to print pascals triangle
    public static void printPascalsTriangle(int numRows) {
        for (int row = 0; row < numRows; row++) {
            for (int space = 0; space < numRows - row - 1; space++) {
                System.out.print("  ");
            }

            int val = 1;
            for (int col = 0; col <= row; col++) {
                System.out.printf("%4d", val);
                val = val * (row - col) / (col + 1);  // Update C(n, k)
            }

            System.out.println();
        }
    }
    //write a program to merge two array
    public static int[] mergeTwoArray(int[] arr1,int[] arr2){
        int l1=arr1.length;
        int l2=arr2.length;
        int[] result=new int[l1+l2];

        int i=0,j=0, k=0;
        while (i<l1 && j<l2) {
            if (arr1[i]<arr2[j]) {
                result[k++]=arr1[i++];
            }else{
                result[k++]=arr2[j++];
            }
        }
        while (i<l1) {
            result[k++]=arr1[i++];
        }
        while (j<l2) {
            result[k++]=arr2[j++];
        }
        return result;
    }

    //write a program to find best time to buy and sell stock 
    public static int maxProfit(int[] price){
        int maxProfit=0;
        int bestBuy=price[0];

        for(int i=1; i<price.length; i++){
            if (price[i]>bestBuy) {
                maxProfit=Math.max(maxProfit, price[i]-bestBuy);
            }
            bestBuy=Math.min(bestBuy, price[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        //System.out.println(isPrime(19));

        //System.out.println(largestPrimeFactor(13195));

        // int[] arr={1,3,4,4,4,5,5};
        // int length=removeDuplicate(arr);
        // for(int i=0; i<length; i++){
        //     System.out.print(arr[i]+" ");
        // }


        //printPascalsTriangle(5);

        // int[] arr1={4,5,2,9};
        // int[] arr2={1,3,5,11};
        // int[] merged= mergeTwoArray(arr1, arr2);
        // for(int num:merged){
        //     System.out.print(num+" ");
        // }


        int[] prices={7, 1, 5, 3, 6, 4};
        System.out.print(maxProfit(prices));
    }
}
