package org.allTopics.SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

// Q - 4) Maximum of all subarrays of size K
// Problem Link:- https://leetcode.com/problems/sliding-window-maximum/description/

// Problem Statement:-
/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very
left of the array to the very right. You can only see the k numbers in the window. Each time the sliding
window moves right by one position. Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length

 */

public class SW04SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // Intuition:-
        /*
        // Why we are using queue data structure here instead of simply using one max variable or
        // 2 variables 1st to store max and 2nd to store secondMax?
        // Please understand, here we can use max variable. but the point when we are sliding the
        // window (i.e. i++), at that time if the element at i is maximum and we are sliding to next
        // elem. it means that elem on previous i is not now max in new window. so we need to remove
        // it ryt. and at that time we want 2nd maximum, or we can say maximum from remaining window
        // element before adding new element to window(i.e. before j++).  so here if we are using
        // 2nd max variable then it will store it for 1st window only. then but we want this thing to be
        // done for each and every window on which we are iterating. so we have to store max and all
        // the smaller than max from ryt side of jth element. that's why we can't use just simply 2
        // variables and instead we are using doubly ended queue open from both ends.

         */

        // ArrayList<Integer> ans = new ArrayList<>(); // To store answer
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> queue = new LinkedList<>(); // doubly ended open queue from both sides
        int i=0;
        int j=0;
        while(j<nums.length){

            // Calculations:-
            // So in calculation what we need to do is, we have to put the element in the queue
            // data structure. but main thing is we don't want to put all the elems in the queue
            // ryt? we want to put all the smaller element from j and of right side of j only from
            // current one window. not the left side of smaller elements.

            // To remove elems
            while(queue.size() > 0 && queue.peekLast()<nums[j]){
                queue.removeLast();
            }
            // Adding max to queue
            queue.addLast(nums[j]);

            // As discussed, we will be having max always at front of queue, hence picking it and
            // adding it to final answer ds.
            // ans.add(queue.peekFirst());

            if(j-i+1<k) j++;

            else if(j-i+1==k){
                // 1) fetching ans from calculation.
                // ans.add(queue.peekFirst());
                ans[i] = queue.peekFirst();

                // 2) Nullyfying impact of previous i
                if(queue.peekFirst()==nums[i]){
                    queue.removeFirst();
                }
                // 3) Slide the window
                i++;
                j++;
            }
        }

        // Integer[] ans1 = ans.toArray();
        return ans;

// Below code is failing at line 389, don't know why...
//        int max=arr[0];
//        List<Integer> maxis = new ArrayList<>();
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        // For the 1st window
//        for(int i=0;i<k;i++){
//            if(arr[i]>max) max=arr[i];
//        }
//        maxis.add(max);
//
//        // for remaining windows
//        int z=0;
//        int i = 1;
//        int j = k;
//        while(j<n){
//            if(arr[j]>maxis.get(0)) maxis.add(arr[j]);
//            // Fetching ans from calculations done so far.
//            ans.add(maxis.get(0));
//            // nullyfying the impact of prev i
//            if(arr[i]>=maxis.get(0)) maxis.remove(0);
//            // Sliding the window
//            i++;
//            j++;
//        }
//        return ans;
    }
}
