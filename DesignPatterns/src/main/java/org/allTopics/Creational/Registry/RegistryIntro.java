package org.allTopics.Creational.Registry;

/*
- Actually Registry is nothing but only Data Storage which basically used to store something.
for example to store the different kind of objects.

- So generally Registry pattern is used with some other patterns like
Registry + Prototype
Registry + Factory

- As we have discussed, like registry is nothing but simply Data Storage,
How it is used with Prototype? --> so we create the prototype objects only once. And put it into the
registry. And just get the copy of the prototypes whenever needed. This is how Registry is used with Prototype.
Mote:- Generally we use the Map DS to store the prototype. Why? --> simple. bec we want to give some name to the
particular prototype to retrieve it's copy later ryt. i.e. we need something like key-val pair in which val is
basically prototype object. And another reason is (we can use any other DS like arraylist,LL etc. but Map is used
to find and retrieve corresponding prototype very fastly i.e. in O(1) so we are using Map).

- How Registry is used with Factory? -->
--> By storing the Factory method inside the Registry.

- Practical example of Registry :-
If you know springboot, then in the springboot we will be having Controller,Service,Repository etc etc...
Now all those are managed by Spring framework ryt. But they are using Registry concept here. means in the spring
they are creating those objects and placed inside the registry ( in spring language, it is called as IoC Container)
and then they return it whenever it's needed. So inshort concept is same means to store object somewhere & use
it later whenever it's needed.

 */

public class RegistryIntro {
}
