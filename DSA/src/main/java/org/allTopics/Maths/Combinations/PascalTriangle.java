package org.allTopics.Maths.Combinations;

/*
Problem Description:-
Write a program to print the pascal triangle up to A rows.

Problem Constraints
1 <= A <= 25

Input Format
The first argument is an integer A.

Output Format
Return a 2D array consisting of A rows whose each row contains A integers.

Example Input
Input 1:
A = 3
Input 2:
A = 5

Example Output
Output 1:
1 0 0
1 1 0
1 2 1
Output 2:
1 0 0 0 0
1 1 0 0 0
1 2 1 0 0
1 3 3 1 0
1 4 6 4 1


Example Explanation
Explanation 1:
Row 1 = 1 0 0
Row 2 = 1C0 1C1 0 = 1 1 0
Row 3 = 2C0 2C1 2C2 = 1 2 1

 */

public class PascalTriangle {

    public int[][] solve(int A) {

        int[][] res = new int[A][A];
        res[0][0] = 1;
        for (int i = 1; i < A; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) res[i][j] = 1;
                else{
                    res[i][j] = res[i-1][j] + res[i-1][j-1];
                }
            }
        }
        return res;
    }
}
