package TargetHundred;

public class day15 {
    //Generate all permutations of a string
    // input:"abc"
    //output: abc,acb , bac, bca, cab cba
    public static void printPermutations(String str,int index){
        if (index==str.length()-1) {
            System.out.println(str);
            return;
        }
        for(int i=index; i<str.length(); i++){
            str=swap(str,index,i);
            printPermutations(str, index+1);
            str=swap(str,index,i);
        }
    }
    private static String swap(String str,int i,int j){
        char[] chars=str.toCharArray();
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
        return String.valueOf(chars);
    }


    //Subset sum problem
    public static boolean isSubsetSum(int[] nums, int index, int target) {
        // Base Cases
        if (target == 0) return true;
        if (index == nums.length) return false;

        // If current element is less than or equal to target, we try including it
        if (nums[index] <= target) {
            if (isSubsetSum(nums, index + 1, target - nums[index])) {
                return true;
            }
        }

        // Try excluding the current element
        return isSubsetSum(nums, index + 1, target);
    }


    //Sudoku Solver (basic)
    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board)) return true;

                            // Backtrack
                            board[row][col] = '.';
                        }
                    }
                    return false; // if no number fits
                }
            }
        }
        return true; // all cells filled
    }

    private static boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == num) return false;

            // Check column
            if (board[i][col] == num) return false;

            // Check 3x3 box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == num) return false;
        }
        return true;
    }

    //Count all paths in a maze
    public static int countPaths(int row, int col, int n, int m) {
        // Base case: out of bounds
        if (row >= n || col >= m) {
            return 0;
        }

        // Base case: reached destination
        if (row == n - 1 && col == m - 1) {
            return 1;
        }

        // Recursive calls: right and down
        int rightPaths = countPaths(row, col + 1, n, m);
        int downPaths = countPaths(row + 1, col, n, m);

        return rightPaths + downPaths;
    }
    public static void main(String[] args) {
        // String str="abc";
        // printPermutations(str, 0);

        // int[] arr={1,9,5,6,7,11};
        // System.out.println(isSubsetSum(arr, 0, 10));

       /*char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
       solveSudoku(board);
       // print board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        } */

        int n = 3, m = 3;  // 3x3 grid
        int totalPaths = countPaths(0, 0, n, m);
        System.out.println("Total paths: " + totalPaths);
    }
}
