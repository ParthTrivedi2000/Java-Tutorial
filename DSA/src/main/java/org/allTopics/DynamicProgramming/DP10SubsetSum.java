package org.allTopics.DynamicProgramming;

// problem Link :- https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

// Problem Description :-
/*
Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to
given sum.

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
Constraints:
1 <= arr.size() <= 200
1<= arr[i] <= 200
1<= sum <= 10^4

Expected Complexities
Time Complexity: O(sum*n)
Auxiliary Space: O(sum)

Company Tags
Amazon Microsoft
 */

public class DP10SubsetSum {
    public static void main(String[] args) {}

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here

        // // Approach - 1:- recursive :- TC:- O(2^n), SC:- O(n) stack space
        // return rec(arr,sum,arr.length-1);

        // // Approach - 2:- Memoised :-  TC:- O(n*sum), SC:- O(n*sum) + stack space=O(n) calls
        // Boolean[][] dp = new Boolean[arr.length+1][sum+1];
        // return memoised(arr,sum,arr.length-1,dp);

        // Approach - 3:- Tabulation :-  TC:- O(n*sum), SC:- O(n*sum)
        /*
        Boolean[][] dp = new Boolean[arr.length+1][sum+1];
        for(int i=0;i<=arr.length;i++){
            for(int j=0;j<=(sum);j++){
            // please note here that whole 1st col should be filled with True. And 1st row from 1 to N (not 0 to N)
            // should filled with False
                if(j==0) dp[i][j]=true;
                else if(i==0) dp[i][j]=false;
                else{
                    boolean notPick = dp[i-1][j];
                    boolean pick=false;
                    if(j-arr[i-1]>=0) pick = dp[i-1][j-arr[i-1]];
                    dp[i][j]=pick||notPick;
                }
            }
        }
        return dp[arr.length][sum];

         */

        // Approach - 4:- Space Optimisation :- Using 2 1D arrays.
        // TC :- O(n*sum); SC:- O(sum) + O(sum)
        /*
        Idea Behind Space Optimization:
    In the tabulation approach:
        - At any point i, you only need the values from i-1 (the previous row).

    So instead of maintaining the entire dp[i][j] table, you can use just:
        - 1D array prev[] for i-1th row, and
        - another 1D array curr[] for ith row.
        - Eventually, you update prev = curr at the end of each iteration.

         */

        /*
        boolean[] prev = new boolean[sum + 1];
        prev[0] = true; // base case: sum == 0 is always true

        for (int i = 1; i <= arr.length; i++) {
            boolean[] curr = new boolean[sum + 1];
            curr[0] = true; // sum == 0 is always true for any i

            for (int j = 1; j <= sum; j++) {
                boolean notPick = prev[j];
                boolean pick = false;
                if (j - arr[i - 1] >= 0)
                    pick = prev[j - arr[i - 1]];
                curr[j] = pick || notPick;
            }
            prev = curr; // Move to the next row
        }

        return prev[sum];

         */


        // Approach - 5 :- Further Space Optimisation:- Using single 1D array of size sum.
        // TC :- O(n*sum), SC:- O(sum)
        /*
        If you want ultra space optimization, you can reduce it to just one array, updating it backwards to avoid
        overwriting needed values.
        This works because we update from sum → 0, so we don't mess up the values needed in the same iteration.
         */

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 0; i < arr.length; i++) {
            for (int j = sum; j >= arr[i]; j--) {
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }

        return dp[sum];

    }

    private static boolean rec(int[] arr, int cap, int idx){
        if(idx==0){
            if(cap==0) return true;
            else return false;
        }

        if(idx<0) return false;
        if(cap<0) return false;

        boolean notPick = rec(arr,cap,idx-1);
        boolean pick = false;
        if(cap>=arr[idx]) pick = rec(arr,cap-arr[idx],idx-1);
        return pick || notPick;
    }

    private static boolean memoised(int[] arr, int cap, int idx, Boolean[][] dp){
        /*
        This approach was failing previously for this edge case. arr=[11,48,24], target=83
        bec You're only returning true when cap == 0 and idx == 0. But there’s another valid case:
        If the first element itself (i.e., arr[0]) equals the remaining capacity (cap), then that subset is valid. You're
        not handling this case currently.

        So I have added cap-arr[idx]==0 also in the base case when idx==0.
        Then it's working fine.
         */
        if(idx==0){
            if(cap==0 || cap-arr[idx]==0) return true;
            else return false;
        }

        //sanity check
        if(idx<0 || cap<0) return false;

        // dp check
        if(dp[idx][cap] != null) return dp[idx][cap];

        // rec calls
        boolean notPick = memoised(arr,cap,idx-1,dp);
        boolean pick=false;
        if(cap-arr[idx]>=0) pick = memoised(arr,cap-arr[idx],idx-1,dp);
        dp[idx][cap] = pick||notPick;
        return pick||notPick;
    }


    // Another way:- (Please go through below code as well)
    /*
        // return rec(arr, sum, 0,arr.length-1);

        // // Approach - 2:- Memoization
        // Boolean [][] dp = new Boolean[arr.length+1][sum+1];
        // return memo(arr,sum,0,arr.length-1, dp);

        // // Approach - 3:-
        boolean[][] dp = new boolean[arr.length+1][sum+1];

         for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }

        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=sum;j++){
                // if(i==1) dp[i][j]=false;
                // if(j==0) dp[i][j]=true;
                // else{
                    // boolean notPick = dp[i-1][j];
                    // boolean pick=false;
                if(j-arr[i-1]>=0) dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
                // }
            }
        }
        return dp[arr.length][sum];

    }

    private static boolean rec(int[] arr, int sum, int start, int end){
        // base
        if((end==0 && sum-arr[end]!=0) || sum<0 || end<0) return false;
        if(sum==0) return true;
        boolean pick = rec(arr,sum-arr[end],start,end-1);
        boolean notPick = rec(arr,sum,start,end-1);
        return pick||notPick;
    }

    private static Boolean memo(int[] arr, int sum, int start, int end, Boolean dp[][]){
        if(sum==0) return true;
        if(end==0) return false;
        if(dp[end][sum]!=null) return dp[end][sum];

        if(arr[end-1]>sum)
        {
            return dp[end][sum]=memo(arr,sum,0,end-1,dp);
        }
        return dp[end][sum] = memo(arr,sum,0,end-1,dp) || memo(arr,sum-arr[end-1],0,end-1,dp);

    }

    */

}
