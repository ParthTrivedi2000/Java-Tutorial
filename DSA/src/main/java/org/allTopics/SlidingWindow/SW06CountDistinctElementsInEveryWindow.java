package org.allTopics.SlidingWindow;

// Problem Link :- https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1

// Problem Statement :-
/*
Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

Examples:

Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output: [3, 4, 4, 3]
Explanation:
First window is [1, 2, 1, 3], count of distinct numbers is 3.
Second window is [2, 1, 3, 4] count of distinct numbers is 4.
Third window is [1, 3, 4, 2] count of distinct numbers is 4.
Fourth window is [3, 4, 2, 3] count of distinct numbers is 3.
Input: arr[] = [4, 1, 1], k = 2
Output: [2, 1]
Explanation:
First window is [4, 1], count of distinct numbers is 2.
Second window is [1, 1], count of distinct numbers is 1.
Input: arr[] = [1, 1, 1, 1, 1], k = 3
Output: [1, 1, 1]
Explanation: Every window of size 3 in the array [1, 1, 1, 1, 1], contains only the element 1, so the number of distinct
elements in each window is 1.

Constraints:
1 ≤ k ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^5

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(k)

Company Tags
Accolite, Amazon, Microsoft, NPCI
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SW06CountDistinctElementsInEveryWindow {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        int i=0;
        int j=0;
        Map<Integer,Integer> mp = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while(j<arr.length){
            // general calc
            if(mp.containsKey(arr[j])) mp.put(arr[j],mp.get(arr[j])+1);
            else mp.put(arr[j],1);

            if(j-i+1<k)j++;
            else if(j-i+1==k){
                // get ans from calc
                ans.add(mp.size());
                // nullyfying impact of prev i
                if(mp.containsKey(arr[i])){
                    mp.put(arr[i],mp.get(arr[i])-1);
                    if(mp.get(arr[i])==0) mp.remove(arr[i]);
                }
                // Slide the window
                i++;
                j++;
            }
        }
        return ans;
    }
}
