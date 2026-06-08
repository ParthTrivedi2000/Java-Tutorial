package org.allTopics.Arrays;

// Problem Link:- https://www.naukri.com/code360/problems/rotate-array_1230543?leftPanelTabValue=PROBLEM
// In above mentioned link, it was asked to rotate the array to left. but in below problem it was asked
// to rotate the array based on the given argument.




// Problem Link :- https://www.naukri.com/code360/problems/rotate-array-ll_4530285?leftPanelTabValue=PROBLEM

// Problem Description :-
/*
You are given an array ‘NUM’ containing ‘N’ integers, the direction of rotation ‘D’, and the number of rotations ‘R’.
You have to rotate the given array ‘R’ times. If the direction of rotation ‘D’ has a value equal to ‘f’ then
you have to rotate the array forward else if it has a value equal to ‘b’ then rotate the array backward.

For Example :
If N = 3, num = [2, 4, 7], D = ‘f’, R = 1.
You have to rotate the array 1 time in the forward direction. Hence, the output will be [7, 2, 4].
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 100000
1 <= num[i] <= 10^7
D = {‘f’, ‘b’}
0 <= R <= 10^7
Sum of N over all the test cases will not exceed 10^5

Time limit: 1 sec
Sample Input 1 :
2
3
2 4 7
f
1
3
3 2 1
b
2
Sample output 1 :
7 2 4
1 3 2
Explanation For Sample Output 1:
For the first test case,
N = 3, num = [2, 4, 7], D = ‘f’, R = 1.
You have to rotate the array 1 time in the forward direction. Hence, the output will be [7, 2, 4].

For the second test case,
N = 3, num = [3, 2, 1], D = ‘b’, R = 2.
You have to rotate the array 2 times in the backward direction.
After 1st rotation, the array will be [2, 1, 3].
After 2nd rotation, the array will be [1, 3, 2].
Hence, the output will be [1, 3, 2].
Sample Input 2 :
2
3
4 6 2
f
5
2
9 10
f
0
Sample output 2 :
6 2 4
9 10
 */

public class Q03RotateTheArray {
    public static void rotateArrayTwo(int n, int d, int r, int[] num) {
        // Write your code here.
        r = r%n;

        if(d=='b'){
            reverse(num,0,r-1);
            reverse(num,r,n-1);
            reverse(num,0,n-1);
        }
        else if(d=='f'){
            reverse(num,0,n-r-1);
            reverse(num,n-r,n-1);
            reverse(num,0,n-1);
        }

    }

    private static void reverse(int[] arr, int start, int end){
        // int i=start;
        // int j = end;
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }



//    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
//        // Write your code here.
//        // Bruteforce:-
//        // Bruteforce approach is to take the first B elems from the current array and store it in another
//        // array. then start traversing on current array from B, and pick each elem, and put it into the
//        // ans[] array from 0th index. once put all the elems from current array, just append the other
//        // elems  as well from another[] array in the ans[] array.
//        // TC:- O(B) + O(N-B) + O(B) => O(N+B);
//        // SC :- O(B){to store first B elems temporarily somewhere} + O(N){to store all the elems in ans}
//
//        /*
//        // Storing 1st K elems into separate Array
//        int[] temp = new int[k];
//        for(int i=0;i<k;i++) temp[i]=arr.get(i);
//
//        // shifting elems
//        for(int i=k;i<arr.size();i++){
//            arr.set(i-k,arr.get(i));
//        }
//
//        // filling k elems to end
//        for(int i=0;i<temp.length;i++){
//            arr.set(arr.size()-k+i, temp[i]);
//        }
//        return arr;
//        */
//
//        // Optimised Brute:-
//        // for(int i=0;i<A.length;i++){
//        //     if(i<B) another[i]=A[i];
//        //     else ans[i-B] = A[i];
//        // }
//        // for(int i=0;i<another.length;i++){
//        //     ans[i+B] = another[i];
//        // }
//
//
//        // Optimised:-
//        // reverse/swap for 1st k elems
//        // reverse/swap remaining K elems
//        // reverse/swap whole arr
//        // TC:- O(B)//for 1st B rotation + O(N-B)// for remaining elems rotation + O(N)//for whole array rotation ==> O(2N)
//        // SC :- O(1)
//
//        k=k%arr.size();
//        reverse(arr,0,k-1);
//        reverse(arr,k,arr.size()-1);
//        reverse(arr,0,arr.size()-1);
//        return arr;
//
//    }
//
//    private static void reverse(ArrayList<Integer> arr, int start, int end){
//        // int i=start;
//        // int j = end;
//        while(start<end){
//            swap(arr,start,end);
//            start++;
//            end--;
//        }
//    }
//
//    private static void swap(ArrayList<Integer> arr, int i, int j){
//        int temp=arr.get(i);
//        arr.set(i,arr.get(j));
//        arr.set(j,temp);
//    }

}
