package org.allTopics.PrefixSum;

// Problem Link:- https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1

// Problem Description:-
/*
You are given an array arr of positive integers. Your task is to find all the leaders in the array. An element
is considered a leader if it is greater than or equal to all elements to its right. The rightmost element is
always a leader.

Examples:
Input: arr = [16, 17, 4, 3, 5, 2]
Output: [17, 5, 2]
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
Input: arr = [10, 4, 2, 4, 1]
Output: [10, 4, 4, 1]
Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on
the right side
Input: arr = [5, 10, 20, 40]
Output: [40]
Explanation: When an array is sorted in increasing order, only the rightmost element is leader.
Input: arr = [30, 10, 10, 5]
Output: [30, 10, 10, 5]
Explanation: When an array is sorted in non-increasing order, all elements are leaders.
Constraints:
1 <= arr.size() <= 10^6
0 <= arr[i] <= 10^6
 */

import java.util.ArrayList;

public class PS03EquilibriumPoint {
    static ArrayList<Integer> leaders(int arr[]) {
        // Bruteforce :- O(N^2), SC:O(1)
        /*
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j;

            // Check elements to the right
            for (j = i + 1; j < n; j++) {

                // If a larger element is found
                if (arr[i] < arr[j])
                    break;
            }

            // If no larger element was found
            if (j == n)
                result.add(arr[i]);
        }
        return result;

         */


        // Optimised :- TC:- O(N), SC:- O(N)
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        // Start with the rightmost element
        int maxRight = arr[n - 1];

        // Rightmost element is always a leader
        result.add(maxRight);

        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxRight) {
                maxRight = arr[i];
                result.add(maxRight);
            }
        }

        // Reverse the result list to maintain
        // original order
        Collections.reverse(result);

        return result;
    }
}