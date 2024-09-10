package org.allTopics.Graph.RottenOranges;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args){
        int[][] grid1 = {
                {1,0,1,2,1},
                {1,1,1,1,1},
                {0,2,0,1,0},
                {0,1,1,1,1},
                {1,1,1,2,1}
        };
        System.out.println(rottingOranges(grid1));

        int[][] grid2 = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(rottingOranges(grid2));

        int[][] grid3 = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
        System.out.println(rottingOranges(grid3));

        int[][] grid4 = {
                {0,2}
        };
        System.out.println(rottingOranges(grid4));

        int[][] grid5 = {
                {0,1,2}
        };
        System.out.println(rottingOranges(grid5));

        int[][] grid6 = {
                {2,2,0},
                {0,2,2},
                {1,0,2}
        };
        System.out.println(rottingOranges(grid6));

        int[][] grid7 = {
                {0,1,0,1}
        };
        System.out.println(rottingOranges(grid7));

        int[][] grid8 = {
                {0,0}
        };
        System.out.println(rottingOranges(grid8));
    }

    public static int rottingOranges(int[][]grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        initialiseQueue(grid,q,n,m);
        int time=0;
        while(!q.isEmpty()){
            int qSize=q.size();
            while(qSize>0){
                Pair curr = q.poll();
                int i = curr.x;
                int j = curr.y;
                int[] rows = {-1,0,1,0};
                int[] cols = {0,1,0,-1};
                for(int k=0;k<4;k++){
                    int childI = i+rows[k];
                    int childJ = j+cols[k];
                    if(childI>=0 && childI<n && childJ>=0 && childJ<m && grid[childI][childJ]==1){
                        q.add(new Pair(childI,childJ));
                        grid[childI][childJ] = 2;
                    }
                }
                qSize--;
            }
            time++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return time==0 ? time : time-1;
    }

    private static void initialiseQueue(int[][] grid, Queue<Pair> q, int n, int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) q.add(new Pair(i,j));
            }
        }
    }
}
