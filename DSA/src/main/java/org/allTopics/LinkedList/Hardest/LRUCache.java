package org.allTopics.LinkedList.Hardest;

// Problem Link :- https://leetcode.com/problems/lru-cache/description/

/*
Problem Description:-

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair
to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example 1:
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]
Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

Constraints:
1 <= capacity <= 3000
0 <= key <= 10^4
0 <= value <= 10^5
At most 2 * 105 calls will be made to get and put.
 */

/*
What is Cache?
- It is a temporary Storage for fast retrieval of data. So that we don't have to go to other server / hard disk
frequently which actually make read performance slow.

- But Main disadvantage is, like cache take space in main memory only. So space assigned for caching purpose
is never be huge/large. It is having very less space like typically ranges from 1 MB to 8 MB.

- So due to space constraints it can't store everything. So cache is designed by developer/designer in such a way
that data continuously added and removed. And this inputting (into cache) and outputting (from cache) of data is
designed based on some principle.
- There are so many algorithms available (which is topic of Operating System basically). few of them are
LRU (Least Recent Used)
LFU (Least Frequently Used)
etc etc...

So we are trying to design/implement LRU cache. As we know it is based on the principle like Always keep
new/latest? Most recently used data in the memory And always remove the oldest/Least Recently Used data from memory.
 */

/*
Understanding Designing of Cache:-
- So generally (in actual cache) cache stores data in form of Key Value pair like HashMap. But just for our sake
of easiness let's 1st just try to take only values and try to understand how it should work then we will decide
which Data Structure to use and what should be the logic.

- Suppose below values are given (remember here these values are constantly coming from input )
7 3 9 2 6 10 14 2 10 15 8 14 And suppose cache size is 5.
Now whenever value is already present inside the cache it means technically it's called CACHE HIT And if it's
not already present then it is said CACHE MISS.

- So let's start with 1st elem. for 1st elem, check 2 things. weather cache has empty space or not. 2nd thing is
elem is already present in cache or not (means HIT or MISS). So for 7--> yes there is space in the cache and there
is MISS, so let's add it. Then for 3 still space is there and again it's cache MISS. So add it to the cache.
Then same for 9,2,6.
- Now for 10, is there space in cache? --> no it's already full. So we need to remove Least Recently Used item i.e.
oldest item here from cache. So we need to remove 7 ryt. And add 10 to the cache. then same for 14--> remove 3 and
add 14.
- Now for 2, is cache has space? no. Is 2 HIT or MISS? it is HIT. But since we are maintaining the sequence in which
data is used ryt so we can't keep it as it is bec as per sequence of data 2 is used after 14 correct?.
So we need to move elem 2 from it's position to the after 14 to maintain correct sequence of recently used elems.
it means we need to remove element 2 from it's current position and need to insert it after 14. so now cache
looks like:- 9 6 10 14 2
- Again same for element 10.:- 9 6 14 2 10
- then for 15 and 8 since it's cache MISS, we will remove older ones and add the newer once:- 14 2 10 15 8
- after elem 14, finally cache looks like :- 2 10 15 8 14

These is our task. I mean this should be my output for the mentioned input.

Note:-
- Now always remember, for any Designing question of Leetcode/Interview (talking only for DSA not for LLD/HLD),
1st you need to decide which all operation you are performing/ going to perform to maintain the asked task. And then on
basis of that we have to choose appropriate data structure depending on the use case.

- So from above discussion we can see that majorly we are performing these 3 operations.
search :- searching weather element is already present in cache or not.
removal :- removed it in case it's already present and then add it.
insertion :- insertion of elems to maintain the sequence.

PseudoCode/ Algorithm/ Steps/ Flowchart for PUT(int elem) operation :-
- Search in cache:
    HIT (i.e. yes):
        - remove it
        - insert it
    MISS (i.e. no):-
        - if space left in cache:
            - yes:- insert it
            - no:-
                - remove the oldest elem
                - insert the newest elem.


Deciding Correct Data Structure based on our use case.
- Very common comes to mind 1st is:- Arrays
searching :- O(N)
insertion :- O(1) since pls again try to dry run like we only need to add elem at the last.
removal :- O(N) { since from in between as well so}

So as we need to perform toooooo many insertion-deletion, so do we have any other option to improve above TC.
- Again in 1st basic lecture of LinkedList we have discussed like while designing application 2 key point for
linked list to be used is:- whenever you heard about too many insertion/deletion then just try to think
about Linked List as a possibility. And 2nd thing is like LL is giving you major benefit of Insertion/Deletion
in O(1) {Only if adding to start or removing from starting}.

- Now since we are maintaining sequence/order here, so it's but obvious Queue comes in mind as an alternative.
So yes correct here we are inserting at last. And Queue is also have similar principle of inserting at last
and removal from 1st.
But there is a loop hole here. Queue is not allowing us for searching operation. And 2nd thing is what about
deletion. Queue is only allowing to remove from last. Not from in between. Since we required in-between removal.
So that's why we can't use the Queue DS here.
(Note:- By the way, Queue are actually internally implemented through either Arrays/LinkedLists !!!!!!!)

- Now in LL also still searching took O(N) correct. And as we are deleting from in between, but to delete it
from in between basically what we are doing searching elem in LL ryt So considering as searching only for in between
deletion case. And for removal from start case it's O(1).
So now headache is Searching and deletion in between ryt? Now just think actually how Linked List works? I mean
why array took O(N) for deletion is like after deleting it needs to shift all the elems since it is continuous
memory DS. But now in Linked List suppose I want to delete/search any elem, I just need to give reference of that
element. So now if you can think of then I have to maintain reference for each elem I am adding. So now you might
be able to think correct DS for our use case.

- Like we will be using LL + HashMap for our use case. Like we will store the int and corresponding
reference(i.e address) id elem in the Map. And since Map offers O(1) TC for searching. So we will find address
from there whenever we want to remove element from in between for that element.

- But now again one issue is there. Like HashMap will give me the reference of elem which I want to delete.
But now how will I delete it from LL? means to delete we require previous element ryt. I mean from there only
we used to cut the link from element and thread it to next element ryt. So previous pointer/elem is the issue.
So now you must understand we should use Doubly LL.
- So finally we will have to use Doubly LL + HashMap for our requirement.

- One more thing is, here we took example of only values. But in input it will be given as key,value to the cache.
So what modifications we need to do is, we will keep everything as it is, just understand here like data (elem) is
changing ie. we need to just store key,value in the Node of DLL instead of only value. And 2nd thing is

 */

/*
Why we have used doubly linked list, why not Singly Linked List or why not an array?
- Why Not Array? :- So here we want to have the insertion and updation to happen in O(1) TC. but if i will use array
then to delete the least recent elem i.e. to delete elem from 0th index, after deleting it, all the remaining elems
needs to be shifted to left side which costs us in TC of O(N). So we can't use Array DS.
- Why not Singly LL ? as deletion of head elem gives O(1) only for the case of singly LL then why we haven't used it?
So reason is for example suppose you have LL of
null-->10-->15-->19-->20-->18-->23
now new elem coming from stream is 20. So I have to add 20 to the LL correct. but I have to check weather it's already
present or not. So I will check in map. And it's present. So in that case as per our approach just directly go to
that element in Linked list and delete element from there. And then add same element 20 to the tail of LL.
But if you think carefully, if it was singly LL, then to delete 20 I go to map and get the address, then I go to
elem 20 in LL. But to delete I have to connect the 19 to 18 in above case right? so how to access prev of 20 in
Singly LL? so we have used doubly LL to have access of prev elem for efficient deleting.
So ans is to perform efficient deleting we are using doubly LL instead of singly LL.
 */

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class ListNode{
        int key;
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int k, int v){
            this.key=k;
            this.val=v;
        }
    }

    // Creating dummy nodes in DLL, and cache will be present between this dummy nodes.

    // remember here cache = DLL+ HM
    ListNode dummyHead;
    ListNode dummyTail;
    Map<Integer, ListNode> mp = new HashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        dummyHead=new ListNode(-1,-1);
        dummyTail=new ListNode(-1,-1);
        dummyHead.next=dummyTail;
        dummyTail.prev=dummyHead;
        this.capacity=capacity;
        mp.clear();
    }

    public int get(int key) {
        // check if it present in the map or not
        if(mp.containsKey(key)){
            // then need to remove it from DLL, and insert at last i.e. tail since now it is
            // most recently used so

            // getting addrs from mp
            ListNode temp = mp.get(key);

            remove_from_between(temp);
            insert_at_tail(temp);
            return temp.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        // now if any key value given, for exa: 3,8:- so I have to check 1st key is present
        // in the cache or not --> if yes --> have to update it --> else have to add it
        if(mp.containsKey(key)){
            ListNode temp=mp.get(key);
            temp.val=value;
            remove_from_between(temp);
            insert_at_tail(temp);
        }
        else{
            // this block is for any new element to the cache
            // so 1st need to check weather cache has enough space of not
            if(capacity>0){
                ListNode temp=new ListNode(key,value);
                mp.put(key,temp);
                insert_at_tail(temp);
                capacity--;
            }
            // else if cache is full--> I have to remove oldest elem from the cache, i.e.
            // then have to add this new elem in cache.
            else{
                // removing old elem
                ListNode nd=remove_from_front();
                mp.remove(nd.key);
                // Adding new elem
                ListNode temp=new ListNode(key,value);
                mp.put(key,temp);
                insert_at_tail(temp);
                capacity--;
            }
        }
    }

    private void remove_from_between(ListNode nd){
        nd.prev.next=nd.next;
        nd.next.prev=nd.prev;
        nd.next=null;
        nd.prev=null;
    }

    private ListNode remove_from_front(){
        ListNode temp=dummyHead.next;
        remove_from_between(temp);
        // delete(temp);
        return temp;
    }

    private void insert_at_tail(ListNode nd){
        ListNode temp = dummyTail.prev;
        nd.prev=temp;
        nd.next=dummyTail;
        temp.next=nd;
        dummyTail.prev=nd;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
