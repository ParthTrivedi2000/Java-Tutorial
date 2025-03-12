package org.allTopics.Arrays.MatrixQuestions;

public class Q02ColumnWiseSum {
    public int[] solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[] ans = new int[cols];
        for(int j=0;j<cols;j++){
            int sum=0;
            for(int i=0;i<rows;i++){
                sum = sum + A[i][j];
            }
            ans[j] = sum;
        }
        return ans;
    }
}
