package org.allTopics.LinkedList.DoublyLinkedList;

// Problem Link :- https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1

/*
Problem Description :-
Given a doubly linked list. Your task is to reverse the doubly linked list and return its head.

Examples:
Input: LinkedList: 3 <-> 4 <-> 5
Output: 5 <-> 4 <-> 3
Input: LinkedList: 75 <-> 122 <-> 59 <-> 196
Output: 196 <-> 59 <-> 122 <-> 75
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 <= number of nodes <= 10^6
0 <= node->data <= 10^4
 */

public class DLL02ReverseDLL {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        // // Approach - 1:- Bruteforce :- Using an ArrayList as DS
        // // - Store the elements in the array and then start traversing from last.
        // // TC:- O(N) + O(N) ~ O(2N),
        // // SC:- O(N)
        // if(head==null) return head;
        // DLLNode curr = head;
        // ArrayList<Integer> arr = new ArrayList<>();
        // while(curr!=null){
        //     arr.add(curr.data);
        //     curr = curr.next;
        // }

        // DLLNode newHead = new DLLNode(arr.get(arr.size()-1));
        // newHead.next = null;
        // newHead.prev=null;
        // curr = newHead;
        // for(int i=arr.size()-2;i>=0;i--){
        //     DLLNode temp = new DLLNode(arr.get(i));
        //     curr.next = temp;
        //     temp.prev = curr;
        //     curr = curr.next;
        // }
        // return newHead;

        // // Approach - 2:- Bruteforce :- Using Stack DS
        // // - So very simple brutefoce solution I can think of is, instead of modifying
        // // pointers I can simply keep structure as is, and pick up the data from each
        // // node and start swapping it will from last side.
        // // - We can use stack DS.
        // // - So we will put all the integers in the stack in the 1st iteration. then
        // // in the 2nd iteration, just pop the data from stack and replace in the node.
        // // - and we are done.

        // Stack<Integer> st = new Stack<>();
        // DLLNode curr=  head;
        // while(curr!=null){
        //     st.push(curr.data);
        //     curr = curr.next;
        // }

        // curr = head;
        // while(curr!=null){
        //     curr.data = st.pop();
        //     curr=curr.next;
        // }
        // return head;



        // // Approach - 2:- Optimised :- Just by modifying the Links. So we are not
        // // using any extra SC
        // // TC:- O(N), SC:- O(1)
        // DLLNode curr = head;
        // DLLNode prevNd = null;
        // DLLNode nextNd = null;
        // while(curr!=null){
        //     prevNd = curr.prev;
        //     nextNd = curr.next;
        //     curr.next = curr.prev;
        //     curr.prev = curr.next;
        //     prevNd = curr;
        //     curr=nextNd;
        // }
        // return prevNd;


        // More Optimised :-
        // But above we used 2 variables fro swapping the links. Instead if you want
        // you can do it by using only single link only.
        DLLNode curr = head;
        DLLNode prevNd = null;
        DLLNode nextNd = null;
        while(curr!=null){
            prevNd = curr.prev;
            curr.prev = curr.next;
            curr.next = prevNd;
            prevNd = curr;
            curr=curr.prev;
        }
        return prevNd;

    }
}
