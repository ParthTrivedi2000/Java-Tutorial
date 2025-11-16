package org.allTopics.BinarySearch;

// Problem Link :- https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

/*
Problem Description :-
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9
 */

public class BS2SearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        int mid=0;
        int[] ans = {-1,-1};

        // For first Occurrence
        while(s<=e){
            mid=(e-s)/2 + s;
            if(target>nums[mid]){
                s=mid+1;
            }
            else if(target<nums[mid]){
                e=mid-1;
            }
            else{
                ans[0] = mid;
                e=mid-1;
            }
        }

        // For last occurrence
        s = 0;
        e = nums.length-1;
        mid=0;
        while(s<=e){
            mid=(e-s)/2 + s;
            if(target>nums[mid]){
                s=mid+1;
            }
            else if(target<nums[mid]){
                e=mid-1;
            }
            else{
                ans[1] = mid;
                s=mid+1;
            }
        }
        return ans;
    }
}
