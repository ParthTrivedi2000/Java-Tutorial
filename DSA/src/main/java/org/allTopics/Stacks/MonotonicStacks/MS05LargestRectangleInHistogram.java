package org.allTopics.Stacks.MonotonicStacks;

// Problem Link:- https://leetcode.com/problems/largest-rectangle-in-histogram/description/

/*
Problem Description :-
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return
the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:
Input: heights = [2,4]
Output: 4

Constraints:
1 <= heights.length <= 10^5
0 <= heights[i] <= 10^4
 */

import java.util.Stack;

public class MS05LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {

        /*
        BruteForce Approach:- TC:- O(N^2)
        function findMaxRectangleArea(hist):
        maxArea = 0
        for i from 0 to len(hist) - 1:
            // Consider each bar as a potential starting point
            minHeight = hist[i]
            for j from i to len(hist) - 1:
                // Iterate through bars to the right
                minHeight = min(minHeight, hist[j])
                width = j - i + 1
                area = minHeight * width
                maxArea = max(maxArea, area)
        return maxArea

         */


        // Optimised Approach :- for any i, I have to find the next smaller elem on right and
        //  prev smaller elem on left.
        int[] left = prevSmallerOnLeft(heights);
        int[] right = nextSmallerOnRight(heights);

        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            maxArea = Math.max(maxArea, heights[i]*(right[i]-left[i]-1));
        }
        return maxArea;
    }


    // Please note here 2 things
    // - Storing Indexes in the stack instead of actual elements
    // - for left side, whenever not found coresponding required element then putting -1
    // but for right side whenever not found corresponding required element then putting arr.length;
    public int[] prevSmallerOnLeft(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]) st.pop();
            ans[i] = (st.isEmpty())?-1:st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] nextSmallerOnRight(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]) st.pop();
            ans[i] = (st.isEmpty())?arr.length:st.peek();
            st.push(i);
        }
        return ans;
    }
}
