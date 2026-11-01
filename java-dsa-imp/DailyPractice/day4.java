package DailyPractice;

import java.util.LinkedHashMap;
import java.util.Map;

public class day4 {
    //write a program to gind non repeating character in string
    public static Character firstNonRepeating(String str){
        Map<Character,Integer> freqMap=new LinkedHashMap<>();

        for(char ch:str.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }

        for(Map.Entry<Character,Integer> entry: freqMap.entrySet()){
            if (entry.getValue()==1) {
                return entry.getKey();
            }
        }
        return null;
    }

    //write a program to replace substring in a string 
    public static String replaceSubstring(String original, String target, String replacement) {
        return original.replace(target, replacement);
    }

    //write a program of armstrong number
    public static boolean isArmstrong(int number){
        int original=number;
        int sum=0;
        int digits=countDigit(number);
        while (number>0) {
            int digit=number%10;
            sum+=Math.pow(digit,digits);
            number/=10;
        }
        return sum==original;
    }
    public static int countDigit(int number){
        int count=0;
        while (number>0) {
            count++;
            number/=10;
        }
        return count;
    }


    //write a program to find the sum of natural numbers using recursion
    public static int sumNNaturalNumber(int n){
        if (n==0) return 0;
       
        return n+sumNNaturalNumber(n-1);
    }
    //write a  program to add two matrices using milti dimensional array
    public static int[][] addMatrices(int[][] a,int[][] b){
        int rows= a.length;
        int cols=a[0].length;
        int[][] result=new int[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                result[i][j]=a[i][j]+b[i][j];
            }
        }
        return result;
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // String str="aabbvdd";
        // Character result=firstNonRepeating(str);
        // System.out.println(result);

        // String original = "the sky is blue and the sky is beautiful";
        // String target = "sky";
        // String replacement = "cloud";

        // String modified = replaceSubstring(original, target, replacement);

        // System.out.println("Original String: " + original);
        // System.out.println("Modified String: " + modified);

        //System.out.println(isArmstrong(153));

        //System.out.println(sumNNaturalNumber(5));



        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] matrix2 = {
            {7, 8, 9},
            {10, 11, 12}
        };

        int[][] sum=addMatrices(matrix1, matrix2);

        printMatrix(sum);
    }
}
