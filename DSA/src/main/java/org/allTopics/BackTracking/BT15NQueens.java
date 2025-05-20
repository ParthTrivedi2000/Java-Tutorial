package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/n-queens/description/

// Problem Description :-
/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:
Input: n = 1
Output: [["Q"]]

Constraints:
1 <= n <= 9

 */


// Intuition & Approach :-
/*
- So there are total N rows & N cols given. & we have to place N Queens on the board.
Is it necessary to place 1 queen in each row or it would be fine if we skip the row means without any queen?
see here it is necessary to place a queen in each row, bec you have been given N rows & N queens. Now if you won't place
queen in any single row means skip the row then you will have to put 2 queens in a row for any row to lapse all the
queen.
- So basically thinking process is like, suppose I am in 6th row, so I can't place queen in any position in 6th row. I
mean there are queens present in all the above 5 rows, so I have to check positions such that it will not be in the
attacking range of any other queens. So simply I mean to say is, I have to find the safe position in the current row
to place the queen. Once I place Queen in the current row, I will ask recursion to place queen in the next rest of the
rows. This is how this question is recursive in nature and we will call the rec in this way.
- Now next thing is, since I want all the possible configurations where N Queens can be placed in the N*N board, so
by getting any 1 of the configurations I can't stop. I mean if we find any safe position, then once we complete
exploring for that position, we should remove Queen from that position & put it to the next safe position & start
exploring it. just means to say is with only 1 safe position if you got answer still that won't enough for you bec you
want to have all the configurations so you have to try all the safe positions available in the row.
- Now main logic is, how to find the safe position ? --> so simply for any cell you can,
1) run a loop to check weather any Queens present in this particular col.
2) run a loop to check weather any queen present in this particular row. (This we don't need to do, bec we are placing
each queen in each row so each row will have 1 queen only).
3) run a loop to check weather any queen present in this particular diagonal-1.
4) run a loop to check weather any queen is present in this particular digonal-2.

Remember for all above things, you need to do in upward directions only. means we are filling chess board from top to
bottom. so we don't need to check in any of the downwards direction. (means from current cell for queen you can have
total 8 directions --> so out of 8 please check only above 3 mentioned upward directions, not downwards). so you can
tun a loop from that current cell to upward direction.

And we are done.

- But here also there is optimisation we can do. Means instead of running loop for each cell everytime. we can use the
array to store weather the column is already used for queen's placement or not. means we can create 3 array for all above
3 options. means whenever we place the queen for any cell, we will also mark those col numbers & diagonal positions (in
diagonal how to do is a bit tricky to explain, please see code how we handled for diagonal).

- TC :- for 1st row we have N options. for 2nd row at max we can have N-1 options (we know obviously it's lesser than
N-1 only, but for easiness you can consider N-1 options), in 3rd row --> N-2 options....for last row --> 1 option
==> so overall TC = N*N-1*N-2... = N!
TC = O(N!)

- SC:- height of rec tree, --> so at max rec stack will be having all the row's config i.e O(N) for stack + O(N*N) we are
using separate space to store all the N*N elems value in separate DS.
SC = O(N^2)
 */

import java.util.ArrayList;
import java.util.List;

public class BT15NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<StringBuilder>> res = new ArrayList<>();

        // ChessBoard Creation
        List<StringBuilder> chessBoard = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringBuilder temp = new StringBuilder();
            for(int j=0;j<n;j++){
                temp.append('.');
            }
            chessBoard.add(temp);
        }

        // rec call
        recBacktrack(0, chessBoard, res);

        // Performing optimised backtrack call
        recBacktrackOptimised(0, chessBoard, res);

        // converting from List<List<StringBuilder>> --> List<List<String>>
        List<List<String>> ans = new ArrayList<>();
        for(List<StringBuilder> temp:res){
            List<String> temp1 = new ArrayList<>();
            for(StringBuilder sb: temp){
                temp1.add(sb.toString());
            }
            ans.add(temp1);
        }
        return ans;

    }

    private void recBacktrack(int row, List<StringBuilder> chessBoard, List<List<StringBuilder>> res){
        // base condition :- when rows reach to n
        if(row==chessBoard.size()){
            // Simply adding below lines are actually representing ....,.... state of chessboard
            // since after backtrack call, we are replacing with '.'. so just mean to say is, this
            // is reference hence for all the configurations it will be reflected so it is showing
            // ....,.... for our solution for everycase.

            // res.add(chessBoard);
            // return;


            // Instead we have to create deep copy of chessBoard whenever we are finding solution
            // I mean whenever we are hitting base case, at that time whatever configuration
            // chessboard holds that we can copy.

            List<StringBuilder> copy = new ArrayList<>();
            for(StringBuilder sb : chessBoard){
                copy.add(new StringBuilder(sb));
            }
            res.add(copy);
            return;
        }

        // for each row, I have to visit all cells present columnwise.
        for(int j=0;j<chessBoard.get(0).length();j++){
            if(isSafePosition(row,j,chessBoard)){
                chessBoard.get(row).setCharAt(j,'Q');
                recBacktrack(row+1, chessBoard, res);
                chessBoard.get(row).setCharAt(j,'.');
            }
        }
    }

    private boolean isSafePosition(int i, int j, List<StringBuilder> chessBoard){
        // 1) run loop for column check
        int tempI = i; // we need to store actual i, bec we need those values of i & j for future use
        while(tempI>=0){
            if(chessBoard.get(tempI).charAt(j)=='Q') return false;
            tempI--;
        }

        // 2) run loop for TOP LEFT diagonal check
        //using same tempI variable here
        tempI = i;
        int tempJ = j;
        while(tempI>=0 && tempJ<chessBoard.size()){
            if(chessBoard.get(tempI).charAt(tempJ)=='Q') return false;
            tempI--;
            tempJ++;
        }

        // 3) run loop for TOP RIGHT diagonal check
        tempI = i;
        tempJ = j;
        while(tempI>=0 && tempJ>=0){
            if(chessBoard.get(tempI).charAt(tempJ)=='Q') return false;
            tempI--;
            tempJ--;
        }

        // if any of above loop doesn't return false then we can place queen there so return true
        return true;
    }

    private void recBacktrackOptimised(int row, List<StringBuilder> chessBoard, List<List<StringBuilder>> res) {

    }
}
