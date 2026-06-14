package org.allTopics.PrefixSum.Category2;

// Problem Link :- https://leetcode.com/problems/contiguous-array/description/

// problem Description :-
/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Example 3:
Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.

Constraints:
1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
 */

import java.util.HashMap;
import java.util.Map;

public class PS11LongestSubArrayWithEquals0And1 {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        // Map<diff of zeros & Ones, 1st occurance of diff>
        int zeros=0;
        int ones=0;
        int maxLen=0;
        int diff=0;
        mp.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zeros++;
            else if(nums[i]==1) ones++;
            diff = zeros-ones;
            if(mp.containsKey(diff)) maxLen = Math.max(maxLen,i - mp.get(diff));
            else mp.put(diff,i);
        }
        return maxLen;
    }
}
