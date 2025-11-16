package org.allTopics.Queues;

// Problem Link :- https://leetcode.com/problems/implement-queue-using-stacks/description/

/*
Problem Description:-
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the
functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:
void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:
You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty
operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or
deque (double-ended queue) as long as you use only a stack's standard operations.

Example 1:
Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]
Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

Constraints:
1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.

Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words,
performing n operations will take overall O(n) time even if one of those operations may take longer.

 */

/*
Complexity Analysis:-

Time Complexity (Amortised Time Complexity):
- Push operation: O(1).
    Same as pop operation in stack.
- Pop operation: O(N) in general and O(1) amortized time complexity.
    In the worst case we have to empty the whole of stack 1 into stack 2 so its O(N). Amortized time is the way to express
    the time complexity when an algorithm has the very bad time complexity only once in a while besides the time complexity
    that happens most of time. So its O(1) amortized time complexity, since we have to empty whole of stack 1 only when
    stack 2 is empty, rest of the times the pop operation takes O(1) time.
- Auxiliary Space: O(N).
    Use of stack for storing values.
 */

import java.util.Stack;

public class QueueImplUsingStacks {
    static Stack<Integer> s1;
    static Stack<Integer> s2;
    /** Initialize your data structure here. */
    QueueImplUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // whenever we pushed anything, it should be pushed in the stack s1 only.

    /** Push element X to the back of queue. */
    static void push(int X) {
        s1.push(X);
    }

    // While we are performing polling operation, 1st we need to check weather queue is empty or not.
    // If it's not empty, we have to perform the transfer operation of all the elems from stack s1 to
    // stack s2. And at last return top of the s2. so we will return the top of the s2 till the moment it
    // becomes empty. once it is empty then only we should transfer the element from stack s1 to s2.

    /** Removes the element from in front of queue and returns that element. */
    static int pop() {
        // checking if queue is empty or not.
        if(s1.isEmpty() && s2.isEmpty()) return -1; // Queue is empty.

        if(!s2.isEmpty()) return s2.pop();
        else{
            while(!s1.isEmpty()){
                int elem = s1.pop();
                s2.push(elem);
            }
        }
        return s2.pop();

    }

    /** Get the front element of the queue. */
    static int peek() {
        if(s1.isEmpty() && s2.isEmpty()) return -1; // Queue is empty

        if(!s2.isEmpty()) return s2.peek();
        else{
            while(!s1.isEmpty()){
                int elem = s1.pop();
                s2.push(elem);
            }
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    static boolean empty() {
        return (s1.isEmpty() && s2.isEmpty());
    }
}

/**
 * Your QueueImplUsingStacks object will be instantiated and called as such:
 * QueueImplUsingStacks obj = new QueueImplUsingStacks();
 * obj.push(X);
 * int param2 = obj.pop();
 * int param3 = obj.peek();
 * boolean param4 = obj.empty();
 */