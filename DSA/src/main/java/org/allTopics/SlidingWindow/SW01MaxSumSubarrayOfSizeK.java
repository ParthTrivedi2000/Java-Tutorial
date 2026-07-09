package org.allTopics.SlidingWindow;

import java.util.ArrayList;

// Q - 1) Maximum Sum SubArray of size K.

// Problem Link:- https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

// Problem Statement:-
/* Given an array of integers Arr of size N and a number K. Return the
maximum sum of a subarray of size K.

Identification:-
- Problem is related to array.
- in problem statement, they are asking to do something to do on subarray.
- windowSize is given as K.
So we can see like we have to apply Sliding Window concept here.

Example:-
Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 10^5
1 <= Arri <= 10^5
1 <= K <= N

Companies:- OYO Rooms

 */

public class SW01MaxSumSubarrayOfSizeK {

    // Approach - 1:- Very Bruteforce:- TC:- O(N^3), SC:- O(1)
    public int maximumSumSubarray_bruteforceApproach(int[] arr, int k) {
         int maxi = Integer.MIN_VALUE;
         for(int i=0;i<arr.length;i++){
             for(int j=0;j<arr.length;j++){
                 int sum=0;
                 for(int p=i;p<=j;p++){
                     if(i<=j){
                         sum+=arr[p];
                     }
                 }
                 if(j-i+1==k) maxi = Math.max(maxi,sum);
             }
         }
         return maxi;
    }

    // Approach - 2:- TC:- O(N^2), SC:- O(1)
    public int maximumSumSubarray_betterApproach(int[] arr, int k) {
        /*
        // Working (not fully tested with all the testcases):-
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<=arr.length-k;i++){
            int sum=0;
            for(int j=i;j<i+k;j++){
                sum+=arr[j];
            }
            maxi = Math.max(maxi,sum);
        }
        return maxi;
         */

        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(j-i+1==k) maxi = Math.max(maxi,sum);
            }
        }
        return maxi;
    }

    // Approach - 3:- Sliding Window:- TC:- O(N), SC:-O(1)
    public long maximumSumSubarray_optimisedApproach(int K, ArrayList<Integer> Arr, int N){

        int i = 0; // represents start of window/subarray
        int j = 0; // represents end of the window/subarray
        long sum=0;
        long ans = Long.MIN_VALUE;
        while(j<Arr.size()){
            // calculation
            sum+=Arr.get(j);

            // till the moment end of window(i.e. here j) is smaller than windowSize,
            // we can just expand the window ryt. nothing else needs to be done. bec
            // whatever we want to achieve that we have done in above calculation part
            // generically like that thing needs to be done anyhow weather I am reaching
            // windowSize or not. So we kept it generic. then we are having 2 things now,

            // end of window < windowSize --> just increase the end i.e. expand the window
            if(j-i+1<K) j++;
                // end of window==windowSize
                // At the time when end of the window is equals to windowSize, we should try
                // to find our o/p based on calculations we have done above till now.
            else if(j-i+1==K){
                ans = Math.max(sum,ans);
                // After getting possible output, we need to shrink our window from left
                // to just move ahead till the end of the array. but before shrinking it
                // (i.e. i++), we just need to remove the impact of i from window which
                // we have considered. bec we are now going for next window ryt so
                // obviously we have to consider everything for the elems present in
                // current window only.

                // so nullifying previous elem's impact from current window.
                sum = sum- Arr.get(i);

                // Now move/slide the current window to next window
                i++;
                j++;
            }
        }
        return ans;
        // Accha one more thing as we have kept calculation generic in above case, it is
        // not necessary to keep as generic. i mean in some cases we have to perform
        // calculation for till end < windowSize. then in those cases we kept calculation in
        // end<windowSize block only. But smjne ki bat ye h ki 2 hi cheeze hogi aesa like
        // end<windowSize and end==windowSize
    }
}
