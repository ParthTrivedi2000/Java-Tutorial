package org.allTopics.DynamicProgramming;

// Problem Link :- https://leetcode.com/problems/coin-change-ii/description/

// Problem Description :-
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing
a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any
combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:
Input: amount = 10, coins = [10]
Output: 1

Constraints:
1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000

 */


// Intution :-
/*
So see how it differs from above coin sum permutation problem is, in that question sequence should not be considered
means (x,y) != (y,x).
For example
coins = {3,1,4}, amount=5
==> possible permutations are
{1,1,1,1,1}
{4,1}, {1,4}
{3,1,1}, {1,3,1}, {1,1,3}
==> ans=6

But in this, coin sum combination we don't have to take that sequence. So it means (x,y) ==(y,x) so you should
consider it as same only. i.e. possible combination for above example:-
{1,1,1,1,1}
{3,1,1} but not {1,3,1} & {1,1,3} bec we have considered 1 subset with 2 times 1 and 1 times 3.
{4,1} but not {1,4} bec we considered subset of 1 times 1 & 4.
=> ans = 3

- So yrrr above clearly we see that somehow we need to maintain the relative order. I also don't know how? but 1st of
all by seeing above example we can think like yes we should follow some relative order like, suppose pehle hmne 3
liya h then 1 h, so next koi bhi combination h usme m 1 ko 3 k bad hi lunga aesa ku6 relative order m khud se
implement krwane ki try krunga.

- So simply to have that implemented order we can just simply interchange the 2 loops. bec here we want to fill
whole dp array with current i 1st, & then only I can go with next i.

(Please read handwritten notes for this question to get better understanding)


 */

public class DP19CoinSumCombinations {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int amt=1;amt<=amount;amt++){
                if(amt-coins[i]>=0) dp[amt] += dp[amt-coins[i]];
            }
        }
        return dp[amount];
    }
}
