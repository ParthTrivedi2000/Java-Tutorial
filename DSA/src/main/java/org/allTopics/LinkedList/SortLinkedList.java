package org.allTopics.LinkedList;

public class SortLinkedList {
    public Node sortList(Node head) {
        /* Approach is to use Merge Sort.
         - get the middle node 1st. 
         - then need to pass the 2 list to merge function. 
         - and we can perform merge 2 sorted arrays function.      
         */

        if(head==null || head.next==null) return head;
        return mergeSort(head);
    }

    public Node getMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node head1, Node head2){
        Node finalHead=null;
        Node tail = null;
        if(head1==null) {
            // finalHead = head2;
            return head2;
        }
        if(head2==null) {
            // finalHead = head1;
            return head1;
        }

        if(head1.val<=head2.val){
            finalHead = head1;
            tail = head1;
            head1 = head1.next;
        } else {
            finalHead = head2;
            tail = head2;
            head2 = head2.next;
        }

        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                tail.next=head1;
                head1 = head1.next;
                tail = tail.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            }
        }

        if(head1!=null){
            tail.next = head1;
        }
        if(head2!=null){
            tail.next = head2;
        }
        return finalHead;
    }

    public Node mergeSort(Node head){
        if(head.next==null) return head;

        Node middle = getMiddle(head);

        Node newHead = middle.next;
        middle.next=null; // cutting link to seperate 2 list and pass it to the recursive mergesort fn.
        Node l1 = mergeSort(head);
        Node l2 = mergeSort(newHead);

        Node finalList = merge(l1,l2);
        return finalList;
    }
}
