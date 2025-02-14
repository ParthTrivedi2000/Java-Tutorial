package org.allTopics.Hashing.Pattern3_Regrouping;

// Problem Link :- https://leetcode.com/problems/number-of-good-pairs/description/

/*
Problem Description :-
Given an array of integers nums, return the number of good pairs.
A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:
Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:
Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:
Input: nums = [1,2,3]
Output: 0

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100
 */

import java.util.HashMap;
import java.util.Map;

public class P02NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int cnt=0;
        for(int elem:nums){
            if(mp.containsKey(elem)) cnt+=mp.get(elem);
            mp.put(elem,mp.getOrDefault(elem,0)+1);
        }
        return cnt;
    }
}
