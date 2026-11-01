public class QuickSort {
    public static void quickSort(int arr[],int low ,int high){
        if (low<high) {
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }
    public static int partition(int arr[],int low,int high){
        int pivot=arr[high];
        int i=low-1;

        for(int j=low; j<high;j++){
            if (arr[j]<pivot) {
                i++;
                //swap
                int temp=arr[i];
                arr[i]=arr[j];

                arr[j]=temp;
            }
        }
        //swap with pivot
        i++;
        int temp=arr[i];
        arr[i]=arr[high];
        arr[high]=temp;
        return i;
    }
    public static void main(String[] args) {
        int arr[]={5,6,2,3,1};
        quickSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}



// Time complexity in worst case O(n^2)
// worst case occur when pivot is smallest or largest 
// Time complexity in average case O(nlogn);
// NO need extra space 