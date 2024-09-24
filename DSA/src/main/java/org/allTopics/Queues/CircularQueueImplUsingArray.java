package org.allTopics.Queues;

/*
Implementation Circular Queue using Array:-

- Initialize an array queue of size n, where n is the maximum number of elements that the queue can hold.
- Initialize two variables front and rear to -1.
- Enqueue(): To enqueue an element x into the queue, do the following:
    - Increment rear by 1.
    - If rear is equal to n, set rear to 0.
    - If front is -1, set front to 0.
    - Set queue[rear] to x.
- Dequeue(): To dequeue an element from the queue, do the following:
    - Check if the queue is empty by checking if front is -1.
    - If it is, return an error message indicating that the queue is empty.
    - Set x to queue[front].
    - If front is equal to rear, set front and rear to -1.
    - Otherwise, increment front by 1 and if front is equal to n, set front to 0.
    - Return x.
 */

public class CircularQueueImplUsingArray {
    int[] queue = new int[10];
    int front  = -1;
    int rear = -1;

    void enqueue(int x){
        // Condition if queue is full.
        if((front == 0 && rear == queue.length - 1) || (rear == (front - 1) % (queue.length - 1))){
            System.out.print("Queue is Full");
        }
        // condition for empty queue.
        else if(front == -1){
            front = 0;
            rear = 0;
            queue[rear] = x;
        }
        else if(rear == queue.length - 1 && front != 0)
        {
            rear = 0;
            queue[rear] = x;
        }
        else
        {
            rear++;
            // Adding a new element if
            if(front <= rear) queue[rear] = x;
            // Else updating old value
            else queue[rear] = x;
        }
//        rear++;
//        if(rear==queue.length) rear=0;
//        queue[rear]=x;
    }

    int dequeue(){
//        int elem=-1;
//        // check if queue is empty or not.
//        if(front==-1 && rear==-1) System.out.println("Queue is empty");
//        else if(front==queue.length) front=0;
//        else if(rear==queue.length) rear = 0;
//        else{
//            elem=queue[front];
//            front++;
//        }
//        return elem;


        int temp;
        // Condition for empty queue.
        if(front == -1) {
            System.out.print("Queue is Empty");
            // Return -1 in case of empty queue
            return -1;
        }
        temp = queue[front];
        // Condition for only one element
        if(front == rear) {
            front = -1;
            rear = -1;
        }
        else if(front == queue.length - 1) front = 0;
        else front++;

        // Returns the dequeued element
        return temp;

    }

    int front(){
        // check if queue is empty or not.
        if(front==-1 && rear==-1) System.out.println("Queue is empty");
        return queue[front];
    }
}
