package org.allTopics.Arrays.MatrixQuestions;

// Problem Link :- https://leetcode.com/problems/diagonal-traverse/description/

/*
Problem Description :-
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
(As shown in the image)
Example 1:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
Example 2:
Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]

Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 10^4
1 <= m * n <= 10^4
-10^5 <= mat[i][j] <= 10^5
 */

import java.util.ArrayList;
import java.util.Collections;

public class Q06DiagonalCyclicTraverse {
    public int[] findDiagonalOrder(int[][] mat) {

        int rows=mat.length;
        int cols = mat[0].length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // only moving on all elems of Top row. hence keeping i=0;
        for(int k=0;k<cols;k++){
            int i=0,j=k;
            ArrayList<Integer> temp = new ArrayList<>();
            while(i<rows && j>=0){
                temp.add(mat[i][j]);
                i++;
                j--;
            }
            ans.add(temp);
        }

        // only moving on all elems of Last Column. hence keeping j=cols-1;
        for(int k=1;k<rows;k++){
            int i=k,j=cols-1;
            ArrayList<Integer> temp = new ArrayList<>();
            while(i<rows && j>=0){
                temp.add(mat[i][j]);
                i++;
                j--;
            }
            ans.add(temp);
        }

        for(int i=0;i<ans.size();i++){
            if(i%2==0){
                ArrayList<Integer> temp = ans.get(i);
                Collections.reverse(temp);
                ans.set(i,temp);
            }
        }

        int[] finalAns = new int[rows*cols];
        int idx=0;
        for(int i=0;i<ans.size();i++){
            for(int j=0;j<ans.get(i).size();j++){
                finalAns[idx] = ans.get(i).get(j);
                idx++;
            }
        }
        return finalAns;
    }
}
