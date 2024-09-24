package org.allTopics.LinkedList;

//Problem Link:- https://leetcode.com/problems/odd-even-linked-list/description/
/*
Problem Statement:-
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with
even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]

Constraints:
The number of nodes in the linked list is in the range [0, 10^4].
-10^6 <= Node.val <= 10^6
 */

public class OddEvenLinkedlist {
    public Node oddEvenList(Node head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        Node odd = head;
        Node even = head.next;
        Node temp = head.next;
        // One thing we have to notice if we check even node is null/not null or even.next 
        // is null/not null then odd nodes also be applied to this beacause odd node behind 
        // is even node
        while (even != null && even.next != null) {
            // Linking Odd indexed elems of linked list
            odd.next = odd.next.next;
            odd = odd.next; // moving to next odd node

            // Linking Even indexed elems of linked list
            even.next = even.next.next;
            even = even.next; // moving to next even node
        }
        odd.next = temp;
        return head;
    }
}
