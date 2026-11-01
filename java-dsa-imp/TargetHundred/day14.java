package TargetHundred;

import java.util.ArrayList;
import java.util.List;

public class day14 {
    //Recursion and backtracking
    //Factorial of number
    public static int factorial(int n){
        if (n==1 || n==0) {
            return 1;
        }
        return n*factorial(n-1);
    }

    //fibonacci number
    public static int fabonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fabonacci(n-1)+fabonacci(n-2);
    }

    //Print all subsets of a string/array
    public static void printSubsets(String str) {
        helper(str, 0, "");
    }

    private static void helper(String str, int index, String curr) {
        // Base case: end of string
        if (index == str.length()) {
            System.out.println("\"" + curr + "\"");
            return;
        }

        // Include current character
        helper(str, index + 1, curr + str.charAt(index));

        // Exclude current character
        helper(str, index + 1, curr);
    }

    public static void printSubsets(int[] arr) {
        List<Integer> current = new ArrayList<>();
        generateSubsets(arr, 0, current);
    }

    private static void generateSubsets(int[] arr, int index, List<Integer> current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // Include the current element
        current.add(arr[index]);
        generateSubsets(arr, index + 1, current);

        // Backtrack and exclude the current element
        current.remove(current.size() - 1);
        generateSubsets(arr, index + 1, current);
    }

    //Tower of hanoi
    public static void towerOfHanoi(int n, char source, char helper, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Step 1: Move top n-1 disks from source to helper
        towerOfHanoi(n - 1, source, destination, helper);

        // Step 2: Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Step 3: Move the n-1 disks from helper to destination
        towerOfHanoi(n - 1, helper, source, destination);
    }


    // N queens problem
    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        placeQueens(board, 0);
    }

    private static void placeQueens(char[][] board, int row) {
        int n = board.length;

        // Base case: All queens are placed
        if (row == n) {
            printBoard(board);
            System.out.println();
            return;
        }

        // Try placing queen in each column
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';        // Place queen
                placeQueens(board, row + 1);  // Recurse for next row
                board[row][col] = '.';        // Backtrack
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check column above
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row)
                System.out.print(c + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        //System.out.println(factorial(5));

        //System.out.println(fabonacci(4));

        // String input="abd";
        // printSubsets(input);

        // int[] arr={1,2,3};
        // printSubsets(arr);

        // int n = 3; // Number of disks
        // towerOfHanoi(n, 'A', 'B', 'C');

        int n = 4;
        solveNQueens(n);
    }
}
