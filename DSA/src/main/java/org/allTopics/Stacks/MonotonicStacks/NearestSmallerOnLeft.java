package org.allTopics.Stacks.MonotonicStacks;

// Problem Link:- https://www.geeksforgeeks.org/problems/smallest-number-on-left3403

/*
Given an array a of integers of length n, find the nearest smaller number for every element such that the smaller
element is on left side.If no small element present on the left print -1.

Example 1:
Input: n = 3
a = {1, 6, 2}
Output: -1 1 1
Explanation: There is no number at the
left of 1. Smaller number than 6 and 2 is 1.
Example 2:
Input: n = 6
a = {1, 5, 0, 3, 4, 5}
Output: -1 1 -1 0 3 4
Explanation: Upto 3 it is easy to see
the smaller numbers. But for 4 the smaller
numbers are 1, 0 and 3. But among them 3
is closest. Similarly, for 5 it is 4.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 10000
0 ≤ a[i] ≤ 10^4

 */

import java.util.Stack;

public class NearestSmallerOnLeft {
    public int[] prevSmaller(int[] A) {

        /*
        BruteForce Approach:- TC:- O(N^2), SC:- O(1)
        // Start from second element
        for (int i = 1; i < n; i++) {
            // look for smaller element on left of 'i'
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    System.out.print(arr[j] + ", ");
                    break;
                }
            }
            // If there is no smaller element on left of 'i'
            if (j == -1)
                System.out.print("_, ");
        }
         */

        /*
        Approach for finding nearest smaller in left side:-
         It's very simple and intuitive. need to apply some common sense. just read below steps.
         - for each i in array, if it is smaller or equal to the stack top element,
              - then I have to remove all the elems from stack which are greater than arr[i] and then
                need to add curr elem which is smaller, ryt (bec for next all the
                element now this curr elem will be considered as nearest smaller)
         - else if curr elem i.e. ith elem of arr is greater than the stack top elem, then we don't need to do
           anything ryt. simply we can take the elem from stack top and add it as ans[i].{if stack is empty then we can
           add -1}.
         - And then we jut need to add the curr elem to the stack. bec this is the only case which is remaining. if you
           see in above steps, no where yet we have added the elem to the stack. So we have to add it at the end or
           before starting the next iteration of for loop.
         */

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[A.length];

        if(A.length==1){
            ans[0] = -1;
            return ans;
        }
        for(int i=0;i<A.length;i++){
            while( !st.isEmpty() && A[i]<=A[st.peek()]) st.pop();

            // if above is not the case for A[i], then simply 1st store the ans.
            ans[i] = st.isEmpty()?-1:A[st.peek()];

            // now adding the index A[i] to the stack.
            st.push(i);
        }
        return ans;
    }
}
