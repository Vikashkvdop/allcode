public class MergeSort{
    public static void divide(int[] arr ,int startIndex, int endIndex){
        if(startIndex>=endIndex){
            return;
        }
        int mid=startIndex+(endIndex-startIndex)/2;
        divide(arr, startIndex,mid);
        divide(arr, mid+1, endIndex);
        conquer(arr,startIndex, mid, endIndex);
    }
    public static void conquer(int[] arr, int startIndex, int mid, int endIndex){
        int[] mergedArr= new int[endIndex-startIndex+1];
        int idx1=startIndex;
        int idx2=mid+1;
        int x=0;
        while (idx1<=mid && idx2<=endIndex) {
            if (arr[idx1]<=arr[idx2]) {
                mergedArr[x++]=arr[idx1++];
            }else{
                mergedArr[x++]=arr[idx2++];
            }
        }
        while (idx1<=mid) {
            mergedArr[x++]=arr[idx1++];
        }
        while (idx2<=endIndex) {
            mergedArr[x++]=arr[idx2++];
        }

        for(int i=0,j=startIndex; i<mergedArr.length;i++,j++){
            arr[j]=mergedArr[i];
        }
    }
    public static void main(String[] args) {
        int arr[]={5,3,6,1,2,4};
        divide(arr,0 , arr.length-1);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}


// Time complexity in every case O(nlogn)
// space complexity O(n) becasuse we need extra array to store sorted array