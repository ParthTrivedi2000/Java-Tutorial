package org.allTopics.Arrays;

//Problem Link :- https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public int lenOfLongestSubarr(int[] arr, int k) {
        // // code here

        // // // BruteForce Approach:- TC:- O(N^3), SC:- O(1)
        // // int maxLen = Integer.MIN_VALUE;
        // // for(int i=0;i<arr.length;i++){
        // //     for(int j=0;j<arr.length;j++){
        // //         int sum=0;
        // //         for(int p=i;p<=j;p++){
        // //             sum+=arr[p];
        // //         }

        // //         if(sum==k){
        // //             maxLen = Math.max(maxLen,j-i+1);
        // //         }
        // //     }
        // // }
        // // return maxLen;

        // // Optimised Bruteforce :- O(N^2)
        // int maxL=0;
        // for(int i=0;i<arr.length;i++){
        //     int sum=0;
        //     for(int j=i;j<arr.length;j++){
        //         sum+=arr[j];
        //         if(sum==k){
        //             maxL = Math.max(maxL,j-i+1);
        //             break;
        //         }
        //     }
        // }
        // return maxL;

        // // Better Approach:- Sliding window
        // // Note :- only works well if array contains only +ve integers

        // int i=0;
        // int j=0;
        // int ans = Integer.MIN_VALUE;
        // int sum = 0;
        // while(j<arr.length){
        //     // Calculations:-
        //     sum+=arr[j];

        //     // while(sum>k){
        //     //     sum-=arr[i];
        //     //     i++;
        //     // }

        //     if(sum<=k){
        //         ans = Math.max(ans,j-i+1);
        //     }
        //     else{
        //         while(sum>k){
        //             sum-=arr[i];
        //             i++;
        //         }
        //     }
        //     j++;
        // }

        // return ans;



        // Better Approach :- Hashing
        // if array contains -ve integers, then this is the most optimised approach we can have
        Map<Long,Integer> mp = new HashMap<>();
        long sum=0;
        int maxL = Integer.MIN_VALUE;
        mp.put(0L,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            // if(sum==k) maxL = i+1; // didn't understand why we need to put, without it not giving correct answer, just try to comment out this line for testcase (arr:- -59 -25 58 -59 -25 58, k=-85)
            // Now if I kept above line mp.put(0,-1), then above line is not needed and working fine. don't know why and how.
            if(mp.containsKey(sum-k)){
                maxL = Math.max(maxL,i-mp.get(sum-k));
            }
            if(!mp.containsKey(sum)) mp.put(sum, i);
            // mp.put(sum, i);
        }

        return maxL;

    }
}
