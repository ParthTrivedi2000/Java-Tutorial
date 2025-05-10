package org.allTopics.Heaps;

// Q) Up-Heapify
// So heap is already given in the form of array. we need to insert a minimum element as new element in the heap.

import java.util.ArrayList;
import java.util.List;

public class HP01InsertMin_UpHeapify {

    public static void main(String[] args) {

        // Important Note:-
        /*
        Always remember this thing.
        - List<Integer> list = List.of(3,4,10,6,8,12,13,10,12); // this will create immutable list.
        (if you try to add element during your code, you will get UnsupportedOperationException error.
        - List<Integer> list = new ArrayList<>(); // it will create mutable list.
         */

        List<Integer> list = new ArrayList<>(List.of(3, 4, 10, 6, 8, 12, 13, 10, 12)); //

        insertMinElemInHeap(list,2);

        for(int elem : list) System.out.print(elem + " ");
    }


    public static void insertMinElemInHeap(List<Integer> heapArr, int element) {


        // Approach :-
        // - For any array if we add any new element at last then only it can add insertion complexity of
        // O(1). And since we want to maintain here O(1) complexity for heap's purpose to get min from O(1).
        // - So just adding element at the last.
        // - now just do check heapify property is maintained or not.

        heapArr.add(element);
        // this is an element at index i. we need to check weather it's parent has smaller value than this or not
        int idx = heapArr.size() - 1;
        while(idx >= 0) {
            // Step - 1:- get parent index
            int parentIdx = (idx - 1)/2;
            // step - 2:- check element at parentIdx. if it's smaller then fine, but if it's greater than
            // the current idx, then do swap them.
            if(heapArr.get(idx) < heapArr.get(parentIdx)) {
                //swapping
                int tmp = heapArr.get(idx);
                heapArr.set(idx, heapArr.get(parentIdx));
                heapArr.set(parentIdx, tmp);
                // decreasing idx
                idx = parentIdx;
            }
            else {break;}
        }
    }
}
