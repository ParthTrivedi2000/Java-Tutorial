package org.allTopics.Heaps;

/*
Question:- You have been given 2D matrix of size N*M with sorted rows. Merge all the rows into a
1D sorted array. (Recently asked in amazon)

Approach - 1:-
Very bruteforce we can think of is, just create 1D array of size N*M. And add each elem to 1D arr. And sort the
whole array.
- Insert each elem to new Array.:- O(N*M)
- Sort the Array :- O(NM LogNM)
TC:-O(NM + NMLogNM) = O(NMLogNM), SC:- O(NM)

Approach - 2:-
Simply put each and every element in the min heap. And then extract it one by one And put it into the Array.
- Insert an element into heap. ideal TC for insertion in heap is logN where N is the size of the heap. So here
want to insert N*M hence atleast N*M sized heap is required. :- O(NM LogNM)
- extract from heap and put into the Array. :- O(NM LogNM)
TC:- (2 NMLogNM) = NMLogNM, SC:- NM

Note :- so many are confused in this.
So clarifying, creating a heap and then making array out of it always took --> O(NlogN)
But if you create Array (or already have array) then to create min heap from it --> O(N)
so simply remember:-
minHeap --> Array ==> TC:- O(NlogN) where N=size of the heap.
Array --> minHeap  ==> TC:- O(N) where N= size of the heap.

Approach -3 :-
- Create Array And convert it into a min heap :- O(MN)
- extract each elem from heap one by one and put into the array. --> NMlogNM
TC:- O(NMLogNM), SC:- O(1)

Now yrrr just once again read question carefully. you have been given certain information in question. like each row
is sorted. But in any of the above 3 approaches you haven't used this information anywhere to implement your solution.
LOL!!!
please always read question very well. each and every information given in question is always meant for something,
it's not like they have written anything blindly. So get question very well.

So let's use this information.:- given each row is sorted.
matrix:-
2 7 10 17 25
-6 0 1 8 11
3 4 6 14 21
7 10 14 19 23

Now just observe like smallest element can be any 1 of the 1st elements of any row can I say this? --> yes absolutely.
So I just found -6 as my 1st elem by iterating from 1st col.  But now once you extract -6 and put into new array.
- Now which is the 2nd smallest? think think
can you say like 2nd smallest from 1st col? --> no. I can't say bec just see it was said each row is sorted means next
element of -6 comes to the race. so now you have to compare 2 0 3 7. And out of that you have to find the minimum ryt.
- Once you choose it ( new Array:- -6,0): now again since you choose elem from 2nd row hence next corresponding
 element from 2nd row comes into the race. i.e. you need to find the smallest from 2 1 3 7. SO new Arr:- -6,0,1
 - Now again compare 2 8 3 7. So new Array = -6 0 1 2. So in this case you removed element from 1st row since it is
 sorted. So now next element from 1st row comes to the race. i.e. 7 8 3 7.

 So yes at the 1st time you can iterate over just 1st column, And able to chose. But will you iterate everytime?
 And if yes then also how? I mean just think like getting min and then removing and considering the next elem from
 same row and iterating on it. Obviously you won't do that ryt bec simple reason is here what you want or what you
 are doing?
 - getting min --> removing/extracting min --> inserting new elem to min ==> and done. SIMPLE!!!
 - So yes now you must be able to identify ki to do above operation use of Heap makes my life easier. So we will use
 the minHeap here.

 - Ok so now next question is like once you remove -6 from minHeap and similarly any element from minHeap, How I came
 to know which element needs to be added next into the heap? like by observing you know that is fine. But in code
 implementation how to decide which to add next? --> So just think like with each element present in heap, I must have
 something for reference like either column name or next element with the value ryt.
 - So correct our purpose won't suffice if we only store int value in the heap. I mean we have to create our Object
 like Pair class element which stores 2 things. one is value and 2nd is something which identifies it. So myObject
 will be having value, row and column 3 attributes. means from row,column we can identify at which cell it's currently
 present and next which value needs to be added So we keep row and column.

- Note:- even if you noticed, then my Heap size is always no of rows only. means not N*M.  bec everytime at max
1 elem from each row present inside the heap. So this is also where so many persons are wrong in interview when
interview asked about SC. So SC in this case is not O(N*M) but it is actually O(N) only.

TC:- O(M*N LogN) , SC:- O(N) considering auxiliary space I mean for heap only which was O(M*N) in prev approaches
And since array is already asked in que to return so won't consider it in SC.

 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MatrixConvertToArray {
    class myObject{
        int val;
        int row;
        int col;
        myObject(int value, int i, int j){
            this.val = value;
            this.row = i;
            this.col = j;
        }
    }
    public int[] solve(int[][] A) {
        // Approach -
        // will create a minHeap. And 1st element of each row in it.

        PriorityQueue<myObject> pq = new PriorityQueue<>(A.length, new Comparator<myObject>(){
            @Override
            public int compare(myObject a, myObject b){
                return a.val-b.val;
            }
        });

        for(int i=0;i<A.length;i++){
            pq.add(new myObject(A[i][0],i,0));
        }

        // Once added I can start polling out it for B times only.
        int[] ans = new int[A.length * A[0].length];
        int idx = 0;
        while(!pq.isEmpty()){
            myObject curr = pq.poll();
            ans[idx] = curr.val;

            // Adding to minHeap.
            // Just perform cautionary check of overflow like column is within range or not then only add.
            if (curr.col+1<A[0].length) pq.add(new myObject(A[curr.row][curr.col+1],curr.row, curr.col+1));

        }
        return ans;
    }
}


