package org.allTopics.Hashing;

// Problem Link :-

/*
Problem Description:-
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements
in both the array.
NOTE:
Each element in the result should appear as many times as it appears in both arrays. The result can be in any order.

Problem Constraints
1 <= N, M <= 10^5
1 <= A[i] <= 10^9

Input Format
First argument is an integer array A of size N.
Second argument is an integer array B of size M.

Output Format
Return an integer array denoting the common elements.

Example Input
Input 1:
 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:
 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]

Example Output
Output 1:
 [1, 2, 2]
Output 2:
 [2, 10]

Example Explanation
Explanation 1:
 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:
 Elements (2, 10) appears in both the array.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class H03CommonElements {
    public int[] solve(int[] A, int[] B) {
        /*
        // Approach - 1:- Using 2 seperate map and then adding the common elems to the ans list.
        Map<Integer,Integer> newA = new HashMap<>();
        for(int elem:A){
            if(newA.containsKey(elem)){
                newA.put(elem,newA.get(elem)+1);
            }
            else{
                newA.put(elem,1);
            }
        }

        Map<Integer,Integer> newB = new HashMap<>();
        for(int elem:B){
            if(newB.containsKey(elem)){
                newB.put(elem,newB.get(elem)+1);
            }
            else{
                newB.put(elem,1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int elem: newA.keySet()){
            while(newB.containsKey(elem) && newB.get(elem)!=0 && newA.get(elem)!=0){
                ans.add(elem);
                newB.put(elem,newB.get(elem)-1);
                newA.put(elem,newA.get(elem)-1);
            }
        }
        return ans;

         */


        // Approach - 2:-
        Map<Integer,Integer> mp = new HashMap<>();
        for(int elem:A) mp.put(elem,mp.getOrDefault(elem,0)+1);

        ArrayList<Integer> ans = new ArrayList<>();
        for(int elem:B){
            if(mp.containsKey(elem)){
                ans.add(elem);
                mp.put(elem,mp.get(elem)-1);
                if(mp.get(elem)==0) mp.remove(elem);
            }
        }
        // Found best way to convert ArrayList --> int[] arr.
        // Converting integer of arrayList to int[] arr.
        int[] n = new int[ans.size()];
        Arrays.setAll(n, ans::get);
        return n;
    }
}
