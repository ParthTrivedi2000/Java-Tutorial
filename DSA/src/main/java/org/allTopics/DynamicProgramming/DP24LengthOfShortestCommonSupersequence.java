package org.allTopics.DynamicProgramming;

// Problem Link :-

// Problem Description :-
/*

 */

// Approach
/*
Q: Given two strings str1 and str2, the task is to find the length of the shortest string that has both str1 and str2
as subsequences.
Eg str1 = "geek", str2 = "eke"
O/P : 5 as the string "geeke" contains both "geek" and "eke" as subsequences

- Now 1 way is simply adding both strings i.e "geekeke" (length=7)
- This string has both "geek" and "eke" as subsequences
- but this is not the shortest since "geeke" also has both "geek" and "eke" as subsequences
- One thing to note here is that LCS here is "ek" and actually we added "ek" twice in the "geekeke"
- so removing it once will serve us the purpose
- Once we find LCS, we insert characters of both strings in order and we get "geeke" So we can simply find the length of
the SCS as :
- So length of the SCS = length of string 1 + length of string 2 - LCS
 */

public class DP24LengthOfShortestCommonSupersequence {
    public int lengthOfShortestCommonSupersequence(String text1, String text2) {

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
        return text1.length() + text2.length() - dp[text1.length()][text2.length()];
    }
}
