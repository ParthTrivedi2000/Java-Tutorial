package org.allTopics.Sorting.SortingAlgos;

public class BubbleSort {

    /*
    So bubble sort is the most simplest of all the sorting algo. We have used very normal thinking / common sense here.
    So simply bubble sort uses transitive property of math. it means simply we are comparing 2 adjacents elems each
    time and whichever is greater, that we will put on right side.
    So we can see that after completion of 1st iteration my larger/max elem comes to it's correct i.e. the end/rightmost
    place in array.

    arr = [5,1,4,2,3] ==>
    after 1st iteration :- [1,4,2,3,5]
    after 2nd iteration :- [1,2,3,4,5]
    same for next iterations

    - So just means to say is, with each iteration, max elems started taking place from end of the array.
    - In comparison of other basic sorting algo, this bubble sort can be preferred, bec here suppose if sorted
    arr is given in the ip, then by maintaining the swap flag you can break the loop and TC would be O(N) in this
    case which is best case. Now if ip arr given with exactly opposite, i.e. in sorted decreasing order, then need
    to perform all the iterations so worst case would be O(N^2).
    - Since this algo can give best/avg/worst TC based on the ip arr given, so this is also called ip dependent algo.

     */

    public void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            boolean swap = false;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    //swap elems
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(swap==false) break;
        }
    }

}
