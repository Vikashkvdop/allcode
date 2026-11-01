import java.util.Scanner;

public class pre2 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter string ");
        String s =scanner.next();
        s=s.toLowerCase();
        int vowels=0,consonant=0;
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i)>='a' && s.charAt(i)<='z') {
                if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                vowels++;
            }else{
                consonant++;
            }
            }
        }
        System.out.println("Vowels "+vowels);
        System.out.println("Consonant "+consonant);

    }
}
