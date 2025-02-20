package org.allTopics.Hashing;

/*

Intuition of Hashing :-

Static Array (i.e. normal array in which size is fixed):-
- Patternless Array (i.e. an array in which random elements are placed without following any pattern like sorted or even or odd
or not in any pattern) :-
    - insertion :- O(N) {bec we already have memory address, we just go to last memory address and add elem to next memory address}
    - Searching :- O(N)
- Pattern Array (i.e. elements are in following some pattern like sorted or even or odd etc etc) :-
    - insertion :- O(N)
    - Searching :- O(logN)

Dynamic Array (i.e. ArrayList in which size is not fixed)
- Patternless Array
    - Insertion :- O(1) Amortised
    - Searching :- O(N)
- Pattern Array
    - Insertion :- O(N)
    - Searching :- O(logN)

LinkedList
- Insertion:- O(1) at head else O(N)
- Searching :- O(N)

Stacks/Queues :- Are always built on top of some base DS like Arrays/LL. So anyhow it won't have that much good searching complexity
and we are looking for good search complexity.
And one more thing is both of these DS are open from one end only, so it won't provide searching facility directly bec it requires all
elements to be popped out from DS so
- Insertion :- O(1)
- Searching :- O(N)


So now understand, I need to have something which can reduce this searching and insertion TC. But what and How it will reduce it?

So if you know we discussed about Count(Bucket) sort. What was it?
so in count sort what happened was, we were having bucket of some size. --> bucket of what size? :- so whatever max element given that much
large bucket size would be there. so for example given elems:- 3,70,100, 8500006
so required bucket size would be 8500006. So in this case we were directly accessing any bucketIndex just via bucket[105] or something
i.e. it was providing me to access any element of bucket in O(1) even though bucket may have 10/100/10000/1000000 elements
Downside :- bucket always stays Sparsed. i.e. so much memory wasted just to have info about few elements (see above example).

So now from here intuition comes like if we use bucket to access something then it would give me benefit of O(1) searching. So here comes
the concept of Hashing.

Hashing:-
in Hashing we will be having bucket of buckets i.e. we will be having a bucket and each bucket is having again bucket inside it.

Concept of Hashing :-
So hashing concept includes below important concepts/keywords/terminologies
1) Range of Collection i.e. spread of collection (here by collections I means input collection) :- for example min elem present was 5 and
max given was 995, then my range of collection would be 5 to 995.
2) Size of collection :- so max elem was 995 but given that total I was having only 10 elems (5,6,10,15,75,89,123,147,179,995). So total
size if 10
3) Bucket Size :- depends on us, how much size of bucket we will take. for example we are using hashing function in which we are doing
elem%100, so we are choosing bucket size of 100 and trying to convert all the input elements in range of 0 to 99 and put into bucket.
4) Hashing Function:-  Unique function designed to convert the elements into bucket range.
5) Collision :- each bucket might be having multiple elements after conversion which is known as collision.


All inputs to the Hashing function known as Domain and output from the Hashing function known as Ranges

Domain --> Hash Function --> Ranges

So hash function would be some function which is converting in the range of bucket. it is not some random undeterministic function.
this hash function can be anything:- like
fn =  ((x^2+7)*4%100) or anything which is just converting inputted elements into range of bucket. But for sake of our easiness we
can take function as fn = x%10

suppose given input elems are :- 7,77,100,120,6,17,4,107
7 --> 7%10 --> 7 --> so got to bucketId 7
77 --> 77%10 --> 7 --> so got to bucketId 7
100 --> 100%10 --> 0 --> so got to bucketId 0
120 --> 120%10 --> 0 --> so got to bucketId 7
6 --> 6%10 --> 6 --> so got to bucketId 6
17 --> 17%10 --> 7 --> so got to bucketId 7
4 --> 4%10 --> 4 --> so got to bucketId 4
107 --> 107%10 --> 7 --> so got to bucketId 7

Since we already discussed, each bucket is itself a bucket (i.e. bucket of buckets), so that bucket can be of anything like Array/LL/BST
etc but let's consider it as LL for now.

so each bucket in buckets is LL.

Insertion in hash DS:-
Step - 1:- i/p elem --> hash fn --> hashedKey (bucketId)     {O(1)}
Step - 2 :- go to the index=HashedKey and add elem in the LL (obviously at head only) of that bucket   {O(1)}
-------------
total= O(1)


Searching in hash DS:- suppose given val=107
Step - 1:- i/p elem --> hash fn --> hashedKey (bucketId)     {O(1)}
Step - 2 :- go to the index=HashedKey bucket and search an element from that LL    {O(k)} where k=size of that particular bucket's LL


So mean to say is as much less elem each bucket has, that much less searching complexity we would get. So Hash function is designed
in such a way that it can uniformly distribute the inputted elements across buckets.

Note:- No matter how Good hashing function you use, just because you are mapping a much bigger Domain into much smaller range So
"Collision will always happens"

These Collisions are costly because you need a way to manage the sub-collection of elems in efficient way.
- Collisions should be as few as possible
- Collisions size should be as minimum as possible.

Now so how we handle collisions is what defines the TC.

you can use any DS as Collision Management Tool (i.e. nothing but inner bucket about which we already discussed above).
 if LL as Collision Mana. Tool --> Retrieval = O(K)
 if BST as Collision Mana. Tool --> Retrieval = O(logK)
 Hash Function as Collision Mana. Tool { So even we can use another Hash function as for collision management }


Suppose given
domain :- 1 to 1,000,000
size of collection :- 1000

buckets :- 10

Worst case single bucket size inside above buckets = 1000
best case single bucket size inside above buckets = 100
so best case is when you distribute all the elems of collection

So you should aim to divide your i/p domain as equally as possible amongst the range.

So now from all the above discussion, you must understand there are 2 lever points or controlling points
1) Range Size (i.e. bucket size) :- Your range size should be find such that your buckets are not going to have lot of collided elements.
2) Hash Function :- another point is what kind of function you can pick to play with.
Hash function should have the property that it distributes it's domain as uniformly as possible across the range.

So let's perform a very small but good exercise. Giving a small scenario and you have to tell which ans is the better function.
Scenario:- I want to make a searchable index on all names in our class. so ip names would be for example like:-
[parth, prashant, param, utsavi,utsav,mehul,deep,mihir etc etc]

bucket size (range) given is 26 :- i.e(bucket indices :- 0 to 25)

option1:- hash fn1:-
fun hash(name) -> len(name)

option2:- hash fn2:-
fun hash(name) -> first char of (name)

So which function will do a better job?
Ans:- So my function should try to uniformly/equally distribute amongst the range. Now for 1st function if you think, almost
names goes from bucketIndex 5 to 9 only and remaining buckets are almost empty since generally any name can have 5 to 9 chars not
more than that. means think like how many elem will be distributed to 25th /24th/ 23rd/ 1st/ 2nd/ 3rd numbered bucket. almost nothing
ryt. so this will distribute like so many collisions between buckets from 4 to 9. So 1st option is very bad hash function.
Now for 2nd option if you see very carefully then, name can start from almost all the letters except may be 'q'. So 2nd option is
good bec it will distribute the ip elems across all the ranges. (even 2nd function also not uniformly distribute bec names from f and e
etc etc are very less ryt, but here it is better than 1st option).

ideally for our languages, these hash function is already designed and written by highly skilled mathematicians so we are directly
using them in our languages to solve problem, hence they are 100% sure to offer O(1) search time and insertion time bec there are so
many things kept abstracted from you like what hash function they have designed etc etc...



note:- The moment you do hash on any collection, you will loose the order. in short any pure hashing can never support ordering,
if you ask about TreeMap/TreeSet(which provides ordered keys/elems) then obviously there must be 2 step in between like on top
of hashing they are using something to get back the order behind the curtains. (By the way, TreeMap/TreeSet uses BST internally).

Note:- JFYI, before Java 8, hashing of Java was using LL as internal DS to handle collisions, but after Java 8, they have switched
on BST.


CRUX OF HASHING:- you take a set of elements that are scarcely populated across a large domain,
and then use mathematical hash functions to map these elements uniformly to a new but smaller spectrum of numbers.

 */

public class HashingImplementation {
}
