package Stack;

import java.util.Stack;

// The next greater element of some element x in an array is the first greater element that is to the right
// of x in the same array 
public class NextGreaterEle {
    public static void main(String[] args) {
        int arr[]={6,8,0,5,1};
        Stack<Integer>s=new Stack<>();
        int nxtGreater[]=new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
            while (!s.isEmpty() && arr[s.peek()]<=arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nxtGreater[i]=-1;
            }else{
                nxtGreater[i]=arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0; i<nxtGreater.length;i++){
            System.out.print(nxtGreater[i]+" ");
        }
        System.out.println();
    }
}
