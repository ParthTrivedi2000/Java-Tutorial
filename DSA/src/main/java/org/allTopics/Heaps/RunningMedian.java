package org.allTopics.Heaps;

// Problem Link:- https://leetcode.com/problems/find-median-from-data-stream/description/

/*
Problem Description :-
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value,
and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be
accepted.

Example 1:
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]
Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0

Constraints:
-10^5 <= num <= 10^5
There will be at least one element in the data structure before calling findMedian.
At most 5 * 10^4 calls will be made to addNum and findMedian.

Follow up:
If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?

 */


/*
So we have to find the median of running stream. It means stream of numbers are continuous from input. we
have to find the median from it.
4 --> 4
4 6 --> 4 6 --> 5
4 6 3 --> 3 4 6 --> 4
4 6 3 2 --> 2 3 4 6 --> 3
4 6 3 2 9 --> 2 3 4 6 9 --> 4

- So simply median means middle of numbers after sorting correct. And that we want to find everytime.

Approach - 1:- Maintain data in sorted order i.e. at correct position with each new number comes.
So it looks like Insertion sort we followed in our approach. Then what would be the TC? so O(N) to insert
any element at correct sorted position. And having such Q times for each number in stream --> O(N*Q) or O(N^2)

But if you use any other sorting algo, like merge sort/or any other, then at each line it will try to sort whole
array of nums it means NlogN And doing this for N number of lines --> O(N * NlogN)

So just mean to say that Insertion sort would be better since it's an online sorting technique.

Now let's move ahead to solve the problem to improve the TC from O(N^2).
So now just a question is, is it necessary that every number has to be there at it's correct position?
Suppose for example: at currently there are below elems present.
3 7 11 13 14 21 23 27

but if you carefully observe then median would be 13+14/2 --> 13
i.e. if you only know the Max elem from 1st N/2 elems And min elem from 2nd N/2 then you will be able to get answer
ryt irrespective of order/ correct position of all the elems in particular half. like if suppose you haven't
maintained order like 11 3 13 7  21 23 14 27. Still somehow if you are able to extract info like what is the max from
1st half and what is the min of 2nd half, then simply we were able to get our answer ryt.

So again want to reiterate, suppose somehow I am able to achieve N/2 smaller elems on 1 side and N/2 larger elems
at one side (irrespective of maintaining their order)  I will be able to get ans by getting max from 1st N/2 smaller
elems and 2nd N/2 larger elems. I know, how to maintain half of the N/2 smaller elems at one side and half of the
N/2 greater elems on another side is still an open question, but if somehow we were able to achieve that then I can
find answer without maintaining everything in sorted order ryt.

Now which data structure provides me the max/min each time in optimal TC? --> obviously max/min heap.
So we need to maintain max heap for N/2 smaller elems to get max and min heap for N/2 larger elems to get min.

So we were able to observe like to maintain each element in it's correct sorted position, rather than we can optimise
if we can have N/2 smaller elems at 1 side and N/2 larger elems at 2nd side then it would be optimised then prev
correct.


Now 2 questions we are having.
1) how to maintain N/2 smaller elems at 1 side and N/2 larger elems at 1 side.
2) what to do if total numbers are odd?

So let's catch it how to do?
Assume you are having empty max heap and small heap created. left side we are having max heap which we are trying
to maintain the N/2 smaller elems and right side min heap (bec I want min out of all the elems) in which we are
trying to maintain N/2 larger elems.
- Now suppose 1st elem comes from stream of numbers. 9 --> in which heap should I put and what should be median?
since both the heaps are empty we can put it into any of them. But since both are empty let's start from left side
only. So putting it into the max heap. And currently my median is 9.
- Now next number comes 6. And fun part begins. So where should my 6 present in comparison to 9. Obviously ideally
it should fall on left side. But yha pe to jb 6 aaya tb pehle ek hi elem present tha so you were able to compare
with that directly and able to say that 6 should be present at left side. but what if next time onwards we are having
multiple elems. then to put elem are we going to compare with each and every element present previously to decide
exactly where new element to be put? --> fir to ye whi bat ho gyi ryt like comparing new elem with each elem and
then decide. So we won't compare with each and every element. But just think like for any new element my median
always stays at middle only ryt so for every new elem can't I compare only with median and I am able to decide easily
like where my elem should fall? on left or right correct?
So from comparison with median we should put it on left or right. Now after putting it, in this example only both 6
and 9 are present in the max heap only. Now again think here.
- Like at anytime
for ODD numbers --> leftSide(x) - middle(x+1) - rightSide(x)
for EVEN numbers --> leftSide(x) - rightSide(x)
So in case of odd my middle elem's left side has x elems and right side has x elems. But here considering only 2
buckets so middle should be counted in either of the bucket. So let's assume middle present at left side, then left
side bucket can have x+1 elems and right side have x elems at any point of time in case of ODD. And in case
of EVEN left side has x elems and right side has x elems at any point of time to make it balanced.

- Now above would be the case ideally. But in our case it's not there. I mean total there are 2 elems (9 and 6) i.e
EVEN elems, hence each bucket should have same count/size x. but here in our case left bucket has 2 and right has 0.
So it is not balanced hence we need to make it balanced as per ideal condition. hence moving 1 elem to right side.
And obviously need to maintain larger elems at right side as per our algorithm we have designed (or vese bhi max heap
can give only max/top element in O(1) time so I will leverage it n), so we will move 9 to right side. And median
in case of this EVEN numbers would be max from left side and min from right side --> i.e. (9+6)/2 = 7

- Now new elem is 4. So
    - compare it with previous/means existing median which is 7. So my 4 needs to be put on left. maxHeap.add(4).
    - Now again compare size of both heap. (if both are equal or left is just +1 than right these 2 are the only
    valid size for us ryt else we need to perform rebalance. But since here  left>=right+1 which is correct.
    So we don't need to do anything.
    - update median. Median = maxHeap.peek() = 6
- Now comes 2. So
    - compare with median i.e. with 6. So adding 2 to leftSide i.e. to maxHeap.
    - checking size. left has 3, right has 1. performing rebalance get max from left and put it to right. So now
    size are equal.
    - and Median would be in case of equal size = maxHeap.peek() + minHeap.peek() = 4+6/2 = 5
- Now comes 10.
    - compare with median i.e. with 5. So adding 10 to right side i.e to minHeap.
    - checking size. left has x and right has x+1. Absolutely fine. no need of rebalance.
    - median would whichever side has higher size uska peek elem = minHeap.peek() = 6.
- Now comes 12.
    - compare with median i.e. 6. adding 12 to right side ie. to minHeap.
    - checking size. leftSide=2, rightSide=4. So size difference >1. i,e need to do rebalance. extracting peek
    elem from right side and putting it on left side. now both side has size 3. hence size diff is 0.
    - in case bot side has equal size, median = left.peek() + right.peek() = 6+9/2 = 7
- Now comes 7.
    - compare with median i.e. 7. So if new elem is same as median then we will put it on left (you can put on any
    side).
    - leftSize=4,rightSize = 3. SizeDifference = 1 which is <=1 only hence it would be great.
    - Since leftSide has size>rightSide size , median = left.peek()
 */


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

public class RunningMedian {

    /*
    // Working & Tested:- Solely by me
    public int[] solve(int[] A) {

        // Solely by me:-
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        int[] ans = new int[A.length];
        maxHeap.add(A[0]);
        ans[0]=A[0];
        int median = A[0];
        if(A.length==1) return ans;
        for(int i=1;i<A.length;i++){
            if(A[i]<=median){
                maxHeap.add(A[i]);
            }
            else minHeap.add(A[i]);

            // need to do rebalance if size difference is>1
            if(Math.abs(maxHeap.size()-minHeap.size())>1){
                if(maxHeap.size()>minHeap.size()){
                    minHeap.add(maxHeap.poll());
                }
                else maxHeap.add(minHeap.poll());
            }

            // if no of elems are even then need to take B[N/2-1] here.
            if((maxHeap.size()+minHeap.size())%2==0){
                ans[i] = maxHeap.peek();
            }
            else ans[i] = maxHeap.size()>minHeap.size()?maxHeap.peek():minHeap.peek();
            median = ans[i];
        }
        return ans;
    }

     */


    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    // int[] ans = new int[A.length];
    // int median;
    public RunningMedian() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // ans = new int[A.length];
        // median = 0;
    }

    public void addNum(int num) {
        if(maxHeap.size()==0 && minHeap.size()==0) maxHeap.add(num);
        else if((double)num<=findMedian()){
            maxHeap.add(num);
        }
        else minHeap.add(num);

        if(Math.abs(maxHeap.size()-minHeap.size())>1){
            if(maxHeap.size()>minHeap.size()){
                minHeap.add(maxHeap.poll());
            }
            else maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        double ans = 0.0;
        if((maxHeap.size()+minHeap.size())%2==0){
            ans = maxHeap.size()==0?0:(double)(maxHeap.peek()+minHeap.peek())/2;
        }
        else ans = maxHeap.size()>minHeap.size()?maxHeap.peek():minHeap.peek();
        return ans;
    }
}
