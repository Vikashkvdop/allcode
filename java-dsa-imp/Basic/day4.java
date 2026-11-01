package Basic;

public class day4 {
    //Write a program to find maximum in an array.
    public static int findMax(int nums[]){
        int maximum=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=maximum){
                maximum=nums[i];
            }
        }
        return maximum;
    }

    //Write a program to count even numbers from an array
    public static int findEvens(int nums[]){
        int count=0;
        for(int i=0; i<nums.length; i++){
            if (nums[i]%2==0) {
                count++;
            }
        }
        return count;
    }

    //Write a program to calculate sum of even number in an array
    public static int sumOfEvens(int nums[]){
        int sum=0;
        for(int i=0; i<nums.length; i++){
            if (nums[i]%2==0) {
                sum+=nums[i];
            }
        }
        return sum;
    }

    //Write a program to find minimum from an array
    public static int findMin(int nums[]){
        int min=Integer.MAX_VALUE;
        for(int i=0; i<nums.length;i++){
            if (nums[i]<=min) {
                min=nums[i];
            }
        }
        return min;
    }

    //Write a program to count odd numbers in an array.
    public static int findOddNumbers(int nums[]){
        int count=0; 
        for(int i=0; i<nums.length; i++){
            if (nums[i]%2!=0) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int nums[]={3,6,1,-8,4};
        //System.out.println(findMax(nums));
        //System.out.println(findEvens(nums));
        //System.out.println(sumOfEvens(nums));
        //System.out.println(findMin(nums));
        System.out.println(findOddNumbers(nums));
    }
}
