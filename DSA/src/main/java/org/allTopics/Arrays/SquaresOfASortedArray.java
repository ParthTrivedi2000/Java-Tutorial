package org.allTopics.Arrays;

// Link :- https://leetcode.com/problems/squares-of-a-sorted-array/description/

// Problem Description :-
/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in
non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Constraints:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a
different approach?
 */

import java.util.ArrayList;
import java.util.List;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        // Bruteforce:- O(N + NlogN)
        // - 1st square all the elems --> O(n)
        // - then do sort it. --> O(nlogn)

        /*
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = nums[i]*nums[i];
        }

        Arrays.sort(ans);
        return ans;
        */

        // Optimised:-
        // [-4,-1,0,3,10] ==> [16,1,0,9,100]
        // if you observe something then we can think of having 2 separate arrays
        // one for -ve & one for +ve. and then we can have squared elems & simply we
        // can apply that algo of merge 2 sorted arrays.

        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        int[] ans = new int[nums.length];

        for(int elem:nums){
            if(elem>=0) pos.add(elem*elem);
            else neg.add(elem*elem);
        }


        if(neg.size()==0){
            for(int i=0;i<pos.size();i++){
                ans[i] = pos.get(i);
            }
            return ans;
        }

        if(pos.size()==0){
            int idx=0;
            for(int i=neg.size()-1;i>=0;i--){
                ans[idx] = neg.get(i);
                idx++;
            }
            return ans;
        }

        // Since array has both: -ve + ve => apply Merge 2 sorted arrays algo.

        // 1st we need to reverse the neg<>() list
        reverse(neg);

        int first=0;
        int second = 0;
        int idx=0;
        while(first<neg.size() && second<pos.size()){
            if(neg.get(first)<=pos.get(second)){
                ans[idx] = neg.get(first);
                first++;
                idx++;
            }
            else{
                ans[idx] = pos.get(second);
                second++;
                idx++;
            }
        }

        while(first<neg.size()){
            ans[idx] =  neg.get(first);
            first++;
            idx++;
        }
        while(second<pos.size()){
            ans[idx]=pos.get(second);
            second++;
            idx++;
        }

        return ans;

    }

    private void reverse(List<Integer> al){
        int i=0;
        int j=al.size()-1;
        while(i<j){
            int temp = al.get(i);
            al.set(i,al.get(j));
            al.set(j,temp);
            i++;
            j--;
        }
    }

    public int[] sortedSquaresByAITool(int[] nums) {

        // Approach :- Two Pointer Approach :- TC:- O(N), SC:- O(N)

        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }

        return result;
    }

}
