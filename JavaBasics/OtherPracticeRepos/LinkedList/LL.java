package LinkedList;

// 1) In Linked list Data Structure, elements are not stored in continuous manner in Heap memory. but
// they are stored randomly at any place in the heap memory.
// 2) Linked List data structure is also similar to array or list type only. it can store any type of
// data like integer, double, string, array, list etc etc...
//3) Important property of LL is, it is not of fixed size. so size can be increased at any moment as it's
// not in continuous manner unlike Array DS.
// 4) Starting point of the linked list is called as Head of the linked list.
// 5) Ending point of the linked list is called as Tail of the linked list.

//Where LL is used?
// LL DS is used in stacks/queues. as stacks/queues doesn't have fixed size hence they are mainly using
// LL as a DS instead of Array DS due to size flexibility. In real life LL is usd in Browser.


// What is Class?
// Basically it is group of properties + functions.
// And we can also say like it is type. I mean object instantiated with this class is B, then we can say
// like B is type className same as if int x=5 means x is type of integer class.

// class Node{
//    int value;
//    Node address;
//    // one basic question is like why here I have written Node type as address. basically as per our
//// understanding in LL, each element is what? it is type of Node which can store value and address. ryt? like
//// each elem in array is type of what...I have to mention it like in array can store value of type int. similarly
//// each elem of LL is of type of Node. now back to the question why address is not of type int and is of
//// type Node? because this particular element is pointing out to next element of type Node. not type int or
//// string or char... And I want to reach to the next type element ryt via memory address. So we have to mention
//// Node type as address.
//}





public class LL {

    private Node Head;
    private Node Tail;
    private int size;

//    Constructor for main class.
    public LL(){
        this.size = 0;
    }

    class Node{
        private int value;
        private Node next;

        //    Constructor with 2 arg.
        public Node(int val, Node addr){
            this.value = val;
            this.next = addr;
        }

        //    Constructor with only 1 arg.
        public Node(int val){
            this.value = val;
//        by default it will be assigned to Null only. So it's fine if we won't write below line.
//        this.next = null;
        }
    }

    public void printList(){
        Node temp = Head;
        while(temp!=null){
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.println((String)null);
    }

    public void insertAtStart(int value){
        Node nd1 = new Node(value);
        nd1.value = value;
        nd1.next = Head;
        Head = nd1;

//        If tail is null it means there is no any elems present.and this is 1st elem we are inserting.
        if(Tail==null) Tail=Head;
        size++;
    }

    public void insertAtLast(int value){
        Node nd1 = new Node(value);
        nd1.value = value;
        Tail.next = nd1;
        Tail = nd1;
        if(Head==null) Head=Tail;
        size++;
    }

    public void insertAtPosition(int position,int value){
        if(position==0){
            insertAtStart(value);
            return;
        }
        if(position==size){
            insertAtLast(value);
            return;
        }
        Node nd1 = new Node(value);
        Node temp = Head;
        for(int i=1;i<position;i++){
            temp = temp.next;
        }
        Node next_address = temp.next;
        temp.next = nd1;
        nd1.next = next_address;
        size++;

    }

    public Node findIndex(int val) {
        Node temp = Head;
        while(temp!=null){
            if(temp.value == val){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Node getValue(int index){
        Node node = Head;
        for(int i=0;i<index;i++){
            node = node.next;
        }
        return node;
    }

    public Node getIndex(int val){
        Node node = Head;
        while(node!=null){
            if(node.value==val) return node;
            node = node.next;
        }
        return null;
    }

    public int deleteFromStart(){
        int value = Head.value;
        Head = Head.next;
//        If only single item present and that also we have deleted then my tail is also should be null.
        if(Head==null) Tail = Head;
        size--;
        return value;
    }

    public int deleteFromLast(){
        Node temp = Head;
        int val = Tail.value;
        if(size<=1) deleteFromStart();
        for(int i=1;i<size;i++){
            temp = temp.next;
        }
        temp.next=null;
        return val;

    }

    public int deleteFromPosition(int position){
        Node temp = Head;
        if(position==0) return deleteFromStart();
        if(position==size-1) return deleteFromLast();
        for(int i=1;i<position;i++){
            temp = temp.next;
        }
//        Node deleteNode = temp.next;
        int val= temp.next.value;
        temp.next = temp.next.next;
        size--;
        return val;
    }

//    Q) Reverse a Linked List. head is given as an argument.
    public Node reverseList(Node A) {
 	    Node curr, prev, nextNode;
 	    curr = A;
 	    if (curr == null)
 	        return null;
 	    prev = null;
 	    while (curr != null) {
 	        nextNode = curr.next;
 	        curr.next = prev;
 	        prev = curr;
 	        curr = nextNode;
 	    }
 	    return prev;
 	}

//     Q) Check if given LL is Palindrome or not.

    public Node reverse(Node head){
    Node prev, curr,nextNode;
    prev = null;
    curr = head;
    nextNode = null;

    while(curr!=null){
        nextNode = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
    }
    return prev;
}

    public Node middleOfLL(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next!=null && fast!=null){
            // move ahead slow with +1 and fast with +2 steps.
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public int checkPalindrome(Node A) {
        // Step - 1:- to find the middle of the linked list using Tortoise & Hare method.
        // Step - 2:- reversing the linkedList.
        // Step - 3:- take 2 pointers by keeping each on head and newHead respectively and start comparing the data.
        // Ṣtep - 4:- return true or false based on the condition. but make sure to reverse the second half of linkedList
        // again to be in original form then return false or true.

        // finding middle of linked list.
        Node middle = middleOfLL(A);
        // now whenever fast reaches end, slow will be at middle. so ,next node should be my newHead.
        // ListNode newHead = middle.next;
        Node newHead = reverse(middle.next);

        // take 2 pointers
        Node first = A;
        Node second = newHead;

        // Start comparison
        while(second!=null){ //bec everytime 2nd will reach early in case of odd length or with same number of times in case
            // of even length so checking for second pointer only.
            if(first.value != second.value){
                // return false. but before returning reverse the 2nd half of the linked list.
                newHead = reverse(newHead);
                return 0;
            }
            first = first.next;
            second = second.next;
        }
        newHead = reverse(newHead);
        return 1;
    }


    public static void main(String[] args){
        System.out.println("Hello World");
        LL list1 = new LL();
        list1.insertAtStart(5);
        list1.insertAtStart(8);
        list1.insertAtStart(2);
        list1.insertAtStart(17);
        list1.insertAtLast(51);
        list1.insertAtPosition(3,33);
        list1.printList();
    }
}

// Stacks:-
class Stack{
//    Implementation of stacks using Arrays:-

//    So it is but obvious to first create the Array to implement the stack.
    int n=10;
    int[] arr = new int[n]; // Size of the Stack
//    initialize index with -1 to traverse the array as when required.
    int index = -1;

//    Now let's write the methods for the operation on the stack.

    public void push(int val){
//        so 1st thing we need to do is, index++ and then we should put our element. but yes
//        before performing this operation, edge case is to check like index is already at index=n
//        or not it means stack is full or not. if yes then we should give back error as Stack Overflow.
//        else we can do index++ and pushing of element.
        if(index+1 == arr.length) System.out.println("Stack Overflow");
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
        if(isEmpty()){
            System.out.println("Stack Underflow");
        }
        else{
            elem = arr[index];
            index--;
        }
        return elem;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
        }
        return arr[index];
    }

    public boolean isEmpty(){
        if(index==-1) return true;
        return false;
//        or simply we can write single statement like this:- return index==-1;
    }

    public int size(){
        return index+1;
    }
}



// Implementation of Stacks using Linked List:-
// Now as we know like in array, we are having fixed size. so that is the main disadvantage of having stacks
// implemented with Arrays. and one another thing is of insertion and deletion operation in array took
// O(N). but remember like main purpose of having stack data structure is to get advantage of insertion
// and deletion operation in O(1) time.
// So now another option of implementation of stack is, Linked List. as using linked list we don't have any
// size issues. and we will be having dynamic size. And 2nd thing is, in linked list if you can recall
// there are some places at which if we want to delete or insert something then it will take O(N) TC only.
// So let's implement stack using Linked List. But there are also few positions in Linked List, at which
// If I want to perform insertion/deletion then I can do it in O(1). such position:- head. another is
// Tail (bt only if you are maintaining Tail element from starting of linked list).

class Node{
    int val;
    Node next;

    public Node(int data) {
        this.val = data;
        this.next = null;
    }

    public Node(int value, Node addr) {
        this.val = value;
        this.next = addr;
    }
}

class Stack_LL{
//    Remember one thing. we want to have insertion and deletion of O(1) time. and that is only possible
//    when we want to insert and delete something at/from Head position. So whenever we will push, then
//    we will push it to head position only. or even it would be better to insert at head position bec
//    when user want to perform pop() operation at time also we can do it in O(1) if element is at head.
    Node head=null;
    int size = 0;
    public void push(int data){
//        here there is no problem of overflow as we are using Linked List as DS hence. so no need to check
//        for Overflow edge case.
        Node nd = new Node(data);
        if(head==null) head = nd;
        else{
            nd.next = head;
            head = nd;
            size++;
        }
    }

    public int pop(){
//        if stack is empty
        if(isEmpty()){
            System.out.println("Underflow");
            return -1;
        }
        int temp = head.val;
        head = head.next;
        size--;
        return temp;
    }

    public int peek(){
//        if stack is empty.
        if(isEmpty()){
            System.out.println("Underflow");
            return -1;
        }
        return head.val;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
}



