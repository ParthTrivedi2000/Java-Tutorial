package org.allTopics.Hashing;

// Problem Link:- https://www.geeksforgeeks.org/problems/key-pair5616/1

/*
Problem Description:-
Given an array arr of positive integers and another number target. Determine whether two elements exist in arr whose
sum is exactly target or not. Return a boolean value true if two elements exist in arr else return false.

Examples:
Input: arr[] = [1, 4, 45, 6, 10, 8], target =16
Output: true
Explanation: arr[3] + arr[4] = 6 + 10 = 16
Input: arr[] = [1, 2, 4, 3, 6], target = 11
Output: false
Explanation: None of the pair makes a sum of 11
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ arr.size ≤ 10^5
1 ≤ arr[i] ≤ 10^5
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    // There are multiple approach available for this problem. This is very famous problem. This problem also
    // available with the name - Pair with given sum. basically we need to identify the pair (i,j) which sums up
    // to target value.
    /*
    // Approach - 1:- Bruteforce:- TC:- O(N^2), SC:- O(1)
    boolean twoSum(int arr[], int target) {
        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            // For each element arr[i], check every other element arr[j] that comes after it
            for (int j = i + 1; j < arr.length; j++) {
                // Check if the sum of the current pair equals the target
                if (arr[i] + arr[j] == target) return true;
            }
        }
        // If no pair is found after checking all possibilities
        return false;
    }
     */

    /*
    // Approach - 2:- [Better Approach-1] Sorting and Binary Search – O(n*log(n)) time and O(1) space
    static boolean twoSum(int[] arr, int target){
        // Sort the array
        Arrays.sort(arr);

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            // Use binary search to find the complement
            if (binarySearch(arr, i + 1, arr.length - 1, complement)) return true;
        }
        // If no pair is found
        return false;
    }
    boolean binarySearch(int[] arr, int left, int right, int target){
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
     */

    // Approach - 3:- [Better Approach-2] Sorting and Two-Pointer Technique – O(n*log(n)) time and O(1) space
    /*
    static boolean twoSum(int[] arr, int target){
        // Sort the array
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        // Iterate while left pointer is less than right
        while (left < right) {
            int sum = arr[left] + arr[right];
            // Check if the sum matches the target
            if (sum == target) return true;
            else if (sum < target) left++; // Move left pointer to the right
            else right--; // Move right pointer to the left
        }
        // If no pair is found
        return false;
    }
     */

    // Approach - 4:- [Best Approach] Using Hash Set – O(n) time and O(n) space
    public boolean solve(int A, int[] B) {
        Set<Integer> hs = new HashSet<>();
        for(int i=0;i<B.length;i++){
            if(hs.contains(A-B[i])) return true;
            hs.add(B[i]);
        }
        return false;
    }
}
