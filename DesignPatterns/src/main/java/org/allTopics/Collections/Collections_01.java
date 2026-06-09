package org.allTopics.Collections;

/*
So why we need to go for Collections?

- Suppose there I want to store info of 1 student. I can store it in single variable. Suppose I want to store info of 2
students, can create 2 variables and i can store it...But suppose I want to store info. of 1000 students, it is very bad 
practice to create 1000 variables. So next option is to have an array and store info in that.

- So I can create an array like below with 1000 elems.
int[] marks = new int[1000];

But now array has it's own below limitations.
1) Fixed size :- At the time of declaration, we have to provide the size.
Once array is declared we can't increase or decrease it's size in case suppose afterwards we get more/less elems from
input. So memory wastage will be there in case of less elems.
2) Homogeneous Datatype:- So I can store only same data type elements only in the array.
Student[] ar = new Student[1000];
ar[0] = new Strudent();
ar[1] = new Customer(); // give C.E.

- yes there is one small solution in this case. Like we can have the Object[] type array in case we want to have different
datatypes data in array. But this thing is good till a level only. Not everytime & everywhere.
Object[] ar = new Object[1000];
ar[0] = new Student();
ar[1] = new Customer(); // will work fine.

3) Not Underlying datastructure :- So for array, there is no underlying data structure on which on top of it we can
create array. Array is the DS that directly take space in memory rather than using base layer as any other DS. 
So very big disadvantage to developers. Like if I want to do anything, I have to implement all the things from
myself only. there is no methods provided by anyone. Means suppose I want to sort the elems stored in Array DS.
So I have to write it by myself only. (if you can recall, Collections having collections.sort method so it's easy to use it).
which actually increases the programming complexity and difficulty. 

So now to overcome the limitations of Array --> we are having Collections.
Variables ------> Array ------> Collections

Conclusion:-
- An Array is an indexed collection of fixed number of homogeneous data type elements.
- The main adavantage of arrays is, we can represent multiple values by using single variable. So that readability of
program improves.
- Limitations:- 
1) Once we create an array there is no chance of increase/decrease the size based on the requirement. Due
to this to use Array concept, we should know the size in advance, which may not possible always.
2) Array can hold only Homogeneous data types only. See examples above. We can solve this problem by using Object type arrs.
3) Array concept is not implemented based on some standard DS, and hence readymade method support is not available. For
every requirement we have to write the code explicitely which increase the complexity of programming.

To overcome above problems of arrays, we should go for Collections Concept.
- Collections are Growable in nature, that is based on our requirement, we can increase/decrease the size.
- Collections can hold both Homogeneous and Heterogeneous objects.
- Every collection class is implemented based on some standard DS. Hence for every requirement, readymade
method support is available. Being a programmer we are responsible to use those method, we are not responsible
to create those methods.


#### Differeneces between Arrays & Collections. (Please create Tabular form in your Notebook for easy visualization)
1) Arrays are fixed in size. that is once we create array, we can't increase/decrease the size based on our requirement.
While collections are growable in nature, so based on the requirements, we can increase/decrease the size.
2)W.r.t memory, Array are not recommeded to use.
W.r.t memory, collections are recommended to use.
3) W.r.t performance, Arrays are recommended to use.
W.r.t performance, Collections are not recommended to use.
4) Arrays can hold only homogeneous datatypes elems.
Collections can hold both homogeneous and heterogeneous elements.
5) There is no underlying DS for Arrays and hence readymade method support is not available.
For every requirement, we have to write the code explicitely which increase the complexity of programming
But every Collection class is implemented based on some standard DS and hence for every requirement readymade method 
support is available. Being a programmer we can use these methods directly, and we are not responsible to 
implement those methods.
6) Array can hold both the Primitives & Objects.
Collections can hold only and only Object types but not Primitives. (Please remember this, it is very useful while coding).


---------------------------------------------------------------------------------------
What do we mean by Collection keyword? (see here I m asking Collection, not Collections)
Collection :-
If you want to represent a group of individual objects as a Single Entity then we should go for Collection.

Now There is one more word. 
Collection Framework:-
It contains several Classes and Interfaces, which can be used to represent a group of object as a Single Entity.

So similar concepts are available in other languages also, not only in Java.
Terminology between Java and other languages (here C++) is as below:-
Java:-
Collection, Collection Framework
Equivalent terminology in C++ :-
Container, STL (Standard Template Library)


----------
Let's move ahead.
which will provide much information? Interfaces or Classes?
- Interfaces provide much information. Classes are just dummy representation of Interfaces.
So 1st we need to learn or look Interfaces present in Collection Framework.

## 9 Key Interfaces of Collection Framework:-
1) Collection
2) List
3) Set
4) SortedSet
5) NavigableSet
6) Queue
7) Map
8) SortedMap
9) NavigableMap



### 1) Collection (I) :-
- We already know the defination ryt like Collection is used to represent a group of Objects as a Single Entity.
- Collection is an Interface(I).
- Now any Interfaces generally contains methods ryt. So collection Interface as well contains some methods.
So Collection Interface is Root of all the other Interfaces, It will contains basic/general methods which are required
while implementing using any of the available collections. Like add(), remove(), size() etc etc most basic/general methods...
Actually it is not exact Root bec Map is not falling under Collection, but it is at same level hierarchy and both are under
Collection Framework.


- If we want to represent group of individual objects as a Single Entity, then we should go for collection.
- Collection Interface defines the most common methods which are applicable for any Collection Object.
- In general COllection Interfaces is considered as a Root Interface of Collection Framework. (Exception is Map).
- There is no Concrete Class which implements Collection Interface directly. But all the concrete classes (like ArrayList
,LinkedList etc) implements any of the child Interfaces of Collection Interface.

// Very Commonly asked Interview Question :-
Difference between Collection & Collections ?
- Collection is an Interface. If you want to represent a group of individual objects as a single entity, then we should go
for Collection.
- While Collections is an Utility Class present in Java.util package to define several Utility methods for Collection
Objects like Sorting, Searching etc...


2) List (I) :-
- It is the child Interface of Collection Interface.

Collection(I)
    |
    |
   List(I)

- if we want to represent a group of individual objects as a Single Entity where 
    --> Duplicates are allowed & 
    --> Insertion order must be preserved 
then we should go for List Interface(I). 
(i.e. we are inserting in whatever order, internally it will store in that particular inserted order only. that is 
called Insertion order preserved.)

     Collection(I)-came into 1.2 Version
        |
        |
    List(I)- 1.2 version
     /    \    \
    /      \    \
Array    Linked  Vector(C)-1.0V
List(C)  List(C)   |
-1.2V     -1.2V    |
                  Stack(C)-1.0V 

So as per above diagram, you can see, Vector and Stack are present/available from starting version 1. that's why they are
also known as Legacy Classes.

Note:- In 1.2 Version, Vector and Stack classes are re-engineered to implement List Interface. (Bec remember when Vector 
and Stack classes are present in version 1.0 at that time List Interface is not there hence when in version 1.2 List(I) 
came into existence, Vector and Stack are also re-engineered to implement with List(I)).


3) Set(I)
- It is the child interface of Collection Interface.

Collection(I)
    |
    |
   Set(I)

- if we want to group of individual objects as a Single Entity where 
    --> Duplicates are not allowed & 
    --> Insertion order is not required 
then we should go for Set Interface.
- Below are the classes which implements the Set Interface.

Collection(I)-1.2V
    |
   Set(I)-1.2V
    |
HashSet(C)-1.2V
    |
LinkedHashSet(C)-1.4V


4) SortedSet(I)
- It is the child Interface of Set Interface.
- If we want to represent a group of Individual objects as a Single Entity where 
    --> Duplicates are not allowed & 
    --> All objects should be Inserted according to some Sorting Order
then we should go for SortedSet.

5) NavigableSet(I)
- It is a child Interface of SortedSet Interface.
- It contains several methods for Navigation purposes.
- Which are the implementation class for this Interface. --> TreeSet is the Implementation class for this Interface.

Collection(I)-1.2V
    |
   Set(I)-1.2V
    |
SortedSet(I)-1.2V
    |
NavigableSet(I)-1.6V
    |
TreeSet(C)-1.2V


// Very important interview Question
### Differences between List & Set:-
- Duplicates are allowed in List
While Duplicates are not allowed in Set.
- Insertion Order preserved in List
while it's not preserved in Set.

6) Queue(I)
- It is a child Interface of Collection Interface.
- if we want to represent a group of individual objects 
    --> prior to processing 
then we should go for Queue.
- Usually Queue follow FIFO(First In First Out) order but based on our requirement, we can implement our 
own Priority Order also.
- example:- before sending an email, all mail ids we have to store in some DS. In which order we had mail ids, in the same
order only mail should be delivered. For this requirement Queue is best choice.
- Below are the classes which implements this Interface.

Collection(I)-came into 1.2 Version
        |
        |
    Queue(I)- 1.5 version
     /    \        \
    /      \        \
Priority  Blocking   .....(Others also like Deque, SynchronisedQue etc etc...)
Queue(C)  Queue(C)
-1.5V     -1.5V 
            |__ PriorityBlockingQueue(C)-1.5V
            |__ LinkedBlockingQueue(C)-1.5V


So we have covered 6 Interfaces till now. And all the 6 interfaces are meant for representing
group of individual objects. Means there is no dependency between 2 individual objects.

But sometimes my requirement is I want to represent a group of objects as Key-Value pair.

Note:- All the above Interfaces (Collection,List,Set,SortedSet,NavigableSet,Queue) meant for representing a group
of individual objects.
- If we want to represent a group of objects as Key-Value Pairs then we should go for Map Interface.


7) Map(I) :-
- Map is not a child interafce of collection interface.
- If we want to represent group of objects as Key value pairs then we should go for Map.
- exa.
rollNo name
1-->Parth
2-->Prashant
3-->Param

- Both the key & value are Objects only.
- Duplicate Keys are not allowed but Values can be duplicated.

    Map(I)- 1.2 version
     /    \         \                \ Dictionary(AC-Abstract Class)-1.0V
    /      \         \                \  |
HashMap(C)  WeakHash  IdentityHash   Hashtable(C)-1.0V
- 1.2V      Map(C)    Map(C)-1.4V        |
    |       -1.2V                    Properties(C)-1.0V
LinkedHash
Map(C)-1.4V

So as per above dia, Hashtable is implemented with Map Interface. But actually it is Child class of Abstract Dictionary
Class. And all the 3 Dictionary, Hashtable, Properties class are available from version 1.0 hence also called as Legacy 
Classes.


8) SortedMap(I)
- It is a child interface of Map Interface.
- If we want to represent a group of objects 
    --> accordings to some sorting order of keys 
then we should go for SortedMap Interface.
- in Sorted Map Sorting should be based on Key but not based on Value.

9) NavigableMap(I)
- It is a child interface of SortedMap Interface.
- It defined several methods for navigation purposes.
- Which are the implementation class? --> Only TreeMap 

   Map(I)-1.2V
    |
SortedMap(I)-1.2V
    |
NavigableMap(I)-1.6V
    |
TreeMap(C)-1.2V


Note :- The following are the Legacy Characters present in Collection Framework.
Enumeration(I)
Dictionary(AC)
Vector(C)
Stack(C)
Hashtable(C)
Properties(C)
 */

public class Collections_01 {

}
