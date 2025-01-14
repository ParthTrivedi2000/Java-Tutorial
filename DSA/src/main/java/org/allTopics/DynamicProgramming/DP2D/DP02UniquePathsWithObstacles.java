package org.allTopics.DynamicProgramming.DP2D;

// Problem Link :- https://leetcode.com/problems/unique-paths-ii/description/

/*
Problem Description :-
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or
right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square
that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1

Constraints:
m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
 */

public class DP02UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // // Approach - 1:- Recursive Approach
        // return rec(m-1,n-1,obstacleGrid);

        // Approach - 2:- Memoized Approach:-
        // I was not able to write correct memoized approach. In free time, need to write it.

        // Approach - 3:- Tabulation Approach
        int[][] ways = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    ways[i][j] = obstacleGrid[i][j]==1?0:1;
                    continue;
                }
                else if(obstacleGrid[i][j]==1){
                    ways[i][j] = 0;
                    continue;
                }

                else if(i==0) ways[i][j]=ways[i][j-1];
                else if(j==0) ways[i][j]=ways[i-1][j];
                else ways[i][j] = ways[i-1][j] + ways[i][j-1];
            }
        }
        return ways[m-1][n-1];
    }

    public int rec(int i, int j, int[][] obstacleGrid){
        if(i==0&&j==0) return obstacleGrid[i][j]==1?0:1;
        if(obstacleGrid[i][j]==1) return 0;
        if(i==0) return rec(i,j-1,obstacleGrid);
        if(j==0) return rec(i-1,j,obstacleGrid);
        return rec(i-1,j,obstacleGrid)+rec(i,j-1,obstacleGrid);
    }
}
