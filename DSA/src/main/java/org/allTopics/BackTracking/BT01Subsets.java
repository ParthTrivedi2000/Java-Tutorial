package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/subsets/description/

// Problem Description :-
/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

 */

import java.util.ArrayList;
import java.util.List;

public class BT01Subsets {
    public static void main(String[] args) {}

    private void rf(int[] arr,int index, ArrayList<Integer> seq, List<List<Integer>> res){
        if(index==arr.length){
            res.add(new ArrayList<>(seq));
            return;
        }

        // picking element
        seq.add(arr[index]);

        // recursive call for picking element
        rf(arr,index+1,seq,res);

        // removing element to get back to the previous state as we are using same array to store the answere of each
        // call hence need to go back to the previous state everytime before calling next not picking function call.
        seq.remove(seq.size()-1);

        // recursive call for not picking element
        rf(arr,index+1,seq,res);
        // return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> seq = new ArrayList<>();
        rf(nums, 0, seq, res);
        return res;
    }
}
