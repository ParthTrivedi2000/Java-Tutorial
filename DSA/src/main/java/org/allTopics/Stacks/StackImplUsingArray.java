package org.allTopics.Stacks;

// Implementation of stacks using Arrays:-
public class StackImplUsingArray {

    static final int MAX = 1000;
    // So it is but obvious to first create the Array to implement the stack.
    int[] arr = new int[MAX]; // Size of the Stack
    // initialize index with -1 to traverse the array as when required.
    int index = -1;

//    Optional :- below constructor is optional to make your code modular and readable
//    StackImplUsingArray(){
//        int index = -1;
//    }

//    Now let's write the methods for the operation on the stack.

    public void push(int val){
//        so 1st thing we need to do is, index++ and then we should put our element. but yes
//        before performing this operation, edge case is to check like index is already at index=n
//        or not it means stack is full or not. if yes then we should give back error as Stack Overflow.
//        else we can do index++ and pushing of element.
        if(index+1 == MAX) System.out.println("Stack Overflow");
        else{
            index++;
            arr[index] = val;
        }
    }

//    let's perform next pop() operation. for pop operation we 1st need to check weather stack has
//    any element present or not. it means if stack is empty then we can return error like "Stack
//    Underflow". else, if there is any element in the array, actually we don't need to remove that
//    element instead we can move back i.e. just index--; and to return back the element, before
//    index--, int elem = arr[index] then index--; return elem.
    public int pop(){
        int elem = 0;
        if(isEmpty()) System.out.println("Stack Underflow");
        else{
            elem = arr[index];
            index--;
        }
        return elem;
    }

    public int peek(){
        if(isEmpty()) System.out.println("Stack Underflow");
        return arr[index];
    }

    public boolean isEmpty(){
        if(index==-1) return true;
        return false;
//      or simply we can write single statement like this:- return index==-1;
    }

    public int size(){
        return index+1;
    }
}
