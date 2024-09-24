package org.allTopics.Hashing;

// Problem Link :- https://leetcode.com/problems/range-frequency-queries/

/*
Problem Description:-
Design a data structure to find the frequency of a given value in a given subarray.
The frequency of a value in a subarray is the number of occurrences of that value in the subarray.

Implement the RangeFreqQuery class:
RangeFreqQuery(int[] arr) Constructs an instance of the class with the given 0-indexed integer array arr.
int query(int left, int right, int value) Returns the frequency of value in the subarray arr[left...right].
A subarray is a contiguous sequence of elements within an array. arr[left...right] denotes the subarray that contains
the elements of nums between indices left and right (inclusive).

Example 1:
Input
["RangeFreqQuery", "query", "query"]
[[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
Output
[null, 1, 2]
Explanation
RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]);
rangeFreqQuery.query(1, 2, 4); // return 1. The value 4 occurs 1 time in the subarray [33, 4]
rangeFreqQuery.query(0, 11, 33); // return 2. The value 33 occurs 2 times in the whole array.

Constraints:
1 <= arr.length <= 10^5
1 <= arr[i], value <= 10^4
0 <= left <= right < arr.length
At most 10^5 calls will be made to query

 */

// JFYI:- this is solved using Hashing and Binary search concept here. but another approach is
//to use the Fenwick tree which is specifically used for this purpose of range queries search purpose.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RangeFrequencyQueries {
    // So we will create map of element and it's corresponding index positions in list
    // form.
    Map<Integer, ArrayList<Integer>> mp;
    public RangeFrequencyQueries(int[] arr) {
        mp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!mp.containsKey(arr[i])) mp.put(arr[i],new ArrayList<>());
            mp.get(arr[i]).add(i);
        }
    }

    // Now logic is to search for the 1st occurance of the given element from range
    // 0 to left. and last occurance of element from range 0 to right. then if we do
    // last occurance-first occurance, we came to know about the count ryt.

    public int query(int left, int right, int value) {
        // Find the position of first occurrence of element
        int a = lower_bound(mp.get(value), 0, mp.get(value).size(), left);

        // Find the position of last occurrence of element
        int b = upper_bound(mp.get(value), 0, mp.get(value).size(), right);

        return b - a;
    }

    public int lower_bound(ArrayList<Integer> a, int low, int high, int key){
        if (low > high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if (key <= a.get(mid)) return lower_bound(a, low, mid - 1, key);
        return lower_bound(a, mid + 1, high, key);
    }

    public int upper_bound(ArrayList<Integer> a, int low, int high, int key){
        if (low > high || low == a.size())
            return low;
        int mid = low + (high - low) / 2;
        if (key >= a.get(mid)) return upper_bound(a, mid + 1, high, key);
        return upper_bound(a, low, mid - 1, key);
    }
}
