package org.allTopics.SlidingWindow;

// Q - 5) Longest Subarray of Sum K :-
// Problem Link :- https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
// Problem Statement :-
/*
Given an array arr containing n integers and an integer k. Your task is to find
the length of the longest Sub-Array with the sum of the elements equal to the given value k.

Example :-
Input :
arr[] = {10, 5, 2, 7, 1, 9}, k = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1<=n<=10^5
-10^5<=arr[i], K<=10^5

 */

public class SW05LongestSubarrayWithSumK {
    public static int lenOfLongSubarr (int A[], int N, int K) {

        // Bruteforce Approach :- TC:- O(N^3), SC:- O(1)
        /*
        int ans=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                int sum=0;
                for(int p=i;p<=j;p++){
                    sum+=arr[p];
                }
                if(sum==k){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;

         */


        // Optimised Bruteforce Approach :-  TC:- O(N^2), SC:- O(1)
        /*
        int ans=0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==k){
                    ans=Math.max(ans,j-i+1);
                    break;
                }
            }
        }
        return ans;

         */


        // Optimal Approach :- Using Sliding Window Technique :- TC:- O(N), SC:- O(1)
        // Starting window
        int i = 0;
        int j = 0;
        long sum = 0;
        int maxLen = 0;
        while (j < N) {
            // Calculations:-
            sum = sum + A[j];
            // Checking condition is met or not.
            if (sum < K) {
                j++;
            }
            // Checking condition is met or not. Once it met, need to store ans from calculation.
            else if (sum == K) {
                // fetching ans from calculation
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else if (sum > K) {
                while (sum > K) {
                    // Nullyfying impact of prev i
                    sum = sum - A[i];
                    // Shrinking window
                    i++;
                }
                // expanding window
                j++;
            }
        }
        return maxLen;
/*
Q). Will the above discussed approach work with negative numbers in the array?
A. No.
Because let's say in the given array [4,1,1,1,2,3,5] when we found the sum within the window to be
greater than the desired value 5 (i=0, j=2 -> [4,1,1]), we started reducing the size of the window by
doing i++. Here we assumed that once the sum of elements within the window becomes greater than 5 then
increasing the window size will just add to the sum and hence we will not attain the sum 5 again. This is
true when all the element are positive and hence reducing the window size by doing i++ makes sense. But
this might not be true if array also contains negative numbers. Consider the array [4,1,1,-2,1,5], here we
would have found the sum to be greater than 5 for i=0, j=2 and if we would have now started reducing the
window size by doing i++, we would have missed the potential subarray (i=0, j=4).
In short, the discussed approach will not work with array having negative numbers.
 */

/*
For above question, Sliding Window will only work if array contains only +ve values. if it contains -ve values, then
above technique won't work.  it is failing for this test case ( arr:- -59 -25 58 -59 -25 58, k=-85 ). So if array contains
-ve integers as well, then we have to use the Hashing (since it is problem of subarray with sum k).

        Map<Long,Integer> mp = new HashMap<>();
        long sum=0;
        int maxL = Integer.MIN_VALUE;
        mp.put(0L,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            // if(sum==k) maxL = i+1; // didn't understand why we need to put, without it not giving correct answer,
            // just try to comment out this line for testcase (arr:- -59 -25 58 -59 -25 58, k=-85)
            // Now if I kept above line mp.put(0,-1), then above line is not needed and working fine. don't know why and how.
            if(mp.containsKey(sum-k)){
                maxL = Math.max(maxL,i-mp.get(sum-k));
            }
            if(!mp.containsKey(sum)) mp.put(sum, i);
            // mp.put(sum, i);
        }

        return maxL;

 */
    }
}
