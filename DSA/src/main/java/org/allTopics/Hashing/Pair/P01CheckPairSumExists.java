package org.allTopics.Hashing.Pair;

// Problem Link:- https://www.geeksforgeeks.org/problems/key-pair5616/1

/*
Problem Description:-
Given an array arr[] of positive integers and another integer target. Determine if there exists two distinct indices such
that the sum of there elements is equals to target.

Examples:
Input: arr[] = [1, 4, 45, 6, 10, 8], target = 16
Output: true
Explanation: arr[3] + arr[4] = 6 + 10 = 16.
Input: arr[] = [1, 2, 4, 3, 6], target = 11
Output: false
Explanation: None of the pair makes a sum of 11.
Input: arr[] = [11], target = 11
Output: false
Explanation: No pair is possible as only one element is present in arr[].
Constraints:
1 ≤ arr.size ≤ 10^5
1 ≤ arr[i] ≤ 10^5
1 ≤ target ≤ 2*10^5
 */

import java.util.HashSet;
import java.util.Set;

public class P01CheckPairSumExists {

    boolean twoSum(int arr[], int target) {
        // code here

        // //  BruteForce Approach:- TC:- O(N^2), SC:-O(N)
        // for(int i=0;i<arr.length;i++){
        //     for(int j=i+1;j<arr.length;j++){
        //         if((arr[i] + arr[j])==K) return true;
        //     }
        // }

        // Better Approach:-
        Set<Integer> st = new HashSet<>();
        for(int elem:arr){
            if(st.contains(target-elem)) return true;
            st.add(elem);
        }
        return false;
    }

}
