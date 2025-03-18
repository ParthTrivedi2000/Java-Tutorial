package org.allTopics.LinkedList.DoublyLinkedList;

// Problem Link :- https://www.geeksforgeeks.org/problems/introduction-to-doubly-linked-list/0

/*
Problem Description :-
Geek is learning data structures and is familiar with linked lists, but he's curious about how to access the previous
element in a linked list in the same way that we access the next element. His teacher explains doubly linked lists to
him.
Given an integer array arr of size n. Construct the doubly linked list from arr and return the head of it.

Example 1:
Input:
n = 5
arr = [1,2,3,4,5]
Output:
1 2 3 4 5
Explanation: Linked list for the given array will be 1<->2<->3<->4<->5.
Example 2:
Input:
n = 1
arr = [1]
Output:
1
Explanation: Linked list for the given array will be 1.
Constraints:
1 <= n <= 10^5
1 <= arr[i] <= 100

Your Task:
You don't need to read input or print anything. Your task is to complete the function constructDLL() which takes arr[]
as input parameters and returns the head of the Linked List.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
 */

public class DLL01ArrayToDLL {
    DLLNode constructDLL(int arr[]) {
        // Code here
        if(arr.length==0) return null;
        if(arr.length==1) return new DLLNode(arr[0]);
        DLLNode head = new DLLNode(arr[0]);
        DLLNode prevNd = head;

        for(int i=1;i<arr.length;i++){
            DLLNode temp = new DLLNode(arr[i]);
            temp.next=null;
            temp.prev = prevNd;
            prevNd.next = temp;
            prevNd = temp;
        }

        // prevNd.next=null;

        return head;
    }
}
