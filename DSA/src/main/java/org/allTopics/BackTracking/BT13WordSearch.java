package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/word-search/description/

// Problem Description :-
/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once.


Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.


Follow up: Could you use search pruning to make your solution faster with a larger board?

 */

public class BT13WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(searchBacktrack(board,i,j,word,0)) return true;
                }
            }
        }
        return false;
    }

    private boolean searchBacktrack(char[][] board, int startI, int startJ, String word, int requiredCharPos){
        // base position
        if(requiredCharPos == word.length()) return true;
        if(startI<0 || startI>=board.length || startJ<0 || startJ>=board[0].length
                || board[startI][startJ]!=word.charAt(requiredCharPos) || board[startI][startJ]=='#') return false;

        // marking cell as visited by changing it's char value to '#'
        char ch = board[startI][startJ];
        board[startI][startJ]='#';
        boolean ans = searchBacktrack(board,startI+1,startJ,word,requiredCharPos+1)
                || searchBacktrack(board,startI-1,startJ,word,requiredCharPos+1)
                || searchBacktrack(board,startI,startJ+1,word,requiredCharPos+1)
                || searchBacktrack(board,startI,startJ-1,word,requiredCharPos+1);

        //marking unvisited
        board[startI][startJ] = ch;
        return ans;
    }

    // Conclusion :-
    /*
    Summary:
1. Question is similar to Flood Fill algorithm
2. We need to find a word in the given board of size (m*n)
3. So we need to iterate over the board [][] and check if word is present inside or not.
4. Instead of using visited matrix, we mark all the visited cells with '#' and upon backtracking we need to undo the
change we have done earlier.
5.We will have three base cases:
a) if(k == word.size() )
     return true;
b) if(i <0 || j<0 || i >=m || j>= n)
return false;
c) if(board[i][j] != word[k] || board [i][j] == '#')
return false;
6. Else we mark the cell as visited using '#' and move in all possible directions Up(i-1,j) , Down (i+1,j), Left(i,j-1)
and Right (i,j+1) and ask Recursion to check whether the remaining part of word is present or not from k+1 till
word.size()
7. At the end, backtrack and undo the change and return OR of all the four options.
return Op1 || Op2 || Op3 || Op4 ;

Time Complexity: O(m*n * 4^k) [ k is word.size(). This is because, in worst case, we traverse the entire board[][] and
for each call we have 4 choices and in the Worst case we will go till word.size() ]

Space Complexity: O(k) [ k is word.size()]

     */
}
