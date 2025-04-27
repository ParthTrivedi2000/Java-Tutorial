package org.allTopics.Arrays;

// Problem Statement:- https://leetcode.com/problems/majority-element/description/

// Problem Description :-
/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3
Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
n == nums.length
1 <= n <= 5 * 10^4
-10^9 <= nums[i] <= 10^9

Follow-up: Could you solve the problem in linear time and in O(1) space?

 */

public class MajorityElement {
    // There are multiple approaches to solve this problem. Here only optimised approach is mentioned. But I highly
    // encourage to write down all the approaches starting from bruteforce whenever you get time. Approaches I am
    // mentioning below.
    // 1) By using 2 loops. TC:O(N^2), SC: O(1)
    // 2) Sorting. TC:O(NlogN), SC:-O(1)
    // 3) Hashing/Freq Array :- TC:-O(N), SC:-O(N)
    // 4) Moore Voting Algo:- TC:-O(N), SC:-O(1). For moore voting algo, there is another code as well which is For
    // if in question, it's not sure ki array always consists of majority element, that code also write it down here.

    public int majorityElement(int[] nums) {

        // Approach - 1:- Bruteforce:- TC:- O(N^2), SC:- O(1)
        // Iterate over the subarray and count each elem in the remaining subarray.

        // // Approach - 2:- Better Approach:- TC:- O(N), SC:- O(N)
        // Map<Integer,Integer> mp= new HashMap<>();
        // for(int i=0;i<A.length;i++){
        //     mp.put(A[i],mp.getOrDefault(A[i],0)+1);
        // }

        // for(int elem: mp.keySet()){
        //     if(mp.get(elem)>Math.floor(A.length/2)) return elem;
        // }


        // Approach - 3:- TC:- O(N), SC:- O(1)
        // Optimised Approach:- Moore Voting Algorithm.
        int majority = nums[0];
        int frequency = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==majority){
                frequency++;
            }else{
                frequency--;
            }

            if(frequency==0){
                majority = nums[i];
                frequency=1;
            }
        }
        return majority;
    }
}
