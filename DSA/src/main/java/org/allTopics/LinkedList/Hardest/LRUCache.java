package org.allTopics.LinkedList.Hardest;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it
should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number
of unique keys it can hold at a time.

Definition of "least recently used" : An access to an item is defined as a get or a set operation of
the item. "Least recently used" item is the one with the oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :
Input :
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full.
         get(5)        returns -1
Expected Output
Enter your input as per the following guideline:
There are 1 lines in the input

Line 1 ( Corresponds to arg 1 ) : The line starts with a pair of number numOperations, capacity. capacity is the number your constructor is initialized with.
Then numOperation operations follow.
Each operation is either :
 * G  : This corresponds to a function call get()
 * S   : This corresponds to a function call set(num1, num2)
Note that the function calls are made in order.
 */

/*
Why we have used doubly linked list, why not Singly Linked List or why not an array?
- Why Not Array? :- So here we want to have the insertion and updation to happen in O(1) TC. but if i will use array
then to delete the least recent elem i.e. to delete elem from 0th index, after deleting it, all the remaining elems
needs to be shifted to left side which costs us in TC of O(N). So we can't use Array DS.
- Why not Singly LL ? as deletion of head elem gives O(1) only for the case of singly LL then why we haven't used it?
So reason is for example suppose you have LL of
null-->10-->15-->19-->20-->18-->23
now new elem coming from stram is 20. So I have to add 20 to the LL correct. but I have to check weather it's already
present or not. SO I will chek in map. And it's present. So in that case as per our approach just directly go to
that element in Linked list and delete element from there. And then add same element 20 to the tail of LL.
But if you think carefully, if it was singly LL, then to delete 20 I go to map and get the address, then i go to
elem 20 in LL. But to delete I have to connect the 19 to 18 in above case right? so how to access prev of 20 in
Singly LL? so we have used double LL to have an access of prev elem for efficient deleting.
So ans is to perfom efficient deleting we are using doubly LL instead of singly LL.
 */

public class LRUCache {
}
