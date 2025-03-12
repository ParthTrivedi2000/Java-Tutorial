package org.allTopics.Arrays.MatrixQuestions;

public class Q01RowWiseSum {
    public int[] solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[] ans = new int[cols];
        for(int i=0;i<rows;i++){
            int sum = 0;
            for(int j=0;j<cols;j++){
                sum = sum + A[i][j];
            }
            ans[i] = sum;
        }
        return ans;
    }
}
