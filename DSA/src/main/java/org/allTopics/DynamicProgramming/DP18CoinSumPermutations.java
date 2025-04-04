package org.allTopics.DynamicProgramming;

// Problem Link :- https://leetcode.com/problems/combination-sum-iv/description/

// Problem Description :-
/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations
that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

Example 1:
Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:
Input: nums = [9], target = 3
Output: 0

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000


Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation
we need to add to the question to allow negative numbers?

 */

public class DP18CoinSumPermutations {
    public int combinationSum4(int[] nums, int target) {
        int[] amountArr = new int[target+1];
        amountArr[0]=1;
        for(int amt=1;amt<=target;amt++){
            int way=0;
            for(int coin=0;coin<nums.length;coin++){
                if(amt-nums[coin]>=0) way += amountArr[amt-nums[coin]];
                // or use below line of using dp arr directly:-
                // if(amt-nums[coin]>=0) amountArr[amt] += amountArr[amt-nums[coin]];
            }
            amountArr[amt] = way;
        }
        return amountArr[target];
    }
}
