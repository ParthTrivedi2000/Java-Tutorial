package org.allTopics.DynamicProgramming;

// Problem Link :- https://leetcode.com/problems/longest-common-subsequence/description/

// Problem Description :-
/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common
subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none)
deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:
1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
 */

public class DP21LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        // // Approach - 1:- Recursive:-
        // return rec(text1, text2, text1.length()-1, text2.length()-1);

        // // Approach - 2:- Memoized
        // int[][] dp = new int[text1.length()][text2.length()];
        // for(int[] row: dp) Arrays.fill(row,-1);
        // return memo(text1, text2, text1.length()-1, text2.length()-1, dp);

        // Tabulation:-
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<=text1.length();i++){
            for(int j=0;j<=text2.length();j++){
                if(i==0 || j==0) dp[i][j]=0;
            }
        }

        for(int i=1;i<text1.length()+1;i++){
            for(int j=1;j<text2.length()+1;j++){
                int resForEq = 0;
                int resForUneq = 0;
                //if equal
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    resForEq = 1 + dp[i-1][j-1];
                }
                else{
                    resForUneq = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                dp[i][j] = Math.max(resForEq, resForUneq);
            }
        }
        return dp[text1.length()][text2.length()];
    }

    private int rec(String s1, String s2, int i, int j){
        //base
        if(i==-1 || j==-1) return 0;
        //choices:-
        // if equals
        int resForEq=0;
        int resForUneq = 0;
        if(s1.charAt(i)==s2.charAt(j)){
            resForEq = 1 + rec(s1,s2,i-1,j-1);
        }
        // if not equals
        else{
            int r1 = rec(s1,s2,i,j-1);
            int r2 = rec(s1,s2,i-1,j);
            resForUneq = Math.max(r1,r2);
        }
        return Math.max(resForEq, resForUneq);
    }

    private int memo(String s1, String s2, int i, int j, int[][] dp){
        if(i==-1||j==-1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        // choices
        // if equals
        int resForEq=0;
        int resForUneq = 0;
        if(s1.charAt(i)==s2.charAt(j)){
            resForEq = 1 + memo(s1,s2,i-1,j-1,dp);
        }
        // if not equals
        else{
            int r1 = memo(s1,s2,i,j-1,dp);
            int r2 = memo(s1,s2,i-1,j,dp);
            resForUneq = Math.max(r1,r2);
        }
        dp[i][j] = Math.max(resForEq, resForUneq);
        return Math.max(resForEq, resForUneq);
    }
}
