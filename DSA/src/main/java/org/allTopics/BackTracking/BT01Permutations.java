package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/permutations/description/

/*
Problem Description :-
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:
Input: nums = [1]
Output: [[1]]

Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */

import java.util.ArrayList;
import java.util.List;

/*
 See here understand this, if you drawn the rec tree for this, in that you are deciding ki what all values possible
 for this particular place ryt, and since here in rec tree, that place is also changing for the nodes of rec tree,
 hence we need variable to store value or change state for that thing ryt. So here in code, that place is represented
 by idx variable. So just mean to say the purpose of idx is to decide/check for which place/index you are performing
 current call/level in recursion tree.

 Then another thing is, in rec tree you are choosing elems to place at particular index ryt, so those options/
 elements to put on the particular index is also varying for each node based on selection of elems previously. So
 we need variable or something to check it ryt. For that purpose we are maintaining boolean visited array. As soon as
 element is visited, you can mark it as true. (and sorry missed to say, during each call only select the elements
 which marked as false). And then perform the recursive call. And once call is over, make sure to remove/mark as false
 means whatever we have done to achieve the next call those needs to be reverted to get back the previous state back
 as per the backtracking principle.

 */

public class BT01Permutations {
    public List<List<Integer>> permute(int[] nums) {
        // Need to apply BackTracking since it was asked to Enlist all the possibilities.

//        // Approach - 1:- TC:- O(N!), SC:- O(N) for stack + O(N) for visited =~ O(N)
//        List<List<Integer>> ans = new ArrayList<>();
//        ArrayList<Integer> seq = new ArrayList<>();
//        boolean[] vis = new boolean[nums.length];
//        backTrack(nums,0,vis,seq,ans);
//        return ans;


        // Approach - 2:- Using Swapping :-  TC:- O(N!), SC:- O(N) for stack
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> seq = new ArrayList<>();
        backTrackOptimised(nums,0,ans);
        return ans;
    }

    public void backTrack(int[] arr, int idx, boolean[] vis, ArrayList<Integer> seq, List<List<Integer>> ans){
        // sanity check
        if(idx<0 || idx>arr.length) return;

        // base check
        if(idx==arr.length){
            ans.add(new ArrayList<>(seq));
            return;
        }
        // rec case:-
        for(int i=0;i<arr.length;i++){
            if(vis[i]==false){
                // do
                vis[i] = true;
                seq.add(arr[i]);
                // rec call
                backTrack(arr,idx+1,vis,seq,ans);
                // undo
                seq.remove(seq.size()-1);
                vis[i] = false;
            }
        }
    }

    public void backTrackOptimised(int[] arr, int idx, List<List<Integer>> ans){
        // Sanity Check:-
        if(idx<0 || idx>arr.length) return;

        // Base check:-
        if(idx==arr.length){
            // ans.add(new ArrayList<>(seq.addAll(Arrays.asList(arr))));
            List<Integer> seq = new ArrayList<>();
            // seq.clear();
            for(int elem:arr){
                seq.add(elem);
            }
            ans.add(new ArrayList<>(seq));
            return;
        }

        for(int i=idx;i<arr.length;i++){
            // DO
            swap(i,idx, arr);
            // seq.add(arr[i]);
            // rec
            backTrackOptimised(arr, idx+1,ans);
            swap(i,idx, arr);
        }
    }

    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
