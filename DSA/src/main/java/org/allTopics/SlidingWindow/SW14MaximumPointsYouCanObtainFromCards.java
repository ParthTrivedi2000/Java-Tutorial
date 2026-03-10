package org.allTopics.SlidingWindow;

// ------------ Striver's Sliding Window & 2 Pointers Questions continued....----------------


// Q - 9) Maximum points you can obtain from cards
// Problem Link :- https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

// Problem Description:-
/*
There are several cards arranged in a row, and each card has an associated number of points. The points
are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take
exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

Example 1:
Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card
first will maximize your total score. The optimal strategy is to take the three cards on the right,
giving a final score of 1 + 6 + 5 = 12.

Constraints:
1 <= cardPoints.length <= 10^5
1 <= cardPoints[i] <= 10^4
1 <= k <= cardPoints.length
 */

public class SW14MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        // Approach:-
        // 1st I can have the sum of 4 cards from starting.
        // Then I can have 2 pointers.
        // i pointer will be placed at K-1th index. and j pointer will be placed at the last index.
        // Then I can add the last elem to the sum & parallel remove the elem at i from sum. and finding
        // maximum each time. will continue this process k times or we can say till i becomes 0.

        int sum=0;
        // Taking sum of starting k elements
        for(int i=0;i<k;i++) sum+=cardPoints[i];

        int ans=sum;
        // Start considering elems from back.
        for(int i=k-1,j=cardPoints.length-1; i>=0;i--,j--){
            sum = sum + cardPoints[j] - cardPoints[i];
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}

// Next question is Longest Substring without repeating characters. Please check Question-7 above.
