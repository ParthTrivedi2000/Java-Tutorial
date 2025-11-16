package org.allTopics.DynamicProgramming;

// Problem Link :- https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1

/*
Problem Description :-
Given an array arr[]  containing non-negative integers, the task is to divide it into two sets set1 and set2 such
that the absolute difference between their sums is minimum and find the minimum difference.

Examples:

Input: arr[] = [1, 6, 11, 5]
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
Hence, minimum difference is 1.
Input: arr[] = [1, 4]
Output: 3
Explanation:
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4
Hence, minimum difference is 3.
Input: arr[] = [1]
Output: 1
Explanation:
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {}, sum of Subset2 = 0
Hence, minimum difference is 1.

Constraints:
1 ≤ arr.size()*|sum of array elements| ≤ 10^5
1 <= arr[i] <= 10^5
 */

public class DP13MinimumSubsetSumDifference {
    public int minDifference(int arr[]) {
        // Your code goes here

        /*
        // Approach - 3:- Tabulative :-
        int sum = 0;
        for(int elem:arr) sum+=elem;

        if(arr.length==1) return arr[0];

        boolean[][] dp = new boolean[arr.length+1][sum+1];
        for(int i=0;i<arr.length+1;i++) dp[i][0]=true;
        for(int j=1;j<sum+1;j++) dp[0][j] = false;

        // filling remaining dp array
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<sum+1;j++){
                boolean notPick = dp[i-1][j];
                boolean pick = false;
                if(j-arr[i-1]>=0) pick = dp[i-1][j-arr[i-1]];
                dp[i][j]=pick||notPick;
            }
        }

        // for performing partition:-
        // s2 - s1 = minimised => totalSum-s1-s1 = minimised => totalSum-2s1=>minimised
        // and s1 we will pick to go from 0 to totalsum/2 only, so that above value
        // totalSum-2s1 will always stays +ve.
        int mini = Integer.MAX_VALUE;
        int remaining=0;
        for(int i=1;i<dp[arr.length-1].length;i++){
            if(dp[arr.length-1][i]){
                mini = Math.min(mini,Math.abs(sum-2*i));
                // remaining = sum-i;
                // mini = Math.min(mini,Math.abs(remaining-i));
            }
        }
        return mini;

         */


        // (Please read understanding from above approach as well, for clarity)

        // Approach - 3:- By me, as per standard subset sum template :-
        if(arr.length==1) return arr[0];

        int totalSum = 0;
        for(int elem:arr) totalSum+=elem;
        int target = totalSum/2;

        boolean[][] dp = new boolean[arr.length+1][target+1];
        for(int i=0;i<=arr.length;i++){
            for(int j=0;j<=target;j++){
                if(j==0) dp[i][j]=true;
                else if(i==0) dp[i][j]=false;
                else{
                    boolean notPick = dp[i-1][j];
                    boolean pick = false;
                    if(j-arr[i-1]>=0) pick = dp[i-1][j-arr[i-1]];
                    dp[i][j] = pick||notPick;
                }
            }
        }

        // now till here DP table is ready which contains weather with below cells contains
        // true or false. means what each cell represent is, weather sum=j is possible with
        // elems 1st i elems. Now what I want is, I want with all the elems, I want sum/2 if
        // possible. if it's not possible than just lesser than that. if not then just more
        // lesser than that.
        // So you can use this created dp table to know weather you can get sum or not?
        // means just start traversing last row of your dp table (why last row only? -->
        // bec using all the array elems we want to check so), check from last column to
        // 1st column, weather you get true anywhere or not. if yes, then you can return
        // totalSum-2*j as the answer.


        for(int j=dp[0].length-1;j>=0;j--){
            if(dp[dp.length-1][j]==true) return totalSum-2*j;
        }
        return 0;
    }

    // Space optimised code is remaining, please pick it from takeuforward.com
}

/*
yrrr see, I am having one array. I have to perform the partition such that difference between 2 partitioned subset
should be minimum. Now means what could be the minimal difference between any 2 numbers. 0 ryt?, so simply 1st
thought came in my mind is, suppose there is subset exists with sum=total/2, then we can say that this subset and
subset with remaining elems can be partitioned. But now what if sum=total/2 doesn't exists? so obviously we will try
to find the subsets with sums such that difference between the sum of them would be 1. means just mean to say that

s2 - s1 = 0
but we know s1+s2 = total => s2 = total-s1
total-s1-s1=0
total-2*s1 = 0 => but since we are not sure that there exists sum with total/2 so we can say that we want to have
sum s1 such that above condition stays as nearest to zero. ==> total-2*s1>=0 => total>=2*s1 => total/2>=s1

So now from above discussion we are sre that we need to have that subset sum which is exactly total/2 or if not then
we can say as close as possible ryt?

Now see as per the subset sum question, we know the dp table we are creating, in that table what each cell is
representing? --> dp[i][j] --> maximum possible subset such that sum=j with first i elems.
So now just see the dp table's last line. what it will represent. It actually represents like by considering
all the given elements will you be able to make sum 0,1,2,3,4.... or not if yes, it has shown as true.
 */