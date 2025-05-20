package org.allTopics.BackTracking;

import java.util.ArrayList;

public class BT14RatInAMaze {
    // 1st, just try this 2 questions before moving to the 3rd question.
    // Question - 1 :-
    /*
Q - 1) Means questions is as below. Rat is standing at starting position, and target position is given. Return
true if Rat is able to reach to the target else false.
blocked cell is represented by 0 & allowed cell is represented by 1.
     */

    // Solution :-
    private boolean RatCanReachOrNot(int[][] maze, int startI, int startJ){
        // if cell is out of bound --> return false
        if(startI<0 || startI>=maze.length || startJ<0 || startJ>=maze[0].length) return false;
        // if cell is blocked --> return false, bec that choice/path is blocked there only.
        if(maze[startI][startJ]==0) return false;
        // if rat return till bottom corner --> return true
        if(startI==maze.length-1 && startJ==maze[0].length-1) return true;

        maze[startI][startJ]=-1; // mark as visited in the current ip only by making it -1 so that at last we can make
        // ip again as is by replacing all the -1 values with their values in the function where this rec function calls
        // 1st time

        // now call the recursive function to explore the choices
        return RatCanReachOrNot(maze,startI+1,startJ) || RatCanReachOrNot(maze,startI,startJ+1)
                || RatCanReachOrNot(maze,startI-1,startJ) || RatCanReachOrNot(maze,startI,startJ-1);
    }

    /*
     TC:- O(MN) only not 4^MN bec as soon as we get true in any of the path, we are returning from there since
     rat can reach to end so we are not exploring all the paths here & prooning the unnecessary call by ORing the rec
     calls.
     SC:- rec stack space
     */


    // Question - 2:-
    /*
Q - 2) Rat is standing at starting position in the maze. In the maze there are 3 types of cells.
- cell with value - 0:- blocked
- cell with value - 1 :- empty
- cell with value - 2 :- cheeze
There are multiple cheeze present in the maze.
Return the number of count of paths in which rat can reach to end such that no cheeze left in the maze & rat eat all the
cheeze.
     */

    // Solution :-
    private int RatPathCount(int[][] maze, int startI, int startJ){
        int totalCheeze=0;
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                if(maze[i][j]==2){totalCheeze++;}
            }
        }

        return RatPathCountBacktrack(maze,0,0,maze.length-1,maze[0].length-1, totalCheeze);
    }

    private int RatPathCountBacktrack(int[][] maze, int startI, int startJ, int endI, int endJ, int totalCheeze){
        if(startI<0 || startI>=maze.length || startJ<0 || startJ>=maze[0].length) return 0;
        if(maze[startI][startJ]==0 || maze[startI][startJ]==-1) return 0;
        if(startI==endI && startJ==endJ && totalCheeze==0) return 1;

        //before marking visited, we must have to store it's value to replace it afterwards. simply we can use variable
        // to store value of startI,startJ cell before marking it as visited.
        int temp = maze[startI][startJ];
        maze[startI][startJ]=-1; // mark visited

        totalCheeze = maze[startI][startJ]==2?totalCheeze-1:totalCheeze;
        // now call the recursive function to explore the choices
        int ans = RatPathCountBacktrack(maze,startI+1,startJ, endI, endJ, totalCheeze)
                + RatPathCountBacktrack(maze,startI,startJ+1, endI, endJ, totalCheeze)
                + RatPathCountBacktrack(maze,startI-1,startJ, endI, endJ, totalCheeze)
                + RatPathCountBacktrack(maze,startI,startJ-1, endI, endJ, totalCheeze);

        maze[startI][startJ] = temp; // unmarking with it's own value
        return ans;
    }

    // TC:- O(4^NM), SC:- rec stack space


// Question - 3:-
// Problem Link :- https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
// Problem Description :-
/*
Consider a rat placed at position (0, 0) in an n x n square matrix mat[][]. The rat's goal is to reach the destination
at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending
at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can
only move to adjacent cells that are within the bounds of the matrix and not blocked.
If no path exists, return an empty list.

Note: Return the final result vector in lexicographically smallest order.

Examples:

Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in
sorted order we get DDRDRR DRDDRR.
Input: mat[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell is blocked.
Input: mat = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
Output: ["DDRR", "RRDD"]
Explanation: The rat has two possible paths to reach the destination: 1. "DDRR" 2. "RRDD", These are returned in
lexicographically sorted order.
Constraints:
2 ≤ mat.size() ≤ 5
0 ≤ mat[i][j] ≤ 1

Expected Complexities
Time Complexity: O(4 ^ (n * n))
Auxiliary Space: O(n * n)
Company Tags
Amazon Microsoft

 */

    // Approach - 1:- By me
    // TC :- O(4^NM), SC:- O(M*N) for visited + rec stack space
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder seq = new StringBuilder();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        recBacktrack(maze,0,0,visited,seq,res);
        return res;
    }

    private void recBacktrack(int[][] maze, int startI, int startJ, boolean[][] vis, StringBuilder seq, ArrayList<String> res){

        if(startI==maze.length-1 && startJ==maze[0].length-1){
            res.add(seq.toString());
            return;
        }

        // Here in the ans, you just need to explore the options in this mention order
        // (D,L,R,U) only else output is not matching. bec here it was asked to return in sorted or lexicographically
        // And in dictionary if you see, then 1st D comes then --> L --> R --> U.

        int[] rows = new int[]{1,0,0,-1};
        int[] cols = new int[]{0,-1,1,0};

        vis[startI][startJ]=true;
        for(int i=0;i<4;i++){
            int childI = startI + rows[i];
            int childJ = startJ + cols[i];
            if(childI>=0 && childI<maze.length && childJ>=0 && childJ<maze[0].length
                    && vis[childI][childJ]==false && maze[childI][childJ]==1){
                // vis[childI][childJ]=true;
                seq.append(getChar(rows[i],cols[i]));
                recBacktrack(maze,childI,childJ,vis, seq, res);
                seq.deleteCharAt(seq.length()-1);
                // vis[childI][childJ]=false;
            }
        }
        vis[startI][startJ]=false;

        // Note :- you can right vis[start][end] before & after loop. Or else you can mark them inside the loop as well.
        // but if you do inside the loop, then also the 1st marking true step needs to be present in the code.

    }

    private Character getChar(int i, int j){
        if(i==-1 && j==0) return 'U';
        else if(i==0 && j==1) return 'R';
        else if(i==1 && j==0) return 'D';
        return 'L';
    }


    // Approach :- 2nd way to write above backtracking logic is:-
    /*
    Summary:
1. We(mouse) are standing at (0,0) and we need to generate all possible paths so that the mouse reachers the last cell
of the maze (n-1,n-1)
2. We are allowed to move in 4 directions only- Up, Down, Left and Right. We need to return a vector<string> ans
containing all possible paths through which the mouse can reach the end of maze.
3. Base conditions are pretty simple. Firstly, we cannot go beyond the boundaries of the matrix, secondly we cannot go
to a cell which contains a blockage that is, matrix[i][j] denotes a blockage or wall and we cannot go through it. Also
we need to mark every cell as visited with any other value(Fraz sir has marked with 0 for better understanding) such
that we don't come back to the same cell again and again. Lastly, when we reach the target cell (n-1,n-1) we need to
put our path string in ans[] vector and return as we have completed our objective.
a) if(i <0 || j<0 || i>=n || j>=n)
     return;
b) if(matrix[i][j] == 0)
     return;
c) if(i==n-1 && j==n-1)
{
     ans.push_back(path);
     return;
}
4. Now, we have four options. But according to the problem we need to print the paths in sorted manner so we will move
like- Down, Left, Right, Up. And before that we will mark the cell as visited by matrix [i][j] = 0 and Back-track at the
end.
// Mark as visited
matrix[i][j] = 0;
// Move Down
help(i+1,j,path+'D');
// Move Left
help(i,j-1,path +'L');
//Move Right
help(i,j+1,path + 'R');
// Move Up
help(i-1,j,path+'U);

// Undo the change
matrix[i][j] = 1;
5. Recursion will generate all the possible paths to reach end. We don't have to do anything else.

Time Complexity: O(4^n*n) [ Because in worst case we will have a maze all filled with 1 and we will traverse all the
cells to reach the end. And we have n*n cells in the maze and for each cell we have 4 option that's why Time Complexity
is O(4^n*n) ]

Space Complexity: O(n*n)
[ This is equal to the height of the Recursive Tree and since we need to reach the end (n-1,n-1) from (0,0) that's why
we need to traverse the entire matrix. ]

     */
}
