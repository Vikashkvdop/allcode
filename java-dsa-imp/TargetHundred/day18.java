package TargetHundred;

public class day18 {
    //check if a number is power of 2
    public static boolean isPowerOfTwo(int n){
        if(n<=0) return false;
        return (n & (n-1))==0;
    }

    // Count number of set bits (set bit=1)
    public static int countSetBits(int n){
        int count=0;
        while (n!=0) {
            n=n & (n-1);
            count++;
        }
        return count;
    }
    //find the only non repeating element
    public static int findSingleNumber(int[] nums){
        int result=0;
        for(int num:nums){
            result^=num;
        }
        return result;
    }

    // XOR of all elements
    public static int xorAllElements(int[] nums){
        int result=0;
        for(int num:nums){
            result^=num;
        }
        return result;
    }
    //Swap two numbers without temp variable
    public static void swapXOR(int[] arr) {
        if (arr.length < 2) return;

        int a = arr[0];
        int b = arr[1];

        a = a ^ b;
        b = a ^ b; // (a ^ b) ^ b = a
        a = a ^ b; // (a ^ b) ^ a = b

        arr[0] = a;
        arr[1] = b;
    }
    public static void main(String[] args) {
        //System.out.println(isPowerOfTwo(3));

        //System.out.println(countSetBits(2));

        //int[] arr={12,12,2,5,2};
        //System.out.println(findSingleNumber(arr));

        //System.out.println(xorAllElements(arr));

        int[] nums={2,3};
        swapXOR(nums);
        for(int num:nums){
            System.out.print(num);
        }
    }
}
