package org.allTopics.Arrays;


// Problem Description :-
/*
You have given a string A having Uppercase English letters.You have to find how many times subsequence "AG" is there
in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.


Problem Constraints:-
1 <= length(A) <= 10^5


Input Format :-
First and only argument is a string A.

Output Format:-
Return an integer denoting the answer.


Example Input:-
Input 1:
 A = "ABCGAG"
Input 2:
 A = "GAB"


Example Output:-
Output 1:
 3
Output 2:
 0


Example Explanation:-
Explanation 1:
 Subsequence "AG" is 3 times in given string
Explanation 2:
 There is no subsequence "AG" in the given string.

 */

public class SpecialSubsequencesAG{
    public int solve(String A) {
         // BruteForce :- O(N^2)
        /*
         for(int i=0;i<A.length();i++){
             for(int j=i+1;j<A.length();j++){
                 if(A.charAt(i)=='A' && A.charAt(j)=='G') cnt++;
             }
         }
         return cnt;

         */


         // Better Approach :- Using prefix-Suffix. TC: O(N), SC:- O(N)
         // Since we only want pairs such that 1st A comes then only G comes i.e. G should be at right of A,
         // so we have created suffix array.
        /*
         int n = A.length(), ans = 0, MOD = 1000*1000*1000 + 7;
         int cnt_G[] = new int[n], count = 0;
         //Suffix count of G
         for(int i = n - 1 ; i >= 0 ; i--){
             if(A.charAt(i) == 'G')
                 count = count + 1;
             cnt_G[i] = count;
         }
         // traverse the string again from beginning
         for(int i = 0; i < n; i++){
             // if current character is "A" then add number of G's after that
             if(A.charAt(i) == 'A') {
                 ans = ans + cnt_G[i];
                 ans = ans % MOD;
             }
         }
         return ans;

         */


         // Optimised Approach:- Carry Forward. TC:-O(N), SC:- O(1)
         // Since we only want pairs such that 1st A comes then only G comes i.e. G should be at right of A,
         // hence we are start traversing from right end of String.
         long countG=0;
         long ans=0;
         for(int i=A.length()-1;i>=0;i--){
             if(A.charAt(i)=='G') countG++;
             else if(A.charAt(i)=='A') {
                 ans = ans + countG;
                 ans = ans % 1000000007;
             }
         }
         return (int)ans;

        // Optimised Approach:- Carry Forward. TC:-O(N), SC:- O(1)
        // Traversing from Starting from left end of String.
        /*
        long cntA=0;
        long ans = 0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='A') cntA++;
            else if(A.charAt(i)=='G') {
                ans+=cntA;
                ans%=1000000007;
            }
        }
        return (int)ans;
         */
    }
}