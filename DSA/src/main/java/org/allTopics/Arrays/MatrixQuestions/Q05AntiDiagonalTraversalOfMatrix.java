package org.allTopics.Arrays.MatrixQuestions;

// Problem Link :- https://www.geeksforgeeks.org/problems/print-diagonally1623/0

/*
Problem Description:-
Give a N*N square matrix, return an array of its anti-diagonals in top-leftmost to bottom-rightmost order. In
an element of a anti-diagonal (i, j), surrounding elements will be (i+1, j-1) and (i-1, j+1). Look at the
examples for more clarity.

Example 1:
Input:
N = 2
matrix[][] = 1 2
            3 4
Output:
1 2 3 4
Explanation:
List of anti-diagnoals in order is
{1}, {2, 3}, {4}
Example 2:
Input:
N = 3
matrix[][] = 3 2 3
            4 5 1
            7 8 9
Output:
3 2 4 3 5 7 1 8 9
Explanation:
List of anti-diagnoals in order is
{3}, {2, 4}, {3, 5, 7}, {1, 8}, {9}
Your Task:
You dont need to read input or print anything. Complete the function antiDiagonalPattern() that takes matrix
as input parameter and returns a list of integers in order of the values visited in the anti-Diagonal pattern.

Expected Time Complexity: O(N * N)
Expected Auxiliary Space: O(N * N)

Constraints:
1 <= N <= 100
0 <= mat[i][j] <= 100
 */

public class Q05AntiDiagonalTraversalOfMatrix {
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        // Code here
        int rows=matrix.length;
        int cols = matrix[0].length;
        // int[] ans = new int[2 * matrix.length-1][matrix.length];
        int[] ans = new int[matrix.length*matrix.length];
        int idx=0;

        // only moving on all elems of Top row. hence keeping i=0;
        for(int k=0;k<cols;k++){
            int i=0,j=k;
            while(i<rows && j>=0){
                // System.out.println("i: "+i+ " and j: "+j + " and index: " + idx+ " elem: "+matrix[i][j]);
                ans[idx]=matrix[i][j];
                i++;
                j--;
                idx++;
            }
        }

        // only moving on all elems of Last Column. hence keeping j=cols-1;
        for(int k=1;k<rows;k++){
            int i=k,j=cols-1;
            while(i<rows && j>=0){
                // System.out.println("i: "+i+ " and j: "+j+ " and index: " + idx+ " elem: "+matrix[i][j]);
                ans[idx]=matrix[i][j];
                i++;
                j--;
                idx++;
            }
        }
        return ans;
    }
}
