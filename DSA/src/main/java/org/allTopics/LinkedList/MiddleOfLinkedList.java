package org.allTopics.LinkedList;

public class MiddleOfLinkedList {
    public Node middleNode(Node head) {
        if (head.next == null || head==null) return head;
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
