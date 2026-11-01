import java.util.Scanner;
/* A furnishing company is manufacturing a new collection of curtains, the curtains are of two colors aqua(a) and black(b).
   the curtains colors is represented as string(str) consisting of a's and b's of length N. then they are packed
   (substring) into L number of curtains in each box. the box with the maximum number of aqua(a) color curtains is
   labeled . the task here is to find the number of aqua color curtains in the labeled box.
   Note: if 'L' is not a multiple of N the remaining number of curtains should be considered as a substring too. 
   In simple words sfter dividing the curtains in set of 'L' any curtains left will be another set
   input- bbbaaababa - value of str
   input L-3
   output- 3 max number of a's
*/
public class prep21 {
    public static int findMaxCurtain(String str, int L){
        int n=str.length();
        
        int max=0;
        for(int i=0; i<n; i=i+L){
            int count=0;
            for(int j=i; j<i+L && j<n; j++){
                if (str.charAt(j)=='a') {
                    count++;
                }
            }
            max=Math.max(max, count);

        }
        return max;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int l=sc.nextInt();
        System.out.print(findMaxCurtain(str, l));

    }
}
