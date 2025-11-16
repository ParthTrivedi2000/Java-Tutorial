package org.allTopics.Hashing;

// Problem Link :- https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1

/*
Problem Description :-
Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Examples:

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence,
the answer is 4.
Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
Input: arr[] = [1, 1, 1, 1], k = 0
Output: 4
Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
Constraints:

1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤10^5
0 ≤ k ≤ 10^5
 */

import java.util.HashMap;
import java.util.Map;

public class H09CountSubArraysWithGivenXOR {

    public long subarrayXor(int arr[], int k) {
        // code here
        // // Bruteforce :- O(N^2);
        // long cnt=0;
        // for(int i=0;i<arr.length;i++){
        //     long xor=0;
        //     for(int j=i;j<arr.length;j++){
        //         xor=xor^arr[j];
        //         if(xor==k) cnt++;
        //     }

        // }
        // return cnt;

        // Optimised Solution :- Hashing + pf
        // Concept  says:- C= A^B ==> A = C^B
        // where A= xor from 0 to i
        // B=xor from i+1 to j
        // C=xor from 0 to j


        Map<Long,Integer> mp = new HashMap<>();
        long xor=0;
        long cnt=0;
        for(int i=0;i<arr.length;i++){
            xor=xor^arr[i];
            if(mp.containsKey(xor^k)) cnt+=mp.get(xor^k);
            if(xor==k) cnt++;
            mp.put(xor,mp.getOrDefault(xor,0)+1);
        }
        return cnt;
    }

    // Go through below link for better understanding :- https://www.geeksforgeeks.org/count-number-subarrays-given-xor/

}
