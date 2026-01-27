package org.allTopics.Arrays;

// Link :- https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1

// Article Link :- https://www.geeksforgeeks.org/dsa/segregate-0s-and-1s-in-an-array-by-traversing-array-once/

// Problem Description:-
/*

Given an array arr consisting of only 0's and 1's in random order. Modify the array in-place to segregate 0s onto the
left side and 1s onto the right side of the array.

Examples :
Input: arr[] = [0, 0, 1, 1, 0]
Output: [0, 0, 0, 1, 1]
Explanation:  After segregation, all the 0's are on the left and 1's are on the right. Modified array will be [0, 0, 0, 1, 1].
Input: arr[] = [1, 1, 1, 1]
Output: [1, 1, 1, 1]
Explanation: There are no 0s in the given array, so the modified array is [1, 1, 1, 1]
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 10^6
0 ≤ arr[i] ≤ 1

 */

public class Rearrange0sAnd1s {
    public static void main(String[] args) {}

    void segregate0and1(int[] arr) {
        // Approach - 1 :- Bruteforce :- With 2 traversal
        // TC:- O(N+N), SC:- O(1)
        /*
        int cnt0 = 0;
        // int cnt1 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){cnt0++;}
            // else cnt1++;
        }
        for(int i=0;i<cnt0;i++) arr[i] = 0;
        for(int i=cnt0;i<arr.length;i++) arr[i] = 1;

         */

        // Approach - 2 :- Optimised (Using 2-pointer):- With 1 traversal
        // TC:- O(N), SC:- O(1)
        int i=0;
        int j=arr.length-1;
        while(i<j){
            while(arr[i] == 0 && i<j){i++;}
            while(arr[j] == 1 && i<j){j--;}
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // By me (Working & Tested):- it's already similar as discussed above
        /*
        int index1 = 0;
        int index2 = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==1){
                index1 = i;
                break;
            }
        }

        index2 = index1+1;
        while(index2<arr.length){
            if(arr[index2]==1) index2++;
            else if(arr[index2]==0){
                int temp=arr[index1];
                arr[index1] = arr[index2];
                arr[index2] = temp;
                index1++;
                index2++;
            }
        }

         */
    }



}
