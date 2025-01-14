package org.allTopics.Stocks;

// Problem Link :- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

/*
Problem Description:-
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future
to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4
 */

public class BestTimetoBuyandSellStock1 {

    // Approach :- See problem statement. means we have to buy at min and sell at maximum in future i.e. after ith elem.
    // - Start traversing from last to first i.e. right to left.
    // - 1st get the max elem , simultaneously calculate max profit by maximum of ((max-currentElem) till now)

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int profit = 0;
        int max = 0;
        int ans = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) max = prices[i];
            profit = max - prices[i];
            ans = Math.max(ans, profit);
        }
        return ans;
    }
}
