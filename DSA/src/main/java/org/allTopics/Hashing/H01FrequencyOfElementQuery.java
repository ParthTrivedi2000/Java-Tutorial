package org.allTopics.Hashing;

// Problem link:-

/*
Problem Description:-
Given an array A. You have some integers given in the array B.
For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.

Problem Constraints
1 <= |A| <= 10^5
1 <= |B| <= 10^5
1 <= A[i] <= 10^5
1 <= B[i] <= 10^5

Input Format
First argument A is an array of integers.
Second argument B is an array of integers denoting the queries.

Output Format
Return an array of integers containing frequency of the each element in B.

Example Input
Input 1:
A = [1, 2, 1, 1]
B = [1, 2]
Input 2:
A = [2, 5, 9, 2, 8]
B = [3, 2]

Example Output
Output 1:
[3, 1]
Output 2:
[0, 2]

Example Explanation
For Input 1:
The frequency of 1 in the array A is 3.
The frequency of 2 in the array A is 1.
For Input 2:
The frequency of 3 in the array A is 0.
The frequency of 2 in the array A is 2.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class H01FrequencyOfElementQuery {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
         /*
         // BruteForce Approach:-
         // TC:- O(Q*N); SC:- O(1)
         int cnt=0;
         int[] ans = new int[query.length];
         for(int q =0;q<query.length;q++){
             cnt=0;
             for(int i=0;i<arr.length;i++){
                 if(arr[i]==query[q]) cnt++;
             }
             ans[i] = cnt;
         }
         return ans;

          */

        // Better Approach:- is to use the map to store the element and it's corresponding freq in map as a key value pair.
        // TC:-O(Q+N), SC:-O(N)
        // Storing elem and freq in the map
        Map<Integer,Integer> mp = new HashMap<>();
        for(int elem:A){
            if(mp.containsKey(elem)){
                mp.put(elem,mp.get(elem)+1);
            }
            else{
                mp.put(elem,1);
            }
        }

        // traversing the query array and finding freq from the map.
        ArrayList<Integer> ans = new ArrayList<>();
        for(int elem:B){
            if(mp.containsKey(elem)) ans.add(mp.get(elem));
            else ans.add(0);
        }
        return ans;
    }
}
