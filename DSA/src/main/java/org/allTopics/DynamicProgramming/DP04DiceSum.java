package org.allTopics.DynamicProgramming;

// Problem Link :- https://www.geeksforgeeks.org/count-ways-to-obtain-given-sum-by-repeated-throws-of-a-dice/


/*
Problem Description :-
Given an integer N, the task is to find the number of ways to get the sum N by repeatedly throwing a dice.

Examples:

Input: N = 3
Output: 4
Explanation:
The four possible ways to obtain N are:
1 + 1 + 1
1 + 2
2 + 1
3
Input: N = 2
Output: 2
Explanation:
The two possible ways to obtain N are:
1 + 1
2

 */

public class DP04DiceSum {

    // Approach - 1:- Recursive Solution :- TC:- O(6^N), SC:- O(N)
    public int findWays(int N) {
        // Base Case
        if (N == 0) return 1;

        // Stores the count of total number of ways to get sum N
        int cnt = 0;

        // Recur for all 6 states
        for(int i = 1; i <= 6; i++) {
            if (N - i >= 0) cnt = cnt + findWays(N - i);
        }

        // Return answer
        return cnt;
    }

    // Approach -2 :- Memoization :- TC:- O(N), SC:- O(2N)
    public static void main(String[] args) {
        // Given sum N
        int N = 4;

        // Initialize the dp array
        int []dp = new int[N + 1];

        for (int i = 0; i < dp.length; i++) dp[i] = -1;

        // Function Call
        System.out.print(memo(N, dp));
    }

    public static int memo(int N, int dp[]) {
        // Base Case
        if (N == 0) return 1;

        // Return already stored result
        if (dp[N] != -1) return dp[N];

        int cnt = 0;
        // Recur for all 6 states
        for (int i = 1; i <= 6; i++) {
            if (N - i >= 0) cnt = cnt + memo(N - i, dp);
        }

        // Return the result
        return dp[N] = cnt;
    }


    // Approach - 3:- Tabulation TC:- O(N), SC:- O(N)
    public static int findWaysTabulation(int N) {
        // Initialize dp array
        int []dp = new int[N + 1];
        dp[0] = 1;
        // Iterate over all the possible intermediate values to reach N
        for(int i = 1; i <= N; i++) {
            dp[i] = 0;
            // Calculate the sum for all 6 faces
            for(int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    dp[i] = dp[i] + dp[i - j];
                }
            }
        }
        return dp[N];
    }

    // Approach - 4:- Space Optimisation Approach:- TC:- O(N), SC:- O(1)
    public static int findWaysSpaceOptimised(int N) {

        // Initialize dp array
        int[] dp = new int[6];
        dp[0] = 1;
        // Iterate over all the possible intermediate values to reach N
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            // Calculate the sum for all 6 faces
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    sum += dp[(i-j)%6];
                }
            }
            // Store the sum for the current i
            dp[i%6] = sum;
        }
        return dp[N%6];
    }

}
