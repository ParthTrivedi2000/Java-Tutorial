package org.allTopics.Queues;

/*
We never ever use the Array to implement Queue. Because Operation wise and memory wise also it seems costly to us.
As stacks and Queues are the data structure which provides the facility to perform Insertion and Deletion in O(1)
Time Complexity. Only thing is in Stacks, Insertion and Removal happens at same end. while in Queues, insertion
happens at the rear end of the queue and deletion/removal happens on the front end of the queue.

So we generally use the LinkedList implementation or circular array implementation for creating queue. But this
normal array implementation is to show why we need to go for Circular Array implementation of queue.
 */

// Problem Link:- https://www.geeksforgeeks.org/problems/implement-queue-using-array

/*
Implementation:-

- As we are implementing the Queue using array, we require Array DS. then if you know queue follows FIFO (First
In First Out) / LILO (Last In Last Out) principle. So to maintain this FIFO property, queue is performing the
insertion and deletion operation on the different ends instead of same unlike in stacks.
- So to represent both the ends, we require to variables. front and rear. Initialise the front with 0 and rear
with -1.
- then whenever there is need to perform add operation on queue, just check weather queue is empty or not (you
can check it using rear variable), if yes increase the rear i.e. rear++. and add the element at the rear index.
- if there is need to perform the poll() operation, just check weather queue is having any element or not (you can
check like if front<rear then yes queue is having elems. else not. and increase the front++.
- for the front()/peek() method, just return the arr[front].
 */

public class QueueImplUsingArray {
    int[] queue = new int[10];
    int front=0;
    int rear=-1;

    // Function to insert an element at the rear of the queue
    void enqueue(int data) {
        // Check if the queue is full
        if (rear == queue.length - 1) {
            System.out.println("Queue is full");
            return;
        }
        // Insert element at the rear
        rear++;
        queue[rear] = data;
    }

    // Function to delete an element from the front of the queue
    int dequeue() {
        // If the queue is empty
        int elem = -1;
        if (front > rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        else if(front<rear){
            elem = queue[front];
            // we can simply increment our front to indicate we have removed our element instead of actually removing
            // elem ryt just for the easiness in the implementation.
            front++;
        }
        return elem;
    }

    // Function to print the front of the queue
    int front(){
        if(front<rear) return queue[front];
        return -1;
    }

/*
In above implementation of dequeue actually we have to delete the element of front then need to shift all the elems to
left and need to decrement the rear ryt. (but we haven't done it) which actually took O(N) TC for the deletion. But
as we know queue is meant to be there to provide O(1) TC for both insertion and deletion.
That is why if we wish to implement a queue using circular array (because of array advantages like cache friendliness and
random access), we do circular array implementation of queue.
 */

}
