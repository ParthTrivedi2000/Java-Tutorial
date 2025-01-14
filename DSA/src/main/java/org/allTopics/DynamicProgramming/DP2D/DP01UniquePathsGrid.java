package org.allTopics.DynamicProgramming.DP2D;

// Problem Link :- https://leetcode.com/problems/unique-paths/description/

/*
Problem Description :-
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot
tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at
any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28
Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Constraints:
1 <= m, n <= 100
 */

public class DP01UniquePathsGrid {
    public int uniquePaths(int m, int n) {
        // // Approach - 1:- Recursive Approach
        // return rec(m-1,n-1);

        // // Approach - 2:- Memoized Approach:-
        // int[][] ways = new int[m][n];
        // for(int[] arr:ways) Arrays.fill(arr,-1);
        // return memo(m-1,n-1,ways);

        // // Approach - 3:- Tabulation Approach
        // int[][] ways = new int[m][n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(i==0||j==0) ways[i][j]=1;
        //         else ways[i][j] = ways[i-1][j] + ways[i][j-1];
        //     }
        // }
        // return ways[m-1][n-1];

        // // Approach - 4:- Optimised Space Complexity Approach
        // // TC:- O(M*N), SC:- O(N);
        // int ways[] = new int[n];
        // ways[0] = 1;
        // for(int i=0;i<m;i++){
        //     for(int j=1;j<n;j++){
        //         ways[j] = ways[j]+ways[j-1];
        //     }
        // }
        // return ways[n-1];


        // Approach - 5:- Using Combinatorics:- Further Optimised TC.
        // Counting the number of paths in an MxN matrix is a classic problem that can
        // be efficiently solved using combinatorics. This approach provides a concise
        // and optimized solution, ensuring the result is within the desired modulo
        // constraint. With a time complexity of O(M) and constant space usage, it's a
        // powerful tool for solving a wide range of grid path problems.
        // TC:- O(M), SC:- O(1)

        return (int)nCr(m + n - 2, m - 1, 1000000007);
    }

    public long nCr(long n, long r, long mod){
        if(r>n-r) r=n-r;
        long res = 1;
        for(int i=0;i<r;i++){
            res = res*(n-i)%mod;
            res=res*modInverse(i+1,mod)%mod;
        }
        return res;
    }

    public long modInverse(long a, long m){
        long mo=m;
        long y=0;
        long x=1;
        if(m==1) return 0;
        while(a>1){
            long q = a/m;
            long t = m;
            m=a%m;
            a=t;
            t=y;
            y=x-q*y;
            x=t;
        }
        if(x<0) x+=mo;
        return x;
    }

    public int rec(int i, int j){
        if(i==0||j==0) return 1;
        return rec(i-1,j)+rec(i,j-1);
    }

    public int memo(int i,int j, int[][]ways){
        if(i==0||j==0){
            ways[i][j]=1;
            return 1;
        }
        if(ways[i][j]!=-1) return ways[i][j];
        ways[i][j] =  memo(i-1,j,ways)+memo(i,j-1,ways);
        return ways[i][j];
    }
}
