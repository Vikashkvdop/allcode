import java.util.Scanner;

public class prep28 {
    /* A parking lot in a mall has R*C number of parking spaces. Each parking space will
      either be empty (0) or full (1).
      The status(0/1) of a parking space is represented as the element of the matrix.
      The task is to find the index of the row (R) in the parking lot that has the maximum
      number of parking spaces full (1).
      Note:
      R*C=Size of the matrix
      Element of the matrix M should be only 0 or 1
      Input: 3 - value of R(row)
             3 - Value of C (column)
            0 1 0
            1 1 0
            1 1 1

            output:3

    */
   public static int findRowWithMax1(int[][] matrix,int row, int col){
        if (row==0 && col==0) {
            return 0;
        }
        int maxCount=0;
        int rowIndex=-1;
        for(int i=0; i<row; i++){
            int count=0;
            for(int j=0; j<col; j++){
                if (matrix[i][j]==1) {
                    count++;
                }
            if (count>maxCount) {
                maxCount=count;
                rowIndex=i;
            }
            }
        }
        return rowIndex+1;//1 based indexing
    }
   public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int R=sc.nextInt();
    int C=sc.nextInt();
    int[][] matrix=new int[R][C];
    for(int i=0; i<R; i++){
        for(int j=0; j<C; j++){
            matrix[i][j]=sc.nextInt();
        }
    }
    System.out.print(findRowWithMax1(matrix, R, C));

   }
}
