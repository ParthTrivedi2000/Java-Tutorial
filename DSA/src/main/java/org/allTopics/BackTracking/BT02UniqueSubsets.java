package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/subsets-ii/description/

// Problem Description :-
/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BT02UniqueSubsets {
    public static void main(String[] args) {}

    /*
     - as discussed, for not picking call, before performing call, if next elems are same
     then we should skip it. for example:- [1,2,2] --> if we are at idx=1, then while
     performing pick call, we don't need to do anything, but while performing not pick
     call, simply we need to skip next elems till it equals with prev elem. so idx will
     be at last occurrence of element. and during next not pick rec call, we will be having
     idx+1 only.
     - But in above discussion, if you observe carefully, always it won't be the case like
     everytime same elems given together in ip. for example:- ip:-[2,1,2], so here as we
     can see, we don't have 2 together. So simply before starting/passing to backtrack
     function, simply we need to sort the ip array, then pass it. else everything keep
     it as is.

Conclusion :
1. In Subsets-I, we have all the elements as unique. That's why our Pick and Don't Pick conditions were working fine.
2. In Subsets-II, we will have duplicate elements. But we want our final ans to contain only unique subsets.
3. We can achieve it by counting only one occurrence of an element and skipping all its rest occurrences in arr[]
4. We need to first sort the given vector arr[]
5. For don't pick condition, we will first check whether arr[i]==arr[i+1] or not. If so, we will ignore the rest
occurrences of that particular element.
5. Time and Space Complexity will remain same[in worst case we will have unique elements only]

Time Complexity :-
Worst Case Time Complexity: O(2^N)
Space Complexity:O(N)
This is mainly because in the Worst Case we will have all unique elements and the maximum number of nodes will be 2^N ,
calculated by sum of GP series ( as explained prev question)

     */

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        Arrays.sort(nums);
        recBacktrack(nums,0,seq,res);
        return res;
    }

    private void recBacktrack(int[] nums, int idx, List<Integer> seq, List<List<Integer>> res){
        if(idx==nums.length){
            res.add(new ArrayList<>(seq));
            return;
        }

        seq.add(nums[idx]);
        // pick call
        recBacktrack(nums,idx+1,seq,res);
        seq.remove(seq.size()-1);

        // skipping elems before not pick call
        while(idx+1<nums.length && nums[idx]==nums[idx+1]) idx++;
        // not pick call
        recBacktrack(nums,idx+1,seq,res);
    }
}
