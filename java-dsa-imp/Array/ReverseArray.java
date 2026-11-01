package Array;

public class ReverseArray {
    public static void reverseArray(int num[]){
        int end=num.length-1;
        int first=0;
        while (first<end) {
            int temp=num[end];
            num[end]=num[first];
            num[first]=temp;
            first++;
            end--;
        }
      
    }
    public static void main(String[] args) {
        int nums[]={6,7,9,2,4};
        reverseArray(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }
}
