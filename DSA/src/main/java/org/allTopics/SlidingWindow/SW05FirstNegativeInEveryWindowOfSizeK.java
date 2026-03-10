package org.allTopics.SlidingWindow;

import java.util.LinkedList;
import java.util.List;

// Q - 2) First negative in every window of size k
// Problem Link :- https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

// Problem Statement:-
/*
Given an array A[] of size N and a positive integer K, find the first
negative integer for each and every window(contiguous subarray) of size K.

Example :-
Input :
N = 5
A[] = {-8, 2, 3, -6, 10}
K = 2
Output :
-8 0 -6 -6
Explanation :
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(K)

Constraints:
1 <= N <= 10^5
-10^5 <= A[i] <= 10^5
1 <= K <= N

Company Tags :- Amazon

 */

public class SW05FirstNegativeInEveryWindowOfSizeK {

    public long[] printFirstNegativeInteger(long A[], int N, int K){

        // Approach - 1:- BruteForce :- TC:- O(N^2), SC:- O(1)
        /*
        int[] ans = new int[N-K+1];
        for(int i=0;i<A.length;i++){
            boolean flg=false;
            for(int j=i;j<i+K;j++){
                if(A[j]<0) {ans[i] = A[j]; flg=true; break;}
            }
            if(!flg) ans[i] = 0;
        }
        return ans;

         */

        /*
        So what happens here is, like we are doing repetitive things how? means suppose array given
        is 12,-1,-7,8,-10,30,17,25
        So when we have started my loop, i will be at 0th index. then we have checked like element is
        -ve or not for next 3 elems. then i++ will be happen. then again in above case during 2nd
        iteration we are checking for elems -1 & -7. But we have already checked it during 1st iteration
        But still we are checking and same thing will happen till the end of the loop. this is how
        Repetitive work is done. (Pls explain to the interviewer if possible).

        So now we need to improve this. Accha and remember 1 thing, for all the Sliding Window problem
        we were doing repetitive work in bruteforce approach then to improve it we are going with
        optimal approach sliding window.

         */

        // Approach - 2:- Optimal Approach:- Sliding Window TC:- O(N), SC:O(N) for ArrayList/LL/Queue
        int i=0;
        int j=0;
        /*
         As per use case here I want to store all the -ves while moving ahead ryt. So now which DS I should
         use. means just think here what I want to do is, when I am moving forward, I have to store the
        -ve values. see we are only moving for windowSize, so wo windowSize me jitni bhi -ve value hogi wo
        add ho jayegi DS m...but usme se muje to 1st wali h whi chahiye ryt...and during next time as well
        when I am sliding the window, my DS should store only -ves which are currently in current window.
        So I have to remove the -ve of previous window if it's present. So I have to choose DS in which I can
        perform both of the above thing.
        So if you think carefully, here I want 1st elem added. i.e. 1st In 1st out type structure (FIFO).
        So I can have Queue.
        But here if I think, I just want to remove the starting elem, that I can achieve via List DS as well
        So either Queue/List would be fine here for above problem.

         */
        List<Long> negatives = new LinkedList<>(); // with arrayList, only last 1111th TS is failing by giving TLE. So I
        // have used LL here since we are doing multiple time insertions and deletions since LL can handle large no of
        // insertions and deletions better than ArrayList.
        long[] ans = new long[N-K+1]; // to store and return the answer
        while(j<N){
            // calculations
            if(A[j]<0) negatives.add(A[j]);

            if(j-i+1<K) j++;

            else if(j-i+1==K){
                // finding ans from calculations done till now
                if(negatives.size()==0) ans[i]=0; // if list is empty, i.e. there is no -ve elem in current
                    //window since it is tracking the current window elems only so.
                else ans[i] = negatives.get(0);

                // Nullifying impact of prev i
                if(A[i]<0) negatives.remove(0);
                // Slide the window
                i++;
                j++;
            }
        }
        return ans;
    }
}
