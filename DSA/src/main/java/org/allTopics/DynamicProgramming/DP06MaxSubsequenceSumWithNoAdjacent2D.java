package org.allTopics.DynamicProgramming;

// Problem Link :- https://www.geeksforgeeks.org/problems/adjacents-are-not-allowed3528/1

/*
Problem Description :-
Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is
maximized.
However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
Return the maximum possible sum.
Note: You are allowed to choose more than 2 numbers from the grid.

Problem Constraints
1 <= N <= 20000
1 <= A[i] <= 2000

Input Format
The first and the only argument of input contains a 2d matrix, A.

Output Format
Return an integer, representing the maximum possible sum.

Example Input
Input 1:
 A = [
        [1]
        [2]
     ]
Input 2:
 A = [
        [1, 2, 3, 4]
        [2, 3, 4, 5]
     ]

Example Output
Output 1:
 2
Output 2:
 8

Example Explanation
Explanation 1:
 We will choose 2 (From 2nd row 1st column).
Explanation 2:
 We will choose 3 (From 2nd row 2nd column) and 5 (From 2nd row 4th column).

 */

/*
Approach:-
No two adjacent elements should be taken ( Adjacent is defined by horizontally, vertically, diagonally ).
so suppose we have 2 * N list :

1 |  6  |  7  | 8
2 |  3  |  4  | 5

Now suppose we choose 6, then we can't choose the elements 1, 2, 3, 4, 7.
If we choose 3, then we can't choose the elements 1, 2, 6, 4, 7.
And out of 3 and 6, we can choose only one, since they are also adjacent.

So, one simple observation is -
We can choose one element out of 1 and 2, 6 and 3, 7 and 4, 8 and 5.
Is order to get the maximum sum, we need to select maximum element out of two.

So, this is the final converted list - [2, 6, 7, 8]
If you pick any element from this, then left adjacent and right adjacent values can't be picked.

Can you implement a brute force for this using recursion using the above fact ?
Can you memoize the bruteforce recursive solution ?

V :
1 |  2  |  3  | 4
2 |  3  |  4  | 5

Lets first try to reduce it into a simpler problem.
We know that within a column, we can choose at max 1 element.
And choosing either of those elements is going to rule out choosing anything from the previous or next column.
This means that choosing V[0][i] or V[1][i] has identical bearing on the elements which are ruled out.
So, instead we replace each column with a single element which is the max of V[0][i], V[1][i].

Now we have the list as :
2 3 4 5

Here we can see that we have reduced our problem into another simpler problem.
Now we want to find maximum sum of values where no 2 values are adjacent.
Now our recurrence relation will depend only on position i and,
 a "include_current_element" which will denote whether we picked last element or not.

MAX_SUM(pos, include_current_element) =
IF include_current_element = FALSE THEN
    max ( MAX_SUM(pos - 1, FALSE) , MAX_SUM(pos - 1, TRUE) )

ELSE
    MAX_SUM(pos - 1, FALSE) + val(pos)
 */

import java.util.ArrayList;

public class DP06MaxSubsequenceSumWithNoAdjacent2D {

    // Here I have written only tabulative approach. Please read other approaches from previous question.
    // Approach - Tabulative
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        if(A.get(0).size()==1) return Math.max(A.get(0).get(0), A.get(1).get(0));
        ArrayList<Integer> newAL = new ArrayList<Integer>();
        for(int i=0;i<A.get(0).size();i++){
            // ans = Math.max(A.get(0).get(i), A.get(1).get(i));
            newAL.add(Math.max(A.get(0).get(i), A.get(1).get(i)));
        }

        // Now this is single list out of which we can perform pick and not pick for each elem from last or 1st
        // and then we can decide the range from which we can pick and add into the sum based on i

        int[] dp = new int[newAL.size()];
        // dp[i] = max subsequence sum from 0 to i such that no 2 elements are consecutive.
        dp[0] = newAL.get(0);
        dp[1] = Math.max(newAL.get(0),newAL.get(1));
        for(int i=2;i<newAL.size();i++){
            dp[i] = Math.max(dp[i-1], newAL.get(i)+dp[i-2]);
        }
        return dp[newAL.size()-1];
    }
}
