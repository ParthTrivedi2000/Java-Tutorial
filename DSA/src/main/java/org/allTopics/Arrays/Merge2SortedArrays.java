package org.allTopics.Arrays;

// Problem Link:- https://leetcode.com/problems/merge-sorted-array
/* Problem Description :-
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To
accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-10^9 <= nums1[i], nums2[j] <= 10^9

Follow up: Can you come up with an algorithm that runs in O(m + n) time?

 */

// There are so many approaches. Please go through below link and list out all the approaches here in your free time.
// Link to merge 2 unsorted Arrays:- https://www.geeksforgeeks.org/merge-two-sorted-arrays/
// link to merge 2 sorted arrays:- https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/

import java.util.Arrays;

public class Merge2SortedArrays {

    // Approach - 1:- Using an extra Array to store the final result.
    // TC:- O(M+N)
    // SC:- O(M+N)
    public int[] solve(final int[] A, final int[] B) {
        int n1 = A.length;
        int n2 = B.length;
        int[] ans = new int[n1+n2];

        int i=0;
        int j=0;
        int index=0;
        while(i<n1 && j<n2){
            if(A[i]<B[j]){
                ans[index] = A[i];
                index++;
                i++;
            }
            else{ //if(A[i]>B[j]){
                ans[index] = B[j];
                index++;
                j++;
            }
        }
        while(i<n1){
            ans[index] = A[i];
            index++;
            i++;
        }
        while(j<n2){
            ans[index] = B[j];
            index++;
            j++;
        }
        return ans;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Approach - 2:- Bruteforce Approach:- Bruteforce Approach is to merge both the arrays and sort the array
        // 1 and return it.
        // TC:- O(M+N)log(M+N)
        // SC:- O(1)
        /*
        // Append elements from nums2 into nums1 starting at index m
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        // Sort the combined array
        Arrays.sort(nums1);
         */

        // Approach - 3:- Optimised Approach Using 2 pointers.
        //TC:- O(M+N)
        //SC:- O(1)
        int i=m-1;
        int j=n-1;
        int idx=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[idx]= nums1[i];
                i--;
                // idx--;
            }
            else{
                nums1[idx]=nums2[j];
                j--;
                // idx--;
            }
            idx--;
        }

        while(i>=0){
            nums1[idx]=nums1[i];
            i--;
            idx--;
        }
        while(j>=0){
            nums1[idx]=nums2[j];
            j--;
            idx--;
        }
    }

}
