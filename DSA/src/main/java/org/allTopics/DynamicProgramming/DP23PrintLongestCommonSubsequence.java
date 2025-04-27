package org.allTopics.DynamicProgramming;

// Problem Link :- https://www.naukri.com/code360/problems/print-longest-common-subsequence_8416383?leftPanelTabValue=PROBLEM

// Problem Description:-
/*
You are given two strings ‘s1’ and ‘s2’.

Return the longest common subsequence of these strings.

If there’s no such string, return an empty string. If there are multiple possible answers, return any such string.

Note:
Longest common subsequence of string ‘s1’ and ‘s2’ is the longest subsequence of ‘s1’ that is also a subsequence of
‘s2’. A ‘subsequence’ of ‘s1’ is a string that can be formed by deleting one or more (possibly zero) characters
from ‘s1’.

Example:
Input: ‘s1’  = “abcab”, ‘s2’ = “cbab”

Output: “bab”

Explanation:
“bab” is one valid longest subsequence present in both strings ‘s1’ , ‘s2’.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
5 6
ababa
cbbcad

Expected Answer:
"bba"

Output on console:
1

Explanation of sample output 1:
“bba” is only possible longest subsequence present in both s1 = “ababa” and s2 = “cbbcad”. '1' is printed if the
returned string is equal to "bba".

Sample Input 2:
3 3
xyz
abc

Expected Answer:
""

Output on console:
1

Explanation of sample output 2:
There’s no subsequence of ‘s1’ that is also present in ‘s2’. Thus an empty string is returned and '1' is printed.

Expected Time Complexity:
Try to solve this in O(n*m). Where ‘n’ is the length of ‘s1’ and ‘m’ is the length of ‘s2’.

Constraints:
1 <= n, m <= 10^3

Time Limit: 1 sec

 */

public class DP23PrintLongestCommonSubsequence {
    public static String findLCS(int n, int m, String s1, String s2){
        // Write your code here.

        // Approach :- Tabulation:-
        // TC:- O(N*M) for filling DP + O(M+N) for traversing DP & printing String
        // SC:- O(N*M)
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if(i==0 || j==0) dp[i][j]=0;
            }
        }

        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                int resForEq = 0;
                int resForUneq = 0;
                //if equal
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    resForEq = 1 + dp[i-1][j-1];
                }
                else{
                    resForUneq = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                dp[i][j] = Math.max(resForEq, resForUneq);
            }
        }

        int i=dp.length-1;
        int j=dp[0].length-1;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]) i--;
            else j--;
        }
        // System.out.println(sb.reverse().toString());
        return sb.reverse().toString();
    }
}
