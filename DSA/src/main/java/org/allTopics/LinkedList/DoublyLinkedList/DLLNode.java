package org.allTopics.LinkedList.DoublyLinkedList;

public class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;
    DLLNode(int val){
        this.data = val;
        this.next = null;
        this.prev = null;
    }

    DLLNode(int val, DLLNode next, DLLNode prev){
        this.data = val;
        this.next = next;
        this.prev = prev;
    }
}
