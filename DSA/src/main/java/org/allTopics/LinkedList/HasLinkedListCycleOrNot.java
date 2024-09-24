package org.allTopics.LinkedList;

public class HasLinkedListCycleOrNot {
    public boolean hasCycle(Node head) {
        if(head==null || head.next==null) return false;

        Node slow = head;
        Node fast = head.next;

        boolean isLoop = false;

        while(slow!=null && fast!=null && fast.next!=null){
            if(slow==fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;

        // or

        /*
        if(head==null|| head.next==null) return false;
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null){
            // if(slow==fast) return true;
            slow=slow.next;
            fast=fast.next.next;
            // if(slow==fast) return true;
        }
        return false;
         */
    }
}
