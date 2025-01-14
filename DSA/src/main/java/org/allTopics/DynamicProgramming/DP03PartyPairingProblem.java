package org.allTopics.DynamicProgramming;

// Problem Link :- https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1

/*
Friends Pairing Problem

Problem Description :-
Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once.
Find out the total number of ways in which friends can remain single or can be paired up.
Note: Since the answer can be very large, return your answer mod 10^9+7.

Examples :

Input: n = 3
Output: 4
Explanation:
{1}, {2}, {3} : All single
{1}, {2,3} : 2 and 3 paired but 1 is single.
{1,2}, {3} : 1 and 2 are paired but 3 is single.
{1,3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1,2} and {2,1} are considered same.
Input: n = 2
Output: 2
Explanation:
{1} , {2} : All single.
{1,2} : 1 and 2 are paired.
Input: n = 1
Output: 1
Constraints:
1 ≤ n ≤ 10^5
 */


import java.util.Arrays;

public class DP03PartyPairingProblem {
    // Approach - 1:- Recursive Approach:- TC:- O(2^n), SC:- O(N)
    /*
    public long countFriendsPairings(int n)
    {
           // Approach - 1:- Recursive Approach:-

           // sanity check
           if(n<0) return 0;

           // base case
           if(n==1 || n==2) return n;

           // rec case
           long ans = countFriendsPairings(n-1) + countFriendsPairings(n-2)*(n-1);
           return ans;
    }

     */


    // Approach - 2:- Memoization Approach:- TC:- O(N), SC:- O(2N)
    /*
    public long countFriendsPairings(int n)
    {
        // Approach - 2:- Memoization Approach:-
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return memo(n,dp)%1000000007;
    }

    long memo(int n, long[] dp){
        //sanity check
        if(n<0) return 0;

        // dp check
        if(dp[n]!= -1) return dp[n];

        // base case
        if(n==1 || n==0){
            dp[n] = 1;
            return 1;
        }

        // rec case
        long ans = (long)memo(n-1,dp) + ((long)memo(n-2,dp)*(long)(n-1))%1000000007;
        dp[n] = ans;
        return ans;
    }

     */

    // Approach - 3:- Tabulation Approach:- TC:- O(N), SC:- O(N)
    /*
    public long countFriendsPairings(int n)
    {
        // Approach - 3:- Memoization Approach:-
        if(n==1) return 1;
        long[] dp = new long[n+1];

        // Step - 1:- base case fill in DP array.
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            long ans = (long)dp[i-1] + ((long)dp[i-2]*(i-1))%1000000007;
            dp[i] = ans;
        }
        return dp[n]%1000000007;
    }

     */

    // Approach - 4:- Space Optimised Approach:- TC:-O(N), SC:- O(1)
    public long countFriendsPairings(int n)
    {
        // Approach - 4:- Space Optimised Approach:-
        if(n==1) return 1;

        long a = 1;
        long b = 1;
        long ans = 0;

        for(int i=2;i<=n;i++){
            ans = b + (a*(i-1))%1000000007;
            a = b;
            b = ans;
        }
        return ans%1000000007;
    }
}
