package org.allTopics.DynamicProgramming;


// Problem Link :-
// https://leetcode.com/problems/partition-equal-subset-sum/description/

/*
Problem Description :-
Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts
is the same.

Note: Each element must be in exactly one subset.

Examples:

Input: arr = [1, 5, 11, 5]
Output: true
Explanation: The two parts are [1, 5, 5] and [11].
Input: arr = [1, 3, 5]
Output: false
Explanation: This array can never be partitioned into two such parts.

Constraints:
1 ≤ arr.size ≤ 100
1 ≤ arr[i] ≤ 200
 */

public class DP11EqualPartition {
    public static boolean equalPartition(int arr[]) {
        // code here
        // // Approach - 1:- Recursive:- TC:- O(2^N), SC:- O(N)
        // int sum=0;
        // for(int elem:arr) sum+=elem;
        // if(sum%2!=0) return false;
        // return rec(arr,sum/2, arr.length-1);


        // // Approach - 2:- Memoized Approach :- TC:- O(N*sum), SC:- O(N*sum)
        // int sum=0;
        // for(int elem:arr) sum+=elem;
        // if(sum%2!=0) return false;
        // // Note:- I have created int[][] dp array since boolean somehow not giving correct
        // // result to me. So inside int[] dp, consider below values.
        // // initially filled with 0 --> consider as null
        // // cells filled with -1 --> false
        // // cells filled with -2 --> true
        // int[][] partiotionResult = new int[arr.length+1][sum+1];
        // return memo(arr,sum/2, arr.length-1, partiotionResult);


        // Approach - 3:- Tabulative Approach:- TC:- O(N*sum), SC:- O(N*sum)
        int sum=0;
        for(int elem:arr) sum+=elem;
        if(sum%2!=0) return false;
        boolean[][] partitionResult = new boolean[arr.length+1][sum+1];
        // filling 1st column
        for(int i=0;i<arr.length+1;i++) partitionResult[i][0]=true;
        // filling 1st row
        for(int j=1;j<sum/2+1;j++) partitionResult[0][j]=false;
        // filling remaining dp array
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<((sum/2)+1);j++){
                boolean notPick = partitionResult[i-1][j];
                boolean pick=false;
                if(j-arr[i-1]>=0) pick=partitionResult[i-1][j-arr[i-1]];
                partitionResult[i][j] = (pick||notPick);
            }
        }
        return partitionResult[arr.length][sum/2];


        // Approach - 4:- Space Optimised:- TC:- O(N*sum), SC;- O(sum)
        // Please check it from here, and write down by your self.
        // https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/

    }

    private static boolean rec(int[] arr, int sum, int end){
        // base case
        if(sum==0) return true;
        if(end==0) return false;
        // sanity check
        if(end<0 || sum<0) return false;
        // now do the rec calls;
        boolean notPick = rec(arr,sum,end-1);
        boolean pick = rec(arr,sum-arr[end],end-1);
        return pick || notPick;
    }

    private static boolean memo(int[] arr, int sum, int end, int[][] dp){
        // base case
        if(sum==0){
            dp[end][sum] = -2;
            return true;
        }
        if(end==0){
            dp[end][sum] = -1;
            return false;
        }

        // sanity check
        if(end<0 || sum<0) return false;
        //dp cehck
        if(dp[end][sum]!=0) return dp[end][sum]==-1?false:true;
        // rec calls
        boolean notPick = memo(arr,sum,end-1,dp);
        boolean pick=false;
        if(sum-arr[end]>=0) pick = memo(arr,sum-arr[end], end-1, dp);
        dp[end][sum] = (pick||notPick)==false?-1:-2;
        return pick||notPick;
    }
}
