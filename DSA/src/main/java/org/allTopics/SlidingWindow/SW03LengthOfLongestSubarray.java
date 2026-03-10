package org.allTopics.SlidingWindow;

// Problem Link :- https://www.geeksforgeeks.org/problems/length-of-longest-subarray0440/1

// Problem Statement :-
/*
Given an array arr[], return the length of the longest subarray of non-negative integers.
Note: Subarray here means a continuous part of the array.

Examples:

Input: arr[] = [2, 3, 4, -1, -2, 1, 5, 6, 3]
Output: 4
Explanation: The subarray [ 1, 5, 6, 3] has longest length 4 and contains no negative integers
Input: arr[] = [1, 0, 0, 1, -1, -1, 0, 0, 1, 0]
Output: 4
Explanation: Subarrays [1, 0, 0, 1] and [0, 0, 1, 0] have equal lengths but sum of first one is greater so that will be
the output.

Constraints:
1 <= arr.size() <= 10^6
-10^6 <= arr[i] <= 10^6
 */

public class SW03LengthOfLongestSubarray {
    public int longestSubarry(int arr[]) {
        // write code here
        int i=0;
        int j=0;
        int ans1 = Integer.MIN_VALUE;
        while(j<arr.length){
            if(arr[j]<0){
                i=j;

            }
            else{
                ans1 = Math.max(ans1,j-i+1);
            }
            j++;
        }
        return ans1;

    }
}
