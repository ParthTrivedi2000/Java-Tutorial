package org.allTopics.Creational.Builder.Version_02;
/*
So now since we want to have attributes validation and based on them we want to pass values for few attributes
so if you think I must have attributes together collectively, so that I can perform validation on few of them
(means jb bhi jitne bhi validate krne ho utne) then we can set values of few attributes as per the requirement.
And remaining could be default values.

So to store collective things, attributes names and it's values, obviously 1st thing comes to our mind is
Hashmap bec we want to store attrName and corresponding values i.e. something like key-val pair.
Hence I can perform validation on few of them based on the values set, and if those are upto the mark then
only need to create the object and pass the values to the object.

So I can create the hashmap and put class's all the 15 attributes in it.
 */

import java.util.HashMap;
import java.util.Map;

class Client{
    public static void main(String[] args){
        Map<String, Object> mp = new HashMap<>();
        mp.put("attr1",1);
        mp.put("attr2","Parth");
        mp.put("attr3",150000.0);

        Student student = new Student(mp);
    }
}

/*
Now issue with this approach is:-
1) No one will prevent me to write wrong attribute name as key. for example name --> neam. so just mean to say that
by mistake if someone passes attribute name incorrectly.
2) Since Map can have similar type of objects for both key and val. So here in student class I am having 1st
attribute to pass value as int then for name I want to pass value as String etc etc. So we need to keep it
as Object. So here is the issue. Since value is an Object type, so no one will prevent me to pass name with int
value (5), id as "parth" etc etc...So no type checking is there.

To solve the above issue check next version of code.
 */