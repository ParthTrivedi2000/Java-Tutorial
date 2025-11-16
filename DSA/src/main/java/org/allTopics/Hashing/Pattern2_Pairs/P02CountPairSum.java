package org.allTopics.Hashing.Pattern2_Pairs;

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
-10^4 <= arr[i] <= 10^4
1 <= target <= 10^4
 */

import java.util.HashMap;
import java.util.Map;

public class P02CountPairSum {
    int countPairs(int arr[], int target) {
        // Your code here

        // // BruteForce :- TC:-O(N^2)  SC:-O(N)
        // int cnt=0;
        // for(int i=0;i<arr.length;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         if(arr[i]-arr[j]==target || arr[j]-arr[i]==target) cnt++;
        //     }
        // }
        // return cnt;

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
