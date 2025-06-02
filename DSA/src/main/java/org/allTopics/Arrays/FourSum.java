package org.allTopics.Arrays;

// Problem Link :- https://leetcode.com/problems/4sum/description/

// Problem Description :-
/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]
such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:
1 <= nums.length <= 200
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {}

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // // Approach - 1:- Bruteforce
        // Set<List<Integer>> hs = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         for(int k=j+1;k<nums.length;k++){
        //             for(int l=k+1;l<nums.length;l++){
        //                 if(nums[i]+nums[j]+nums[k]+nums[l]==target){
        //                     List<Integer> temp = new ArrayList<>();
        //                     temp.add(nums[i]);
        //                     temp.add(nums[j]);
        //                     temp.add(nums[k]);
        //                     temp.add(nums[l]);
        //                     Collections.sort(temp);
        //                     hs.add(temp);
        //                 }
        //             }

        //         }
        //     }
        // }
        // List<List<Integer>> ans = new ArrayList<>();
        // for(List<Integer> temp:hs) ans.add(temp);
        // return ans;


        // // Approach - 2:- Use Hashing instead of 3rd loop => TC:-O(N^3), SC:- O(N) + O(2* no. of triplets)

        // Set<List<Integer>> hs = new HashSet<>();
        // Set<Long> st = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         for(int k=j+1;k<nums.length;k++){
        //             // just to handle very large value of arr elems for 1 of the TS, we are
        //             // decoupling summations into multiple variables and also taking set as
        //             // set<Long> instead set<Integer>.
        //             // Failed TS:- arr= [1000000000,1000000000,1000000000,1000000000], target= -294967296
        //             long l = nums[i]+nums[j];
        //             l += nums[k];
        //             long random = target - l;
        //             if(st.contains(random)){
        //                 List<Integer> temp = new ArrayList<>();
        //                 temp.add(nums[i]);
        //                 temp.add(nums[j]);
        //                 temp.add(nums[k]);
        //                 temp.add((int)random);
        //                 Collections.sort(temp);
        //                 hs.add(temp);
        //             }
        //             else st.add((long)nums[k]);
        //         }
        //         st.clear();
        //     }
        // }

        // List<List<Integer>> ans = new ArrayList<>();
        // for(List<Integer> temp:hs) ans.add(temp);
        // return ans;


        // Approach - 3:- 2-Pointer Approach
        // TC:- O(NlogN) + O(N^3), SC:- O(No of unique quadruplets) for storing ans.

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            // if i is not 1st elem & i euqals prev elem --> i++
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                // if j is not 1st elem after i & j euqals prev elem --> j++
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    long sum = (nums[i]+nums[j]);
                    sum+=nums[k];
                    sum+=nums[l];
                    if(sum<target) k++;
                    else if(sum>target) l--;
                    else{ // else for sure we got triplet here
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++; // keep incrementing j till j euqals prev elem
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }
}
