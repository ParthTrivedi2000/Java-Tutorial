package org.allTopics.LinkedList;

public class Node {
    public int val;
    public Node next;
    Node(int val){
        this.val = val;
        this.next=null;
    }
    Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
}
