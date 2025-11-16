package org.allTopics.LinkedList;

//Problem Link :- https://leetcode.com/problems/add-two-numbers/description/

/*
Problem Description :-
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */

public class AddTwoNumbers {
    public Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;
        int newVal = 0;

        Node head =new Node(-1);
        Node tail = head;

        while(l1!=null || l2!=null || carry > 0){
            newVal = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

            carry = newVal / 10;

            tail.next = new Node(newVal%10);
            tail = tail.next;

            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        return head.next;
    }
}



// Another Good Question of related above problem. Please look this as well, slight modified problem.
// This is a bit Trickier than above one
// Problem Link :- https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1

// Problem Description :-
/*

For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked
list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:
Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
Output:  3 -> 9 -> 0
Explanation: Given numbers are 45 and 345. There sum is 390.
Input: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7
Output: 7 -> 0
Explanation: Given numbers are 63 and 7. There sum is 70.
Constraints:
        1 <= size of both linked lists <= 10^6
        0 <= elements of both linked lists <= 9
 */

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        Node l1 = reverseList(num1);
        Node l2 = reverseList(num2);
        Node curr = null;
        int carry = 0;
        while(l1!=null || l2!=null || carry >0){
            int v1 = l1!=null ? l1.val : 0;
            int v2 = l2!=null ? l2.val : 0;
            int sum = v1+v2+carry;
            carry = sum/10;
            Node tmp = new Node(sum%10);
            tmp.next = curr;
            curr = tmp;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        while(curr!=null && curr.val == 0){
            curr=curr.next;
        }
        return curr;

    }
    static Node reverseList(Node head) {
        // code here
        Node tmpHead = null;
        while(head!=null){
            Node nex = head.next;
            if(tmpHead == null) {
                tmpHead = head;
                tmpHead.next = null;
            }
            else {
                head.next = tmpHead;
                tmpHead = head;
            }
            head = nex;
        }
        return tmpHead;
    }
}