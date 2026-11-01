package Array;
public class LinearSearch {
    public static boolean linearSearch(int arr[],int key){
      
        for(int i=0; i<arr.length; i++){
            if (key==arr[i]) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int arr[]={45,4,6,7,1,3};
        int key=1;
        System.out.print(linearSearch(arr, key));
    }
}
