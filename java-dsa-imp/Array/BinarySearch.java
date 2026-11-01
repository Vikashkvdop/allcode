package Array;
public class BinarySearch {
    public static boolean binarySearch(int arr[],int key){
        int n=arr.length;
        int mid=n/2;
        if (mid==key) {
            return true;
        }else if (key<mid) {
            for(int i=0; i<mid;i++){
                if (key==arr[i]) {
                    return true;
                }
            }
        }else if (mid<key) {
            for(int i=mid; i<n; i++){
                if (key==arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        int key=81
        ;
        System.out.print(binarySearch(arr, key));
    }
}
