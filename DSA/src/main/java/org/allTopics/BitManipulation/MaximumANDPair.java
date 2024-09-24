package org.allTopics.BitManipulation;

// Problem Link :- https://www.geeksforgeeks.org/problems/maximum-and-value-1587115620/1

// Please go through below solution for good understanding. Suggesting must go through it once for proper understanding
// and make solution clear.
// Link:- https://www.geeksforgeeks.org/maximum-value-pair-array/

/*
Problem Description:-
Given an array arr[] of N positive elements. The task is to find the Maximum AND Value generated by any
pair(arri, arrj) from the array such that i != j.
Note: AND is bitwise '&' operator.

Example 1:
Input:
N = 4
arr[] = {4, 8, 12, 16}
Output: 8
Explanation:
Pair (8,12) has the Maximum AND Value 8.
Example 2:
Input:
N = 4
arr[] = {4, 8, 16, 2}
Output: 0
Explanation: Any two pairs of the array has
Maximum AND Value 0.

Expected Time Complexity: O(N * log M), where M is the maximum element of the array.
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 10^5
1 <= arr[i] <= 10^5

 */

public class MaximumANDPair {
    public static int maxAND (int arr[], int N) {
        // Approach - 1:- Bruteforce Appraoch:-
        /*
         // Use 2 loops to perform the ANDing operation between i and j.
         int max=0;
         for(int i=0;i<arr.length;i++){
             for(int j=i+1;j<arr.length;j++){
                 max = Math.max(max, (arr[i]&arr[j]));
             }
         }
         return max;

         */


        // Approach - 2:-
        // for each bits I have to find the count of number of set bits from all the elems. bec it's but obvious like
        // to make any number max, my MSB should be 1 or means starting from MSB to LSB we wants ki higher
        // order of bits makes contribution so my ans becomes maximum. so that is the whole idea like
        // for each bit iteration, I can count the number of bits for all the elems, and if it is greater than 2 i.e.
        // I can use it for my AND operation bec we need atleast 2 or more elems to get value > 0 (bec 1&0=0, 0&1=0 but
        //2 1's means 1&1=1).
        int ans=0;
        for(int i=31;i>=0;i--){
            int cnt=0;
            for(int elem:arr){
                if((elem&(1<<i))!=0) cnt++;
            }

            if(cnt>=2){
                ans=ans|(1<<i);
                // below loop we are writing to neglect the particular element which is having 0 at the current position
                // means just open the class notes and check it, after each bit consideration for all the elems,
                // we are neglecting 1 or more elems from considerations from next bit onwards. So that we were doing
                // on the paper for the understanding, but how to do it in code. so to neglect that particular elem,
                // simply we can put 0 for those elems. So that from next bit onwards it won't considered for the
                // bits calculation.
                for(int j=0;j<arr.length;j++){
                    if((arr[j]&(1<<i))==0) arr[j]=0;
                }
            }
            // ans=ans|(1<<i);
        }
        return ans;
    }
}
