package org.allTopics.Stacks;

// Implementation of Stacks using Linked List:-
// Now as we know like in array, we are having fixed size. so that is the main disadvantage of having stacks
// implemented with Arrays. and one another thing is of insertion and deletion operation in array took
// O(N). but remember like main purpose of having stack data structure is to get advantage of insertion
// and deletion operation in O(1) time.
// So now another option of implementation of stack is, Linked List. as using linked list we don't have any
// size issues. and we will be having dynamic size. And 2nd thing is, in linked list if you can recall
// there are some places at which if we want to delete or insert something then it will take O(N) TC only.
// So let's implement stack using Linked List. But there are also few positions in Linked List, at which
// If I want to perform insertion/deletion then I can do it in O(1). such position:- head. another is
// Tail (bt only if you are maintaining Tail element from starting of linked list).

class Node{
    int val;
    Node next;

    public Node(int data) {
        this.val = data;
        this.next = null;
    }

    public Node(int value, Node addr) {
        this.val = value;
        this.next = addr;
    }
}

public class ST00StackImplUsingLinkedList {
    //    Remember one thing. we want to have insertion and deletion of O(1) time. and that is only possible
    //    when we want to insert and delete something at/from Head position. So whenever we will push, then
    //    we will push it to head position only. or even it would be better to insert at head position bec
    //    when user want to perform pop() operation at time also we can do it in O(1) if element is at head.
    Node head=null;
    int size = 0;
    public void push(int data){
    //    here there is no problem of overflow as we are using Linked List as DS hence. so no need to check
    //    for Overflow edge case.
        Node nd = new Node(data);
        if(head==null) head = nd;
        else{
            nd.next = head;
            head = nd;
            size++;
        }
    }

    public int pop(){
    //   if stack is empty
        if(isEmpty()){
            System.out.println("Underflow");
            return -1;
        }
        int temp = head.val;
        head = head.next;
        size--;
        return temp;
    }

    public int peek(){
    //   if stack is empty.
        if(isEmpty()){
            System.out.println("Underflow");
            return -1;
        }
        return head.val;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
