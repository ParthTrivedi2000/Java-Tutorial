package org.allTopics.Hashing;

// Problem Link :-

/*
Problem Statement:-
Given an array A of N integers.
Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the
remainder on dividing the result with 10^9+7.

Problem Constraints
1 <= N <= 10^5
-10^9 <= A[i] <= 10^9

Input Format
Single argument which is an integer array A.
Output Format
Return an integer.

Example Input
Input 1:
 A = [1, -1, -2, 2]
Input 2:
 A = [-1, 2, -1]

Example Output
Output 1:
3
Output 2:
1

Example Explanation
Explanation 1:
 The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
Explanation 2:
 The subarray with zero sum is [-1, 2, -1].

 */

import java.util.HashMap;
import java.util.Map;

public class CountSubArray0Sum {
    public int solve(int[] A) {
        if(A.length==1 && A[0]==0) return A.length;

        long count=0;
        long mod = (long)(Math.pow(10,9) + 7);
        long[] pf = new long[A.length];
        pf[0]= A[0];
        for(int i=1;i<A.length;i++){
            pf[i] = pf[i-1] + A[i];
        }

        Map<Long,Long> mp = new HashMap<>();
        mp.put(0L,1L);
        for(int i=0;i<A.length;i++){
            if(mp.containsKey(pf[i])){
                count=count+mp.get(pf[i]);
                mp.put(pf[i],mp.get(pf[i])+1);
            }
            else{
                mp.put(pf[i],1L);
            }
        }
        return (int)(count%mod);
        /*
        But why are we adding the value from the map instead of just 1? This is the key insight:
        When we find a prefix sum that we've seen before, we're not just finding one new subarray with sum zero. We're
        actually finding a new subarray for each previous occurrence of this prefix sum.
        Let's use an analogy:
        Imagine you're walking on a path and marking your altitude at each step. If you find yourself at the same
        altitude you've been before, it means you've completed a net zero change in height not just with your last
        step, but with every previous time you were at this altitude.
        Can you think of a small example where this would make a difference? Try to construct an array where you'd
        get a different (correct) result by adding the map value instead of just 1.
         */
    }
}
