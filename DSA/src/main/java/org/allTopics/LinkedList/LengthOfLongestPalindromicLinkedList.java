package org.allTopics.LinkedList;

//Problem Link:- https://www.geeksforgeeks.org/problems/length-of-longest-palindrome-in-linked-list/1

/* Problem Description:-

Given a linked list, return an integer denoting the length of the longest palindrome list that exists in
the given linked list.

Examples:
Input: Linked List: 2->3->7->3->2->12->24
Output: 5
Explanation: 2 -> 3 -> 7 -> 3 -> 2 is the linked list whose nodes leads to a palindrome.
Input: Linked List: 12->4->4->3->14
Output: 2
Explanation: 4 -> 4 is the linked list whose nodes leads to a palindrome with length 2.
Expected Time Complexity: O(n2)
Expected Space Complexity: O(1)

Constraints:
1 <= number of nodes <= 10^4
1 <= data of nodes <= 10^5

*/

import java.util.Stack;

public class LengthOfLongestPalindromicLinkedList {
// Approach:-
/*
 So to say any list/string to be palindrome, it should be read same from back and front side. so here also we need to do the same.
 for exam:- abba is palindrome (which is even palindrom), abcba(odd palindrome).

 Now instead of string we will be given it as LinkedList. i.e. null --> a --> b --> c --> b --> a --> null

 Here concept should be same like if it is palindrome then it should be read same from back and front. But it is a bit tricky bec in
 string or array we can access the previous characters via indexing and you can check for prev and post chars from certain point.
 But here in LinkedList, I won't have access to the previous nodes (values).

 So what we need to do now? --> just think very carefully, I want to access prev elems. then either we can use the prev variable or another
 way is just make prev elems as reverse list then I can access the elems by using curr.next bec since now arraow will be reversed from the
 curr point. now prev variable method we can't use here, bec we don't want to store only single variable, but we want to store all the values.
 so we will use the reversing list method to access the prev elems.

 Now by standing any 1 idx/char (i.e. we have to consider every char during iteration and whomesoeevr give maximum length that would be ans)
  and for any char, we will be consider it as middle point. by considering it as middle point, now we can have 2 options.
 palindrome can be odd length or even length. So for each char considering it as middle pointe, I am having 2 options. cosnider suppose
 odd len palin will be exists then we need to create 2 pointers, each pointer you have to iterate to both the left and right side of
 curr char. (And rememeber for left pointer you can only iterate after perfroming reverse on LinkedList).
 Now if it might happen ki even LL can exist, then we also have to check for even as 2nd option by staying on each char. So for even
 len also you have to create 2 pointers and you need to start iterating on left and right side of the curr char. and chars match till
 certain point which will give me the answer.

 Now see code for better understaning.

 TC:- O(N^2) bec one loop for iterating whole LL by considering each char as middle. And another loop is, when you are at middle of pali,
 you have to start iterating left and right of that middle char ryt. So O(N^2).
 SC:- O(1)

 */

    public static int maxPalindrome(Node head) {
        Node curr=head;
        Node prev = null; // we need it to make LL reverse in future.
        int ans=0;
        while(curr!=null){
            Node nextNode=curr.next; // storing next node before reversing the pointer of current node
            curr.next=prev; // reversed the pointer of curr node to access prev to check palin.
            // Now we have 2 options. to consider current node as middle and check it like there exists odd palin, and also check it like
            // there exists even. and consider max ans given from it.

            // we have created count function which take 2 nodes from where we need to start iterating on opposite side i.e. left and right.
            // so one call we made for odd. so for odd, notice 2 things. like curr node can not be part of checking palin bec it is common
            // for both left and right side. So we will be passing prev and next node to tart checking. And whterver ans we got, that we
            // returned from count() funtion for 1 side only --> so need to multiply with 2 and add 1 to it for getting total palin sublist length
            ans = Math.max(ans, 2*count(prev,nextNode)+1); // consider it as odd centerd palin.

            // for even centered palin check, curr node itswlf should be considered for left side palin. and next node as right side palin.
            // and obviously here we should multiply with 2 only not need to add 1 for even palin check.
            ans = Math.max(ans, 2*count(curr,nextNode)); // consider it as even centered palin.

            // Now once checked it, and get ans by considering curr node, we need to move ahead. so we have to move  all the nodes ahead.
            prev=curr;
            curr=nextNode;
        }
        return ans;
    }

    public static int count(Node first, Node second){
        Node a = first;
        Node b = second;
        int cnt=0;
        while(a!=null && b!=null){
            if(a.val==b.val){
                a=a.next;
                b=b.next;
                cnt++;
            }
            else break;
        }
        return cnt;
    }
}