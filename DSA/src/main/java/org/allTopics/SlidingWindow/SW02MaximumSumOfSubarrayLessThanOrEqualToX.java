package org.allTopics.SlidingWindow;

// Q - 2) Maximum Sum of Subarray Less than or Equal to X :-
// Problem Link :- https://www.geeksforgeeks.org/problems/maximum-sum-of-subarray-less-than-or-equal-to-x4033/1

// Problem Statement :-
/*
Given an array arr[] of integers and a number x, the task is to find the sum of subarray having a maximum sum less than
or equal to the given value of x.

Examples:

Input: arr[] = [1, 2, 3, 4, 5], x = 11
Output: 10
Explanation: Subarray having maximum sum is [1, 2, 3, 4].
Input: arr[] = [2, 4, 6, 8, 10], x = 7
Output: 6
Explanation: Subarray having maximum sum is [2, 4] or [6].
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^6
1 ≤ x ≤ 10^12

 */

public class SW02MaximumSumOfSubarrayLessThanOrEqualToX {
    public long findMaxSubarraySum(int[] arr, long x) {
        int i=0;
        int j=0;
        long ans=0;
        long sum=0;
        while(j<arr.length){
            // general calc
            sum+=arr[j];
            while(sum>x){
                // nullyfy impact of prev i
                sum-=arr[i];
                // slide the window
                i++;
            }
            // in case sum<= x
            if(sum<=x){
                // get ans from calc
                ans = Math.max(sum,ans);
            }
            // common expansion from right side in window
            j++;
        }
        return ans;
    }
}
