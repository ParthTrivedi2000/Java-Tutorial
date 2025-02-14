package org.allTopics.Sorting.SortingAlgos;

/*
Sorting :- Sorting means basically systematic arrangement of objects means sorting.

Insertion Sort:-
- Insertion sort means picking up the element and putting it to the right/correct place inside the array.
Suppose you are having running stream of integers, i.e. ip is not fixed for you it's running stream. so each
new elem comes to you that you have to place at the correct position.

- Suppose 2 comes 1st. so you place 2 in the array at the 1st place since it is empty.
- Now 10 comes. so since new elem 10 is greater than the 2, you place it right side of the 2.
- then suppose 8 comes from stream. then where you will place the 8. so for 8, to maintain the order, you have to
shift all the elems greater than 8 to the right side bec you want to place 8 after the 2 but there is no space to put
it. So you shifted 10 to the right side and you placed 8 in between 2 and 10. great enough!
- now suppose 7 comes. So again you have to insert at it's correct place to maintain the order. And correct place is
just after 2 i.e. right side of 2. But there is no space at the right of the 2. So to make space, you have to shift
all the elems which are greater than the current elem those needs to be shifted to the right.
- So similarly process has been followed each time when new elem comes. SO what is the worst Time complexity to shift
the elems? --> here it was asked to find the woost TC so you can think of if new elem comes is 1, then all the n elems
present currently inside the array needs to be shifter. Hence it's O(N) for shifting in worst case.
- So what is the total overall Time Complexity of Insertion Sort? --> Since O(N) for shifting. and there can be n elems
comes one by one...so total TC of Insertion Sort is:- O(N^2)

- So you might be having doubt like since array is in sorted form, so if I want to insert 7 in the array, can't I use
the Binary search ?
--> very good and obviously valid thought. But see in programming we perform everthing if it gives us some advantage
or benifits. but here if I will try to find the correct position of 7 using Binary search then also after finding
correct position, anyhow I have to shift all the greater elements to the right side so anyhow it will take O(N) and
eventually we are supposing to come N numbers from stream so total TC won't get improved. it will be as it is of
O(N^2). So we won't use BS to find the correct position. instead we will use the simple comparison between new elem
and the current elem of the array.

APPROACH :-
- so for any new element to be inserted, start checking (iterating) array from last elem. check if that element is
greater then the new element. if yes, it needs to be shifted to the right side. And do i--. So now i will be at
2nd last elem. And check for that element like is it greater than the new elem? if yes then move it to the i+1 position.
if it's not greater then we don't need to shift that element to the i+1 position instead we will place out new element
to the i+1 place. S basically we will be looking for the 1st smaller (or equal) of new element and place our new
element over there. And remaining greater element to be shifted right side (for ascending order sort).

- Just a small question, can't we traverse from beginning of the array instead of last?
--> yes certainly we can, but here as it was asked to sort in ascending order, hence shofting happens for greater elems
and in sorted array greater elems present at the lasts of the array. And if you have start traversing from starting
there is no issue, eventually ans will be same, but for each new element you have to traverse for whole array elements
if you start traersing from beggning. so it is not good idea. hence we hasve started traversing from end to just
save few more operations for TC.

- So insertion sort is, find the position and insert there.
 */

public class NewSorting {

    // Insertion Sort:- TC:-O(N^2), SC:-O(1)
    public void insertionSort(int[] arr){
        // Consider 0th place is sorted. so my left side elems are sorted. and right side elems are unsorted. And now
        // I am start sorting the array. I am placing my j pointer to 0th index. And start comparing elems from 1st idx.
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int newElem = arr[i];
            // Why I have to store ith elem into another variable? --> bec as if my ith element is not greater than
            // the currently available jth element then, I have to j to the right side ryt? and as soon as I will
            // shift it to the right side, I will loose the value at ith position. So 1st stored it into another
            // variable.

            // Now i have to compare the ith elem to jth elem. And till what time I have to compare and shift jth elem?
            // till the moment I wpn't find any jth elem which is smaller than ith elem/ or j goes beyond the array
            // start index.
            while(arr[j]>arr[i] && j>=0){
                // if above condition is the case, then I have to shift the j to the right side ryt to make place for
                // current ith element.
                arr[j+1] = arr[j];
                j--;
            }
            // Once I will shift the elems which are greater than the ith element, then i have to put the ith element
            // at (j+1)th place ryt (be careful over here. not on the jth place, bec after shifting you are already
            // doing j--. i.e. once my loop broke, at that time j ki value already ek less ho chuki hogi so I have to
            // insert the ith elem at j+1th place).
            arr[j+1] = newElem;
        }
    }

    public void insertionSortDecreasing(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int newElem = arr[i];
            while(arr[j]<arr[i] && j>=0){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = newElem;
        }
    }


    // Selection Sort:- TC:-O(N^2), SC:-O(1)
    // In selection sort, simple logic we are applying. like we will find the min element from the array and place it
    // at start idx of array. now move ahead and increase the i++. So now startIdx of array is i=1. and again it's
    // left part is already sorted. So from the remaining array i.e. from i=1 to n, we need to find the minimum
    // elem and need to swap with the ith elem i.e. starting idx of the array. this process we will keep continue till
    // last element of the array.
    public void selectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            // find the minimum from the array from the remaining right side of the array.
            int mini = arr[i];
            int minIdx = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<mini){
                    mini = arr[j];
                    minIdx=j;
                }
            }
            // Once min element is found, as per the algorithm, it should be swapped with the current i.
            int temp = i;
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    // So above is the normal/unidirectional selection sort. but there is also Bi-Directional Selection sort which
    // is optimised version of the selection sort algo.
    // So basically how we are optimising the selection sort algo is, it finds the min element from the remaining
    // array ryt. But now we will find the min and max bothe elems from the remaining array and place it at
    // starting and ending idx of the array. so in this case, previously we were using inner loop to find only
    // min elem from the remaining array. but here we are using the same inner loop to find the max elem also from the
    // array.
    public void biDirectionalSelectionSort(int[] arr){
        int k=arr.length-1;
        for(int i=0;i<k;i++,k--){
            int mini = arr[i];
            int minIdx = i;

            int maxi = arr[i];
            int maxIdx = i;

            for(int j=i+1;j<=k;j++){
                if(arr[j]<mini){
                    mini = arr[j];
                    minIdx=j;
                }
                if(arr[j]>maxi){
                    maxi = arr[j];
                    maxIdx=j;
                }
            }

            // swapping
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;

            // for swapping  with max elem, we should take care of 1 edge case, where my minIdx and maxIdx is one after
            // another while converging. so we have to apply check for that.
            if(maxi== arr[minIdx]){
                temp = arr[k];
                arr[k] = arr[minIdx];
                arr[minIdx] = temp;
            }
            else{
                temp = arr[k];
                arr[k] = arr[maxIdx];
                arr[maxIdx] = temp;
            }
        }
    }



    // Bubble Sort:-
    // Bubble sort is based on passes & Pair wise sort. So during each pass, we will put max elem on the end of the
    // array. And exaclty what we are doing in passes? nothing just swap the elems based on the value. so for
    // starting from 1st 2 elems, if 1st is smaller, we will keep it as it is and move ahead. but if 1st is greater
    // then 2nd, then we can swap those 2 elems and then move ahead. so once we reach at the end, my last elem is in
    // sorted position. then in the next iteration, my 2nd last elem is also in the sorted and so on.
    public void bubbleSort(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            // for each pass, I have to take 2 pairs starting from 0, and do the swap in case 1st is greater. But
            // pls note here that this inner loop, we will do only till the last unsorted elem.
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    //swapping
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Optimised Bubble Sort:- so instead of performing pairwise comparison for each pass blindly, we will check
    // suppose durring any iteration, if I haven't perform any swapping then it means now remaining elems are
    // already in sorted position. so we can use the flag here. and at starting of each pass my flag should be false.
    // and if I will swap any pair, the I can make flag as true. so after completion of that iteration, I will check
    // if my flag remains as it is, i.e false, then we don't need to check for remaining all the iterations/passes bec
    // now remaining all the elems are already in sorted order.
    public void optmisedBubbleSort(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            // for each pass, I have to take 2 pairs starting from 0, and do the swap in case 1st is greater. But
            // pls note here that this inner loop, we will do only till the last unsorted elem.
            boolean flg = false;
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    //swapping
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    flg=true;
                }
            }
            if(flg==false) break;
        }
    }
}
