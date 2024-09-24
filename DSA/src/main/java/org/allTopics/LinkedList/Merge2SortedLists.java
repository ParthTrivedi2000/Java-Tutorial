package org.allTopics.LinkedList;

public class Merge2SortedLists {
    public Node mergeTwoLists(Node list1, Node list2) {
        if(list1==null) return list2;
        else if(list2==null) return list1;

        Node head = list1;
        Node tail = list2;

        if(list1.val<=list2.val){
            head = list1;
            tail = list1;
            list1=list1.next;
        }
        else if(list2.val<list1.val){
            head=list2;
            tail = list2;
            list2 = list2.next;
        }

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                tail.next=list1;
                tail = tail.next;
                list1=list1.next;
            }
            else{
                tail.next=list2;
                tail = tail.next;
                list2=list2.next;
            }
        }

        while(list1!=null){
            tail.next=list1;
            tail = tail.next;
            list1=list1.next;
        }

        while(list2!=null){
            tail.next=list2;
            tail = tail.next;
            list2=list2.next;
        }
        return head;
    }
}
