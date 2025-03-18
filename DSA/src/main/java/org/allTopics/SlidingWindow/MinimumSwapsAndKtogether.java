package org.allTopics.SlidingWindow;

// Problem Link :- https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1

/*
Problem Description :-
Given an array arr and a number k. One can apply a swap operation on the array any number of times, i.e choose
any two index i and j (i < j) and swap arr[i] , arr[j] . Find the minimum number of swaps required to bring
all the numbers less than or equal to k together, i.e. make them a contiguous subarray.

Examples :

Input: arr[] = [2, 1, 5, 6, 3], k = 3
Output: 1
Explanation: To bring elements 2, 1, 3 together, swap index 2 with 4 (0-based indexing), i.e. element arr[2] = 5
with arr[4] = 3 such that final array will be- arr[] = [2, 1, 3, 6, 5]
Input: arr[] = [2, 7, 9, 5, 8, 7, 4], k = 6
Output: 2
Explanation: To bring elements 2, 5, 4 together, swap index 0 with 2 (0-based indexing) and index 4 with 6 (0-based
indexing) such that final array will be- arr[] = [9, 7, 2, 5, 4, 7, 8]
Input: arr[] = [2, 4, 5, 3, 6, 1, 8], k = 6
Output: 0
Constraints:
1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^6
1 ≤ k ≤ 10^6
 */

public class MinimumSwapsAndKtogether {
    int minSwap(int[] arr, int k) {
        /*
         So I have make all the numbers with less than k together
         it means elems<k in whole array should be together in ans/op array ryt.

         so yha se hi pta pdta h ki pehle wo sare elems ka grp find krna pdega
         ryt which are lesser than k. means me ye bol rha hu ki anyhow those
         all elems needs to be together ryt. now in that case it might happen
         ki out of those all elems lesser than k, we have few elems very nearby
         each other. those cluster we have to identify ki which could be best
         possibility so that we can have min number of swaps.

         So here simply 1st we must have to know how many numbers lesser than k are
         present ryt? then we can check where it would be best suitable in whole arr.
         so once we got elems lesser than k, then that count will be size for my
         group/cluster to be placed/find appropriate place inside the array.
        So now we have to check where to put exactly, so for that simply since
         we want to check elem at each place so we just need to apply fixed size
         sliding window and we can check which window already contains maximum numbers
         which are already lesser than k, so that we have to swap less elems to make
         whole group together.

         cool!

         */

        int windowSize=0;
        for(int elem:arr) if(elem<=k) windowSize++;
        if(windowSize<=1) return 0;
        int i=0;
        int j=0;
        int cnt=0;
        int ans = Integer.MAX_VALUE;
        while(j<arr.length){
            if(arr[j]>k) cnt++;

            if(j-i+1<windowSize) j++;

            else if(j-i+1==windowSize){
                ans = Math.min(ans,cnt);

                if(arr[i]>k && cnt>0) cnt--;
                i++;
                j++;
            }
        }
        return ans;
    }
}
