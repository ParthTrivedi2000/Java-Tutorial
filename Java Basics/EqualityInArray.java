// Q) :- Given an array of integers, determine the minimum number of elements to delete to leave only elements of equal value.
// Example
// arr= [1,2,2,3]
// Delete the 2 elements 1 and 3 leaving arr as [2,2]. If both twos plus either the 1 or the 3 are deleted, it takes 3 deletions to leave either [3] or [1]. The minimum number of deletions is . 2

// Solution :-
// logic:-
        // 1) find the maximum frequency of an element from the array.
        // 2) remaining all element needs to be deleted. hence 
        // formula = size of array - maximum frequency of an element

// import java.util.Scanner;

// public class EqualityInArray {

//     // Approach - 1) which has Time Complexity of O(N^2)

//     // Concept:- whenever u want to find frequency of an element from array, how to find?
//     // we have to chaek for 1st element weather this element is present or not in the array. if it is
//     // present then we have to increase count by 1. same we have to do for all elements in the array. it
//     // means to iterate all the elements of array 2 times.
//     public static void main(String[] args) {
        
//         Scanner any = new Scanner(System.in);
//         int size = any.nextInt();
//         int[] arr = new int[size];
//         for (int i=0;i<size;i++){   // taking array input from system and store in an array
//             arr[i] = any.nextInt();
//         }

//         int maxFrequency = 0;
//         for(int i=0;i<size;i++){
//             int currentFrequency=0;
//             for(int j=0;j<size;j++){
//                 if(arr[i]==arr[j]){
//                     currentFrequency++;
//                 }
//                 if (currentFrequency>maxFrequency){
//                     maxFrequency = currentFrequency;
//                 }
//             }
//             System.out.println(arr[i]+" "+ maxFrequency);
//         }
//         System.out.println("Minimum elements to be deleted: "+ (size-maxFrequency));

//     }
// }

// Above approach is brute force. It is not optimal one. That approach is aving O(N^2) time
// complexity. Now in question if constraint given for N is 0<N<10^6. then it means using above
// approach we need to perform O(10^12) operations in 1 sec.(but we will get the time exceded error
// if operations are>10^8 in 1 second). So we will go for another approach. which is using frequency
// array approach.

// One Thumb Rule is :- if I want to decrease Time Coomplaxity then--> Space Complexity will be increased.



// Approach - 2) which has O(N) time complexity and O(N) Space Complexity.

import java.util.*;
public class EqualityInArray{
    public static void main(String[] args) {
        Scanner any = new Scanner(System.in);
        int n = any.nextInt();
        int arr[] = new int[n];
        int maxi = 0;

        for (int i=0;i<n;i++){
            arr[i] = any.nextInt();
            if(arr[i]>maxi){
                maxi = arr[i];
            }
        }

        int frequency[] = new int[maxi+1];
        int maxFrequency = 0;

        for (int i=0;i<n;i++){
            frequency[arr[i]]++;
            if(frequency[arr[i]]>maxFrequency){
                maxFrequency=frequency[arr[i]];
            }
        }

        System.out.println((n-maxFrequency));

    }
}