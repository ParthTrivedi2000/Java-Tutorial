package org.allTopics.Heaps;

// Problem Link :- https://www.geeksforgeeks.org/problems/heap-sort/1

// Problem Description :-
/*
Heap Sort

Given an array arr[]. The task is to sort the array elements by Heap Sort.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: After sorting elements using heap sort, elements will be in order as 1, 3, 4, 7, 9.
Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Explanation: After sorting elements using heap sort, elements will be in order as 1, 2, 3, 4, 5, 6, 7, 8, 9, 10.
Input: arr[] = [2, 1, 5]
Output: [1, 2, 5]
Explanation: After sorting elements using heap sort, elements will be in order as 1, 2, 5.
Constraints:
1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^6

Expected Complexities
Time Complexity: O(n log n)
Auxiliary Space: O(1)

Company Tags
Amazon Microsoft Samsung 24*7_Innovation_Labs Oracle Visa Intuit SAP_Labs Belzabar
 */

public class HP04HeapSort {
    public void heapSort(int arr[]) {

        // Approach :- Using Max Heap :- TC:- O(NlogN) + O(N) ~ O(NlogN), SC:- O(1)
        // Steps:-
        // 1) build max heap for an array.
        // 2) then just do find max elem from heap & swap it with last elem.
        // 3) now do downHeapify from 1st to n-2th index in heap.
        // 4) continue this process till 1 elem remains in the array.

        // Note:-
        // - Heap Sort is In-Place sorting Algo ? --> yes, since we are not using any extra space.
        // - Heap Sort is stable sorting algo? --> No, it's not, since in case of 2 same values, their
        // relative order may be changed during heapification process.


        buildHeap(arr); // TC:- O(N), SC:- O(1)

        // TC:- O(NlogN), SC:- O(1)
        int tillIdx = arr.length-1;

        while(tillIdx>0){
            swap(arr, 0, tillIdx);
            tillIdx--;
            downHeapify(arr,0, tillIdx);
        }

    }

    public void buildHeap(int[] arr){
        // start from 1st nonleafNode & do downHeapify
        for(int i=(arr.length-1-1)/2;i>=0;i--) downHeapify(arr,i,arr.length-1);

    }

    public void downHeapify(int[] arr, int start, int end){
        while(2*start+1<=end){
            int leftChildIdx = 2*start+1;
            int rightChildIdx = 2*start+2;

            int maxElem = Math.max(arr[start], arr[leftChildIdx]);
            // now if right child exist, then only check max for that
            if(2*start+2<=end) maxElem=Math.max(maxElem, arr[rightChildIdx]);

            // now do check heap Properties
            if(maxElem==arr[start]) break;
            else if(maxElem == arr[leftChildIdx]){
                swap(arr,start,leftChildIdx);
                start = leftChildIdx;
            }
            else{
                swap(arr,start,rightChildIdx);
                start=rightChildIdx;
            }
        }
    }

    public void swap(int arr[], int first, int second){
        int temp = arr[first];
        arr[first]  = arr[second];
        arr[second] = temp;
    }
}
