package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/combination-sum/description/

// Problem Description :-
/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of
candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency
of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150
combinations for the given input.


Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:
Input: candidates = [2], target = 1
Output: []

Constraints:
1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40

 */

// Intuition & Approach :-
/*
- Almost similar as previous Combinations problem only. Only thing needs to be changed is, base condition.
Means in this problem, whenever target==0 then we have to add it to the ans/res data structure and we are done.
- Another thing is, here if you read question carefully, then it was written that same element can be picked
unlimited times. So another change we need to o is, in the pick call, instead of passing idx+1, we need to pass idx
only means next time to explore the possibilities.
 */

import java.util.ArrayList;
import java.util.List;

public class BT06CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        recBacktrack(candidates,target,0,seq,res);
        return res;
    }

    // Approach - 1:- standard Backtracking template (just apply subset template over here, and you are done)
    /*
    private void recBacktrack(int[] candidates, int target, int idx, List<Integer> seq, List<List<Integer>> res){

        if(target==0){
            res.add(new ArrayList<>(seq));
            return;
        }

        if(target<0 || idx>=candidates.length) return;

        seq.add(candidates[idx]);
        recBacktrack(candidates,target-candidates[idx],idx,seq,res);
        seq.remove(seq.size()-1);
        recBacktrack(candidates,target,idx+1,seq,res);
    }

     */

    // Approach - 2 (More Optimised) :- this approach showing 99.84% better than others.
    private void recBacktrack(int[] candidates, int target, int idx, List<Integer> seq, List<List<Integer>> res){
        // Base condition-1:-
        if(target==0){
            res.add(new ArrayList<>(seq));
            return;
        }
        // Base condition-2:-
        if(target<0 || idx>=candidates.length) return;

        for(int i=idx;i<candidates.length;i++){
            if(candidates[i]<=target){
                seq.add(candidates[i]);
                recBacktrack(candidates,target-candidates[i],i,seq,res);
                seq.remove(seq.size()-1);
            }
        }
    }
    // Conclusion :-
    /*
Summary:
1. This question is very similar to the Combination question we did in Lect 11
2. In place of having exactly k elements in a subset, we have to put those Subsets which have sum equal to TargetSum
3. For that we need to keep calculating currentSum which calculates the current sum of each subset.
4. An element can be picked for any number of times we want.
5. Three Base conditions will be there:
a) if(currentSum == target)
Put the subset in ans[][] and return
b) if(currentSum > target)
We cannot get our targetSum, so we simply return
c) if(i >= arr.size() )
We have traversed the entire array and still hasn't found the Target, so we simply return
6.As we can pick a element for any number of times then the Recursive calls will be such:
a) Pick the Element, include it in the subset and increment currentSum by currentSum+ = arr[i]
b) Back-track, un do the changes we did to both currentSum and subset
c) Don't pick the element, and call for i+1

Time Complexity: Exponential [ we cannot exactly say the number of calls we make]
Space Complexity:  Height of Recursive Tree [ don't know exactly 😅]

Time Complexity :- 0(2 pow n) and  Space Complexity:-0(n)

// Anonymously :-
Logic:- Whenever we have a problem of array where we are supposed to find the subset in any way we can go for pick and
non pick logic.

Now, in this problem  we need to find the subset with the target sum given the condition that we can choose an element
more than once.

Now, for every element we can either choose that elem or not choose .
If we choose the elem then we should add that elem in a temp data structure maybe a list and go for the next call .
NOTE :- since we can use an elem more than once therefore in the next call we should not increment the index counter .

NOTE:-
i)Add the elem in your ds only if the remaining target is less then equal to the current elem.
ii)when we are returning back make sure to remove the last added elem in the data structure if it was aded.

If we dont choose the elem then we should simply make a call to the next iteration and this time we should the index
counter , since we are very sure that we wont need that elem even in the future.


BASE CASE:
i)if the index is equal to the length of the array then check whether the remaining target is 0 or not . If its 0 then
add the ds in your final list else return.




- By Anonymous:-
Prerequisite: Subset and Combination Problem
In this problem, we need those subsets whose sum is equal to a given number. We don't need all subsets.

IMPORTANT NOTE: We can use the same element any number of time. As it is possible that we will need that element again
in the future, but we won't need the element that we have ignored so it will be ignored forever.

Step-1: As in Subset, we have two options:- Either we take the ith element of skip it. First we will skip the ith element.

Step-2: Then by taking the ith element we will add the element into the variable "sum" to keep check on the sum value.
Push the element into "subset" vector then a recursive call with the same value of i.

Step-3: Undo the changes you have made, i.e. remove the last element of the vector that u have added. And subtract that
element from the variable "sum"

BASE CONDITIONS:-
(i) We will return our function when the sum > requiredSum.
(ii) We will add the subset and return our function when the sum = requiredSum.
(iii) We can't go further than the elements in the array size so we will return the function when i >= size of the array.

Time Complexity: O(2^n)
Space Complexity: O(B) or O(n)



- TC Analysis Anonymous:-
TC : O(2^n)+ O (floor(target/min(arr)).
The extra '+' term is for repeated addition till reaching the target
     */
}
