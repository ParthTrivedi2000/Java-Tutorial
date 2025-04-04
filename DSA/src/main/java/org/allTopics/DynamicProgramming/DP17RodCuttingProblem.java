package org.allTopics.DynamicProgramming;

// Problem Link :- https://www.naukri.com/code360/problems/rod-cutting-problem_800284?leftPanelTabValue=PROBLEM

// Problem Description :-
/*
Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost associated with it.
Determine the maximum cost obtained by cutting the rod and selling its pieces.

Note:
1. The sizes will range from 1 to ‘N’ and will be integers.
2. The sum of the pieces cut should be equal to ‘N’.
3. Consider 1-based indexing.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 50
1 <= N <= 100
1 <= A[i] <= 100

Where ‘T’ is the total number of test cases, ‘N’ denotes the length of the rod, and A[i] is the cost of sub-length.

Time limit: 1 sec.
Sample Input 1:
2
5
2 5 7 8 10
8
3 5 8 9 10 17 17 20
Sample Output 1:
12
24
Explanation of sample input 1:
Test case 1:

All possible partitions are:
1,1,1,1,1           max_cost=(2+2+2+2+2)=10
1,1,1,2             max_cost=(2+2+2+5)=11
1,1,3               max_cost=(2+2+7)=11
1,4                 max_cost=(2+8)=10
5                   max_cost=(10)=10
2,3                 max_cost=(5+7)=12
1,2,2               max _cost=(1+5+5)=12

Clearly, if we cut the rod into lengths 1,2,2, or 2,3, we get the maximum cost which is 12.

Test case 2:
Possible partitions are:
1,1,1,1,1,1,1,1         max_cost=(3+3+3+3+3+3+3+3)=24
1,1,1,1,1,1,2           max_cost=(3+3+3+3+3+3+5)=23
1,1,1,1,2,2             max_cost=(3+3+3+3+5+5)=22
and so on….

If we cut the rod into 8 pieces of length 1, for each piece 3 adds up to the cost. Hence for 8 pieces, we get 8*3 = 24.
Sample Input 2:
1
6
3 5 6 7 10 12
Sample Output 2:
18

 */

import java.util.Arrays;

public class DP17RodCuttingProblem {
    public static int cutRod(int price[], int n) {
        // Write your code here.
        int[] dp=  new int[n+1];
        for(int cutLen=1;cutLen<=n;cutLen++){
            int maxi = 0;
            int profit = 0;
            for(int pr = 0;pr<price.length;pr++){
                if(cutLen-1-pr>=0) profit = price[pr] + dp[cutLen-1-pr];
                maxi = Math.max(maxi,profit);
            }
            dp[cutLen] = maxi;
        }
        return dp[n];
    }

    // Space Optimised Version of code:-
    // Not working code. copied code from somewhere. need to correct it.
    public int cutRod_V2(int[] price, int n) {
        // 1D DP tables
        int[] nextRow = new int[n + 1];
        int[] idealRow = new int[n + 1];
        Arrays.fill(nextRow, Integer.MIN_VALUE);
        Arrays.fill(idealRow, Integer.MIN_VALUE);
        nextRow[0] = 0;

        // Fill the rest of the table
        for (int cutLength = n; cutLength >= 1; --cutLength) {
            idealRow[0] = 0;
            for (int rodLength = 1; rodLength <= n; ++rodLength) {
                int currSkip = nextRow[rodLength];
                int currTake = Integer.MIN_VALUE;
                if (cutLength <= rodLength) {
                    int nextValue = idealRow[rodLength - cutLength];
                    currTake = (nextValue != Integer.MIN_VALUE) ? price[cutLength - 1] + nextValue : Integer.MIN_VALUE;
                }
                idealRow[rodLength] = Math.max(currSkip, currTake);
            }
            nextRow = Arrays.copyOf(idealRow, idealRow.length);
        }

        // Return the result value
        return nextRow[n];
    }
}
