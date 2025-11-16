package org.allTopics.Heaps;

// Q) Delete-Min :- Down Heapify

import java.util.ArrayList;
import java.util.List;

public class HP02DeleteMin_DownHeapify {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(3, 4, 10, 6, 8, 12, 13, 10, 12)); // We are creating
        // immutable list, and then since we are wrapping it with mutable list constructor, final list will behave
        // as the mutable list only.

        deleteMinElemFromHeap(list,0);

        for(int elem : list) System.out.print(elem + " ");
    }

    public static void deleteMinElemFromHeap(List<Integer> list, int deleteElemIdx) {
        // Approach:- TC:- O(height of tree) = O(logN)
        /*
         - if we directly delete the minimum, then in array elems would get shifted it means it will increase the
         complexity. so 1st we should swap to last position.
         - now we just need to start checking heap property from 1st index.
         - like we can consider it as parent. hence child indexes (i.e. left & right would be basically needs to
         be checked with current parent index).
         - so till the moment left side elems get over in the heap tree, we should check.
         - during each comparison, each time we need to find the minimum out of (parentIdx, leftChild, rightChild)
         and out of which whichever is minimum, we should put it on parent's place. And you can move parentIdx to
         1 step ahead.

         */

        int temp = list.get(list.size()-1);
        list.set(list.size()-1, list.get(deleteElemIdx));
        list.set(deleteElemIdx, temp);

        // just removing last element, since we want to remove minimum from heap so.
        list.remove(list.size()-1);

        int parentIdx = deleteElemIdx;
        while(2*parentIdx+1 < list.size()-1){
            int leftChildIdx = 2*parentIdx+1; // to get left child of parent from array
            int rightChildIdx = 2*parentIdx+2; // to get the right child from array

            int minElem = Math.min(Math.min(list.get(leftChildIdx), list.get(rightChildIdx)), list.get(parentIdx));
            if(minElem == list.get(parentIdx)) {break;} // bec elem which needs to be deleted is already maintaining heap property.
            else if(minElem == list.get(leftChildIdx)) {
                // swap with left child
                int temporary = list.get(parentIdx);
                list.set(parentIdx, list.get(leftChildIdx));
                list.set(leftChildIdx, temporary);
                parentIdx = leftChildIdx;
            }
            else{
                // swap with right child
                int temporary = list.get(parentIdx);
                list.set(parentIdx, list.get(rightChildIdx));
                list.set(rightChildIdx, temporary);
                parentIdx = rightChildIdx;
            }
        }
    }
}
