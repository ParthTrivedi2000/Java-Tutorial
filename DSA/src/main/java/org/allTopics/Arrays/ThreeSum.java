package org.allTopics.Arrays;

// Problem Link :- https://leetcode.com/problems/3sum/description/

// Problem Description :-
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

Constraints:
3 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // // Approach - 1:- Bruteforce :- TC:- O(N^3), SC:- O(2* no. of triplets)
        // Set<List<Integer>> hs = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         for(int k=j+1;k<nums.length;k++){
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 List<Integer> temp = new ArrayList<>();
        //                 temp.add(nums[i]);
        //                 temp.add(nums[j]);
        //                 temp.add(nums[k]);
        //                 Collections.sort(temp);
        //                 hs.add(temp);
        //             }
        //         }
        //     }
        // }
        // List<List<Integer>> ans = new ArrayList<>();
        // for(List<Integer> temp:hs) ans.add(temp);
        // return ans;


        // // Approach - 2:- Use Hashing instead of 3rd loop => TC:-O(N^2), SC:- O(N) + O(2* no. of triplets)

        // Set<List<Integer>> hs = new HashSet<>();
        // Set<Integer> st = new HashSet<>();
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         int k = -(nums[i]+nums[j]);
        //         if(st.contains(k)){
        //             List<Integer> temp = new ArrayList<>();
        //             temp.add(nums[i]);
        //             temp.add(nums[j]);
        //             temp.add(k);
        //             Collections.sort(temp);
        //             hs.add(temp);
        //         }
        //         else st.add(nums[j]);
        //     }
        //     st.clear();
        // }

        // List<List<Integer>> ans = new ArrayList<>();
        // for(List<Integer> temp:hs) ans.add(temp);
        // return ans;


        // Approach - 3:- 2 pointer => TC:-O(N^2), SC:- O(no. of triplets)

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            // if i is not 1st elem & i equals prev elem --> i++
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0) j++;
                else if(sum>0) k--;
                else{ // else for sure we got triplet here
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++; // keep incrementing j till j equals prev elem
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
}
