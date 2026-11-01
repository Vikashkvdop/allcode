import java.util.Scanner;

public class prep27 {
    /* Imagine you are working with a system that stores text in camel case format,
       where multiple words are joined together without spaces and each new word start with an
       uppercase letter
       For better readability, you need to reformat this string by separating the words
       and converting all characters to lowercase
       input -HiVikashHowAreYou
       output hi vikash how are you
     */
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();

        StringBuilder result=new StringBuilder();
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            if (Character.isUpperCase(ch)) {
                if (i!=0) {
                    result.append(" ");
                }
                result.append(Character.toLowerCase(ch));
            }else{
                result.append(ch);
            }
        }
        System.out.print(result);
    }
}
