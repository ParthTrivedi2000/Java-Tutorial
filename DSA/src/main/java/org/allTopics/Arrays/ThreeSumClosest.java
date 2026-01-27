package org.allTopics.Arrays;

// Link :- https://leetcode.com/problems/3sum-closest/description/
// Problem Description :-
/*
Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such
that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.


Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

Constraints:
3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-10^4 <= target <= 10^4
 */

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // Bruteforce :-
        // TC:- O(N^3), SC:- O(1)
        /*
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum=nums[i] + nums[j] + nums[k];
                    // diff = sum-target;
                    if(Math.abs(sum-target)<diff) {
                        diff=Math.abs(sum-target);
                        ans = sum;
                    }
                }
            }
        }
        return ans;
        */


        // Optimised :- Using 2-pointers approach :-
        // TC:- O(N^2)+O(NlogN) ~ O(N^2), SC:- O(1)
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum-target)<diff) {
                    diff=Math.abs(sum-target);
                    ans = sum;
                }
                // Above if block will run for all/any of the below 3 conditions means
                // irrespective of sum is equal or lesser or greater than target at any
                // point of time. Simply we need to find sum at lowest difference between
                // sum & target which we are handling separately in above if block.
                if(sum==target){
                    j++;
                    k--;
                }
                else if(sum<target) j++;
                else k--;
            }
        }
        return ans;
    }
}
