package org.allTopics.PrefixSum;

// Problem Link:- https://leetcode.com/problems/find-the-middle-index-in-array/description/

// Problem Description:-
/*
Given a 0-indexed integer array nums, find the leftmost middleIndex (i.e., the smallest amongst all the possible ones).
A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ...
+ nums[nums.length-1].
If middleIndex == 0, the left side sum is considered to be 0. Similarly, if middleIndex == nums.length - 1, the right side sum is
considered to be 0.
Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index.

Example 1:
Input: nums = [2,3,-1,8,4]
Output: 3
Explanation: The sum of the numbers before index 3 is: 2 + 3 + -1 = 4
The sum of the numbers after index 3 is: 4 = 4
Example 2:
Input: nums = [1,-1,4]
Output: 2
Explanation: The sum of the numbers before index 2 is: 1 + -1 = 0
The sum of the numbers after index 2 is: 0
Example 3:
Input: nums = [2,5]
Output: -1
Explanation: There is no valid middleIndex.

Constraints:
1 <= nums.length <= 100
-1000 <= nums[i] <= 1000

Note: This question is the same as 724: https://leetcode.com/problems/find-pivot-index/
 */

public class PS03EquilibriumPoint {

    public static int equilibriumPoint(int nums[]) {
        // code here
        /*
         // Bruteforce:- TC:- O(N^2)
         int idx=-1;
         for(int i=0;i<nums.length;i++){
             int left=0;
             int right=0;
             for(int j=0;j<i;j++) left+=nums[j];
             for(int j=i+1;j<arr.length;j++) right+=nums[j];
             if(left==right){
                 idx=i;
                 break;
             }
         }
         return idx;

        */

        /*
         // Better:- Prefix Sum :- TC:- O(N), SC:-O(2N)
         long[] pf = new long[nums.length];
         pf[0] = arr[0];
         for(int i=1;i<nums.length;i++){
             pf[i] = pf[i-1] + nums[i];
         }

         long[] sf = new long[nums.length];
         sf[arr.length-1] = arr[nums.length-1];
         for(int i=nums.length-2;i>=0;i--){
             sf[i]=sf[i+1]+nums[i];
         }

         int idx=-1;
         for(int i=0;i<nums.length;i++){
             long left=0;
             long right=0;
             if(i==0){
                 left=0;
                 right=sf[i+1];
             }
             else if(i==nums.length-1){
                 left=pf[i-1];
                 right=0;
             }
             else{
                 left = pf[i-1];
                 right = sf[i+1];
             }

             if(left==right){
                 idx=i;
                 break;
             }
         }
         return idx;

         */

        /*
         // Optimised Prefix Approach:- without using suffix.:- TC:- O(N), SC:- O(N)
         int[] pf = prefixSumArray(A);
         pf[0] = A[0];
         for(int i=1;i<A.length;i++){
             pf[i] = pf[i-1] + A[i];
         }
         int index = -1;
         int ls = 0;
         int rs = 0;
         int count = 0;
         for(int i=0;i<A.length;i++){
             if(i == 0){
                 ls = 0;
                 rs = pf[A.length-1] - pf[0];
             }
             else{
                 ls = pf[i-1];
                 rs = pf[A.length-1]-pf[i];
             }
             if(ls==rs) {
                 count++;
                 if(count>1) index = Math.min(index,i);
                 else{
                     index = i;
                 }
             }
         }
         return index;

         */


        // Optimised :- Cumulative Sum:- TC:- O(n), SC:-O(1)
        if(nums.length==0){
            return -1;
        }

        // Optimised :- TC:- O(2N), SC:- O(1)
        long totalSum=0;
        for(int elem:nums) totalSum += elem;

        long cumSum=0; // cumulative sum
        for(int i=0;i<nums.length;i++){
            // while moving forward, reduce current elem from totalSum (which denotes the
            // rightSum), and add it to the cumSum (which denotes the leftSum) after comparison.
            totalSum-=nums[i];
            if(totalSum==cumSum){
                return i;
            }
            cumSum+=nums[i];
        }
        return -1;
    }
}
