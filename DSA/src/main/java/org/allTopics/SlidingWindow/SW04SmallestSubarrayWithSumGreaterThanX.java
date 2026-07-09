package org.allTopics.SlidingWindow;

// Problem Link :- https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1

// problem Statement :-
/*
Given a number x and an array of integers arr, find the smallest subarray with sum greater than the given value. If
such a subarray do not exist return 0 in that case.

Examples:

Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
Output: 3
Explanation: Minimum length subarray is [4, 45, 6]
Input: x = 100, arr[] = [1, 10, 5, 2, 7]
Output: 0
Explanation: No subarray exist

Constraints:
1 ≤ arr.size, x ≤ 10^5
0 ≤ arr[] ≤ 10^4

Expected Complexities:-
Time Complexity: O(n)
Auxiliary Space: O(1)

Company Tags
Accolite, Amazon, Goldman Sachs, Google, Facebook

 */

public class SW04SmallestSubarrayWithSumGreaterThanX {
    // Approach:- Sliding Window Technique
    // TC:- O(N), SC:- O(1)
    public static int smallestSubWithSum(int x, int[] arr) {
        int i=0;
        int j=0;
        int ans = Integer.MAX_VALUE;
        int sum=0;
        while(j<arr.length){
            sum+=arr[j];
            while(sum>x){
                ans = Math.min(ans,j-i+1);
                sum-=arr[i];
                i++;
            }
            // Below empty if block can be removed as well, but I kept it for more clarity, to show that
            // we are checking if the sum is less than or equal to x, we just move the right pointer forward.
            if(sum<=x){

            }
            j++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
