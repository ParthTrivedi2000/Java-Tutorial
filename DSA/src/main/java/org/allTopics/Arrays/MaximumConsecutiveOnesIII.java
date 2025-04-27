package org.allTopics.Arrays;

// Problem Link :- https://leetcode.com/problems/max-consecutive-ones-iii/

// Problem Description:-
/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip
at most k 0's.

Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Constraints:
1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
0 <= k <= nums.length

 */

public class MaximumConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {

        // // Approach - 1:-  BruteForce Approach :-
        // // Approach is same only like we need to find the longest sub array
        // // with at most k zeroes. but complexity will be diffn as we are looking for bruteforce
        // // solution. it means we are generating all the subarrays and finding the subarray with
        // // above condition.

        // int ans = Integer.MIN_VALUE;
        // int zeros = 0;
        // for(int i=0;i<nums.length;i++){
        //     zeros=0;
        //     for(int j=i;j<nums.length;j++){
        //         if(nums[j]==0) zeros++;

        //         if(zeros<=k) ans = Math.max(ans,j-i+1);
        //         else break;
        //     }
        // }
        // return ans;

        // TC:- TC is 1st for loop ran N times, but 2nd for loop is not running exactly
        // N times bec we are breaking the loop as soon as k+1th zero founded. So TC is
        // not exactly N^2. but ~ O(N^2).
        // SC :- O(1)

        // // Approach - 2:- we can use the sliding window. window with max 1 and at most k zeroes.
        // int i=0;
        // int j=0;
        // int zeros=0;
        // int ans=0;
        // while(j<nums.length){
        //     if (nums[j]==0) zeros++;

        //     while(zeros>k){
        //         if(nums[i]==0) zeros--;
        //         i++;
        //     }

        //     if(zeros<=k){
        //         ans = Math.max(ans,j-i+1);
        //     }
        //     j++;
        // }
        // return ans;

        // // TC:- for 1st while loop, driving or changing factor is j. and we are running it
        // // from 0 to N. for inner 2nd while loop, changing factor is zeros. And we are running
        // // it for small small times if it just exceeds K. But if you think here 2 nested while
        // // loops are there hence TC should be O(N^2) then you are wrong, bec actually it means
        // // ki you are running inner while loop for each value of j, which is actually not the
        // // case. So if you think carefully during whole variable lifecycle of j, variable
        // // zeros can go at max till N(remember here not for single value of j, I mean jb se
        // // j ko start kiya tbse leke j ko end krenge us pure time me variable zero will
        // // can take at max N ). So total TC:- O(N) + O(N) ~ O(2N) ~ O(N).
        // // SC:-O(1).

        // // But now if inerviewer might ask ki still optimise the code to remove internal
        // // while loop.

        // Approach:- 3:- Best Optimised Approach:-
        int i=0;
        int j=0;
        int zeros=0;
        int ans=0;
        while(j<nums.length){
            if (nums[j]==0) zeros++;
            if(zeros>k){
                if(nums[i]==0) zeros--;
                i++;
            }
            if(zeros<=k) ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
        // TC:-O(N), SC:-O(1)
    }
}
