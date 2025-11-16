package org.allTopics.DynamicProgramming;

// Problem Link :- https://www.naukri.com/code360/problems/unbounded-knapsack_1215029?leftPanelTabValue=PROBLEM

/*
Problem Description :-
You are given ‘n’ items with certain ‘profit’ and ‘weight’ and a knapsack with weight capacity ‘w’.
You need to fill the knapsack with the items in such a way that you get the maximum profit. You are allowed to take
one item multiple times.

Example:
Input:
'n' = 3, 'w' = 10,
'profit' = [5, 11, 13]
'weight' = [2, 4, 6]
Output: 27

Explanation:
We can fill the knapsack as:
1 item of weight 6 and 1 item of weight 4.
1 item of weight 6 and 2 items of weight 2.
2 items of weight 4 and 1 item of weight 2.
5 items of weight 2.

The maximum profit will be from case 3 = 11 + 11 + 5 = 27. Therefore maximum profit = 27.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3 15
7 2 4
5 10 20

Expected Answer:
21

Output on console:
21

Explanation of Sample Input 1
The given knapsack capacity is 15. We can fill the knapsack as [1, 1, 1] giving us profit 21 and as [1,2] giving us
profit 9. Thus maximum profit will be 21.

Sample Input 2
2 3
6 12
4 17

Expected Answer:
0

Output on console:
0

Explanation of Sample Input 2:
We can clearly see that no item has weight less than knapsack capacity. Therefore we can not fill knapsack with any
item.

Expected Time Complexity:
Try to solve this in O(n*w).

Constraints
1 <= n <= 10^3
1 <= w <= 10^3
1 <= profit[i] , weight[i] <= 10^8

Time Limit: 1 sec

 */

// Intuition :-
/*
From Aditya Verma:-
- See this is also as similar as 0/1Knapsack problem.
- Here what is the only difference is, Unbounded knapsack allows any element to be picked multiple times.
- It means what, when we are doing 2 choices for each call, here also we will do 2 choice only for any elem.
notPick & Pick.
- but previously in 0/1Knapsack, since we have performed choices for any element, we can't consider same elem
2nd time to pick, bec it was constraint that we can consider any element only 1 time.
- But here it was not the case. in case of Unbounded Knapsack, we can consider any element any number of times.

- So how we will proceed?
- See, while performing 2 choices for any elem, in case of notPick, if elem is not considered to be picked due to
condition, then during next time also it will not be considered ryt. for example, capacity given is 6, and suppose
we are performing choices on elem 4, then for this time it falls under notPicked category, then during next iterations
also it will again fall in the same category only. So in-short, notPick code will stays as is.
- But for pick recursive call, once we pick we were doing end-1 for each elem/recursive call bec we were allowed
to consider elem only single time. But in unbounded problem we were allowed to pick elem any number of times
so for pick we won't do end-1, instead we keep end same as end only while doing next recursive call for pick. so
that's the only difference in the code we should do, else everything remains as is.
 */

public class DP16UnboundedKnapsack {
    // As per the Aditya Verma's approach :-
    /*
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[profit.length+1][w+1];
        for(int i=0;i<=profit.length;i++){
            for(int j=0;j<=w;j++){

                if(i==0||j==0) dp[i][j]=0;
                else{
                    int notPick = dp[i-1][j];
                    int pick = Integer.MIN_VALUE;
                    if(j-weight[i-1]>=0){
                        pick = profit[i-1] + dp[i][j-weight[i-1]];
                    }
                    dp[i][j] = Math.max(pick,notPick);
                }
            }
        }
        return dp[profit.length][w];
    }

     */

    // Other way of thinking.
    /*
    See here in the unbounded knapsack problem, for each element we can think like we should consider it. it means
    we pick it, now if that elem's weight<=capacity, then we can include it. And for the next recursive call again
    without doing end-1, we can pass end only so that in the next iterations/calls also it can be picked. but yes
    we should do capacity-weight[end] while passing into next recursive call.

    - So just mean to say is, here if you draw the rec tree, then
    fun(startIdx, endIdx, capacity)
    for each function call, our start index and end index stays as is, only changing parameter is capacity as explained
    above.
    - So we can ommit to pass start and end index.
    (just check the rec tree dia from book notes).

     */

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        // Approach - 1:- Recursive
        // return rec(weight,profit,w);

        // Approach - 2:- Memoized:-
        int[] dp = new int[w+1];
        return memo(weight,profit,w, dp);

        // Approach - 3:- Tabulation (Please see above tabulation approach as well, which is written based on
        // Adity verma's explanation.
        /*
        int[] dp = new int[w+1];
        for(int wt=0;wt<=w;wt++){
            int maxi = 0;
            int value =0;
            for(int j=profit.length-1;j>=0;j--){
                if(wt-weight[j]>=0) value = profit[j] + dp[wt-weight[j]];
                maxi = Math.max(maxi,value);
            }
            dp[wt] = maxi;
        }
        return dp[w];

         */



    }
    private static int memo(int[] wt, int[] val, int cap,int[] dp){
        if(cap<0) return 0;
        if(dp[cap]!=0) return dp[cap];
        int maxi = 0;
        int value=0;
        for(int i=val.length-1;i>=0;i--){
            if(cap-wt[i]>=0) value = val[i]+memo(wt,val,cap-wt[i],dp);
            maxi = Math.max(maxi,value);
        }
        return dp[cap] = maxi;
    }

    private static int rec(int[] wt, int[] val, int cap){
        if(cap<0) return 0;
        int maxi = 0;
        int value = 0;
        for(int i=val.length-1;i>=0;i--){
            if(cap-wt[i]>=0){
                value = val[i] + rec(wt, val,cap-wt[i]);
            }
            maxi = Math.max(maxi,value);
        }
        return maxi;
    }
}
