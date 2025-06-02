package org.allTopics.DynamicProgramming;

// Problem Link :-

// Problem Description :-

// Intution :-
/*
Yrrr how it is identified like it is similar category of LCS, means how to say like this question can be solved
with the same/similar way in which we were solved LCS category question.

- See here as well there are 2 strings in the input. And here also similar as LCS, they have asked something
as Longest Common from 2 strings (which was the same case with LCS).
Then obviously agr koi question m longest common chahiye from 2 strings, to hm whi wali method follow krenge ryt.

- So again base case would be same. Smallest Minimum Input for index i & j would be 0.
Then Initialization is also done in the same way as LCS. (put 0 for the 1st row & 1st col in dp)

- Now inside code, previously what happen if s1 = abcde, s2 = abfce ==> then we are basically adding + to our count
irrespective of those matching characters are continuous or not. But here if they are matching, then same as before
we will keep on increasing count, but if not, then we have to start counting again correct, means simply we can again
make count as 0 in case of != strings, so that whenever next time same character mile to again count will be started
from 1.

- So this is the simplest change we have to do. Simply we have to consider 0 while 2 chars are not equal.

- And yes, I made this mistake 2 times, by just copying code from LCS. But there we are returning  the last state of
DP table bec in that case it would give correct answer. but here in this case we will not get correct answer at last
cell ryt, means just reiterate the definition of each do state in the table,
dp[i][j] = longest possible substring with i chars & j chars.

- So just mean to say is, each cell will fill the value, and we want maximum values from whole DP table that would be
our answer bec we want max/longest substring so.

- Another thing is recursive code would be complex for this, means we have to consider new extra variable and need to
make it 0 or changed, it means we need that 3rd variable as changing argument  which will make code more complex,
so please try to avoid recursive/memoized code for this question, provide direct tabulation with approach discussion
to the interviewer.

 */

public class DP22LongestCommonSubstring {
    public static int lcs(String str1, String str2){
        // Write your code here.
        // // Tabulation:-
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++){
            for(int j=0;j<=str2.length();j++){
                if(i==0 || j==0) dp[i][j]=0;
            }
        }

        int ans=0;
        for(int i=1;i<str1.length()+1;i++){
            for(int j=1;j<str2.length()+1;j++){
                //if equal
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans = Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
