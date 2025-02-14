package org.allTopics.Sorting.SortingAlgos;

public class InsertionSort {

    /*
    So Insertion sort can be used in the cases where entire array is not there with you at starting. For example
    if you want to sort Stream of inputs, then in this case you don't have entire ip with you at starting. means you
    are having only few elems of input and as soon as new elems comes, you need to insert it at it's correct position
    in the array. This is the Insertion Sort algo.
     */
    public void inserionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int newElem = arr[i];
            while(arr[j]>arr[i] && j>=0){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = newElem;
        }
    }
}
