package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;
// Given the weight and values of N items put these items in a knapsack of capacity  w to get the 
// maximum totl value in the knapsack
// value=[60,100,120]
// weight=[10,20,30]
// W=50
public class fractionalKnapsack {
    public static void main(String[] args) {
        int val[]={60,100,120};
        int weight[]={10,20,30};
        int w=50;
        double ratio[][]=new double[val.length][2];
        for(int i=0; i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        }
        //ascending order
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        int capacity=w;
        int finalval=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if (capacity>=weight[idx]) {
                finalval+=val[idx];
                capacity-=weight[idx];
            }else{
                finalval+=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
        System.out.println("final value="+finalval);
    }
}
