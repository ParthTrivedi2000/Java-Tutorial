package org.allTopics.Arrays.MatrixQuestions;

import java.util.ArrayList;

public class Q04DiagonalFromRtoL {
    public ArrayList<Integer> solve(final int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0;
        int j=cols-1;
        while(i<rows){
            ans.add(A[i][j]);
            i++;
            j--;
        }
        return ans;
    }
}
