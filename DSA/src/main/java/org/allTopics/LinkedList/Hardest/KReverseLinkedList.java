package org.allTopics.LinkedList;

//Problem Link:- https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1

/* Problem Description:-
Given the head a linked list, the task is to reverse every k node in the linked list. If the number of nodes
is not a multiple of k then the left-out nodes in the end, should be considered as a group and must be reversed.

Examples:
Input: head = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8, k = 4
Output: 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5
Explanation: The first 4 elements 1, 2, 2, 4 are reversed first and then the next 4 elements 5, 6, 7, 8. Hence,
the resultant linked list is 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5.

Input: head = 1 -> 2 -> 3 -> 4 -> 5, k = 3
Output: 3 -> 2 -> 1 -> 5 -> 4
Explanation: The first 3 elements 1, 2, 3 are reversed first and then left out elements 4, 5 are reversed.
Hence, the resultant linked list is 3 -> 2 -> 1 -> 5 -> 4.

Constraints:
1 <= size of linked list <= 10^5
1 <= data of nodes <= 10^6
1 <= k <= size of linked list

*/

// Please go through all the approaches once:- https://www.geeksforgeeks.org/reverse-a-linked-list-in-groups-of-given-size/

public class KReverseLinkedList {
    public static Node reverseKGroup(Node head, int k) {
        // Approach: Using Recursion:-
        // so we need to perform below 3 steps to achieve our final answer.
        // - Given list can be split into bucket of length B.
        // - Then we will try to solve for the one bucket, i.e. reversing a single linked list (which we already know how to do).
        // - So now our problem is modified to solving the problem for each bucket and then concateneting the lists to get a final
        // K-reversed LinkedList.
        return reverse(head,k);

    }

    public static Node reverse(Node head, int k){
        Node curr=head;
        Node prev=null;
        Node nextNode = null;
        int i=0;
        while(curr!=null && i<k){
            nextNode =curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
            i++;
        }
        // Now till here, it's normal reversing LinkedList code ryt. but main crux of this function to make it recursive lies over here
        // only. See carefully.
        // Like currently you prev is pointing to the newhead of the new LinkedList. and nextNode is pointing to the next if it was not
        // null.
        // But notice very carefully ki head pointer which was given in argument, is still pointing to the old head only.
        // So for example:- [1,2,3,4,5,6];k=3
        // so now at end of 1st recursive call of this function, my prev=3, nextNode=4, but head is still pointing to element 1 here
        // So now this portion of liknedlist looks like[3->2->1 [4->5->6]].
        // So we have to connect 1 to next reversed bucket. and 1 is what? currently it is still head i.e. head.next to next reversed bucket ryt? so recursive call should be like below.
        // since we want to perform this recursion till my nextNode is not equals to null,
        if(nextNode!=null) head.next= reverse(nextNode,k);
        return prev;
    }
}




// Problem With Slight Modification
// Problem Statement :- https://leetcode.com/problems/reverse-nodes-in-k-group/description/

// Please check it without missing.

// Above we have used recursive approach. Here we are using Iterative approach.
class Solution1 {
    public Node reverseKGroup(Node head, int k) {
        if(head==null || head.next==null) return head;

        Node dummy = new Node(0);
        Node prev = dummy;
        prev.next = head;
        while (head != null) {
            int cnt = 1;
            Node cur = head;
            // take B consecutive nodes and reverse them
            while (cur.next != null && cnt < k) {
                cnt++;
                cur = cur.next;
            }
            if (cnt == k) {
                Node next = cur.next;
                cur.next = null;
                Node rev = reverse(head);
                prev.next = rev;
                head.next = next;
            }
            prev = head;
            head = head.next;
        }
        return dummy.next;
    }

    public Node reverse(Node head) {
        Node prev = new Node(0);
        Node nhead = head;
        prev.next = head;
        while (head != null) {
            Node tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        nhead.next = null;
        return prev;
    }
}