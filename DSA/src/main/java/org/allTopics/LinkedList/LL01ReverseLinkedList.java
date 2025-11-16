package org.allTopics.LinkedList;

//Problem Link:- https://leetcode.com/problems/reverse-linked-list/

// Q) Reverse a Linked List. head is given as an argument.
/*

Problem Description :- Given the head of a singly linked list, reverse the list, and return the reversed list.
Example:-
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:
Input: head = [1,2]
Output: [2,1]
Example 3:
Input: head = []
Output: []

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LL01ReverseLinkedList {

    // Approach - 1:-
    // Bruteforce Approach :-
    // TC:- O(N)+O(N)+O(N) = O(3N) i.e. 3  iteration of N elems
    // SC:- O(N)
    // - Iterate over LinkedList and store it in ArrayList.
    // - Just simply reverse the ArrayList.
    // - And now again convert the ArrayList to LinkedList back.
    public Node reverseListBrute(Node head) {
        ArrayList<Integer> LL = new ArrayList<>();
        Node temp=head;
        while(temp!=null){
            LL.add(temp.val);
            temp=temp.next;
        }
        Collections.reverse(LL);
        Node dummy=new Node(-1);
        Node iter=dummy;
        for(int elem:LL){
            Node nd=new Node(elem);
            iter.next=nd;
            iter=iter.next;
        }
        return dummy.next;
    }

    // Approach - 2:- Since Linked list is all about pointers ryt so why to store elems and all those things?
    // I mean simply we can just change the direction of each pointers, and we will be able to get the answer.
    // Time Complexity: O(n), Traversing over the linked list of size n only once.
    // Auxiliary Space: O(1)

    // we have to use the 3 pointers. prev, curr, next. bec somehow I want to point
    // out the next elem to the curr elem or I can say curr elem to the prev elem
    // ryt? so let's do it.

    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node nextNode = null;
        while(curr!=null){
            nextNode = curr.next; //storing current elems address for future use.
            curr.next = prev; // now changing the curr elems pointer in reverse direction
            prev = curr;
            curr = nextNode; // using previously stored elem to move current pointer ahead
        }
        // At last if you notice then curr pointing to null and prev pointing to last elem
        // so returning prev.
        return prev;
    }



    // Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
    // above we have seen the iterative solution. let's see the recursive code.

    // Approach - 3:- Recursive code.
    /*
    The idea is to reach the last node of the linked list using recursion then start reversing the linked list
    from the last node.

    Follow the steps below to solve the problem:
     - Divide the list in two parts – first node and rest of the linked list.
     - Call reverse for the rest of the linked list.
     - Link the rest linked list to first.
     - Fix head pointer to NULL.
     Time Complexity: O(n), visiting over every node one time.
     Auxiliary Space: O(n) , Function call stack space.

     */

    public Node reverseListRec(Node head, Node prev){
        // Base case:-
        // If we have reached the last node or the linked
        // list is empty, simply return the head of linked
        // list
        if (head == null || head.next == null) return head;
        // reverse the rest of linked list and put the first element at the end
        Node rest = reverseList(head.next);
        // Make the current head as last node of remaining linked list
        head.next.next = head;
        head.next = null; // Update next of current head to NULL
        // Return the reversed linked list
        return rest;


        // Follow below instead of above:-
        /*
         Try to always think about the smallest case in recursion, and how will you perform reverse in that case simply
         think about it
         1 ===> 1
         1-->2 ===> 2-->1
         head.next i.e. 2 ka next I have to set it as 1 i.e. head => head.next.next=head;
         and need to remove the link between them hence:- head.next=null;
         And 3rd imp point is, every time whenever you are returning, at that time
         propagate that what is last elem you were? hence simply you are not doing
         anything with last but always doing something with head, hence last always stays
         as it is of 1st call's return value i.e. here 2 during all the calls.
         see code for more understanding.

         */

        // Recursive code:-
        /*
        if(head==null || head.next==null) return head;

        // rec call
        Node last = reverseListRec(head.next);
        head.next.next=head; // changing the pointer
        head.next=null;
        return last;
         */
    }

    // Approach - 4:- Using Stacks:-
    /* The idea is to traverse the linked list and push all nodes except the last node into the stack. Make
     the last node as the new head of the reversed linked list. Now, start popping the element and append
     each node to the reversed Linked List. Finally, return the head of the reversed linked list.
     Time Complexity: O(N), Visiting every node of the linked list of size N.
     Auxiliary Space: O(N), Space is used to store the nodes in the stack.
     */

    public Node reverseListUsingStack(Node head){
        Stack<Node> stack = new Stack<>(); // Create a stack to store the nodes
        Node temp = head;
        // Push all nodes except the last node into stack
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        // Make the last node as new head of the linked list
        if (!stack.isEmpty()) {
            head = stack.pop();
            temp = head;
            // Pop all the nodes and append to the linked list
            while (!stack.isEmpty()) {
                temp.next = stack.pop(); // append the top value of stack in list
                temp = temp.next; // move to the next node in the list
            }
            temp.next = null; // Update the next pointer of last node of stack to NULL else it is resulting in cycle
        }
        return head;


        // My Solution using stack:-
        /*
        if(head==null || head.next==null) return head;
        Node curr=head;
        Stack<Node> st = new Stack<>();
        Node nextNode=null;
        while(curr!=null){
            nextNode=curr.next;
            st.push(curr);
            curr.next=null;
            curr=nextNode;
        }


        curr=st.pop();
        Node ans=curr;
        while(!st.isEmpty()){
            curr.next=st.pop();
            curr=curr.next;
        }
        return ans;
         */
    }
}
