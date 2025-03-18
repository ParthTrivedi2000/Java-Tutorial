package org.allTopics.Arrays;



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
             else if(A.charAt(i)=='A') ans = ans + countG;
         }
         return (int)(ans%1000000007);
    }
}