package org.allTopics.Sorting.SortingAlgos;

import java.util.ArrayList;

public class Sorting {
    /* Bubble Sort:-
- It is not Efficient Algorithm.
- But it is easy to understand.

Working:-
- From the name itself, like you just need to put elem into bubble and compare it with another element,
then shift it to the end. Suppose given array is [8,6,9,2,4,5]. O/p would be:- [2,4,5,6,8,9].

So what we will do it, we will start comparing 2 elements from starting of the array. you need to swap
the greater element with the smaller one. So after completion of 1st Iteration, your maximum value of the
array shifted to the last position of the Array.
Now again for the 2nd Iteration, we will perform the same step. Start comparing 2 values, if value is
greater, then we need to swap it else skip swapping. And just move ahead. So after 2nd iteration, your
2nd max element is shifted to 2nd last position.
So in each iteration greater elements are shifted to last of the array. And eventually whole array
will be sorted.
TC:- O(N^2)
     */
    public int[] bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

/* Selection Sort:-
- Using Selection sort, we won't reduce the time complexity from O(N^2) to something. But we just improves
the bubble sort by doing somewhat less operation then bubble sort.
- So in bubble sort we are performing swapping everytime ryt. But here what we will do, we can pick either
max/min from the array (either of the value would be fine. means if you select min, then we should start
putting it at start of the array. If you pick max from array, we should start putting it at the end of
an array). Suppos we choose min value.
- So now from the name itself, I should select place to put the element. Now as it is minimum & we are
trying to sort in ascending order, then min value should be swapped with the 1st element present in the
array.
- Then we can find the minimum from remaining element, and we can swap it with the 2nd element of the arr.
- So here what we are doing is selecting minimum value hence the name.
[6,5,2,8,9,4]
So from the example you can see, like we are not swapping the values everytime. instead we swap only
once in 1st iteration. then 2nd time in whole 2nd iteration...Same thing we will do till the end of
sorted array. like everytime i will assume 1st elem as the max, then comparing with all the next elems.
If next elem is smaller, then it's fine, else I will say yes next elem you are greater than me so
max would be my that element. then once iteration will end we can swap it with the last value of array.
- hence during each pass we are performing swapping only once which is at last. And remember in this
case as well elements are start sorting from last in each iteration in case we have choosen our max
elem to start with. So eventually we required 2 nested loops.
- Hence TC:- O(N^2). But yes this also has quadratic TC bt still better than Bubble sort as per the
operations we have performed.
 */
    public int[] selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int maxi = arr[0];
            for(int j=1;j<arr.length;j++){
                if(arr[j]>maxi) maxi=arr[j];
            }
            // Once comparison is over, now we will perform swapping of this max element with last
            // element of the array.
            int temp=arr[arr.length-1-i];
            arr[arr.length-1-i] = maxi;
            maxi=temp;
        }
        return arr;
    }

/* Insertion Sort:-
- So insertion sort is basically, we will be having an array. we pick element and we insert the element
at it's correct position in the array. That is insertion sort.
- Actually we won't swap in array. I mean we swap but we call it as shifting.
- So we will start from 2nd element. we are assuming the 1st part of array is sorted i.e. here 1st elem
is sorted that's what we are assuming. and then we will start from 2nd element to pick and start comparing
from 1st elem. weather elem needs to be inserted there or not. if yes, we shift that element to next location
and put current element over there.
 */
    public int[] insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j=i-1;
            while(arr[j]>key && j>=0){
                // shifting operation
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

/* Quick Sort
- Best/Average case TC:- O(nlog(n))
- worst case TC:- O(N^2)

What Quick Sort is?
- So till now in bubble/selection/insertion sort what we were doing is we were performing everything on whole
single array. But Quick sort, it says to use Divide & Conquer. i.e. we won't operate on whole array but
instead we will divide the array and sort it and then merge it.
- Next thing it uses is, Recursion.
- Next thing it uses is Pivot:- Pivot means central point of the problem.

Ok so quick sort uses this 3 main concept of Divide & conquer, Recursion and Pivot.
Let's see how actually it uses these 3 things to sort.

- So now we want to divide the array. but I can't do it randomly. So how to divide array everytime?
that's where Pivot comes into the picture. So pivot should be decided such that it is at right position
in the array.

 */
    public static void quickSort(int[] arr, int low, int high){

    }

    public static void main(String[] args){
        int[] arr = {5,7,3,8,2,1};

        quickSort(arr,0,arr.length-1);


    }


/*
Sort an array using recursion only. --> from Aditya Verma's Recursion series.
Solution is giving TLE.
 */
//class Solution {
//    public void sort(List V){
//        if(V.size() == 1) return;
//        int temp = V.get(V.size() - 1);
//        V.remove(V.size() - 1);
//        sort(V);
//        insertElement(V, temp);
//        return;
//    }
//    public void insertElement(List V, int temp){
//        if(V.size() == 0 || V.get(V.size() -1 ) <= temp){
//            V.add(temp);
//            return;
//        }
//        int last = V.get(V.size() - 1);
//        V.remove(V.size() - 1);
//        insertElement(V, temp);
//        V.add(last);
//        return;
//    }
//    public int[] sortArray(int[] nums) {
//        List<Integer> V = new LinkedList<>();
//        for(int i = 0;  i< nums.length; i++){
//            V.add(nums[i]);
//        }
//        sort(V);
//        int[] ans = new int[V.size()];
//        for(int i =0; i < V.size() ;i++){
//            ans[i] = V.get(i);
//        }
//        return ans;
//    }

/* Working code
    // Java code for recursiely sorting an arrar:
    public class Main {
        public static void main(String[] args) {
            ArrayList arr = new ArrayList(
                    Arrays.asList(3,2,1,4,5,6,7)
            );
            arr = sort(arr);
            System.out.println(arr);

        }
        public static ArrayList sort(ArrayList arr){
            if(arr.size()==1){
                return arr;
            }
            int temp = (int)arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            arr = sort(arr);
            arr  = insert(arr,temp);
            return arr;
        }
        public static ArrayList insert(ArrayList arr,int temp){
            if(arr.size()==0 ){//|| (int)arr.get(arr.size()-1)temp){
                arr.add(temp);
                return arr;
            }else if((int)arr.get(0)>=temp){
                arr.add(0,temp);
                return arr;
            }else if((int)arr.get(arr.size()-1)<=temp){
                arr.add(arr.size(),temp);
                return arr;
            }
            int temp1 =(int) arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            arr = insert(arr,temp);
            arr.add(arr.size(),temp1);
            return arr;
        }

    }

 */

/* Solely by me only
    public ArrayList<Integer> recursiveSort(ArrayList<Integer> al){
        if(al.size()==1) return al;
        int lastElem = al.get(al.size()-1);
        al.remove(al.size()-1);
        recursiveSort(al);
        // putting back the removed element. / we can say this is the main induction step.
        insert(al,lastElem);
    }

    public ArrayList<Integer> insert(ArrayList<Integer> al,int elem){
        if(al.size()==0 || elem>=al.get(al.size()-1)){
            al.add(elem);
            return al;
        }
        // Else during normal scenario [0,1,5], elem=2 --> then I have to remove last elem and call insert
        // method again with smaller i/p. And then put this removed element at the last again once insert()
        // method returns me the updated sorted list.
        int removedElem = al.get(al.size()-1);
        al.remove(al.size()-1);
        insert(al,elem);
        al.add(removedElem);
    }

 */
}
