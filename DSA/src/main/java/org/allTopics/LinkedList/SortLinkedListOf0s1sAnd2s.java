package org.allTopics.LinkedList;

// Problem Link :- https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

/*
Problem Description :-
Given a linked list where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked
list such that all zeros segregate to the head side, 2s at the end of the linked list, and 1s in the middle of 0s and
2s.

Examples:

Input: LinkedList: 1->2->2->1->2->0->2->2
Output: 0->1->1->2->2->2->2->2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in
between.
Input: LinkedList: 2->2->0->1
Output: 0->1->2->2
Explanation: After arranging all the 0s,1s and 2s in the given format, the output will be 0 1 2 2.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= no. of nodes <= 10^6
0 <= node->data <= 2
 */

public class SortLinkedListOf0s1sAnd2s {
    static Node segregate(Node head) {
        // add your code here

         // Approach - 1 :-Bruteforce :-
         // - Traverse the entire LL. And count the 0,1,and 2.
         // - Then again traverse the LL and replace the values as per the counts.
         // TC:- O(2N) 2 traversal
         // SC:- O(1)
        /*
         Node curr = head;
         int noZ=0;
         int noO = 0;
         int noT = 0;
         while(curr!=null){
             if(curr.val==0) noZ++;
             else if(curr.val==1) noO++;
             else if(curr.val==2) noT++;
             curr = curr.next;
         }

         Node dummy = new Node(-1);
         Node temp = dummy;
         for(int i=0;i<noZ;i++){
             Node elem = new Node(0);
             temp.next = elem;
             temp=temp.next;
         }

         for(int j=0;j<noO;j++){
             Node elem = new Node(1);
             temp.next = elem;
             temp=temp.next;
         }

         for(int i=0;i<noT;i++){
             Node elem = new Node(2);
             temp.next = elem;
             temp = temp.next;
         }
         return dummy.next;

         */


        // Approach - 2:- Optimised Appraoch:- in single traversal
        // - Take 3 seperate list.
        // - Tarverse the LL and Append the list based on value of 0,1,2.
        // - At last just connect them.
        // TC :- O(N) single traversal
        // SC:- O(1)

        Node list0 = new Node(-1);
        Node list1 = new Node(-1);
        Node list2 = new Node(-1);
        Node tail0 = list0;
        Node tail1 = list1;
        Node tail2 = list2;

        Node curr = head;
        while(curr!=null){
            if(curr.val==0){
                tail0.next = curr;
                tail0 = tail0.next;
                curr = curr.next;
                tail0.next = null;
            }
            else if(curr.val == 1){
                tail1.next = curr;
                tail1 = tail1.next;
                curr = curr.next;
                tail1.next = null;
            }
            else{
                tail2.next = curr;
                tail2 = tail2.next;
                curr = curr.next;
                tail2.next = null;
            }
        }

        tail0.next = list1.next!=null?list1.next:list2.next;
        tail1.next = list2.next;
        return list0.next;
    }
}
