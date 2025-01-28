// Problem Link :-
// https://www.geeksforgeeks.org/problems/merge-sort/1

/*
Problem Description :-
Given an array arr[], its starting position l and its ending position r. Sort the array using the merge sort
algorithm.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Input: arr[] = [1, 3 , 2]
Output: [1, 2, 3]
Constraints:
1 <= arr.size() <= 10^5
1 <= arr[i] <= 10^5
 */

public class S03MergeSort {

    public void mergeSort(int[] A, int l, int r) {

        if (l == r) return; //it means only single element is there. hence this is the base case of the recursion.

        int mid = (l + r) / 2;
        mergeSort(A, l, mid);
        mergeSort(A, mid + 1, r);
        merge(A, l, mid, r);

    }

    public void merge(int[] A, int l, int mid, int r) {

        int i = l;
        int j = mid + 1;
        int index = 0;
        int[] ans = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (A[i] > A[j]) {
                ans[index] = A[j];
                j++;
                index++;
            } else {
                ans[index] = A[i];
                i++;
                index++;
            }
        }

        while (i <= mid) {
            ans[index] = A[i];
            i++;
            index++;
        }
        while (j <= r) {
            ans[index] = A[j];
            j++;
            index++;
        }

        for (int k = 0; k < ans.length; k++) {
            A[l + k] = ans[k];
        }
    }
}