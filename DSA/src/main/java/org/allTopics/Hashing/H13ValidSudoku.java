package org.allTopics.Hashing;

// Problem Link :- https://leetcode.com/problems/valid-sudoku/description/

/*
Problem Description :-
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


Example 1:


Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in
the top left 3x3 sub-box, it is invalid.


Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class H13ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Approach:-
        // we need to check
        // 1) weather any row has duplicate or not,
        // 2) same weather any col has duplicate or not
        // 3) same weather any block has duplicate or not.
        // So for above 3 duplication checks, we need to have 3 Arrays/HashMaps each of
        // size 9+9+9. And each this entry inside the HashMap represnt key as row/col/bolck
        // no. And value as HashSet<Integer> which stores the values inside hashset.
        // hence while we are populating all the 3 Hashmaps/Arryas, if any element is
        // duplicated then we need to return false then n there. after the end of for loop
        // we need to return true.
        // So total I will be having 9+9+9=27 HashSets available.

        // TC of above approach:- O(N^2). but here N=9 always, so we can say fix 81 iterations at max always, not more than that except in future sudoku of size 18 comes.

        Map<Integer, HashSet<Character>> rowsMp = new HashMap<>(); // 0 to 9 rows as key
        Map<Integer, HashSet<Character>> colsMp = new HashMap<>(); // 0 to 9 cols as key
        Map<Integer, HashSet<Character>> blocksMp = new HashMap<>(); // 0 to 9 blocks as key

        for(int i=0;i<9;i++){
            rowsMp.put(i,new HashSet<>());
            colsMp.put(i,new HashSet<>());
            blocksMp.put(i,new HashSet<>());
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                // continue when iterating empty cells
                if(board[i][j]=='.') continue;

                // filling rows map
                if(rowsMp.get(i).contains(board[i][j])) return false;
                rowsMp.get(i).add(board[i][j]);


                // filling cols map
                if(colsMp.get(j).contains(board[i][j])) return false;
                colsMp.get(j).add(board[i][j]);


                // Filling block map
                int blockId=getBlockId(i,j);
                if(blocksMp.get(blockId).contains(board[i][j])) return false;
                blocksMp.get(blockId).add(board[i][j]);
            }
        }
        return true;
    }

    int getBlockId(int row,int col){
        return (row/3)*3+(col/3);
    }
}
