/*
Problem Description :-
Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
Note: A linear time complexity is expected and you should avoid use of any library function.

Problem Constraints
-2×10^9 <= A[i], B[i] <= 2×10^9
1 <= |A|, |B| <= 5×10^4


Input Format
First Argument is a 1-D array representing  A.
Second Argument is also a 1-D array representing B.

Output Format
Return a 1-D vector which you got after merging A and B.

Example Input
Input 1:
A = [4, 7, 9]
B = [2, 11, 19]
Input 2:
A = [1]
B = [2]

Example Output
Output 1:
[2, 4, 7, 9, 11, 19]
Output 2:
[1, 2]

Example Explanation
Explanation 1:
Merging A and B produces the output as described above.
Explanation 2:
 Merging A and B produces the output as described above.
 */

public class S01MergeTwoSortedArrays {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] mergeSortedArrays(final int[] A, final int[] B) {
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
            else{
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
}

// TC:- O(arr1.length + arr2.length)
// SC:- O(arr1.length + arr2.length)

// Please checkout below question:-
// Problem Statement:- https://leetcode.com/problems/merge-sorted-array/description/

/*
Problem Description :-
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To
accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

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
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit
in nums1.

Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-10^9 <= nums1[i], nums2[j] <= 10^9

Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // // Aprpoach - 1:- BruteForce Approach:-
        // // TC:- O(M+N)log(M+N)
        // // Append elements from nums2 into nums1 starting at index m
        // for (int i = 0; i < n; i++) {
        //     nums1[m + i] = nums2[i];
        // }
        // // Sort the combined array
        // Arrays.sort(nums1);


        // Approach - 2:- Optimised Approach:- Using 2 pointers
        int i=m-1;
        int j=n-1;
        int idx=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[idx]= nums1[i];
                i--;
            }
            else{
                nums1[idx]=nums2[j];
                j--;
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