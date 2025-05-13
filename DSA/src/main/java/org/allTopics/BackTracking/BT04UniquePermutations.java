package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/permutations-ii/description/

// Problem Description:-
/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BT04UniquePermutations {
    public static void main(String[] args) {}

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        recBacktrack(nums,0,seq,res);
        return res;
    }

    private void recBacktrack(int[] nums, int idx, List<Integer> seq, List<List<Integer>> res){
        // Base Case
        if(idx==nums.length){
            res.add(new ArrayList<>(seq));
            return;
        }

        // simply I am putting each elem at position, & ask the recursion to do the
        // remaining small tasks.
        // So small task is below:- put the elem at position & swap it for remaining positions
        // and ask the recursion to do the tasks.

        Set<Integer> track = new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            if(!track.contains(nums[i])){
                //adding to set, to track during the recursive call
                track.add(nums[i]);
                seq.add(nums[i]);
                swap(nums,i,idx);
                recBacktrack(nums,idx+1,seq,res);
                swap(nums,i,idx);
                seq.remove(seq.size()-1);
            }
        }

    }

    private void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
