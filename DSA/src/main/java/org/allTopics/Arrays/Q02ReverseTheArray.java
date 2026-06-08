package org.allTopics.Arrays;

// Problem Link: https://www.naukri.com/code360/problems/reverse-an-array_8365444

// Problem description :-
/*
Given an array 'arr' of size 'n'.
Return an array with all the elements placed in reverse order.

Note:
You don’t need to print anything. Just implement the given function.

Example:
Input: n = 6, arr = [5, 7, 8, 1, 6, 3]
Output: [3, 6, 1, 8, 7, 5]

Explanation: After reversing the array, it looks like this [3, 6, 1, 8, 7, 5].

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
8
3 1 1 7 4 2 6 11
Sample Output 1:
11 6 2 4 7 1 1 3
Explanation Of Sample Input 1 :
After reversing the array, it looks like this [11, 6, 2, 4, 7, 1, 1, 3].
Sample Input 2:
4
8 1 3 2
Sample Output 2:
2 3 1 8
Explanation Of Sample Input 2 :
After reversing the array, it looks like this [2, 3, 1, 8].
Expected time complexity
The expected time complexity is O(n).
Constraints:
1 <= 'n' <= 10^6
-10^9 <= 'arr[i]' <=10^9
 */

public class Q01ReverseTheArray {
    public static int[] reverseArray(int n, int []nums) {
        // Write your code here.
        // Bruteforce :- Bruteforce will be just to take another array ans[]. and start
        // traversing the given array from last and dump the element in ans[] array from starting index.
        // TC:- O(N), SC:- O(N)
        /*
        int[] ans = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            ans[nums.length-i-1] = nums[i];
        }
        return ans;
        */


        // Better/Optimised :- Use Swapping.
        // TC:- O(N/2), SC:- O(1)
        // Note:- this optimised approach is doing in-place reversal of the array.
        int start=0;
        int end = nums.length-1;
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
}
