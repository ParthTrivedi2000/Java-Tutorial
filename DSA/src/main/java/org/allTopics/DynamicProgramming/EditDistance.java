package org.allTopics.DynamicProgramming;

// Problem Link :- https://leetcode.com/problems/edit-distance/

/*
Problem Description :-
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
Insert a character
Delete a character
Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

Constraints:
0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
 */

import java.util.Arrays;

public class EditDistance {
    // Approach - 2:- Memoization :- TC:-O(N^2), SC:-O(N^2)
    /*
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        return memoization(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }

    public int memoization(String s1, String s2, int i, int j, int[][] dp ){
        if(i<0 && j<0) return 0;
        else if(i<0) return j+1;
        else if(j<0) return i+1;

        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = memoization(s1, s2, i - 1, j - 1, dp);
        }
        else{
            return dp[i][j] = 1 + Math.min(memoization(s1, s2, i - 1, j - 1, dp),
                    Math.min(memoization(s1, s2, i - 1, j, dp), memoization(s1, s2, i, j - 1, dp)));

        }
    }

     */



    // Approach - 3:- Tabulation :- TC:-O(N^2), SC:-O(N^2)
    public int minDistance(String word1, String word2) {
        int[][] dp =  new int[word1.length()+1][word2.length()+1];
        int ci=1, cd=1, cr=1; // ci (char Insertion cost), cd(char deletion cost), cr(char replacement cost)
        for(int i=0;i<=word1.length();i++){
            for(int j=0;j<=word2.length();j++){
                if(i==0&&j==0) dp[i][j] = 0;
                else if(i==0) dp[i][j] = dp[i][j-1] + ci;
                else if(j==0) dp[i][j] = dp[i-1][j] + cd;
                else{
                    if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                    else dp[i][j] = Math.min(Math.min(dp[i-1][j-1]+cr , dp[i-1][j]+cd), dp[i][j-1]+ci);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
