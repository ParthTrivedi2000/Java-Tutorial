package org.allTopics.Arrays.MatrixQuestions;

import java.util.ArrayList;

public class Q03DiagonalFromLtoR {
    public ArrayList<Integer> solve(final int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<rows;i++){
            ans.add(A[i][i]);
        }
        return ans;
    }
}
