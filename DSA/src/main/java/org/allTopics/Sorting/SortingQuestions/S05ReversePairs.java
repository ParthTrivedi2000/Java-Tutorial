// Problem Link :- https://leetcode.com/problems/reverse-pairs/description/

/*
Problem Description :-
Given an integer array nums, return the number of reverse pairs in the array.
A reverse pair is a pair (i, j) where:
0 <= i < j < nums.length and
nums[i] > 2 * nums[j].

Example 1:
Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:
Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1

Constraints:
1 <= nums.length <= 5 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
 */


class S05ReversePairs {

    public int reversePairs(int[] nums) {

        // Bruteforce Approach:-
        // TC:- O(N^2), SC:- O(1)
        /*
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > 2 * a[j])
                    cnt++;
            }
        }
        return cnt;

         */

        // Optimised Approach:- Using Merge Sort:-
        // TC:- O(2NlogN), SC:- O(N)
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] arr, int left, int right){
        int cnt=0;
        if(left>=right) return cnt;
        int mid = left+(right-left)/2;
        cnt += mergeSort(arr,left,mid);
        cnt += mergeSort(arr,mid+1,right);
        // this is to count reverse pairs.
        // (Understand this, since it has to be applied to 2 sorted portion of the array
        // to get the correct answer due to condition of A[i]>2*A[j], else we will be
        // missing out few elements if we try to count at the time of merging as we did
        // in Inversion of Count (A[i]>A[j]) problem. Hence have to do on sorted portion
        // or 2 sorted array to make sure that if 1st elem of left is 2 times greater than
        // 1st elem of right array then definately remaining elems of the left array would
        // be greater than right elem of the array. So we will stand at each elem of left
        // and then start traversing right array to check which all elems fulfill the
        // condition, at whichever element j would be stopped, that much we can add to
        // the count simple. Then now very imp thing. then for next iteration means for
        // 2nd elem of left array we don't need to start checking from 1st elem of right
        // since prev elem of left array is greater then current elem also will be greater
        // than those elems in the right (since both left and rigtht are sorted array so),
        // so we would be checking from the next right elem from where previous iteration
        // has stopped, but adding count from starting to current jth elem in the right.
        // And we are done. Whatever discussed above is implemented in this function, please
        // see code for more information)
        cnt += countPairs(arr,left,mid,right);
        merge(arr,left,mid,right);
        return cnt;
    }

    private void merge(int[] arr, int left, int mid, int right){
        int i=left;
        int j=mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else{
                temp.add(arr[j]);
                j++;
            }
        }

        while(i<=mid){
            temp.add(arr[i]);
            i++;
        }
        while(j<=right){
            temp.add(arr[j]);
            j++;
        }

        for(int k=left;k<=right;k++){
            arr[k] = temp.get(k-left);
        }
    }

    private int countPairs(int[] arr, int left, int mid, int right){
        int j=mid+1;
        int cnt=0;
        // by standing on each elem of left arr
        for(int i=left;i<=mid;i++){
            // checking each elem of right elem && condition
            while(j<=right && (long)arr[i]>(long)2*arr[j]){
                j++;
            }
            // Adding count of right side elems from starting of right side arr(ie. mid+1)
            // to whatver elem we reached (i.e. j)
            cnt+=(j-(mid+1));
        }
        return cnt;
    }
}