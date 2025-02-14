package org.allTopics.Hashing;

// Problem Statement:- https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

/*
Problem Description :-
Given an array arr[] containing integers and an integer k, your task is to find the length of the longest
subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal
to k, return 0.

Examples:
Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the
longest subarray with a sum of 15 is 6.
Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Only subarray with sum = 15 is [-5, 8, -14, 2, 4] of length 5.
Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
Constraints:
1 ≤ arr.size() ≤ 10^5
-10^4 ≤ arr[i] ≤ 10^4
-10^9 ≤ k ≤ 10^9
 */


import java.util.HashMap;
import java.util.Map;

public class H07LongestSubArrayWithSumK {
    public int lenOfLongestSubarr(int[] arr, int k) {

         // BruteForce Approach:- TC:- O(N^3), SC:- O(1)
        /*
          int maxLen = Integer.MIN_VALUE;
          for(int i=0;i<arr.length;i++){
              for(int j=0;j<arr.length;j++){
                  int sum=0;
                  for(int p=i;p<=j;p++){
                      sum+=arr[p];
                  }

                  if(sum==k){
                      maxLen = Math.max(maxLen,j-i+1);
                  }
              }
          }
          return maxLen;

         */


         // Optimised Bruteforce :- O(N^2)
        /*
         int maxL=0;
         for(int i=0;i<arr.length;i++){
             int sum=0;
             for(int j=i;j<arr.length;j++){
                 sum+=arr[j];
                 if(sum==k){
                     maxL = Math.max(maxL,j-i+1);
                     break;
                 }
             }
         }
         return maxL;

         */


         // Better Approach:- Sliding window
         // Note :- only works well if array contains only +ve integers
        /*
         int i=0;
         int j=0;
         int ans = Integer.MIN_VALUE;
         int sum = 0;
         while(j<arr.length){
             // Calculations:-
             sum+=arr[j];

             // while(sum>k){
             //     sum-=arr[i];
             //     i++;
             // }

             if(sum<=k){
                 ans = Math.max(ans,j-i+1);
             }
             else{
                 while(sum>k){
                     sum-=arr[i];
                     i++;
                 }
             }
             j++;
         }
         return ans;

         */


        // Better Approach :- Hashing
        // if array contains -ve integers, then this is the most optimised approach we can have
        Map<Long,Integer> mp = new HashMap<>();
        long sum=0;
        int maxL = Integer.MIN_VALUE;
        mp.put(0L,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            // if(sum==k) maxL = i+1; // didn't understand why we need to put, without it not giving correct answer, just try to comment out this line for testcase (arr:- -59 -25 58 -59 -25 58, k=-85)
            if(mp.containsKey(sum-k)){
                maxL = Math.max(maxL,i-mp.get(sum-k));
            }
            if(!mp.containsKey(sum)) mp.put(sum, i);
            // mp.put(sum, i);
        }
        return maxL;
    }
}