package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/sudoku-solver/description/

// Problem Description :-
/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.


Example 1:
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"]
,["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],
["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:


Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.

 */


public class BT16SudokuSolver {
    public void solveSudoku(char[][] board) {
        sudokuBacktrack(board,0,0);
    }

    private boolean sudokuBacktrack(char[][] board, int currI,int currJ){

        // move ahead cell by cell
        // - if cell has '.' --> skip it & make next recursive call.
        // - else run a loop to place from 1 to 9 in it.
        //      - if num is safe to place --> true --> then put it & return true
        //                                --> else --> backtrack number

        // base condition
        if(currI==9) return true;
        if(currJ==9) return sudokuBacktrack(board,currI+1,0);
        if(board[currI][currJ]!='.') return sudokuBacktrack(board,currI,currJ+1);

        for(char num='1';num<='9';num++){
            if(isSafeNumberToPlace(board,currI,currJ,num)){
                board[currI][currJ] = num;
                if(sudokuBacktrack(board,currI,currJ+1)==true) return true;
                    // else backtrack it, i.e. place the another char
                else board[currI][currJ]='.';
            }
        }

        return false;
    }

    private boolean isSafeNumberToPlace(char[][] board, int currI,int currJ, char num){

        // col check
        for(int i=0;i<9;i++) if(board[i][currJ]==num) return false;

        // row check
        for(int j=0;j<9;j++) if(board[currI][j]==num) return false;

        // box check
        int boxStartRow = (currI/3)*3;
        int boxStartCol = (currJ/3)*3;
        for(int i=boxStartRow;i<boxStartRow+3;i++){
            for(int j=boxStartCol;j<boxStartCol+3;j++){
                if(board[i][j]==num) return false;
            }
        }

        // if any of above was not returning false --> then it's true
        return true;
    }

    // Optimised code :-
    /*
    public class Solution {
    boolean[][] rows = new boolean[9][10];    // rows[i][num] = true if num is in row i
    boolean[][] cols = new boolean[9][10];    // cols[j][num] = true if num is in col j
    boolean[][] boxes = new boolean[9][10];   // boxes[k][num] = true if num is in box k

    public void solveSudoku(char[][] board) {
        // Initialize the tracking arrays
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int box = (i/3)*3 + j/3;
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[box][num] = true;
                }
            }
        }
        sudokuBacktrack(board, 0, 0);
    }

    private boolean sudokuBacktrack(char[][] board, int i, int j) {
        if(i == 9) return true;
        if(j == 9) return sudokuBacktrack(board, i+1, 0);
        if(board[i][j] != '.') return sudokuBacktrack(board, i, j+1);

        int box = (i/3)*3 + j/3;
        for(int num = 1; num <= 9; num++) {
            if(!rows[i][num] && !cols[j][num] && !boxes[box][num]) {
                board[i][j] = (char)(num + '0');
                rows[i][num] = cols[j][num] = boxes[box][num] = true;

                if(sudokuBacktrack(board, i, j+1)) return true;

                board[i][j] = '.';
                rows[i][num] = cols[j][num] = boxes[box][num] = false;
            }
        }
        return false;
    }
}
     */
}
