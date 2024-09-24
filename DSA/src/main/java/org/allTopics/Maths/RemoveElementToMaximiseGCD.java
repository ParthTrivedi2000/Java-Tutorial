package org.allTopics.Maths;

// Problem Link :- https://www.geeksforgeeks.org/remove-an-element-to-maximize-the-gcd-of-the-given-array/

/*
Problem Description:-
Given an array arr[] of length N ≥ 2. The task is to remove an element from the given array such that the GCD of the
array after removing it is maximized.

Examples:
Input: arr[] = {12, 15, 18}
Output: 6
Remove 12: GCD(15, 18) = 3
Remove 15: GCD(12, 18) = 6
Remove 18: GCD(12, 15) = 3

Input: arr[] = {14, 17, 28, 70}
Output: 14

 */

public class RemoveElementToMaximiseGCD {


    public int MaxGCD(int[] A, int n) {

        // Approach - 1:- BruteForce:- Use 2 loops
        /*
        int ans = 0;
        // Try removing each element and calculate GCD of the remaining array
        for (int i = 0; i < n; i++) {
            // Create a temporary array to hold the elements of the original array except for the one at index i
            int[] temp = new int[n - 1];
            int k = 0;
            for (int j = 0; j < n; j++) {
                // Skip the element at index i while copying elements to the temporary array
                if (j != i) {
                    temp[k++] = a[j];
                }
            }

            // Calculate the GCD of the elements in the temporary array
            int res = temp[0];
            for (int j = 1; j < n - 1; j++) {
                res = gcdFunc(res, temp[j]);
            }

            // Update the maximum GCD found so far
            ans = Math.max(ans, res);
        }

        // Return the maximum GCD of all subarrays obtained by removing one element at a time
        return ans;

         */


        // Approach - 2:- Using Prefix concept
        //  I can use the prefix & suffix concept to precalculate the GCD of the element except itself.
        int[] pf = new int[A.length];
        int[] sf = new int[A.length];

        pf[0] =  A[0];
        for(int i=1;i<A.length;i++){
            pf[i] = gcdFunc(pf[i-1],A[i]);
        }

        sf[A.length-1] = A[A.length-1];
        for(int i=A.length-2;i>=0;i--){
            sf[i] = gcdFunc(sf[i+1],A[i]);
        }

        int max = 0;
        int gcd = 0;
        int left=0;
        int right=0;
        for(int i=0;i<A.length;i++){
            // Handling edge case for PF,SF
            if(i==0){
                left = 0;
                right = sf[1];
                gcd = gcdFunc(left,right);
            }
            // Handling edge case for PF,SF
            else if(i==A.length-1){
                left = pf[A.length-2];
                right = 0;
                gcd = gcdFunc(left,right);
            }
            // General Case
            else{
                left = pf[i-1];
                right = sf[i+1];
                gcd = gcdFunc(left,right);
            }
            max = Math.max(max,gcd);
        }
        return max;
    }

    private int gcdFunc(int A, int B){
        if(A==0) return B;
        return gcdFunc(B%A,A);
    }

}
