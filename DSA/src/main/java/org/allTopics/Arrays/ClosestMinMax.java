package org.allTopics.Arrays;


/*
Problem Description:-

Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the
maximum value of the array
and at least one occurrence of the minimum value of the array.

Problem Constraints
1 <= |A| <= 2000

Input Format
First and only argument is vector A

Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array

Example Input
Input 1:
A = [1, 3, 2]
Input 2:
A = [2, 6, 1, 6, 9]

Example Output
Output 1:
 2
Output 2:
 3

Example Explanation
Explanation 1:
 Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
Explanation 2:
 Take the last 3 elements of the array.
 */

public class ClosestMinMax {
    public int solve(int[] A) {
        int max = A[0];
        int min = A[0];
        int max_index = -1;
        int min_index = -1;
        int result = A.length;
        for(int i=0;i<A.length;i++){
            if(A[i]>max){
                max = A[i];
                max_index = 0;
                result = A.length;
            }
            if(A[i]<min){
                min = A[i];
                min_index = 0;
                result = A.length;
            }

            if(A[i]==max){
                max_index = i;
            }
            if(A[i]==min){
                min_index = i;
            }
            result = Math.min(result,Math.abs(max_index-min_index)+1);
        }
        return result;

        /*
         find max and find min.
         2 things we have observed:- one thing is, both max and min should be at the corner to have the smallest length.
         another thing is there should not be duplicated max and/or min in subarray.

          // BruteForce:- O(N^3)
         for(int i=0;i<A.length;i++){
             if(A[i]>maxi) maxi=A[i];
             if(A[i]>mini) mini = A[i];
         }
         for(int i=0;i<A.length;i++){
             for(int j=i;j<A.length;j++){
                 for(int k=i;k<j;k++){
                     if(A[k]==maxi) oneIndex=k;
                     else if(A[k]==mini) secondIndex=k;
                 }
              len = Math.min(len,Math.abs(oneIndex-secondIndex));
             }
         }
         return len;
         */

        /*
         // Optimised:- TC:- O(2N), SC:- O(1)
         int min_ele = Integer.MAX_VALUE, max_ele = Integer.MIN_VALUE;
         int min_Index = -1, max_Index = -1;
         int ans = Integer.MAX_VALUE;
         for(int x:A){
             min_ele = Math.min(min_ele, x);
             max_ele = Math.max(max_ele, x);
         }

         for(int i=0 ; i<A.length ; i++){
             if(A[i] == min_ele) min_Index = Math.max(min_Index, i);
             if(A[i] == max_ele) max_Index = Math.max(max_Index, i);

             if(min_Index != -1 && max_Index != -1){
                 int len = Math.abs(max_Index - min_Index) + 1;
                 ans = Math.min(ans, len);
             }
         }
         return ans;
         */

        /*
         // Optimised and Best Solution:- TC:- O(N) only in single traversal as max and min can be found in the same for loop so.
         //                               SC:- O(1)
         int max = A[0];
         int min = A[0];
         int max_index = -1;
         int min_index = -1;
         int result = A.length;
         for(int i=0;i<A.length;i++){
             if(A[i]>max){
                 max = A[i];
                 max_index = 0;          // here I didn't understood like why he assigned max_index=0? and same que for min_index?
                 result = A.length;
             }
             if(A[i]<min){
                 min = A[i];
                 min_index = 0;
                 result = A.length;
             }

             if(A[i]==max){
                 max_index = i;
             }
             if(A[i]==min){
                 min_index = i;
             }
             result = Math.min(result,Math.abs(max_index-min_index)+1);
         }
         return result;
         */
    }
}

// For Better understanding, please go through below Solution :-
// https://www.geeksforgeeks.org/smallest-subarray-containing-minimum-and-maximum-values/
