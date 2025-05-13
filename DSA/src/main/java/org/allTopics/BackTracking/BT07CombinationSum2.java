package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/combination-sum-ii/description/

// Problem Description :-
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.


Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]


Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

 */


// Intuition & Approach:-
/*
- This question is as similar as subset-II. Means here we have been given duplicate elems, but we have to return the
unique subset only which makes up the target. So simply we can sort the ip array and then only pass to the recursive
call. And then during not pick call, simply we skip the same elms as we did in the subset-II problem. means pick code
from prev combination sum and Just add that skipping elems line and we are done.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BT07CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        Arrays.sort(candidates);
        recBacktrack(candidates,target,0,seq,res);
        return res;
    }

    private void recBacktrack(int[] candidates, int target, int idx, List<Integer> seq, List<List<Integer>> res){
        // Base condition-1:-
        if(target==0){
            res.add(new ArrayList<>(seq));
            return;
        }
        // Base condition-2:-
        if(target<0 || idx>=candidates.length) return;

        seq.add(candidates[idx]);
        recBacktrack(candidates,target-candidates[idx],idx+1,seq,res);
        seq.remove(seq.size()-1);
        // Not pick call
        while(idx+1<candidates.length && candidates[idx]==candidates[idx+1]) idx++;
        recBacktrack(candidates,target,idx+1,seq,res);
    }

    // Conclusion :-
    /*
    Summary:
1. Combination Sum 2 is a question of Subsets-II, which was generating Unique subsets, and Combination- I where we need
to generate a subsets whose sum is equal to TargetSum. To avoid duplicate elements, we need to sort the given array
first then only we can use the logic as we discussed previously of generating Unique subsets with duplicate elements.
2. The only difference is that we can't keep choosing an element as many times as we want. We can choose an element
only once.
3. So what we will do here is, we use the knowledge of Subsets-II and Combination Sum -1 to solve the question.
4. The bases cases are very simple:
a) if(currenrSum == targetSum)
put the subset in your ans[][] vector and return.
b) if (currentSum > targetSum)
We can't get the targetSum, so we should return
c) if(i >= arr.size())
We have traversed the entire array so we should return.
5)We then pick the ith element, put it into our subset[] vector and increment sum as sum += arr[i] and call Recursive
function with i+1
6) On returning, we need to backtrack, and put the element out of subset vector and bring currentSum to its original
value.
7) Now to avoid duplicate elements, we start traversing through the subset till arr[i] == arr[i+1]
8)After that, we apply the condition of don't pick, so i+1 but currentSum remains the same.
Time Complexity: O(2^N) [ Because we are always moving to the next index so it can be O(2^N) , if target is equal to
sum of all array elements as well]
Space Complexity: O(N) [ It's equal to the height of the Recursive tree, so it's O(N)]
     */
}
