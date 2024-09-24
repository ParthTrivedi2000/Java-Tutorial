package org.allTopics.Hashing;

// Problem Link :- https://www.geeksforgeeks.org/problems/first-repeating-element4018/1

/*
Given an integer array A of size N, find the first repeating element in it.
We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
If there is no repeating element, return -1.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9

Input Format
The first and only argument is an integer array A of size N.
Output Format
Return an integer denoting the first repeating element.

Example Input
Input 1:
 A = [10, 5, 3, 4, 3, 5, 6]
Input 2:
 A = [6, 10, 5, 4, 9, 120]
Example Output
Output 1:
 5
Output 2:
 -1

Example Explanation
Explanation 1:
 5 is the first element that repeats
Explanation 2:
 There is no repeating element, output -1
 */

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {
    public int solve(int[] A) {
        Map<Integer,Integer> frequency = new HashMap<>();
        for(int elem:A){
            if(frequency.containsKey(elem)) frequency.put(elem, frequency.get(elem)+1);
            else frequency.put(elem,1);
        }

        // for finding non repeating number.
        for(int elem:A){
            if(frequency.get(elem)>1) return elem;
        }
        return -1;
    }
}

/*
// Another very good and optimised solution:-

// public class Solution {
//     public int solve(ArrayList<Integer> A) {
//         HashMap<Integer, Integer> vis = new HashMap<Integer, Integer>();
//         int ans = -1;
//         for(int i = A.size()-1; i >= 0; --i){
//             if(vis.containsKey(A.get(i))){
//                 ans = A.get(i);
//             }
//             else{
//                 vis.put(A.get(i), 1);
//             }
//         }
//         return ans;
//     }
// }
 */
