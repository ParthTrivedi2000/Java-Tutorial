// Problem Statement :- https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1

/*
Problem Description :-
Given two sorted arrays a[] and b[] of size n and m respectively, the task is to merge them in sorted order
without using any extra space. Modify a[] so that it contains the first n elements and modify b[] so that it
contains the last m elements.

Examples:
Input: a[] = [2, 4, 7, 10], b[] = [2, 3]
Output:
2 2 3 4
7 10
Explanation: After merging the two non-decreasing arrays, we get, 2 2 3 4 7 10
Input: a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]
Output:
1 2 3 5 8 9
10 13 15 20
Explanation: After merging two sorted arrays we get 1 2 3 5 8 9 10 13 15 20.
Input: a[] = [0, 1], b[] = [2, 3]
Output:
0 1
2 3
Explanation: After merging two sorted arrays we get 0 1 2 3.

Constraints:
1 <= a.size(), b.size() <= 10^5
0 <= a[i], b[i] <= 10^7

Expected Complexities:-
Time Complexity: O(nlogn + mlogm)Auxiliary Space: O(1)
 */

// Please go through the below links for more approaches and better understanding.
// https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
// https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/

/*
Approach :-
Please see very carefully.

Now 2 sorted arrays are given. We have to merge them without using any extra space.
suppose for example:-
arr1=[1,3,5,7]
arr2=[0,2,6,8,9]

- Now see, whatever info given in question, every info is very important.
It was given that both the arrays are already sorted, it means my elements in both array is arranged from lowest
to highest in each array ryt. So now suppose I want to compare the elements between 2 arrays, so obviuosly we will
start by comparing 1st element of each array.
- Now before moving ahead in the array, let me tell you how this sorted array info will be used to determine the
solution furhter. I want to put min 4 elements out of all the 9 elems into the arr1 ryt? and remaining 5 elems in
the arr2 ryt? but as we can see above, 2 min elems (1,3) are already present in the arr1. But remaining 2 min
elems (0,2) out of all the elems (arr1+arr2) are present in the array2. Now if you have been asked to remove any
element from arr1 and include this 1st min elem from arr2, then which one would you prefer to remvove from arr1
and replace with elem of arr2?
- Since array is sorted, hence we are 100% sure that last elem of array is already larger than all the previous 3
elem, so just mean to say is we will start removing elems from array1 from last and keep replacing with elems
of array2 in case of smaller elems present in the arr2.
- So we need to use 3-Pointer approach. 2 pointer each to place on starting for comparison purpose and 1 pointer
to place on last elem of arr1 for replacement during the comparison.
- And make sure to apply sort on each array after comparison got over. Bec if you see here, both arrays loose
their property of sorted elems as soon as you start replacing smaller elems at ends and vice versa in another
array, for examp after completion of comparison for above exa:-
arr1=[1,3,2,0], arr2=[7,5,6,8,9]
so at last sort both the arrays again. (Since here it was asked to optimise SC, we have to compromise
with TC).
- That's all. This was the logic.

Please see code for better understanding.
 */



class S02MergeTwoSortedArraysWithoutExtraSpace {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        // code here

        int i=0;
        int j=0;
        int k=a.length-1;

        // Since with each iteration i moves right side and k moves left side, so
        // we eed to stop where i and k won't cross bec after kth portion all the
        // elms are of arr2.
        // That is to limit i. Now what about to limit j. it is as usual.
        while(i<=k && j<b.length){
            // if my a[i] is smaller then keep continue i till i<=k
            if(a[i]<b[j]){
                i++;
                continue;
            }
            // if bth elem is smaller while comparing, then have to replace it with k
            else{
                int temp = a[k];
                a[k] = b[j];
                b[j] = temp;
                k--;
                j++;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }
}

// TC:- O((m+n)*(log(m+n))), SC:- O(1)