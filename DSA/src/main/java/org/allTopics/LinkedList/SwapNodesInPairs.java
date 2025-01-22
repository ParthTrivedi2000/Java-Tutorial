class SwapNodesInPairs{
    public Node swapPairs(ListNode head) {
        Node dummy=new Node(-1);
        Node prev=dummy;
        dummy.next=head;
        Node curr=head;
        Node nextNode;
        while(curr!=null && curr.next!=null){
            nextNode=curr.next.next;
            curr.next.next=curr;
            prev.next=curr.next;
            curr.next=nextNode;
            prev=curr;
            curr=curr.next;
        }
        return dummy.next;
    }
}