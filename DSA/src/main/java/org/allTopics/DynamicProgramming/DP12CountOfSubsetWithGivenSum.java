package org.allTopics.DynamicProgramming;

// Problem Link :- https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/0

/*
Problem Description:-
Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array
whose sum is equal to the given target.

Examples:

Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
Output: 3
Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.
Input: arr[] = [2, 5, 1, 4, 3], target = 10
Output: 3
Explanation: The subsets {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3} sum up to the target 10.
Input: arr[] = [5, 7, 8], target = 3
Output: 0
Explanation: There are no subsets of the array that sum up to the target 3.
Input: arr[] = [35, 2, 8, 22], target = 0
Output: 1
Explanation: The empty subset is the only subset with a sum of 0.
Constraints:
1 ≤ arr.size() ≤ 10^3
0 ≤ arr[i] ≤ 10^3
0 ≤ target ≤ 10^3
 */

import java.util.Arrays;

public class DP12CountOfSubsetWithGivenSum {
    public int perfectSum(int[] nums, int target) {

        // // Approach - 2:- Memoized:- TC:- O(N*target), SC:- O(N*Target)
        int[][] dp = new int[nums.length+1][target+1];
        for(int rows[] : dp){
            Arrays.fill(rows, -1);
        }
        return memo(nums, target, nums.length-1, dp);

    }

    private int memo(int[] nums, int target, int end, int[][] dp){
        // if(target==0) return 1;
        /*
        generally we used to write above line also in the base case. but it works fine when constraint given as
        1<=nums[i]<=10^3, means if array contains 0 as well, then it won't work so instead add only end==0 & inside
        it you have to handle if 0 is present in the array. bec on code360 constraint given was 1<=nums[i]<=10^3. SO
        in that case when we pass the below input manually, arr=[0,0,1], target=1 --> it was failing means our old
        code is giving value 1, while expected answer is 4 (this TS is present in GFG problem link), so handling it
        as below.
         */
        if(end==0){
            if(target==0 && nums[end]==0) return 2; // 2 is for, if 0 is present in the array then either we pick or
            // not pick both the case will give me sum==0 so returning 2 in this case.
            if(target==0 || target==nums[end]) return 1;
            return 0;
        }
        if(end<0 || target<0) return 0;
        if(dp[end][target]!=-1) return dp[end][target];
        // rec calls
        int notPick=memo(nums,target,end-1,dp);
        int pick=0;
        if(target-nums[end]>=0) pick = memo(nums,target-nums[end], end-1,dp);
        return dp[end][target] = pick+notPick;
    }

}

/*
// Note:- for any count related problems of recursion, always always always remember below points/template
to make the recursive function calls.
- Inside recursive function, if condition==true --> returns 1 (always), if condition false --> return 0 (always)
- And while calling different recursive calls, return the sum of all the rec call functions. For example if you
are doing 3 recursive call inside your recursionFunction(), then return fun call f1() + f2() + f3().

 */