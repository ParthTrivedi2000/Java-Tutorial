package org.allTopics.Stacks.MonotonicStacks;

// Problem Link:- https://www.scaler.com/academy/mentee-dashboard/class/215156/assignment/problems/7042/?navref=cl_pb_nv_tb

//Actually this is very important problem. below are the almost similar problems links as above. just need to do some
//minor changes like >= or<= or instead of -1, need to provide arr.length as ending elem etc etc.
//So below problems require only minor tweaks but still not able to do it. So pasting here scaler's problme link.
//Once you will be able to do it on leetcode pls change this question with that quesion of leetcode.

//Links:-
/*
https://leetcode.com/problems/sum-of-subarray-ranges/
https://leetcode.com/problems/sum-of-subarray-minimums/
https://leetcode.com/problems/sum-of-total-strength-of-wizards/description/
https://leetcode.com/problems/number-of-visible-people-in-a-queue/description/
https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/description/
https://leetcode.com/problems/next-greater-element-i/

 */

// Final working code with leetcode link:-
// Problem Link:- https://leetcode.com/problems/sum-of-subarray-ranges/

/*
You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest
element in the subarray.
Return the sum of all subarray ranges of nums.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:
Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:
Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.

Constraints:
1 <= nums.length <= 1000
-10^9 <= nums[i] <= 10^9

Follow-up: Could you find a solution with O(n) time complexity?
 */

import java.util.Stack;

public class MaxAndMin {
    public long subArrayRanges(int[] nums) {
        long[] nextGreaterLeft = nextGreaterLeft(nums);
        long[] nextGreaterRight = nextGreaterRight(nums);
        long[] nextSmallerLeft = nextSmallerLeft(nums);
        long[] nextSmallerRight =  nextSmallerRight(nums);

        long MOD = 1000000007;
        long sum = 0L;

        for(int i=0;i<nums.length;i++){
            // long leftGreater = i - nextGreaterLeft[i];
            // long rightGreater = nextGreaterRight[i] - i;
            // long leftSmaller = i - nextSmallerLeft[i];
            // long rightSmaller = nextSmallerRight[i] - i;

            // long max = (leftGreater * rightGreater) % MOD;
            // long min = (leftSmaller * rightSmaller) % MOD;

            // long contribution = (max * nums[i] % MOD - min * nums[i] % MOD + MOD) % MOD;
            // sum = (sum + contribution) % MOD;

            // // sum += (nums[i] * (max-min));

            sum+= (nums[i]*((nextGreaterLeft[i]*nextGreaterRight[i])-(nextSmallerLeft[i]*nextSmallerRight[i])));
        }
        return (long)sum;
    }

    public long[] nextGreaterRight(int[] A) {
        Stack<Integer> st = new Stack<>();
        long[] ans = new long[A.length];
        for(int i=A.length-1;i>=0;i--){
            while( !st.isEmpty() && A[i]>A[st.peek()]) st.pop();
            // ans[i] = st.isEmpty()?A.length:st.peek();
            ans[i] = st.isEmpty()?A.length-i:st.peek()-i;
            st.push(i);
        }
        return ans;
    }

    public long[] nextGreaterLeft(int[] A) {
        Stack<Integer> st = new Stack<>();
        long[] ans = new long[A.length];
        for(int i=0;i<A.length;i++){
            while( !st.isEmpty() && A[i]>=A[st.peek()]) st.pop();
            // ans[i] = st.isEmpty()?-1:st.peek();
            ans[i] = st.isEmpty()?i+1:i-st.peek();
            st.push(i);
        }
        return ans;
    }


    public long[] nextSmallerRight(int[] A) {
        Stack<Integer> st = new Stack<>();
        long[] ans = new long[A.length];
        for(int i=A.length-1;i>=0;i--){
            while( !st.isEmpty() && A[i]<A[st.peek()]) st.pop();
            // ans[i] = st.isEmpty()?A.length:st.peek();
            ans[i] = st.isEmpty()?A.length-i:st.peek()-i;
            st.push(i);
        }
        return ans;
    }

    public long[] nextSmallerLeft(int[] A) {
        Stack<Integer> st = new Stack<>();
        long[] ans = new long[A.length];
        for(int i=0;i<A.length;i++){
            while( !st.isEmpty() && A[i]<=A[st.peek()]) st.pop();
            // ans[i] = st.isEmpty()?-1:st.peek();
            ans[i] = st.isEmpty()?i+1:i-st.peek();
            st.push(i);
        }
        return ans;
    }
}

/*
public class Solution {
    public long[] nextGreaterRight(int[] A) {
        Stack<Integer> st = new Stack<>();
        long[] ans = new long[A.length];
        for(int i=A.length-1;i>=0;i--){
            while( !st.isEmpty() && A[i]>A[st.peek()]) st.pop();
            ans[i] = st.isEmpty()?A.length:st.peek();
            st.push(i);
        }
        return ans;
    }

    public long[] nextSmallerRight(int[] A) {
        Stack<Integer> st = new Stack<>();
        long[] ans = new long[A.length];
        for(int i=A.length-1;i>=0;i--){
            while( !st.isEmpty() && A[i]<A[st.peek()]) st.pop();
            ans[i] = st.isEmpty()?A.length:st.peek();
            st.push(i);
        }
        return ans;
    }

    public long[] nextSmallerLeft(int[] A) {
        Stack<Integer> st = new Stack<>();
        long[] ans = new long[A.length];
        for(int i=0;i<A.length;i++){
            while( !st.isEmpty() && A[i]<A[st.peek()]) st.pop();
            ans[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }

    public long[] nextGreaterLeft(int[] A) {
        Stack<Integer> st = new Stack<>();
        long[] ans = new long[A.length];
        for(int i=0;i<A.length;i++){
            while( !st.isEmpty() && A[i]>A[st.peek()]) st.pop();
            ans[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }


    public int solve(int[] A) {
        long[] nextGreaterLeft = nextGreaterLeft(A);
        long[] nextGreaterRight = nextGreaterRight(A);
        long[] nextSmallerLeft = nextSmallerLeft(A);
        long[] nextSmallerRight =  nextSmallerRight(A);

        long sum = 0L;
        long max=0L;
        long min=0L;

        for(int i=0;i<A.length;i++){
            max = (i-nextGreaterLeft[i]) * (nextGreaterRight[i]-i);
            min = (i-nextSmallerLeft[i]) * (nextSmallerRight[i]-i);
            // sum += A[i] * (max-min);
            sum = (sum + ((long)A[i] * (max-min) % 1000000007) + 1000000007) % 1000000007;
        }
        return (int)(sum%1000000007);
    }
}
 */
