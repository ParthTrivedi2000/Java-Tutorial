package org.allTopics.Heaps;

/*
Problem Description :-
Given an array A of N integers, convert that array into a min heap and return the array.
NOTE: A min heap is a binary tree where every node has a value less than or equal to its children.

Problem Constraints
1 ≤ N ≤ 10^5
0 ≤ A[i] ≤ 10^9

Input Format
First and only argument of input contains a single integer array A of length N.

Output Format
Return the reordered array A such that it forms a min heap.

Example Input
Input:
A = [5, 13, -2, 11, 27, 31, 0, 19]
Example Output
Output:
A = [-2, 5, 0, 13, 11, 19, 27, 31]
Example Explanation
One possible Heap is
                -2
               /    \
             5       0
            / \    /  \
          13  11  19   27
          /
        31

It can be seen that each parent has a value smaller than its children. Hence it is a Valid Heap.
The Heap in the Array format is [-2, 5, 0, 13, 11, 19, 27, 31].
Some more possible heaps are  [-2, 0, 5, 13, 11, 27, 19, 31], [-2, 5, 0, 11, 27, 13, 19, 31], etc.
You can return any possible Valid Heap Structure.

 */

public class HP1BuildAHeapFromArray {
    public void downHeapify(int[] heapArr, int i){
        // I have to continue to down heapity process till leaf node comes for any particular element at ith node.
        // so starting a while loop. And checking for if any left node exists (for right I mean I don't need to check ith
        // seperately bec heapArray me se first hm left m element put krte h. So it might case ki single left child ho bt
        // right side na ho vice versa case possible ni h. So taking only left child in consideration.).

        // to find the left child of any element at parent node i.: lc = 2*i + 1
        while((2*i + 1)<heapArr.length){
            int minElem = Math.min(heapArr[i],heapArr[2*i + 1]);
            if(2*i+2<=heapArr.length-1) minElem = Math.min(minElem,heapArr[2*i+2]);  // if right child exists then only

            // if min element is i only i.e. it is at it's correct place as per heap properties. so we don't need to do
            // anything for that particular given input i. hence we are breaking. you might have question like why we
            // are breaking and not continuing. but this heapify process we are performing for particular given input
            // element i, so.
            if(minElem==heapArr[i]) break;
            else if(minElem==heapArr[2*i + 1]){
                swap(heapArr,i,2*i+1);
                i = 2*i+1;
            }
            else{
                swap(heapArr,i,2*i+2);
                i = 2*i+2;
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] buildHeap(int[] A) {
        // code here
        // Now for any of the leaf Nodes, we don't need to check bec assuming those are already at their correct position
        // as they don't have child so. But we have to do this heapify process for each and every remaining parent Nodes
        // starting from last leaf Node to root node.
        // So how to find the last non leaf node ? --> (lastIndex-1)/2
        for(int i=(A.length-1-1)/2; i>=0;i--){
            downHeapify(A,i);
        }
        return A;
    }

    // Approach - 2:- Recursively :-
    /*
    public int[] buildHeap(int[] A) {
        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            minHeapify(A, i);

        return A;
    }

    private void minHeapify(int[] A, int i) {
        int n = A.length;
        int smallest = i, l = 2 * i + 1, r = 2 * i + 2;

        if (l < n && A[l] < A[smallest])
            smallest = l;

        if (r < n && A[r] < A[smallest])
            smallest = r;

        if (smallest != i) {
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;
            minHeapify(A, smallest);
        }
    }
     */
}


// Just for Note:- As at last moment if you need this can be very useful.
// Standard code for (insertion of val in Heap) and (deletion of min elem from heap)

/*
insertion of val in Heap :-
private static void insertMinHeap(ArrayList<Integer> heap, int value) {
        heap.add(value);
        int index = heap.size() - 1;
        while (index > 0 && heap.get((index - 1) / 2) > heap.get(index)) {
            int temp = heap.get(index);
            heap.set(index, heap.get((index - 1) / 2));
            heap.set((index - 1) / 2, temp);
            index = (index - 1) / 2;
        }
    }

deletion of min elem from heap :-
    private static int extractMin(ArrayList<Integer> heap) {
        if (heap.isEmpty()) {
            return -1;
        }

        int minElement = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int index = 0;
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
                smallest = leftChild;
            }

            if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
                smallest = rightChild;
            }

            if (smallest != index) {
                int temp = heap.get(index);
                heap.set(index, heap.get(smallest));
                heap.set(smallest, temp);
                index = smallest;
            } else {
                break;
            }
        }

        return minElement;
    }

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> heap = new ArrayList<>();
        for (List<Integer> operation : A) {
            if (operation.get(0) == 1) {
                ans.add(extractMin(heap));
            } else {
                insertMinHeap(heap, operation.get(1));
            }
        }
        return ans;
    }
 */
