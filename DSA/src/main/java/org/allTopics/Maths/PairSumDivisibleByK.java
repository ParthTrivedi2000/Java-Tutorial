package org.allTopics.Maths;

// Problem Link:- https://www.geeksforgeeks.org/problems/count-pairs-in-array-divisible-by-k/1

/*
Problem Description :-
Given an array arr[] and positive integer k, the task is to count total number of pairs in the array whose sum is
divisible by k.

Examples:
Input :  arr[] = {2, 2, 1, 7, 5, 3}, k = 4
Output : 5
Explanation : There are five pairs possible whose sum is divisible by '4' i.e., (2, 2), (1, 7), (7, 5), (1, 3)
and (5, 3)
Input : arr[] = {5, 9, 36, 74, 52, 31, 42}, k = 3
Output : 7
Explanation : There are seven pairs whose sum is divisible by 3, i.e, (9, 36), (9,42), (74, 52), (36, 42), (74, 31)
, (31, 5) and (5, 52).

Expected Time Complexity : O(n)
Expected Auxiliary Space : O(k)

Constraints :
1 <= n <=10^6
1 <= arr[i] <= 10^6
1 <= k <= 100
 */

public class PairSumDivisibleByK {
    public static long countKdivPairs(int arr[], int n, int k) {
        // // Approach - 1:- BruteForce Approach :-
        // int cnt=0;
        // for(int i=0;i<A.length;i++){
        //     for(int j=i+1;j<A.length;j++){
        //         if((A[i]%B + A[j]%B)%B==0) cnt++;
        //     }
        // }

        // Approach - 2 :-
        long ans=0;
        // Creating frequency array:-
        long[] freq = new long[k];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]%k]++;
        }

        for(int i=0;i<=k/2;i++){
            if(i==k-i || i==0) ans+= freq[i]*(freq[i]-1)/2;
            else ans += freq[i]*freq[k-i];
        }
        return (long)ans;
    }
}
