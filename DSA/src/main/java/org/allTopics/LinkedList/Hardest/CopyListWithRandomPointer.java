package org.allTopics.LinkedList.Hardest;

// Problem Link:- https://leetcode.com/problems/copy-list-with-random-pointer/description/

/*
Problem Description:-
A linked list of length n is given such that each ListNode contains an additional random pointer, which could point to
any ListNode in the list, or null.
Construct a deep copy of the list. The deep copy should consist of exactly n brand new ListNodes, where each new ListNode has
its value set to the value of its corresponding original ListNode. Both the next and random pointer of the new ListNodes
should point to new ListNodes in the copied list such that the pointers in the original list and copied list represent the
same list state. None of the pointers in the new list should point to ListNodes in the original list.
For example, if there are two ListNodes X and Y in the original list, where X.random --> Y, then for the corresponding
two ListNodes x and y in the copied list, x.random --> y.
Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n ListNodes. Each ListNode is represented as a pair
of [val, random_index] where:
val: an integer representing ListNode.val
random_index: the index of the ListNode (range from 0 to n-1) that the random pointer points to, or null if it does not point to any ListNode.
Your code will only be given the head of the original linked list.

Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

Constraints:
0 <= n <= 1000
-10^4 <= ListNode.val <= 10^4
ListNode.random is null or is pointing to some ListNode in the linked list.
 */


class ListNode {
    int val;
    ListNode next;
    ListNode random;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    /*
    // Bruteforce Approach:- is to use the map<ListNode,ListNode>. And you can store the ListNode and it's corresponding
    // random pointer in the map. and then start creating new copied LL by creating ListNodes from given list and
    // then look up the random pointers from the map and assign the corresponding random pointers to the new
    // copied elems of nre list. and return the head of new copied list.
    // TC:- O(N), SC:- O(N) where N is the number of ListNodes given in the ip list.

    private HashMap < RandomListNode, RandomListNode > hashMap;
    public ListNode copyRandomList(ListNode head) {
        ListNode node, newHead, newNode;
        hashMap = new HashMap < > ();
        node = head;
        newHead = null;
        while (node != null) {
            newNode = new ListNode(node.val);
            if (newHead == null)
                newHead = newNode;
            hashMap.put(node, newNode);
            node = node.next;
        }
        for (Map.Entry < ListNode, ListNode > entry: hashMap.entrySet()) {
            node = entry.getKey();
            newNode = entry.getValue();
            if (node.next != null) {
                newNode.next = hashMap.get(node.next);
            }
            if (node.random != null) {
                newNode.random = hashMap.get(node.random);
            }
        }
        return newHead;
    }

     */

    // But main thing is, it was asked by interviewer to do it in SC of O(1).
    public ListNode copyRandomList(ListNode head) {
        if(head==null) return head;
        // Below I have created the copy of same list ListNodes conencted with the current
        // list. i.e. if list give n is 7-->13-->11-->10-->1--null, I have converted it to
        // 7-->7-->13-->13-->11-->11-->10-->10-->1-->1--null
        ListNode curr=head;
        while(curr!=null){
            ListNode temp = new ListNode(curr.val);
            temp.next=curr.next;
            curr.next = temp;
            curr=temp.next;
        }

        // Now we just need to point out random pointers as per the given ip list ryt?
        curr=head;
        while(curr!=null){
            if(curr.random!=null) curr.next.random = curr.random.next;
            curr=curr.next.next;
        }

        // Now again, i just have to decouple copied list from original list.
        curr=head;
        ListNode newHead = curr.next;
        ListNode temp = newHead;
        while(curr!=null){
            temp = curr.next;
            curr.next=curr.next.next;
            if(temp.next!=null) temp.next=temp.next.next;
            curr=curr.next;
        }
        return newHead;
    }
}

