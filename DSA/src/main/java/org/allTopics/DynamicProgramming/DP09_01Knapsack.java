package org.allTopics.DynamicProgramming;

// Problem Link :- https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

/*
Problem Description :-
Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the
items in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is
maximized.

Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in
single quantity.

Examples :

Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6]
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3]
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.

Constraints:
2 ≤ val.size() = wt.size() ≤ 10^3
1 ≤ W ≤ 10^3
1 ≤ val[i] ≤ 10^3
1 ≤ wt[i] ≤ 10^3

 */

import java.util.Arrays;

public class DP09_01Knapsack {
    static int knapsack(int W, int val[], int wt[]) {

        // // Approach - 1:- Recursive :- TC:- O(2^N), SC:- O(N)
        // return rec(W, val, wt, val.length-1);

        // // Approach - 2:- Memoization :- TC:-
        /*
         int[][] dp = new int[val.length+1][W+1];
         for(int[] arr: dp) Arrays.fill(arr,-1);
         return memoization(W,val,wt,dp,val.length-1);

         */

        // Approach - 3:- Tabulative Approach:- TC:- O(N*Capacity),  SC:- O(N*Capacity)
        /*
        int[][] dp = new int[val.length+1][W+1];

        for(int i=0;i<=val.length;i++){
            for(int j=0;j<=W;j++){
                // here 1st row and 1st column ka mtlb kya hua yha pe ki 1col =0 means mre knapsack ki capacity hi 0 he
                // to me usme add kya hi krunga. And 1st row=0, i.e. knapsack ki capacity to di h means j=1,2,3,4,...
                // but mre pass usme rkhne k liye koi weight hi nh h so we kept 0 for both of that condition.
                if(i==0||j==0) dp[i][j]=0;
                else{
                    int notPick = dp[i-1][j];
                    int pick = Integer.MIN_VALUE;
                    if(j-wt[i-1]>=0){
                        pick = val[i-1] + dp[i-1][j-wt[i-1]];
                    }
                    dp[i][j] = Math.max(pick,notPick);
                }
            }
        }
        return dp[val.length][W];

         */

        // Approach - 4:- Space Optimised Approach :- Using two 1-D arrays instead of N*Capacity dp array
        // TC:- O(N*Capacity), SC:- O(Capacity)
        // Not working code:-
        /*
        int[] prev = new int[W+1];
        int[] curr = new int[W+1];
        for(int i=0;i<=val.length;i++){
            for(int j=0;j<=W;j++){
                if(i==0||j==0) curr[j] = 0;
                else{
                    int notPick = prev[j];
                    int pick= Integer.MIN_VALUE;
                    if(j-wt[i-1]>=0) pick = val[i-1] + prev[j-wt[i-1]];
                    curr[j] = Math.max(pick,notPick);
                }
            }
            // prev=curr;
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[W];

         */



        // Approach - 4:- Space optimised approach :- TC:- O(N*Capacity), SC:- O(Capacity)
        // with Optimised SC:- by using two 1-D array instead of using 2-D array.
        int[] currRow = new int[W+1];
        for(int i=0;i<val.length;i++){
            for(int j=W;j>=wt[i];j--){
                int ans = val[i]+currRow[j-wt[i]];
                currRow[j] = Math.max(ans, currRow[j]);
            }
        }
        return currRow[W];
    }

    private static int rec(int capacity, int val[], int wt[], int endIdx){
        // Base Check
        if(endIdx==0){
            if(capacity-wt[endIdx]>=0) return val[endIdx];
            return 0;
            // // Another shorthand way to write above lines
            // return (capacity-wt[endIdx]>=0)?val[endIdx]:0;
        }
        // Sanity Check
        if(endIdx<0) return 0;
        if(capacity<0) return 0; // invalid case handling
        // Recursive call
        int notPick = rec(capacity, val, wt, endIdx-1);
        int pick=Integer.MIN_VALUE;
        if(capacity-wt[endIdx]>=0){
            pick = val[endIdx] + rec(capacity-wt[endIdx],val,wt,endIdx-1);
        }
        return Math.max(pick,notPick);
    }

    private static int memoization(int capacity, int val[], int wt[], int[][] dp, int endIdx){
        // Base case
        if(endIdx==0){
            if(capacity-wt[endIdx]>=0){
                dp[endIdx][capacity]=val[endIdx];
                return val[endIdx];
            }
            return 0;
        }
        // Sanity Check
        if(endIdx<0 || capacity<0) return 0; // handling edge case of invalid index. And if knapsack is full,
        // means no capacity then we don't need to proceed further.

        // DP check
        if(dp[endIdx][capacity]!=0) return dp[endIdx][capacity];
        // Recursive calls
        int notPick = memoization(capacity,val,wt,dp,endIdx-1);
        int pick=Integer.MIN_VALUE;
        if(capacity-wt[endIdx]>=0){
            pick = val[endIdx] + memoization(capacity-wt[endIdx], val, wt, dp, endIdx-1);
        }
        dp[endIdx][capacity] = Math.max(notPick,pick);
        return dp[endIdx][capacity];
    }
}
