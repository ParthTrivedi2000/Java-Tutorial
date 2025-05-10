package org.allTopics.DynamicProgramming;

// Problem Link :- https://leetcode.com/problems/climbing-stairs/

/*
Problem Description :-
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class DP02ClimbingStairs {
    // Approach - 1:- Recursive:- TC: O(2^N), SC:- O(N)
    /*
    public int climbStairs(int n) {
        if(n==1||n==2) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }

     */

    // Approach - 2:- Memoized:- TC:- O(N), SC:- O(2N)
    /*
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return memoized(n,dp);
    }

    // dp[i] :- means total no of ways to reach the ith stair.

    public int memoized(int n, int[] dp){
        if(n==0||n==1){
            dp[n]=1;
            return dp[n];
        }

        if(dp[n]!=-1) return dp[n];
        dp[n] = memoized(n-1,dp) + memoized(n-2,dp);
        return dp[n];
    }

     */

    // Approach - 3:- Tabulative:- TC:-O(N), SC:- O(N)
    /*
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[1] = 1;
        dp[0] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

     */

    // Approach - 4:- Further Space Optimised:- TC:-O(N), SC:-O(1)
    public int climbStairs(int n) {
        if(n==1) return 1; // handling edge case
        int a=1;
        int b=1;
        int c=0;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}


// Note:- See here if you understand why there are only 2 recursive calls? and wo bhi like with n to -1 and -2 only kyu?
// bec in question it was given ki you can take either 1 step or 2 step. it means with each 1 step and with each 2 step
// my answer/ calculation can be changed hence we have to take 3 recursive calls each with (current n -1, current n -2).
// So if it was given in question like if you can take 1,2 and 3 steps as well, then just think very carefully.
// you have to consider the new recursive call with current n-3 as well now it will also make difference in answer.