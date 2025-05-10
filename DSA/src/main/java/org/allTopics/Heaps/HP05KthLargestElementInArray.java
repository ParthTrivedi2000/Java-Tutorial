package org.allTopics.Heaps;

// Problem Link :- https://leetcode.com/problems/kth-largest-element-in-an-array/description/

// Problem Description :-
/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4

 */

import java.util.PriorityQueue;

public class HP05KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        /*
         // Approach - 1:- Using sorting :-
         // TC:- O(NlogN), SC:-O(1);
         Arrays.sort(nums);
         return nums[nums.length-k];

         Approach - 2:- Using BinarySearch
         Similar as how we did question of find kth smallest using binary search.
         but currently I don't know how to do it. Just write code here for this approach
         later whenever you get time.

         Approach - 3:- Using HeapSort
         TC:- O(NlogN), SC:- O(1)

         */

        // Approach - 4:- Using MinHeap to find the max/larget elem
        // TC:- O(KlogK) + O((N-K)logK) ~ O(NlogK), SC:- O(K)
        /*
         - Create an heap of only k size. means only add 1st k elems to the heap.
         - kth largest = n-kth smallest correct?!!
         - now for the remaining elems start checking with the heap.peek() which represent
         the minimum amongs the k elems.
         - if any new element is larger than peek of heap, then remove min elem from the
         heap & add this new elem to the heap.
         */


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++) pq.add(nums[i]);                  // O(KlogK), O(K)

        for(int i=k;i<nums.length;i++){                        // O((N-K)logK), O(1)
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
