package Basic;

public class day1 {
    //write a program to calculate sum of  n number of series 

    public static int N_number_sum(int n){
        int sum=0;
        for(int i=0; i<=n; i++){
            sum+=i;
        }
        return sum;
    }
    // write a program to check even or odd
    public static boolean checkEvenOdd(int n){
        if (n%2==0) {
            System.out.println("even number");
            return true;
        }else{
            System.out.println("odd number");
            return false;
        }
    }
    //write a program to swap two numbers
    public static void swapNumbers(int a,int b){
        int temp=a;
        a=b;
        b=temp;
        System.out.println(a+","+b);
    }
    // write a program to print fobonnaci series
   public static void fibonacci(int n) {
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }


    //write a program to find largest number among three numbers
    public static int isLargest(int a,int b,int c){
        int largest=a;
        if (b>largest) {
            largest=b;
        }
        if (c>largest) {
            largest=c;
        }
        return largest;
    }
    //write a program to find the average number 
    public static float average(int arr[]){
        
        float sum=0;
        int n=arr.length;
        for(int i=0; i<n; i++){
            sum+=arr[i];
        }
        return sum/n;
        
    }
    //print pattern 
    public static void printPattern(int rows){
        for(int i=0; i<rows;i++){
            for(int j=0; j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    //factorail find
    public static void findFactorail(int n){
        int fact=1;
        for(int i=1; i<=n; i++){
            fact*=i;
        }
        System.out.println(fact);
    }
    public static void main(String[] args) {
        //System.out.println(N_number_sum(10));
        //System.out.println(checkEvenOdd(12));
        //swapNumbers(4, 6);
        fibonacci(6);
        //System.out.println(isLargest(4, 8, 1));

        //  int arr[]={2,2,2,2,2};
        //  System.out.println(average(arr));
        //printPattern(5);
        ////findFactorail(5);
    }
}
