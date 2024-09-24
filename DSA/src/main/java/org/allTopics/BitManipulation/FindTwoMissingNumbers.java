package org.allTopics.BitManipulation;

// Problem Link :-

/*
Problem Description :-
Given an array A of length N where all the elements are distinct and are in the range [1, N+2].
Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= N+2

The elements of array A are distinct

Input Format
Only argument A is an array of integers

Output Format
Return a sorted array of size 2 denoting the missing elements.

Example Input
Input 1:
A = [3, 2, 4]
Input 2:
A = [5, 1, 3, 6]

Example Output
Output 1:
[1, 5]
Output 2:
[2, 4]

Example Explanation
For Input 1:
The missing numbers are 1 and 5.
For Input 2:
The missing numbers are 2 and 4.
 */

public class FindTwoMissingNumbers {
    public int[] findTwoMissingNumbers(int[] A) {
        int n = A.length;
        int xor = 0;
        for(int elem:A) xor=xor^elem;
        // performing xor with elems of A till n+2.
        for(int i=1;i<=n+2;i++) xor=xor^i;

        // now we need to find the RSB.
        int xor1 = ~(xor) + 1;
        int RSB = xor&xor1;

        // Why we have used the another loop as well to segregate the 2 numbers are given below.
        /*
        However, there's a small detail we're missing in the final step. Let's break it down:
        Your understanding of XOR is correct. After XORing all elements in A and all numbers from 1 to N+2, the result
        (stored in 'xor') will indeed contain only the XOR of the two missing numbers.
        The RSB (Rightmost Set Bit) calculation is correct and will help us separate the two missing numbers.
        The final step where we separate the numbers is close, but not quite complete. We need to consider the elements
        of A as well. Here's why:
        We need to XOR all numbers from 1 to N+2 AND all elements in A with either num1 or num2 based on their RSB.
        This ensures that all numbers except the two missing ones will be XORed twice (cancelling out), leaving only
        the missing numbers.
         */

        int num1 = 0;
        int num2 = 0;
        for(int i=1;i<=n+2;i++){
            if((i&RSB)==0) num1=num1^i;
            else num2=num2^i;
        }
        for(int elem:A){
            if((elem&RSB)==0) num1=num1^elem;
            else num2=num2^elem;
        }
        int ans[] = new int[2];
        ans[0] = Math.min(num1,num2);
        ans[1] = Math.max(num1,num2);
        return ans;
    }
}
