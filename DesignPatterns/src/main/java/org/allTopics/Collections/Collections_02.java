package org.allTopics.Collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Stack;
import java.util.Vector;

/*

######## Collection(I) ########
- If we want to represent a group of individual objects as a Single Entity then we should go for collection.
- Collection Interface defines the most common methods which are applicable for any collection object.
if you want to add a single object, we are having --> add(Object o) method.
if you want to add a group of objects (i.e. nothing bt collection ryt), we are having --> l.addAll(Collection c)
if you want to remove a particular object --> remove(Object o);
if you want to remove a group of objects (i.e. nothing bt collection ryt) --> removeAll(Collection c);
if you want to remove all the objects --> clear();
if you want to remove all the objects except these group of objects --> retainAll(Collection c);
if you want to check weather collection has this object or not --> contains(Object o);
if you want to check weather collection contains group of objects or not --> containsAll(Collection c)
if you want to check weather collection is empty or not --> isEmpty();
if you want to check what is the size of the collection --> size();

as operations wise Array are better then Collections. so
if you want to convert collection to array to perform some operations in between of code
then --> toArray() --> return type of this array is Object[].

As collection is a group of objects. so now if I want to get object one by one, then cursor will be required ryt.
And Universal cursor is, Iterator.
if you want to get one by one elements from any collection --> Iterator() --> iterator() method will return Iterator type objs.

boolean add(Object o);
boolean addAll(Collection c);
boolean remove(Object o);
boolean removeAll(Collection c);
boolean retainAll(Collection c);
void clear();
boolean contains(Object o);
boolean containsAll(Collection c);
boolean isEmpty();
int size();
Object[] toArray();
Iterator iterator();

Note:- There is no concrete class which implements collection interface directly.


---------- List Interface ------------------------
- List is child Interface of Collection Interface.
- if we want to represent a group of individual object as a single entity where duplicates are allowed and insertion
order must be preserved then we should go for List.
- we can preserve the insertion order via Index. And we can differentiate duplicate objects by using Index. Hence
Index will play a very very important role in List.
- All the methods of parent Collection methods are already available to List(I) as it is child of Collection(I).
- Other Methods of List:-
List Interface defines following specific methods.
void add(int index, Object o);
Boolean addAll(int index, Collection c);
Object remove(int index);
Object get(int index); // here interviewer might ask like what if object is not present at specified index--> then NULL 
will be returned.
Object set(int index, Object newObj); // to replace the element present at specified index with provided Object and returns
old Object.
int indexOf(Object o):- will always return the 1st Occurance of object's index.
int lastIndexOf(Object o) :- will return the last occurance of object's index.

ListIterator listIterator();

- Below are the concrete classes which implements List Interface.
ArrayList, LinkedList, Vector, Stack. (Please see hierarchy in diagram in Collections_01 note).



####### ArrayList Class :- ------------
- The underlying DS is Resizable Array or Growable Array.
- Duplicates are allowed.
- Insertion Order is preserved.
- Heterogeneous Objects are allowed.(Except TreeSet and TreeMap, in collection framework for every collection heterogeneous 
are allowed bt it's not allowed in this 2 collection bec Sorting Order is required & for sorting purpose, comparison is 
required. And we can't compare 2 different types of datatype hence...).
- Null insertion is possible for ArrayList Object. 
exa:- ls.add(null); valid

** Constructors of ArrayList Class:-
1) ArrayList ls = new ArrayList(); //creates empty ArrayList object with the Default initial capacity with 10.
- Once Array list reaches at it's max capacity, then new Arraylist object will be created with new capacity of
new capacity = (current capacity * (3/2)) + 1;

2) ArrayList ls = new ArrayList(int initialCapacity);
Creates empty ArrayList object with the specified initial capacity.

3) ArrayList ls = new ArrayList(Collection c);
creates an equivalent ArrayList Object for the given Collection.
 */

class ArrayListDemo{
    public static void main(String[] args){
        ArrayList ls = new ArrayList();
        ls.add("A");
        ls.add(10);
        ls.add("A");
        ls.add(null);
        System.out.println(ls);
        ls.remove(2);
        System.out.println(ls);
        ls.add(2,"M");
        ls.add("N");
        System.out.println(ls);

        List<Integer> ls1 = new ArrayList<>();
        ls1.add(10);
        System.out.println(ls1);       
    }
}


/*
Important to Note:-
- Usually we can use collections to hold and transfer objects from one location to another location (container/collection).
So to provide support for this requirement, every collection class 
    --> by default implements Serializable and Clonable Interfaces.
- ArrayList and Vector, this 2 classes implements RandomAccess Interface.
- ArrayList and Vector classes implements RandomAccess Interface so that any random element we can access with the same speed.
So suppose I am having an ArrayList ls = new ArraList<>() object.  So I can access ls.get(0) or ls.get(1000) or any elems
we can access with the same speed. 
- And this RandomAccess Interface is implemented by 2 classes only ArrayList, Vector. So you get benefit of fast 
retrival in these cases only.


------- RandomAccess (I) -----------------------------
- RandomAccess Interface present in java.util package.
- and it doesn't containes any methods. 
- It is a Marker Interface, where required ability will be provided automatically by JVM.
 */

public class Collections_02 {

    public static void main(String[] args){
        ArrayList l1 = new ArrayList<>();
        LinkedList l2 = new LinkedList<>();
        System.out.println(l1 instanceof Serializable); // True
        System.out.println(l2 instanceof Cloneable); //  True
        System.out.println(l1 instanceof RandomAccess); // True
        System.out.println(l2 instanceof RandomAccess); // False
    }
}

/*
- ArrayList is the best choice if our operation is Retrival Operation (Bec Array List implements RandomAccess Interface).
- ArrayList is the worst choice if our frequent operation is Insertion/Deletion in a middle. (Then which is the best choice 
for frequent Insertion/Deletion operation? --> It is LinkedList. we will cover these thing in next classes).


// Very very very very important and common question for interview
###  What is the Difference between ArrayList and Vector?
- Every method present in the ArrayList is Non-Synchronise.
While every method present in the Vector is Synchronised.
- At a time multiple threads are allowed to operate on ArrayList Object. And hence it is not Thread-safe.
while At a time only 1 thread is allowed to operate on Vector Oject and hence it is Thread-safe.
- Relatively Performance is high in ArrayList. bec threads are not required to wait operate on ArrayList object.
Relatively performance is low in Vector bec Threads are required to wait to operate on Vector object.
- ArrayList introduced in 1.2 Version and it is not Legacy.
while Vector introduced in 1.0 Version and it's a Legacy.

Then Interview might ask next below followup question.
How to get Synchronised version of ArrayList Object?
- By default ArrayList is non synchronised. But we can get synchronised version of ArrayList object by using 
SynchronisedList() method of Collections class.
- Syntax/signature of the method:-
public static List synchronisedList(List l);
example:-
ArrayList l = new ArrayList();
list l1 = Collections.synchronisedList(l1); // here l is non-synchronised, and returned object l1 is synchronised.

- Similarly we can get Synchronised version of Set & Map objects by using following methods of Collections class.
public static Set synchronisedSet(Set s);
public static Map synchronisedMap(Map m);



######## LinkedList Class :- -------
- Underlying data Structure is Doubly Linked List.
- Insertion Order is preserved.
- Duplicate objects are allowed.
- Heterogenous objects are allowed.
- Null insertion is possible.
- LinkedList Interface implements Serialisable and Cloneable Interface but not RandomAccess Interface.
- LinkedList is the best choice if our freqent opertion is Insertion/Deletion in the middle.
- LinkedList is the worst choice if our frequent oeperation is Retrival Operations.

Constructors :-
1) LinkedList l = new LinkedList();
It creates empty LinkedList object.
2) LinkedList l = new LinkedList(Collection c);
It creates an equivalent LinkedList object for the given collection.

LinkedList Class specific methods:-
- Ususally we can use linkedList to develop Stack & Queues.
To provide support of this requirements, LinkedList Class defined the following specific methods.
void addFirst(Objec o);
void addLast(Object o);
Object getFirst();
Object getLast();
Object removeFirst();
Object removeLast();

*/ 

class LinkedListDemo{
    public static void main(String[] args){
        LinkedList l = new LinkedList<>();
        l.add("parth");
        l.add(30);
        l.add(null);
        l.add("parth");
        l.set(0,"Software");
        l.add(0,"Franky");
        l.removeLast();
        l.addFirst("CCC");
        System.out.println(l);
    }
}


/*

Again Important interview Question

### Differences between ArrayList And LinkedList:-
- ArrayList is the best choice if our frequent operation is retriveal operation. 
While LinkedList is the best choice if our frequent operation is insertion/deletion in the middle.
- ArrayList is the worst choice if our frequent operation is Insertion/Deletion in the middle. Bec internally several
shift operations are performed. 
while LinkedList is the worst choice if our frequent operation is Retrival operation.
- In ArrayList, the elements will be stored in consecutive memory locations. And hence Retrival operation will become easy.
While in LinkedList, elements won't be stored in consecutive memory locations and hence retrival operation will become
difficult/complex.
- ArrayList is internally implemented using Array as underlying Data Structure.
While LinkedList is internally implemented using Double Linked List as underlying Data Structure.

 */

/*

##### Vector Class:-----------
- The underlying Data Structure is Resizable Array which are Growable Array.
- Insertion Order is preserved.
- Duplicates are allowed.
- Heterogeneous Objects are allowed.
- Null insertion is possible.
- it implements Serializable, Cloneable & RandomAccess Interfaces.
- Every Method present in Vector is Synchonised and hence Vector Object is Thread Safe.

## Constructors of Vector class:-
1) Vector v = new Vector();
cretes an empty Vector Object with default Initial Capacity 10.
- Once Vector reaches it's Max capcaity, then a new object will be created with the 
new capacity = current_capacity* 2;

2) Vector v = new Vector(int InitialCapacity);
creates an empty Vector object with the specified InitialCapacity.

3) Vector v = new Vector(int initialCapacity, int incrementalCapacity);
creates an empty Vector Object

4) Vector v = new Vector(Collection c);
creates an equivalent Vector Object for the given collection.
- This constructor means for the inter conversion between collection objects.


## Vector Specific Methods:-
- To remember this, you can correlate like this ki hmari generation h usme names h wo bahot 6ote h like parth,prashant.
but agr older generation ka dekhoge then, nageshwara, shanamuganathan or means thode jyada lmbe hote the and even we have
seen at so many places in movies/series ki pehle k maharaja ki entry hoti thi to bhi usko sambodhit krne k liye bahot 
bada sentence use kiya jata tha...so kehne ki bat ye h ki Vector class is Legacy class i.e. Oldest one. So usme methods
k names jyada bde hoge i.e. names se hi thode descriptive hoge. See below comparison.
- To add objects:-
add(Object o) - equivalent method present in Collection interface.
add(int index, Object o) - equivalent method present in List interface.
addElement(Object o) :- Present in Vector Class.

-To remove objects.
remove(Object o) --> C
removeElement(Object o) --> V
remove(int index) --> L
removeElementAt(int index) --> V
clear() --> C
removeAllElements() --> V

- To get Objects.
Object get(int index) -->L
Object elementAt(int index) --> V
Object firstElement() --> V
Object lastElement() --> V

- Other methods.
int size()
int capacity()
Enumeration elements() :- to get the elements one by one.

 */

class VectorDemo1{
    public static void main(String[] args){
        Vector v = new Vector();
        System.out.println(v.capacity());//10
        for(int i=1;i<=10;i++) v.addElement(i);
        System.out.println(v.capacity());//10
        v.addElement("A");
        System.out.println(v.capacity());//20
        System.out.println(v);
    }
}


/*

Stack
- It is the child class of Vector.
- It is a specially designed class for Last In First Out (LIFO) order.

Constructor:- Only one default constructor.
Stack st = new Stack();

Stack Specific Methods:-
Object push(Object o) --> To insert an object into the stack
Object pop() --> to remove and return top of the stack
Object peek() --> to return top of the stack without removal
boolean empty() --> returns true if the stack is empty.
int search(Object o) --> returns the offset if the element is present otherwise returns -1.
here offset means position of element/object from top of the stack starting from 1. (remember here index is also there bt
that is different. It will start from bottom of stack and starting from 0).
 */

 class StackDemo{
    public static void main(String[] args){
        Stack s = new Stack();
        s.push("A");
        s.push("B");
        s.push("C");
        System.out.println(s); // [A,B,C]
        System.out.println(s.search("A")); // 3
        System.out.println(s.search("Z")); // -1
    }
 }

/*
 ###### The 3 Cursors of Java :- -------------------
- If you want to get the objects one by one from the collection then we should go for Cursor.
- There are 3 types of cursors available in Java.
1) Enumeration
2) Iterator
3) ListIterator


#### 1) Enumeration Cursor:- ---------------
- we can use enumeration() to get objects one by one from Legacy collection object.
- How we can create enumeration object?
we can create enumeration object by using elements() method of Vector class.
Syntax:- public Enumeration elements();
Enumeration e = v.elements();


Methods:-
- public boolean hasMoreElements();
- public Object nextElement();
 */

class EnumerationDemo{
    public static void main(String[] args){   
        Vector v = new Vector();
        for(int i=0;i<=10;i++){
            v.addElement(i);
        }
        System.out.println(v);
        Enumeration e = v.elements();
        while(e.hasMoreElements()){
            Integer I = (Integer)e.nextElement();
            if(I%2==0) System.out.println(I);
            else{
                System.out.println(I+ "will be removed");
                v.remove(I);
                System.out.println(v);
            }
        }
    }
}

/*
Since we are having 3 cursors (enumerations, iterators, ListIterators) ryt. So if we were already having 1st one, then
why we go for next other cursors. So obviously bec of 1st one enumerations() might have some limitations, so we got
other cursors in future versions.

#### Limitations of Enumerations:-
- we can apply Enumeration concept only for Legacy classes.
- And it's not a Universal Cursor.
- by using Enumerations class, we can get only read access on objects, and we can't perform remove operation on 
objects from collections.
- To overcome above limitations we should go for Iterator().


######### 2) Iterator Cursor:- ----------------------------------
- we can apply Iterator concept for any type of Collection. Hence it it s a universal cursor.
- By using Iterator, we can perform both the read and remove operations.
- We can create Iterator object by using iterator() method of Collection Interface.
public Iterator iterator();
examp:- Iterator itr = c.iterator(); //where c is any Collection Object.

Methods of Iterators:-
1) public boolean hasNext();
2) public Object next();
3) public void remove();
 */

 class IteratorDemo {
    public static void main(String[] args){
        ArrayList l = new ArrayList();
        for(int i=0;i<=10;i++) l.add(i);
        System.out.println(l);              //[0,1,2,3...10]
        Iterator iter = l.iterator();

        while(iter.hasNext()){
            Integer I = (Integer) iter.next();
            if(I%2==0) System.out.println(I); // 0,2,4,6,8,10
            else iter.remove();
        }
        System.out.println(l); // [0,2,4,6,8,10]
    }
 }


/*
### Limitations of Iteraor:-
1) By using enumeration & Iterator, we can always move only towards forward direction & we can't move towards
backward direction. These are single directional cursor but not bi-directional cursor.
- By using Iterator, we can perform only read & remove operations, and we can't perform replacement & addition of
new objects.
- To overcome above Limitations, we should go for ListIterator.

####### ListIterator Cursor:-
- By using listIterator, we can move either to the forward direction or to the backward direction. And hence it is
bi-directional cursor.
- By using ListIterator, we can perform replacement & addition of new objects in addition to read & remove operations.
- We can create ListIterator, by using listIterator() method of List Interface.
pulic ListIterator listIterator();
example:- ListIterator ltr = l.listIterator(); //where l is any List Object.

## Methods:-
- ListIterator is the child Interface of Iterator interface. Hence all methods present in iterator, by 
default available to the ListIterator.
- ListIterator defines the following 9 methods.
- Forward Movement
public boolean hasNext();
public Object next();
public int nextIndex();

-Backward Movement
public boolean hasPrevious();
public Object previous();
public int previousIndex();

- Extra Operations
public void remove();
public void add(Object o);
public void set(Object o);
 */


class ListIteratorDemo{
    public static void main(String[] args){
        LinkedList l = new LinkedList();
        l.add("parth");
        l.add("prashant");
        l.add("param");
        l.add("utsavi");
        System.out.println(l); // [parth,prashant,param,utsavi]

        ListIterator ltr = l.listIterator();
        while(ltr.hasNext()){
            String s = (String) ltr.next();
            if(s.equals("param")) ltr.remove(); // [parth,prashant,param]
            else if(s.equals("prashant")) ltr.add("sejal"); //[parth,prashant,param,sejal]
            else if(s.equals("parth")) ltr.set("aditi"); // [aditi,prashant,param,sejal]
        }
        System.out.println(l);
    }
}

/*
Note :-
- The most powerful cursor is ListIterator. But it's Limitation is it is applicable only for List Objects.

### Comparison Table of 3 cursors:-
Property | Enumerations | Iterator | ListIterator {write in this format in Notebook}
- Where we can apply?
Enumeration:- Only for Legacy classes.
Iterator:- For any Collection object.
listIterator:- Only for List Objects.
-Is it Legacy?
Enumeration:- yes (1.0V)
Iterator:- no (1.2V)
listIterator:- no (1.2V)
- Movement
Enumeration:- single direction (Only forward direction)
Iterator:- single direction (Only forward direction)
listIterator:- bidirectional
- Allowed Operations
Enumeration:- Only Read
Iterator:- Read/remove
listIterator:- Read/Remove/Replace/Add
- How we can get?
Enumeration:- By using elements() method of Vector class
Iterator:- By using iterator() method of Collection Interface
listIterator:- By using listIterator() method of List Interface
- Methods:-
Enumeration:- 2 methods - hasMoreElements(), nextElement()
Iterator:- 3 methods - hasNext(), next(), remove()
listIterator:- 9 methods - 

 */

class CursorsDemo{
    // below is the same doubt in my mind as well.
    /*
     ## Internal implementation of Cursors:-
     Like we can't create Object for Interface ryt. here we are having Enumeration(I), Iterator(is also I), and
     listIterator(is also I). And we have written Enumeration e = v.elements();
     So how it's possible or how will it internally work?
     --> So here please make note of it here whatever e object we are getting is not Inferface's object. But it's
     object of the implemented class of this interface. So now next question is like how I came to know that 
     implemented class name? --> so that we can get from e.getClass().getName() line.
     So in this output:- java.util.Vector is the main class name. inside it $1 i.e. anonymous class. so i.e. we got this
     e object from the anonymous class implemented using Enumeration Interface. Same for below line. itr object we got is
     not the object of Iterator Interface, but it is the object of the class which has implemented Iterator Interface.
     So here itr is the object of, java.util.Vector$Itr i.e. java.util.Vector is the main class. and $Itr is the inner
     class which has implemented the Iterator Interface.

     Please make everything very clear in mind. Understand all this very carefully.
     */
// ## Internal implementation of Cursors:-
    public static void main(String[] args){
        Vector v = new Vector();
        Enumeration e = v.elements();
        Iterator itr = v.iterator();
        ListIterator ltr = v.listIterator();

        System.out.println(e.getClass().getName());  // java.util.Vector$1
        System.out.println(itr.getClass().getName()); // java.util.Vector$Itr
        System.out.println(ltr.getClass().getName()); // java.util.Vector$ListItr
    }
}