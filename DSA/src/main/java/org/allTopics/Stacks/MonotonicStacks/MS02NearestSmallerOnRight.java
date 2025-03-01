package org.allTopics.Stacks.MonotonicStacks;

// Problem Link:- https://www.geeksforgeeks.org/problems/help-classmates--141631

/*
Professor X wants his students to help each other in the chemistry lab. He suggests that every student should help
out a classmate who scored less marks than him in chemistry and whose roll number appears after him. But the students
are lazy and they don't want to search too far. They each pick the first roll number after them that fits the criteria.
Find the marks of the classmate that each student picks.
Note: one student may be selected by multiple classmates.

Example 1:
Input: N = 5, arr[] = {3, 8, 5, 2, 25}
Output: 2 5 2 -1 -1
Explanation:
1. Roll number 1 has 3 marks. The first person
who has less marks than him is roll number 4,
who has 2 marks.
2. Roll number 2 has 8 marks, he helps student
with 5 marks.
3. Roll number 3 has 5 marks, he helps student
with 2 marks.
4. Roll number 4 and 5 can not pick anyone as
no student with higher roll number has lesser
marks than them. This is denoted by -1.
Output shows the marks of the weaker student that
each roll number helps in order. ie- 2,5,2,-1,-1

Example 2:
Input: N = 4, a[] = {1, 2, 3, 4}
Output: -1 -1 -1 -1
Explanation: As the marks ars in increasing order.
None of the students can find a classmate who has
a higher roll number and less marks than them.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 5*10^5
 */

import java.util.Stack;

public class MS02NearestSmallerOnRight {
    public static int[] help_classmate(int arr[], int n)
    {
        // Your code goes here
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];

        if(arr.length==1){
            ans[0]=-1;
            return ans;
        }

        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]) st.pop();

            // if above is not the case for A[i], then simply 1st store the ans.
            ans[i] = st.isEmpty()?-1:arr[st.peek()];

            // now adding the index A[i] to the stack.
            st.push(i);
        }
        return ans;
    }
}
