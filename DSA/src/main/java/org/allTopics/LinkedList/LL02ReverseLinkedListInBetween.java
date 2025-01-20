package org.allTopics.LinkedList;

public class LL02ReverseLinkedListInBetween {
    public Node reverse(Node head){
        Node prev,current,nextNode;
        prev = null;
        current = head;
        nextNode = null;
        while(current!=null){
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public Node reverseBetween(Node head, int left, int right) {
        if(head==null || head.next==null) return head;
        if(left==right) return head;

        // Approach - 1:- I have used another method to reverse the list.
        /*
        // int index = 1;
        // Node curr = head;
        // Node reverseStart = null; // need to fetch value from where reversing should start
        // Node reverseEnd = null;  // need to fetch value from where reversing should end
        // Node reverseStartPrev = null; // need to fetch value of just prev element after which reversing will start
        // Node reverseEndPost = null; // need to fetch value of just after element at which reversing will end

        // // Now let's get the values of above variables.
        // while(curr != null && index<=right){
        //     if(index==left){
        //         reverseStart = curr;
        //     }
        //     if(index<left){
        //         reverseStartPrev = curr;
        //     }
        //     if(index==right){
        //         reverseEnd=curr;
        //         reverseEndPost = curr.next;
        //     }
        //     curr = curr.next;
        //     index++;
        // }
        // reverseEnd.next = null; // cutting the link betn last reversed element and next one as we have already stored
        // // the next value in reverseEndPost variable.

        // reverseEnd = reverse(reverseStart);

        // // If starting position was not head 
        // if(reverseStart!=null && reverseStartPrev!=null) reverseStartPrev.next = reverseEnd;
        // // If starting position was head then we can directly change head
        // else head = reverseEnd;

        // reverseStart.next = reverseEndPost;

        // return head;
        */

        // // Approach - 2:- below code is somewhat optimised from above code. I have use the
        // // same function only to reverse the LL. Below is absolutely efficient
        // // solution in interview. but in very top notch product based company might
        // // ask or if you want to demonstrate additional knowledge from your side,
        // // then you can tell the interviewer ki still here i have used 1 iteration to
        // // find the required values. and on the same nodes again I am iterating to reverse
        // // those nodes. But i can do it in single pass. See approach-3 for that.

        /*
        // Node preReverseStart=null;
        // Node reverseStart = null;
        // Node reverseEnd = null;
        // Node postReverseEnd = null;

        // // The dummy node technique is very useful in linked list problems, especially 
        // // when you might need to modify the head of the list.

        // Node dummy = new Node(0);
        // dummy.next = head;
        // preReverseStart = dummy;

        // Node curr = head;
        // int size=1;
        // while(curr!=null){
        //     if(size<left) preReverseStart=curr;
        //     if(size==left) reverseStart=curr;
        //     if(size==right){
        //         reverseEnd=curr;
        //         postReverseEnd=curr.next;
        //     }
        //     curr=curr.next;
        //     size++;
        // }
        // if(reverseEnd!=null) reverseEnd.next=null;

        // Node prev = null;
        // curr = reverseStart;
        // Node nextNode = null;
        // while(curr!=null){
        //     nextNode=curr.next;
        //     curr.next=prev;
        //     prev=curr;
        //     curr=nextNode;
        // }
        // preReverseStart.next = prev;
        // reverseStart.next=postReverseEnd;
        // return dummy.next;
        */

        // Approach - 3:-
        // If you observe carefully, while reversing the LL,we wre using 3 variables (prev, curr,nextNode),
        // So here also doing the same thing once we reached at the reversing start point, and those 3 variables
        // are (prev,start,then) here.
        if (head == null || left == right) return head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for (int i = 0; i < left - 1; i++) prev = prev.next;

        Node start = prev.next;
        Node then = start.next;

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}
