package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/combination-sum-iii/description/

// Problem Description :-
/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the
combinations may be returned in any order.


Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are
no valid combination.

Constraints:
2 <= k <= 9
1 <= n <= 60

 */


// Intuition & Approach :-
/*
- This question is again similar as problem Combinations. Just see that solution & we just need to change the base
condition everything remains as is.
 */

import java.util.ArrayList;
import java.util.List;

public class BT08CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        recBacktrack(k,n,1,seq,res);
        return res;
    }

    private void recBacktrack(int k, int n, int start, List<Integer> seq, List<List<Integer>> res){
        // Base Condition - 1:-
        if(k==0 && n==0){
            res.add(new ArrayList<>(seq));
            return;
        }
        // Base Condition - 2:-
        if(n<0 || start>9) return;

        seq.add(start);
        recBacktrack(k-1,n-start,start+1,seq,res);
        seq.remove(seq.size()-1);
        recBacktrack(k,n,start+1,seq,res);
    }

    // Conclusion :-
    /*
    Summary:
1. Today's question is the culmination of Combination Sum-I and Combination Sum-II
2. Instead of having a given vector nums or arr, we are asked to consider numbers from 1 to 9(both inclusive)
3. We can also visualise them to be inside an array but actually we don't to create it and use extra space.
4. Now we need to pass in the void help() the following parameters:
1) i for the element and n for the target sum
2) sumTillNow to calculate the sum we have accumulated till now
3) k for the number of elements we require in our subset
4) vector subset and vector<vector<int>> ans

5. Now we will have the base conditions:
a) if(k==0)
It means we have calculated the number of elements required. Thus check whether sumTillNow== n. If so include it in the
subset else simply return
b) if(sumTillNow > n)
We have a sum which is more than target, and as we don't have negative numbers we cannot form n so we simply return.
c) if(i==10)
We can have elements till 9 only. So we return

6. Now we pick the i-th element into our subset , increment sumTillNow by i and ask Recursion to do the calculation for
i +1 elements.
7. When we return, we backtrack the changes, decrement sumTillNow by i and pop_back() the inserted element.
8. We now ignore the i-th element, so we simply call for i+1 and ask Recursion to do the remaining task.

Time Complexity: O(2^N) [ In worst case, we need to include all the elements till 9 to have n]
Space Complexity: O(N) [ Height of Recursive Tree]

     */
}
