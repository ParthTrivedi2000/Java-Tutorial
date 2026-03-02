package org.allTopics.LinkedList;

//Link :- https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

// Problem Statement :-
/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
Return the linked list sorted as well.

Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]

Constraints:
The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class RemoveDuplicatesFromSortedList {
    public Node deleteDuplicates(Node head) {
        if(head==null || head.next==null) return head;

        Node curr = head.next;
        Node prev = head;
        while(curr!=null){
            if(prev.val==curr.val){
                prev.next=curr.next;
                curr = curr.next;
                continue;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}

