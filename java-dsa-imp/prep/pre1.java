import java.util.Scanner;

public class pre1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string ");
        String n=sc.next();
        
        boolean ans=false;
        int left=0;
        int right=n.length()-1;
        while (left<=right) {
            if(n.charAt(left)!=n.charAt(right)){
                ans=false;
            }else{
                ans=true;
            }
            left++;
            right--;
        }
        System.out.println(n+" is palindrome "+ans);

    }
}
