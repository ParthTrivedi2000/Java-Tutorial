package org.allTopics.Graph;

// Problem Link :- https://leetcode.com/problems/number-of-islands/

/*
Problem Description :-
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

 */

// TC:- O(N*M)  SC:- O(N*M)
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false && grid[i][j]=='1'){
                    DFS(grid,i,j,visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void DFS(char[][] graph, int i, int j, boolean[][]visited){
        visited[i][j] = true;
        int[] rows = {-1,0,1,0};
        int[] cols = {0,1,0,-1};
        for(int k=0;k<4;k++){
            int childI = i + rows[k];
            int childJ = j + cols[k];
            if(childI>=0 && childI<graph.length && childJ>=0 && childJ<graph[0].length
                    && graph[childI][childJ]=='1' && visited[childI][childJ]==false){
                DFS(graph,childI,childJ,visited);
            }
        }
    }


    /* But now Given island definition changed. See below. it was asked to consider all the directions available
    instead of only top, bottom,left,right.

    Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent
    lands horizontally or vertically or diagonally i.e., in all 8 directions.

    So in that case we just need to check for all the 4 diagonals as well. Please use below DFS function for that.
     */

    void DFS1(char[][] graph, int i, int j, boolean[][]visited){
        visited[i][j] = true;
        int[] rows = {-1,0,1,0, -1,1,1,-1}; // {top,right,bottom,left, topRightCorner,bottomRightCorner,bottomLeftCorner,topLeftCorner}
        int[] cols = {0,1,0,-1, 1,1,-1,-1};
        for(int k=0;k<8;k++){
            int childI = i + rows[k];
            int childJ = j + cols[k];
            if(childI>=0 && childI<graph.length && childJ>=0 && childJ<graph[0].length
                    && graph[childI][childJ]=='1' && visited[childI][childJ]==false){
                DFS1(graph,childI,childJ,visited);
            }
        }
    }

}
