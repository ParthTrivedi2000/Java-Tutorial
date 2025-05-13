package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/combinations/description/

// Problem Description :-
/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.

Constraints:
1 <= n <= 20
1 <= k <= n

 */


// Intution & Approach :-
/*
- See here if you checked output carefully, then simply we have to generate subsets only but with size=k, very simple!!
so we already know how to generate the subsets. we can write that whole code as is, but while adding in the res/ans
data structure, at that place you can put that condition of adding in res only if seq is of size k.

- But as you wrote that code, it will work fine. but here you are doing extra work. means see here anyhow, you just
need only k sized subsets, then why to generate subsets which has higher size than k? ryt? --> so that's where you
can optimise the TC. --> for that, simply in the base condition only you can write this thing & we are done.

- Now one more thing is, if you draw rec tree then we can see that for not picking call which has subset size < k
(lesser than k) then we don't need to perform that call, bec that won't useful & again that's where we can optimise the
time complexity a bit. so just add that condition like whenever k>n-i+1 then we don't need to go ahead & simply return.

 */

import java.util.ArrayList;
import java.util.List;

public class BT05Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        recBacktrack(n,k,1,seq,res);
        return res;
    }

    // Approach - 1:- Written by myself ( but below other ways are more optimised)
    // TC :- O(nCk) = n!/(n-k)!*k! , SC:-
    /*
    private void recBacktrack(int n, int k, int idx, List<Integer> seq, List<List<Integer>> res){
        if(seq.size()==k){
            res.add(new ArrayList<>(seq));
            return;
        }
        for(int i=idx;i<=n;i++){
            seq.add(i);
            if(seq.size()<=k) recBacktrack(n,k,i+1,seq,res);
            seq.remove(seq.size()-1);
        }
    }
     */

    // Approach - 2 :- By generating all the combinations
    /*
    private void recBacktrack(int n, int k, int idx, List<Integer> seq, List<List<Integer>> res){
        // Base case
        if(idx>n){
            if(k==0){
                res.add(new ArrayList<>(seq));
            }
            return;
        }

        seq.add(idx);
        recBacktrack(n,k-1,idx+1,seq,res); // now we just need to pick k-1 elems only
        seq.remove(seq.size()-1);
        // since we haven't picked elem, so still we have to pick k elems.
        recBacktrack(n,k,idx+1,seq,res);
    }

     */

    // Approach - 2 (Optimised) :- Only generate the k sized subsets
    /*
    See simply what we are doing is, we are bringing inner condition of base case from above code to outer. i.e. simply
    whenever we are having k sized array, there only it will stop & return from there itself.
     */
    /*
    private void recBacktrack(int n, int k, int idx, List<Integer> seq, List<List<Integer>> res){
        // Base condition-1:-
        if(k==0){
            res.add(new ArrayList<>(seq));
            return;
        }
        // Base condition-2:-
        if(idx>n) return;

        seq.add(idx);
        recBacktrack(n,k-1,idx+1,seq,res); // now we just need to pick k-1 elems only
        seq.remove(seq.size()-1);
        // since we haven't picked elem, so still we have to pick k elems.
        recBacktrack(n,k,idx+1,seq,res);
    }

     */

    // Approach - 2 (Further Optimised) :- Only generate the k sized subsets (means not exploring trees of >k and <k size)
    // (this approach is providing 99.26% better TC)
    private void recBacktrack(int n, int k, int idx, List<Integer> seq, List<List<Integer>> res){
        // Base condition-1:-
        if(k==0){
            res.add(new ArrayList<>(seq));
            return;
        }
        // Base condition-2:-
        if(k>n-idx+1) return;
        // Base condition-3:-
        if(idx>n) return;

        seq.add(idx);
        recBacktrack(n,k-1,idx+1,seq,res); // now we just need to pick k-1 elems only
        seq.remove(seq.size()-1);
        // since we haven't picked elem, so still we have to pick k elems.
        recBacktrack(n,k,idx+1,seq,res);
    }

    // Conclusion :-
    /*
Summary:
1. This question is a variation of generating all possible subsets
2. Here we have been given a value k and n and we need to generate all possible subsets starting from i = 1 till i <= n
of size k.
3. We would still be using our same logic-  pick an element, backtrack and pop it out and don't pick the element.
4. The above basic approach will be to generate all possible subsets. Time complexity will definitely be O(2^N)
5. A slight improvement from our side can be, we can check if subset.size() == k, that is, if our current Subset already
has k elements, we can simply put it in our ans vector and return.
     Can also be used as if(k==0) if we are returning k-1 in  pick condition.
6. In the most optimised version, we can check if we have greater than or equal to k elements to process or not. That is
to say, if k becomes greater than (n-i+1) elements, this means no matter if we pick all the remaining elements, we still
cannot generate a subset of size k. In this way, we can return directly avoiding smaller subsets.
7. In this way, we can improve the run time of our answer. The Time Complexity is still calculated based on worst case
so it will still be O(2^N).


Selecting all the subsets of size k value from n.
1.Take the element -> k-1 , Skip the element ->k.
2.Base conditions:
(i) if we reach k==0, then push subset into ans and return.
(ii) if k value is greater than remaining elements in n (n-i+1) then return.
(iii) if current(i) value greater than n we return.



Time Complexity: O(2^N) [in worst case]
Space Complexity: O(N) [ for recursive stack] + O(N^2) [ for storing all the subsets in ans vector, in worst case k == n]
     */
}
