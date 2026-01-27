package org.allTopics.Arrays;

// Link :- https://www.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1

// Problem Description :-
/*
Given an array arr[] of distinct integers of size n and a value sum, the task is to find the count of triplets (i, j, k),
having (i<j<k) with the sum of (arr[i] + arr[j] + arr[k]) smaller than the given value sum.

Examples :

Input: n = 4, sum = 2, arr[] = {-2, 0, 1, 3}
Output:  2
Explanation: Below are triplets with sum less than 2 (-2, 0, 1) and (-2, 0, 3).

Input: n = 5, sum = 12, arr[] = {5, 1, 3, 4, 7}
Output: 4
Explanation: Below are triplets with sum less than 12 (1, 3, 4), (1, 3, 5), (1, 3, 7) and (1, 4, 5).

Expected Time Complexity: O(N^2).
Expected Auxiliary Space: O(1).


Constraints:
3 ≤ N ≤ 10^3
-10^3 ≤ arr[i] ≤ 10^3

Company Tags :
AmazonSAP Labs
 */

import java.util.Arrays;

public class ThreeSumWithSmallerSum {
    long countTriplets(int n, int sum, long arr[]) {

        // Bruteforce:-
        /*
        long cnt=0;
        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    long mySum = arr[i] + arr[j] + arr[k];
                    if(mySum<sum) cnt++;
                }
            }
        }
        return cnt;
        */

        // Optimised :-
        Arrays.sort(arr);
        long cnt=0;
        for(int i=0;i<arr.length-2;i++){
            int j=i+1;
            int k=arr.length-1;
            while(j<k){
                long mySum=arr[i]+arr[j]+arr[k];
                if(mySum<sum){
                    cnt=cnt+(k-j);
                    j++;
                }
                else k--;
            }
        }
        return cnt;
    }
}
