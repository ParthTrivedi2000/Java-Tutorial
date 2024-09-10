package org.allTopics.LinkedList;

public class CheckPalindrome {
    public boolean lPalin(Node A) {
        // Step - 1:- to find the middle of the linked list using Tortoise & Hare method.
        // Step - 2:- reversing the linkedList.
        // Step - 3:- take 2 pointers by keeping each on head and newHead respectively and start comparing the data.
        // Ṣtep - 4:- return true or false based on the condition. but make sure to reverse the second half of linkedList
        // again to be in original form then return false or true.

        if (A == null || A.next == null) return true; // Empty list or single node is a palindrome

        Node middle = findMiddle(A);
        Node secondHalf = reverseList(middle.next);
        return compareLists(A, secondHalf);
    }

    private Node findMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node reverseList(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private boolean compareLists(Node first, Node second) {
        //bec everytime 2nd will reach early in case of odd length or with same number of times in case
        // of even length so checking for second pointer only.
        while (second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }
}
