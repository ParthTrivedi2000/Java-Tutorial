package org.allTopics.Hashing;

// Problem Link :- https://leetcode.com/problems/subarray-sum-equals-k/description/

/*
Problem Description :-
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2
Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

Constraints:
1 <= nums.length <= 2 * 10^4
-1000 <= nums[i] <= 1000
-10^7 <= k <= 10^7
 */

import java.util.HashMap;
import java.util.Map;

public class H07SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

/*
 whenever finding subarray with sums question is there, then we can use concept
 pf+hashing
 or carray forward + hashing

 Concept:-
 Concept says, 1st precalculate the sum. Now if this sum-target is available previously in the DS(Map/Set) then i.e. there
 exists a subarray with that target sum. hence you can get the count of (sum-target) key. And then you have to update the
 DS with the current sum available for future use (remember here you need to put the sum not the element arr[i])

 And to handle one of the edge case, at starting only, put (0,1) in the mp.

 */

        int sum=0;
        int cnt=0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(mp.containsKey(sum-k)) cnt+=mp.get(sum-k);
            mp.put(sum, mp.getOrDefault(sum,0)+1);
        }
        return cnt;
    }

}
