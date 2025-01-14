package org.allTopics.LinkedList;

// Q) Merge Two Sorted Lists :- https://leetcode.com/problems/merge-two-sorted-lists/description/

/*
Problem Description :-
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two
lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:
Input: list1 = [], list2 = []
Output: []
Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

 */

public class Merge2SortedLists {
    public Node mergeTwoLists(Node head1, Node head2) {
        if(head1==null) return head2;
        if(head2==null) return head1;

        Node head,tail;

        if(head1.val<=head2.val){
            head = head1;
            tail = head1;
            head1 = head1.next;
        }
        else{
            head = head2;
            tail = head2;
            head2 = head2.next;
        }

        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                tail.next = head1;
                head1 = head1.next;
            }
            else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail=tail.next;
        }

        if(head1!=null) tail.next = head1;

        else if(head2!=null) tail.next = head2;

        return head;
    }
}
