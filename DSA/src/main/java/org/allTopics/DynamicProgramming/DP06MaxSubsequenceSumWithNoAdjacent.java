package org.allTopics.DynamicProgramming;

// Problem Link :- https://www.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1
// Stickler Thief:- https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/1
// House Robber:- https://leetcode.com/problems/house-robber/description/

/*
Problem Description :-
Given an array Arr of size N containing positive integers. Find the maximum sum of a any possible subsequence
such that no two numbers in the subsequence should be adjacent in Arr.

Example 1:
Input:
N = 6
Arr[] = {5, 5, 10, 100, 10, 5}
Output: 110
Explanation: If you take indices 0, 3
and 5, then Arr[0]+Arr[3]+Arr[5] =
5+100+5 = 110.
Example 2:
Input:
N = 4
Arr[] = {3, 2, 7, 10}
Output: 13
Explanation: 3 and 10 forms a non
continuous subsequence with maximum
sum.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 10^5
1 ≤ Arri ≤ 10^5
 */

public class DP06MaxSubsequenceSumWithNoAdjacent {
    // Approach - 1:- Recursive:- TC:- O(2^N), SC:- O(N)
    /*
    int findMaxSum(int arr[], int n) {
        // code here
        return recursive(arr,0,arr.length-1);
    }

    // We will start with end and keep start 0 only. There is no requirement of variable start in argument of recursion.
    // But since it makes you to read/feel easy while revising hence keeping it. else whenever I am revising this
    // problem, almost time I got confused in corresponding memoized and tabulative code just due to start is not
    // present in recursive solution hence I was not able to decide how actually we are moving and keeping variable
    // of what in the further approaches.
    public int recursive(int[] arr, int start, int end){
        if(end==0) return arr[end];
        // need to handle this edge case as well as we are recursively calling end-2 also
        if(end<0) return 0;

        int sum1 = arr[end] + recursive(arr,start,end-2); // Pick element rec call
        int sum2 = recursive(arr,start,end-1); // not pick element rec call
        return Math.max(sum1,sum2);
    }

     */

    // Approach - 2:- Memoized:- TC:- O(N), SC:- O(N)+O(N) {dp+rec stack space}
    /*
    int findMaxSum(int arr[], int n) {
        // code here
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        return memoized(arr,0,arr.length-1,dp);
    }

    // Make sure to remove startIndex in interview. It is only kept here for my understanding purpose.
    public int memoized(int[] arr, int start, int end, int[] dp){
        if(end==0){
            dp[end] = arr[end];
            return arr[end];
        }

        if(end<0) return 0;

        if(dp[end]!=-1) return dp[end];
        int sum1 = arr[end] + memoized(arr,start,end-2, dp); // Pick element rec call
        int sum2 = memoized(arr,start,end-1, dp); // not pick element rec call
        dp[end] = Math.max(sum1,sum2);
        return Math.max(sum1,sum2);
    }

     */

    // Approach - 3:- Tabulative:- TC:- O(N), SC:- O(N)
    // Note:- dp[i] = max subsequence sum from index 0 to i such that no 2 elements are adjacent

    /*
    int findMaxSum(int arr[], int n) {
        // code here
        if(arr.length==1) return arr[0];
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);

        for(int i=2;i<arr.length;i++){
            int sum1 = arr[i] + dp[i-2];
            int sum2 = dp[i-1];
            dp[i] = Math.max(sum1,sum2);

            // // Other shorten way is:-
            // dp[i] = Math.max(dp[i-1], arr[i]+dp[i-2]);
        }
        return dp[arr.length-1];
    }

     */


    // Since it seems all these 3 variables are again just depends on each other sequentially. So we can do Space
    // Optimisation.
    // On observing the dp[] array in the previous approach, it can be seen that the answer at the current index
    // depends only on the last two values. In other words, dp[i] depends only on dp[i – 1] and dp[i – 2]. So, instead
    // of storing the result in an array, we can simply use two variables to store the last and second last result.

    // Approach - 4:- Space Optimised:- TC:- O(N), SC:- O(1)

    int findMaxSum(int arr[], int n) {
        if(arr.length==1) return arr[0];
        // Compute current value using previous two values. The final current value would be our result c.
        int c = 0;
        int a = arr[0];
        int b = Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            c = Math.max(arr[i]+ a, b);
            a = b;
            b = c;
        }
        return c;
    }

}


