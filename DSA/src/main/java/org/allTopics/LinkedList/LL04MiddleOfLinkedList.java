package org.allTopics.LinkedList;

// Q) Middle of the Linked List
// Problem Link :- https://leetcode.com/problems/middle-of-the-linked-list/description/

/*
Problem Description :-
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

Constraints:
The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100

 */

public class LL04MiddleOfLinkedList {
    public Node middleNode(Node head) {
        /*
        Standard way to find the middle of the LL:- is to use the Tortoise and Hare method.
        - Take 2 pointers. And place each on head.
        - 1 pointer move 1 step ahead and another pointer move 2 step ahead.
        - Need to do this till end of the LL
         */

        // Note 2 points over here:-
        // - this method gives you 2nsd element (N/2 + 1)th element as middle in case of even length LL. If you
        // want N/2th elem as middle, then you have to just maintain the prev element in above approach.
        // - 2nd point is make sure to keep fast!=null condition before fast.next!=null in the while. else it will
        // give NULLPointerException.
        if (head.next == null || head==null) return head;
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
