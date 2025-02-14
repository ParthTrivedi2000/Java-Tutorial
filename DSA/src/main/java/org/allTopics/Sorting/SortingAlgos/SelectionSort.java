package org.allTopics.Sorting.SortingAlgos;

public class SelectionSort {

    /*
    Appraoch is again very simple.
    So in selection sort, we are finding the min element in each iteration and place it at the starting of the array.
    - So here what happens is, with each iteration my array got sorted from left side (unlike array got sorted from
    right side in case of bubble sort).
    - And if you notice here, always it took O(N^2) means it is not ip dependent.
     */
    public void selectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            // take minIndexed elem and put it at starting place. i.e swap it
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
