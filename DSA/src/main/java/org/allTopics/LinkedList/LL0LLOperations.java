package org.allTopics.LinkedList;

public class LL0LLOperations {
    Node head = null;
    public void insert(int elem, int position){

        Node newElem = new Node(elem);
        // If there is an empty LL
        if(head==null) head=newElem;
        // If wants to insert at 0 the position of existing LL
        if(position==0){
            newElem.next = head;
            head = newElem;
        }

        // If want to add in between or last
        int pos=0;
        Node temp = head;
        while(pos<position){
            if(temp==null) System.out.println("Enter Valid Position");
            temp=temp.next;
            pos++;
        }
        newElem.next = temp.next;
        temp.next = newElem;

    }

    public void delete(int elem){
        if(head==null){
            System.out.println("LL is empty");
            return;
        }

        // deletion of head element
        if(head.val==elem) head = head.next;

        // deletion of intermediate element
        Node prev=null;
        Node curr = head;
        while(curr.val!=elem){
            if(curr.next!=null){
                prev = curr;
                curr = curr.next;
            }
        }
        //Once you reached at that elem
        prev.next=curr.next;
        curr.next=null;
    }

    public void printLL(){
        if(head==null) System.out.println("LL is empty");
        Node curr = head;
        while(curr!=null){
            System.out.print(" " + curr.val);
            curr=curr.next;
        }
    }
}
