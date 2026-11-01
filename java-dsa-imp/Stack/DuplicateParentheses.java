package Stack;

import java.util.Stack;

/* Given a balanced expression find if it contains duplicate parentheses or not.A set of parentheses are duplicate
 * if the same subexpression is surrounded by multiple parentheses
 * return a true if it contains duplicate else false
 * example- (((a+(b)))+(c+d))  true
 * ((a+b)+(c+d))  false
 */
public class DuplicateParentheses {
    public static boolean isDuplicate(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0; i<str.length();i++){
            char ch=str.charAt(i);

            //closing
            if (ch==')') {
                int count=0;
                while (s.peek()!='(') {
                    s.pop();
                    count++;
                }
                if (count<1) {
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str="((a+b)+(c+d))";
        System.out.print(isDuplicate(str));
    }
}
