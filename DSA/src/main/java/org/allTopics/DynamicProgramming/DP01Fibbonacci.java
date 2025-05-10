package org.allTopics.DynamicProgramming;


import java.util.Arrays;

public class DP01Fibbonacci {
    // TC:- O(2^n), SC:- O(n) for stack space   // worst solution
    public int recursiveFib(int n){
        if(n==0||n==1) return n;
        return recursiveFib(n-1) + recursiveFib(n-2);
    }

    // Just pass the DP array from main fib() function which should be initialised with -1.
    // TC:- O(N), SC:-O(N) + O(N) ~ O(2N) { for recursive stack space + DP Array respectively }
    public int memoizedFib(int n, int[] dp){
        if(n==0 || n==1) return n;
        if(dp[n]!=-1) return dp[n];

        dp[n] = memoizedFib(n-1,dp) + memoizedFib(n-2,dp);
        return dp[n];
    }

    // TC:- O(N), SC:-O(N) {for DP arr space only}
    public int tabulativeFib(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        // initialisation
        dp[0] = 0;
        dp[1] = 1;

        // filling remaining DP elems with DP expression
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // So from above solution you can see that at a time we require only 3 DP states only which is changing. So
    // here it comes to mind, can't this problem is solved using only 3 variables? --> absolutely yes.
    // TC:- O(N) SC:-O(1)
    public int optimisedFib(int n){
        int a=0;
        int b=1;
        int c = 0;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }

// So benefit of writing Tabulative Solution is:- We can optimise space after tabulation, if your current state is
// dependent upon some fixed previous states.
}
