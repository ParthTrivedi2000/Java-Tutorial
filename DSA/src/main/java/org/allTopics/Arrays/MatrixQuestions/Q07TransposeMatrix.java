package org.allTopics.Arrays.MatrixQuestions;

// Problem Link :- https://leetcode.com/problems/transpose-matrix/description/


/*
Problem Description :-
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:
Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 10^5
-10^9 <= matrix[i][j] <= 10^9
 */

public class Q07TransposeMatrix {
    public int[][] transpose(int[][] matrix) {

        // Approach - 1:- Using Another array. (Not In Place):- TC:- O(N^2), SC:-O(N^2)
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] ans = new int[cols][rows];
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;

        // Approach - 2:- In Place. T.C:- O(N^2), SC:- O(1) :- This approach is not
        // working for rectangular matrice. it's only working for suqare matrices.
        // Hint :- Swapping.
        // Note/ Edge Case :- start jth column's swapping from i+1 not 0 else swapped
        // element will be swapped again.
        // int rows = matrix.length;
        // int cols = matrix[0].length;
        // int temp = 0;
        // for(int i=0;i<rows;i++){
        //     for(int j=i+1;j<cols;j++){
        //         temp = matrix[i][j];
        //         matrix[i][j] = matrix[j][i];
        //         matrix[j][i] = temp;
        //     }
        // }
        // return matrix;

    }
}
