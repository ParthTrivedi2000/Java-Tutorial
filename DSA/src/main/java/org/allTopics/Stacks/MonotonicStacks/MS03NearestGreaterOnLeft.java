package org.allTopics.Stacks.MonotonicStacks;

// Below is not the exact same problem, but almost same but with minor tweaks.
// Problem link:- https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621

/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need
to calculate the span of stocks price for all n days.
The span Si of the stocks price on a given day i is defined as the maximum number of consecutive days just before
the given day, for which the price of the stock on the given day is less than or equal to its price on the current day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for
corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Example 1:
Input:
N = 7, price[] = [100 80 60 70 60 75 85]
Output:
1 1 1 2 1 4 6
Explanation:
Traversing the given input span
100 is greater than equal to 100 and there are no more elements behind it so the span is 1,
80 is greater than equal to 80 and smaller than 100 so the span is 1,
60 is greater than equal to 60 and smaller than 80 so the span is 1,
70 is greater than equal to 60,70 and smaller than 80 so the span is 2,
60 is greater than equal to 60 and smaller than 70 so the span is 1,
75 is greater than equal to 60,70,60,75 and smaller than 100 so the span is 4,
85 is greater than equal to 80,60,70,60,75,85 and smaller than 100 so the span is 6.
Hence the output will be 1 1 1 2 1 4 6.
Example 2:
Input:
N = 6, price[] = [10 4 5 90 120 80]
Output:
1 1 2 4 5 1
Explanation:
Traversing the given input span
10 is greater than equal to 10 and there are no more elements behind it so the span is 1,
4 is greater than equal to 4 and smaller than 10 so the span is 1,
5 is greater than equal to 4,5 and smaller than 10 so the span is 2,
90 is greater than equal to all previous elements so the span is 4,
120 is greater than equal to all previous elements so the span is 5,
80 is greater than equal to 80 and smaller than 120 so the span is 1,
Hence the output will be 1 1 2 4 5 1.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 10^5
1 ≤ C[i] ≤ 10^5
 */

import java.util.Stack;

public class MS03NearestGreaterOnLeft {
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        // Your code here
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[price.length];

        if(price.length==1){
            ans[0] = 1;
            return ans;
        }

        st.push(0);
        // Span value of first element is always 1
        ans[0] = 1;

        for(int i=1;i<price.length;i++){
            while(!st.isEmpty() && price[i]>=price[st.peek()]) st.pop();

            // if above is not the case for A[i], then simply 1st store the ans.
            ans[i] = st.isEmpty()?i+1:i-st.peek();

            // now adding the index A[i] to the stack.
            st.push(i);
        }
        return ans;
    }
}
