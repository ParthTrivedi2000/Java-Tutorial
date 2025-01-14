package org.allTopics.LinkedList;
/* Q) Remove Nth Node From End of List
Problem Link:- https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
Problem Description:-
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example:-
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:
Input: head = [1], n = 1
Output: []
Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

 */

public class LL03RemoveNthNodeFromEndOfList {
    public Node removeNthFromEnd(Node A, int B){
//        Approach - 1:-
//        int n;
//        Node node;
//        if (A == null) return null;
//        n = 0;
//        node = A;
//        // calculates the size of the linked list
//        while (node != null) {
//            n++;
//            node = node.next;
//        }
//        if (B >= n) return A.next;
//        node = A;
//        for (int i = 0; i < n - B - 1; i++) node = node.next;
//        node.next = node.next.next;
//        return A;

        // Follow up Question:- Can you please do it in 1 pass.
        /*
        Solution:- Always remember in LinkedList one pass is only possible using slow and fast pointer. So
        whenever in interview discussion/question is about single pass, you can think of using slow-fast
        pointer method.

        Approach - 2:-
        So idea or logic behind using this 2 pointers is, if you see carefully in code, 1st we created the
        distance of n nodes between 2 pointers (fast and slow). so now if we start traversing the linked list
        with both the pointers then what happens is when my fast pointer will reach to the end of the
        linked list at that time my slow pointer will be n nodes behind the fast pointer ( just recall ki hmne
        starting m fast ko isiliye n node aage hi rkh k traversing start kiya tha taki m wha se traversing
        start kru to jb fast pointer list k last node pe pahuchega tb pi6e wala node h wo n nodes back pe hi
        pahucha hoga since we have started slow pointer to traverse from start).
        And another thing is we have applied one check of if fast==null/ bec suppose given list is
        1-->2-->3-->none, and n=3
        Now in this case what happens??
        if you think like when we are placing our fast pointer and slow pointer, at that time only my slow
        pointer completes the LL and reached to the end. then as per question we have to remove 3rd node from last
        i.e. 1st node from start in above case ryt. so that is why in this case we kept that check ki if fast
        pointer will reach to last at the time of placement of pointers then I have to again start of
        the LinkedList.
        And one more last thing ki in above example if you think ki what will be the answer if n=4, then it is
        invalid input, bec in constraints it's given that n should be in between 0 to no.of nodes in LL.

        // This will unfortunately cause a problem when n is the same as the length of the list,
        // which would make the first node the target node, and thus make it impossible to find
        // the node before the target node. If that's the case, however, we can just return
        // head.next without needing to stitch together the two sides of the target node.
         */

        Node fast = A, slow = A;
        for (int i = 0; i < B; i++) fast = fast.next;
        if (fast == null) return A.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return A;
    }
}
