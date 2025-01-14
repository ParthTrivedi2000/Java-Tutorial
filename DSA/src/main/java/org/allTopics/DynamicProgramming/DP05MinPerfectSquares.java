package org.allTopics.DynamicProgramming;

// Problem Link:- https://leetcode.com/problems/perfect-squares/description/

/*
Problem Description :-
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer
with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

Constraints:
1 <= n <= 10^4
 */

import java.util.Arrays;

public class DP05MinPerfectSquares {
     // Approach - 1:- Recursive:- TC:- O(N^N), SC:- O(N) for recursive stack space
    /*
     public int numSquares(int n) {
         if(n==0) return 0;
         int ans = Integer.MAX_VALUE;
         for(int i=1;i*i<=n;i++){
             ans = Math.min(ans,numSquares(n-i*i)+1);
         }
         return ans;
     }

     */

     // Approach - 2:- Memoized :- TC:- O(N*sqrt(N)):- See how it n square is, you are performing N calls, and each call
     // has TC of sqrt(N) hence overall O(N*sqrt(N)), SC:- O(N)
    /*
     public int numSquares(int n) {
         int[] dp = new int[n+1];
         Arrays.fill(dp,Integer.MAX_VALUE);
         return memoized(n,dp);
     }

     public int memoized(int n, int[] dp){
         if(n==0){
             dp[n]=n;
             return dp[n];
         }
         if(dp[n]!=Integer.MAX_VALUE) return dp[n];

         int ans = Integer.MAX_VALUE;
         for(int i=1;i*i<=n;i++){
             int sa = memoized(n-i*i,dp);
             ans = Math.min(ans,sa+1);
         }
         dp[n] = ans;
         return ans;
     }

     */

    // Approach - 3:- Tabulative, TC:- O(N*sqrt(N)), SC:- O(N)
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0]=0;

        for(int i=1;i<=n;i++){
            int ans = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                if(i-j*j>=0){
                    // int sa = dp[i-j*j];
                    // ans = Math.min(ans,sa+1);

                    // Other shorten way of writing is:-
                    dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                }
            }
            // dp[i] = ans;
        }
        return dp[n];
    }
}
