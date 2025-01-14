package org.allTopics.Maths;

// Problem Link :- https://www.geeksforgeeks.org/find-sum-of-aiaj-for-all-valid-pairs/

/*
Problem Description:-
Given an array arr[] of size N. The task is to find the sum of arr[i] % arr[j] for all valid pairs. Answer can be
large. So, output answer modulo 1000000007
Examples:
Input: arr[] = {1, 2, 3}
Output: 5
(1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2)
+ (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5
Input: arr[] = {1, 2, 4, 4, 4}
Output: 10

 */

public class ModSum {

    // Approach - 1:- BruteForce Approach:-
    public int Sum_Modulo(int A[], int n) {

        // Approach - BruteForce :- Use 2 Loops:- TC:-O(N^2), SC:-O(1)
        /*
        long sum = 0;
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.size();j++){
                sum+=A.get(i)%A.get(j);
            }
        }
        return (int)(sum % 1000000007);

         */


        // Approach - 2:- Use the freq array to reduce the no of operations.
        long sum = 0;
        long ans=0;
        int mod = 1000000007;

        int freq[] = new int[1001];// bec constraint is given like max size of any element of the array can be 1000 only.

        for(int elem: A){
            freq[elem]++;
        }

        for(int i=1; i<=1000; i++){
            for(int j=1;j<=1000;j++){
                sum=(i%j)*freq[i]*freq[j];
                ans+=sum;
            }
        }
        return (int)(ans%mod);
    }
}
