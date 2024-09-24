package org.allTopics.Hashing;

// Problem Link :- https://www.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1

/*
Problem Description:-
Given an array of integers. Find if there is a subarray (of size at-least one) with 0 sum. You just need to return
true/false depending upon whether there is a subarray present with 0-sum or not. Printing will be taken care by
the driver code.

Example 1:
Input:
n = 5
arr = {4,2,-3,1,6}
Output:
Yes
Explanation:
2, -3, 1 is the subarray with sum 0.
Example 2:
Input:
n = 5
arr = {4,2,0,1,6}
Output:
Yes
Explanation:
0 is one of the element in the array so there exist a subarray with sum 0.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= n <= 10^4
-10^5 <= a[i] <= 10^5
 */

import java.util.HashSet;
import java.util.Set;

public class SubArrayWith0Sum {

    /*
    // Approach - 1:- BruteForce Approach:- TC:- O(N^2), SC:- O(1)
    static boolean findsum(int arr[],int n) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += arr[j];
            }
            if (sum == 0) return true;
        }
        return false;
    }
     */


    // Approach - 2:- Using PF + Hashing :- TC:- O(N), SC:- O(N+N) ~ O(N)
    static boolean findsum(int arr[],int n) {
        //Your code here
        int[] pf = new int[arr.length];
        pf[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            pf[i] = pf[i-1] + arr[i];
        }

        Set<Integer> hs = new HashSet<>();
        hs.add(0);
        for(int i=0;i<arr.length;i++){
            if(hs.contains(pf[i])) return true;
            hs.add(pf[i]);
        }
        return false;
    }

    /*
    // Approach - 3:- Hashing + Carry Froward :- TC:- O(N), SC:- O(N)
    static boolean findsum(int arr[],int n){
        // Very good, easy & Intuitive solution using carry forward approach:-
        HashSet < Long > set = new HashSet < Long > ();
        long sum = 0;
        set.add(sum);
        for (int x: arr) {
            sum += x;
            if (set.contains(sum)) return true;
            else set.add(sum);
        }
        return false;
    }
     */
}
