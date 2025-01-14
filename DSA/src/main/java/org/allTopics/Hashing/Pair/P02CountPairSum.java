package org.allTopics.Hashing.Pair;

// Problem Link :- https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum--150253

/*
Problem Description :-
Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.

Examples:
Input: arr[] = [1, 5, 7, -1, 5], target = 6
Output: 3
Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5).
Input: arr[] = [1, 1, 1, 1], target = 2
Output: 6
Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1), (1, 1).
Input: arr[] = [10, 12, 10, 15, -1], target = 125
Output: 0
Constraints:
1 <= arr.size() <= 10^5
-104 <= arr[i] <= 10^4
1 <= target <= 10^4
 */

import java.util.HashMap;
import java.util.Map;

public class P02CountPairSum {
    int countPairs(int arr[], int target) {
        // Your code here
        // Bruteforce:- Will write it later
        // Better Approach:- Hashing
        Map<Integer,Integer> mp = new HashMap<>();
        int cnt=0;
        for(int elem:arr){
            if(mp.containsKey(target-elem)){
                cnt+=mp.get(target-elem);
            }
            mp.put(elem,mp.getOrDefault(elem,0)+1);
        }
        return cnt;
    }
}
