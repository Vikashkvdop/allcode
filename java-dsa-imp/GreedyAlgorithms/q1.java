package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// Activity selection
// you are given n activities with their start and end times. select the maximum number of activities
// that can be performed by a single person assuming that a person can only work on a single Activity
// at a time. activities are sorted according to end time 
public class q1 {
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,53};
        int end[]={2,4,6,7,9,93};

        //sorting
        int activities[][]=new int[start.length][3];
        for(int i=0; i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
        //end time basisi sort
        int maxAct=0;
        ArrayList<Integer>ans=new ArrayList<>();
        //1st activity
        maxAct=1;
        ans.add(activities[0][0]);
        int lastEnd=activities[0][2];
        for(int i=1;i<end.length;i++){
            if (activities[i][1]>=lastEnd) {
                //activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd=activities[i][2];
            }
        }
        System.out.print("Max activities="+maxAct);
        for(int i=0; i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();

        
    }
}
