package org.allTopics.BinarySearch;

// Problem Link:- https://leetcode.com/problems/single-element-in-a-sorted-array/description/

/*
Problem Description :-
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one
element which appears exactly once.
Return the single element that appears only once.
Your solution must run in O(log n) time and O(1) space.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10

Constraints:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
 */

public class BS3SingleElementInSortedArray {
    public int singleNonDuplicate(int[] A) {
        int s=0;
        int e=A.length-1;
        int mid=0;
        int ans=-1;
        int fo=0;

        if(A.length==1) return A[0];

        while(s<=e){

            if(A[0]!=A[1]) return A[0];
            else if(A[A.length-1]!=A[A.length-2]) return A[A.length-1];

            mid=(e-s)/2 + s;

            if(A[mid]!=A[mid-1] && A[mid]!= A[mid+1]) return A[mid];

            else if(A[mid]==A[mid-1]) fo=mid-1;
            else if(A[mid]==A[mid+1]) fo=mid;

            // if fo is even, i.e. wo single elem ke left side fall kr rha h
            // else right side fall kr rha h
            if(fo%2==0) s=mid+1;
            else{e=mid-1;}

        }
        return ans;

        // // efficient version of above code :-
        // if(A[0]!=A[1]) return A[0];
        // else if(A[A.length-1]!=A[A.length-2]) return A[A.length-1];

        // while(s<=e){

        //     mid=(e-s)/2 + s;

        //     if(A[mid]!=A[mid-1] && A[mid]!= A[mid+1]) return A[mid];

        //     else if ((A[mid] == A[mid + 1] && mid % 2 == 0) || (A[mid] == A[mid - 1] && mid % 2 != 0))
        //         {s = mid + 1;}
        //     else{e=mid-1;}

        // }
        // return -1;
    }
}
