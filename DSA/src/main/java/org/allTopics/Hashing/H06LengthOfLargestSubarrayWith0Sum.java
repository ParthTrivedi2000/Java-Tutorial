package org.allTopics.Hashing;

// Problem Statement:- https://www.scaler.com/topics/largest-subarray-with-0-sum/

/*
Problem Description :-
Given the array ar[] of size, n has positive and negative integers. From the array ar[], find the length of the
largest subarray having a 0 sum.

Example Explanation
We are required to find all the subarrays starting from the ith index and ending with the jth index where
0<=i<n and
i<=j<n where
n represents the length of the array.

Example : 1

First of all, we will find the sum of every subarray of the input array ar[].

Here the size of the array is 7 so we are required to find the sum of all the subarrays starting from the ith index
and ending with the jth index where
0<=i<7 and
i<=j<7.

Subarrays with 0 sum are :
[−6,5,1] with length 3 and
[4,−3,−6,5] with length 4.

So the maximum length of subarray with 0 sum is 4.

Input :
Given a positive integer n which represents the size of an array
ar[]. And the n positive/negative integers represent the elements of ar[].

Output :
You have to return the length of the largest subarray that has a sum of 0.

Constraints
The constraints for the largest subarray with a 0 sum problem are given below :
1<=n<=100000,
−1000<=ar[i]<=1000, for i in range 0 to n.
 */

import java.util.HashMap;
import java.util.Map;

public class H06LengthOfLargestSubarrayWith0Sum {

    // Approach - 1:- BruteForce:- TC:-O(N^3), SC:- O(1)
    /*
    public int maxLenSubSumZero(int ar[], int size){
        // declaring the variable max_length for storing maximum length of subarray with sum 0
        int max_length = 0;
        // iterating over the input array
        for(int i=0;i<size;i++){
            for(int j=i;j<size;j++){
                // variable cursum to store the sum of subarray that starts with ith index and ends with a jth index
                int cursum = 0;
                for(int k=i;k<=j;k++)
                    cursum = cursum + ar[k];
                // checks that the subarray has a sum of zero or not
                if(cursum == 0){
                    // if the sum of the subarray is zero and current subarray length is greater then update max_length
                    if(max_length < j-i+1)
                        max_length = j-i+1;
                }
            }
        }
        //returning the length of the largest subarray with a sum of 0
        return max_length;
    }
     */

    // Approach - 2:- Efficient Bruteforce using 2 nested loops. TC:- O(N^2) SC:-O(1)
    /*
    public int maxLenSubSumZero(int ar[], int size){
        // declaring the variable max_length for storing maximum length of subarray with sum 0
        int max_length = 0;
        // iterating over the input array
        for(int i=0;i<size;i++){
            // variable cursum to store the current sum of subarray starting with ith index
            int cursum=0;
            for(int j=i;j<size;j++){
                // getting the sum of subarray that starts with i and ends with j
                cursum = cursum + ar[j];
                // checks that the subarray has sum zero or not
                if(cursum == 0){
                    // if sum of subarray is zero and current subarray length is greater then update max_length
                    if(max_length < j-i+1)
                        max_length = j-i+1;
                }
            }
        }
        //returning the length of largest subarray with sum 0
        return max_length;
    }

     */

    // Approach - 3:- Efficient using Hash Table:-

    public int maxLenSubSumZero(int ar[], int size){
        // declaring the variable max_length for storing maximum length of subarray with sum 0
        int max_length = 0;
        // Creating an empty hashmap for storing previous sum
        HashMap<Integer,Integer> prevsummap=new HashMap<Integer, Integer>();
        // Declaring and Initializing the cur_sum to store sum
        int cur_sum = 0;
        // iterating over an input array
        for (int i = 0; i < ar.length; i++) {
            // Adding current element to the previous calculated sum
            cur_sum += ar[i];
            if (ar[i] == 0 && max_length == 0) max_length = 1;
            if (cur_sum == 0) max_length = i + 1;

            // Checking this sum in the map
            Integer prevind = prevsummap.get(cur_sum);
            // If sum is in map then update the value of max_length
            if (prevind != null)
                max_length = Math.max(max_length, i - prevind);
            else {
                // If sum is not in the map then insert it into map with current index
                prevsummap.put(cur_sum, i);
            }
        }
        //returning the length of largest subarray with sum 0
        return max_length;
    }



    // Extended version:-
    // Now if it was asked to print the first longest subarray with sum=0. Please see below solution.
/*
Problem Description:-
Given an array A of N integers.
Find the largest continuous sequence in a array which sums to zero.

Problem Constraints
1 <= N <= 10^6
-107 <= A[i] <= 10^7

Input Format
Single argument which is an integer array A.

Output Format
Return an array denoting the longest continuous sequence with total sum of zero.

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.

Example Input
A = [1,2,-2,4,-4]

Example Output
[2,-2,4,-4]

Example Explanation
[2,-2,4,-4] is the longest sequence with total sum of zero.

*/

    public int[] lszero(int[] A) {
        Map<Integer,Integer> mp = new HashMap<>();
        int sum=0;
        int start=-1;
        int end=-1;
        int len=Integer.MIN_VALUE;
        mp.put(0,-1);
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            if(mp.containsKey(sum)){
                if(i-mp.get(sum)>len){
                    len=i-mp.get(sum);
                    start=mp.get(sum)+1;
                    end=i;
                }
            }
            else mp.put(sum,i);

        }
        // if don't have any array with sum =0, then returning empty array as that testcase was failing so.
        if(start==-1) return new int[0];
        int[] ans = new int[end-start+1];
        int idx=0;
        for(int i=start;i<=end;i++){
            ans[idx]=A[i];
            idx++;
        }
        return ans;
    }
}
