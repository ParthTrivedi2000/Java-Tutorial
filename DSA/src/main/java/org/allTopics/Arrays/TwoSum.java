package org.allTopics.Arrays;

// Link :- https://leetcode.com/problems/two-sum/description/

// Problem Description :-
/*

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.

Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?

 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {}

    public int[] twoSum(int[] nums, int target) {
         // Approach - 1:- Bruteforce:-
         // TC:- O(N^2), SC:- O(1)
        /*
         int[] ans = new int[2];
         for(int i=0;i<nums.length-1;i++){
             for(int j=i+1;j<nums.length;j++){
                 if(nums[i]+nums[j]==target){
                     ans[0]=i;
                     ans[1]=j;
                 }
             }
         }
         return ans;

         */


        // Approach - 2 :- Better (Using HashMap):-
        // TC:- O(N), SC:-O(N)
        Map<Integer, Integer> mp = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(target-nums[i])){
                ans[0] = mp.get(target-nums[i]);
                ans[1] = i;
                break;
            }
            else{
                mp.put(nums[i],i);
            }
        }
        return ans;
    }

    // Important Note:- while you sort the list/array, elems won't get changed but their indexes will get changed.

    // Since here it was asked to find the indexes and array is not sorted, we can't use 2 pointer approach.
    // But if array was sorted, we could have used 2 pointer approach to solve this problem in O(N) time & O(1) space.

}
