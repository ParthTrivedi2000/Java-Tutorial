package org.allTopics.DynamicProgramming;

// Problem Link:- https://leetcode.com/problems/coin-change/description/

// Problem Description :-
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing
a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by
any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:
Input: coins = [2], amount = 3
Output: -1
Example 3:
Input: coins = [1], amount = 0
Output: 0

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4

 */

public class DP20MinimumCoins {
    public int coinChange(int[] coins, int amount) {
        // // Approach -  2:- Memoized
        // int[][] dp = new int[coins.length+1][amount+1];
        // for(int[] row:dp) Arrays.fill(row,-1);
        // int ans = memo(coins,amount,coins.length-1, dp);
        // return ans>=Integer.MAX_VALUE-2?-1:ans;

        // Approach - 3:- Tabulation :-
        // Not Working:-
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i] = i/coins[0];
            else dp[0][i] = Integer.MAX_VALUE-1;
        }
        for(int i=1;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                int notTake = dp[i-1][j];
                int take = Integer.MAX_VALUE-1;
                if(j-coins[i]>=0) take = 1+dp[i][j-coins[i]];
                dp[i][j] = Math.min(take,notTake);
            }
        }
        int ans = dp[coins.length][amount];
        return ans>=Integer.MAX_VALUE-2?-1:ans;
    }
    private int memo(int[] arr, int target, int end, int[][] dp){
        if(end==0){
            if(target%arr[end]==0) return target/arr[end];
            else return Integer.MAX_VALUE-1;
        }
        if(dp[end][target]!=-1) return dp[end][target];
        //rec calls
        int notPick = memo(arr,target,end-1,dp);
        int pick = Integer.MAX_VALUE-1;
        if(target-arr[end]>=0) pick = 1+ memo(arr,target-arr[end],end,dp);
        dp[end][target] = Math.min(pick,notPick);
        return dp[end][target];
    }
}
