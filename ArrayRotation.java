// Q)
// John Watson knows of an operation called a right circular rotation on an array of integers. One rotation operation moves the last array element to the first position and shifts all remaining elements right one. To test the abilities of Sherlock , Watson provides Sherlock with an array of integers. Sherlock is to perform the rotation operation a number of times then determine the value of the element at a given position.
// For each array, perform a number of right circular rotations and return the values of the elements at the given indices in array queries.

// Input Format
// The first line contains 3 space-separated integers n, k & q the number of elements in the integer array, the rotation count and the number of queries.
// The second line contains n space-separated integers, describing elements in arr.
// The third line contains q space-seprated integers, describing elements in queries

// Output Format
// Return the array containing values of the elements at the given indices in array queries.

// Example 1
// Input
// 3 2 2
// 3 4 5
// 1 2
// Output
// 5 3
// Explanation
// arr = [3,4,5]
// k = 2
// queries = [1,2]
// Here k is the number of rotations on `arr`, and `queries` holds the list of indices to report. 
// First we perform the two rotations: 
// [3,4,5] -> [5,3,4] -> [4,5,3]
// Now return the values from the zero-based indices 1 and 2 as indicated in the `queries` array.
// arr[1]=5
// arr[2]=3

// Example 2
// Input
// 3 2 3
// 1 2 3
// 0 1 2
// Output
// 2 3 1
// Explanation
// arr = [1,2,3]
// k = 2
// queries = [0,1,2]
// Here k is the number of rotations on `arr`, and `queries` holds the list of indices to report. 
// First we perform the two rotations: 
// [1,2,3] -> [3,1,2] -> [2,3,1]
// Now return the values from the zero-based indices 0, 1 and 2 as indicated in the `queries` array.
// arr[0] = 2
// arr[1] = 3
// arr[2] = 1

// Constraints
// 1 <= n <= 10^5
// 1 <= arr[i] <= 10^5
// 1 <= k <= 10^5
// 1 <= q <= 500
// 0 <= queries[i] <= n

// Solution :- 
// Approach :- Time Complexity O(N) or O(Q), Space Complexity O(N) 
// 1) take n,k,q as input. then take array as input.
// 2) then we have to create new array with old elements at new indexes.
// have to update all elements at new indexes.
// 3) newArr[(oldIndex+rotation)%sizeOfArray] = arr[oldIndex]
// 4) then fetch elemetns from array at q positions and print it.

import java.util.*;

public class ArrayRotation {
    public static void main(String[] args){
        Scanner any = new Scanner(System.in);
        int n = any.nextInt();
        int k = any.nextInt();
        int q = any.nextInt(); 
        if(k>n)
        {
            k = k%n;
        }
        
        int arr[] = new int [n];

        for(int i=0;i<n;i++)
        {
            arr[i] = any.nextInt();
        }

        int newArr[]= new int[n];
        // int newIndex = (originalIndex+rotation)%size;
 
        for(int i=0;i<n;i++)
        {
            newArr[(i+k)%n] = arr[i];
        }

        for(int j=0;j<q;j++)
        {
            int x = any.nextInt();
            System.out.println(newArr[x]+" ");
        }
    }
    
}
