package TargetHundred;

public class day17 {
    //Search an element in a matrix (metrix must be sorted)
    public static boolean searchInMetrix(int[][] metrix,int key){
        int row=metrix.length;
        int col=metrix[0].length;
        int i=0,j=col-1;
        while (i<row && j>=0) {
            if (metrix[i][j]==key) {
                System.out.println("Found at ("+i+" "+j+")");
                return true;
            }else if (metrix[i][j]>key) {
                j--;
            }else{
                i++;
            }
            
        }
        System.out.println("Element Not Found");
        return false;
    }

    //Transpose of a matrix
    public static int[][] transpose(int[][] metrix){
        int rows=metrix.length;
        int cols=metrix[0].length;

        int[][] transposed=new int[cols][rows];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                transposed[j][i]=metrix[i][j];
            }
        }
        return transposed;
    }
    //print matrix
    public static void printMetrix(int[][] matrix){
        for(int[] row:matrix){
            for(int ele:row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
        
    }

    //Rotate a matrix 90 degrees (clockwise)
    public static void rotateMatrixBy90d(int[][] matrix){
        transposeSquareMatrix(matrix);
        reverse(matrix);
    }
    public static void transposeSquareMatrix(int[][] matrix){
        int n=matrix.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    public static void reverse(int[][] matrix){
        int n =matrix.length;
        for(int i=0; i<n; i++){
            int start=0,end=n-1;
            while (start<end) {
                int temp=matrix[i][start];
                matrix[i][start]=matrix[i][end];
                matrix[i][end]=temp;
                start++;
                end--;
            }
        }
    }
    //Spiral traversal of a matrix
    public static void spiralTraversal(int[][] matrix){
        if (matrix.length==0) {
            return;
        }
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        while (top<=bottom && left<=right) {
            //1. Traverse left to right
            for(int i=left; i<=right; i++){
                System.out.print(matrix[top][i]+" ");
            }
            top++;
            //2.Traverse top to bottom
            for(int i=top; i<=bottom; i++){
                System.out.print(matrix[i][right]+" ");
            }
            right--;
            // traverse from right to left (check it is valid)
            if (top<=bottom) {
                for(int i=right; i>=left; i--){
                    System.out.print(matrix[bottom][i]+" ");
                }
                bottom--;
            }
            // traverse from bottom to top (check it is still valid)
            if (left<=right) {
                for(int i=bottom; i>=top; i--){
                    System.out.print(matrix[i][left]+" ");
                }
                left++;
            }
        }
    }


    // Set matrix zero
    /*Given an M*N matrix if an element if 0 set its entire row and column to 0 . you must do it in-place no extra space */
    public static void setZeroes(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        boolean firstRowHasZero=false;
        boolean firstColHasZero=false;

        //check if first row has zero
        for(int j=0; j<n; j++){
            if (matrix[0][j]==0) {
                firstRowHasZero=true;
                break;
            }
        }

        //step 2 check if first column has 0
        for(int i=0; i<m; i++){
            if (matrix[i][0]==0) {
                firstColHasZero=true;
                break;
            }
        }
        //marker first now and col zero
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (matrix[i][j]==0) {
                    matrix[0][i]=0;
                    matrix[j][0]=0;
                }
            }
        }
        //step 4. zero cells based on marker
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if (matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j]=0;
                }
            }
        }
        //step 5 zero first row if needed
        if (firstRowHasZero) {
            for(int j=0; j<n; j++){
                matrix[0][j]=0;
            }
        }
        //step6 zero first column needed
        if (firstColHasZero) {
            for(int i=0; i<m; i++){
                matrix[i][0]=0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] metrix={{1,3,5},
                        {2,9,10,},
                        {4,12,0}};

        //searchInMetrix(metrix, 100);

        // int[][] transposed= transpose(metrix);
        // printMetrix(transposed);

        // rotateMatrixBy90d(metrix);
        // printMetrix(metrix);

        //spiralTraversal(metrix);

        setZeroes(metrix);
        printMetrix(metrix);
    }
}
