package org.allTopics.Hashing.Pattern3_Regrouping;

// Problem Statement:- https://leetcode.com/problems/count-nice-pairs-in-an-array/description/

/*
Problem Description:-

You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the
non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it
satisfies all of the following conditions:

0 <= i < j < nums.length
nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.



Example 1:

Input: nums = [42,11,1,97]
Output: 2
Explanation: The two pairs are:
 - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
Example 2:

Input: nums = [13,10,35,24,76]
Output: 4


Constraints:

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
 */

import java.util.HashMap;
import java.util.Map;

public class P01CountNicePairsinAnArray {

    /*
    Always remember this pattern. For this kind of problem where you have been asked like there is equal to and
    on LHS side something needs to be checked on i , j and same on RHS side need to perfrom things on i,j and check.
    So in this kind of questions, solution is, simply you should bring all the operations on i to one side of the array
    and all the operations of j take another side of the aray. And now perform those operations and try to solve the
    problem

    For Example:-
    for above question, it was said that pairs are said to be nice if they are following below operations
    nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])

    - Now here as we discussed, something needs to be done on i and j both are present on LHS as well as RHS side.
    - So 1st just regroup them on single side based on variables.
    - For example here, i should regroup like below.
    nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
    - Now try to solve it. So now my problem becomes very easy ryt? like now it only becomes to travel on i and
    store value (nums[i]-rev(nums[i])) in the map to keep track of like weather this value has been seen previously
    or not? if yes then how many times and we sum up to get the final answer.
    - So means just after regrouping my question transformed into simple counting the values from array (i.e. by
    using Hashing, store elems as move ahead).

     */

    public int countNicePairs(int[] nums) {
        // Better Approach :- TC:- O(N) + N*O(logN) { to reverse each number}, SC:- O(N)
        Map<Integer,Integer> mp = new HashMap<>();
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(nums[i]-rev(nums[i]))) cnt = (cnt + mp.get(nums[i]-rev(nums[i])))%1000000007;
            mp.put(nums[i]-rev(nums[i]),mp.getOrDefault(nums[i]-rev(nums[i]),0)+1);
        }
        return cnt%1000000007;
    }

    private int rev(int num){
        // 1) way to reverse a number
        // StringBuilder sb = new StringBuilder(Integer.toString(n));
        // return Integer.parseInt(sb.reverse().toString());

        // 2) Another way to reverse a number (more optimised) - TC:- O(logN)
        int result=0;
        while(num > 0){
            result=result*10 + num%10;
            num/=10;
        }
        return result;
    }

}