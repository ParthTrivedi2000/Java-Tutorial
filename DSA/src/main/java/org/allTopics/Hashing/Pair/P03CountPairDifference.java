package org.allTopics.Hashing.Pair;

// Problem Statement:- https://www.scaler.com/academy/mentee-dashboard/class/215248/assignment/problems/27741?navref=cl_tt_lst_nm

/*
Problem Description:-

You are given an array A of N integers and an integer B.
Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
First argument A is an array of integers and second argument B is an integer.

Output Format
Return an integer.

Example Input
Input 1:
A = [3, 5, 1, 2]
B = 4
Input 2:
A = [1, 2, 1, 2]
B = 1

Example Output
Output 1:
1
Output 2:
4

Example Explanation
Example 1:
The only pair is (2, 3) which gives difference as 4
Example 2:
The pair which gives difference as 3 are (2, 1), (4, 1), (2, 3) and (4, 3).
 */

import java.util.HashMap;
import java.util.Map;

public class P03CountPairDifference {
    public int solve(int[] A, int B) {

        // // BruteForce :- TC:-O(N^2)  SC:-O(N)
        // int cnt=0;
        // for(int i=0;i<A.length;i++){
        //     for(int j=i+1;j<A.length;j++){
        //         if(A[i]-A[j]==B || A[j]-A[i]==B) cnt++;
        //     }
        // }
        // return cnt;


        //  Aprpoach - 2:- Use HashMap TC:-O(N), SC:-O(N)
        int mod=(int)Math.pow(10,9) + 7;
        Map<Integer,Integer> mp = new HashMap<>();
        int target=0;
        int count=0;

        for(int i=0;i<A.length;i++){
            target = A[i]+B;
            if(mp.containsKey(target)){
                count+=mp.get(target);
            }
            target = A[i]-B;
            if(mp.containsKey(target)){
                count+=mp.get(target);
            }
            if(mp.containsKey(A[i])) mp.put(A[i],mp.get(A[i])+1);
            else mp.put(A[i],1);
        }
        return count%mod;


        // // Another way of writing code in concise manner :-
        // Map<Integer,Integer> mp = new HashMap<>();
        // int cnt=0;
        // for(int i=0;i<A.length;i++){
        //     if(mp.containsKey(A[i]-B)) cnt+=mp.get(A[i]-B);
        //     if(mp.containsKey(A[i]+B)) cnt+=mp.get(A[i]+B);
        //     mp.put(A[i],mp.getOrDefault(A[i],0)+1);
        // }
        // return cnt;

    }
}
