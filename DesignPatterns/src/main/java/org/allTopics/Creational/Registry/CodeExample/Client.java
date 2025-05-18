package org.allTopics.Creational.Registry.CodeExample;

/*
This code is associated with Prototype Code. (So please 1st visit the Prototype's Client.java file, then only land here).
 */

/*
We are creating student registry to store prototype objects of different types of Student.
And from the registry we can return the copy of those objects whenever anyone needs it.

- So create the StudentRegistry class. And create hashmap inside it. Also implement add(),remove(),get() methods.
- Now inside the client, just create the student object and place it inside the student registry.

 */

import org.allTopics.Creational.Prototype.CodeExample.Student;

public class Client {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John Doe");
        student.setAge(25);
        student.setBatch("Aprl2024");

        // Register April2024 batch student into the student registry.
        StudentRegistry registry = new StudentRegistry();
        registry.add("Aprl2024Student", student);

        // Now whenever next time you want april 2024 student, you can simply ask to registry & it will give the
        // copy object of it.

        Student student2 = registry.get("Aprl2024Student");

        /*
        Best Practices:-
        - Always try to register prototypes (i.e create single time & register it) and register to the registry.
        - Always try to implement get() method inside the registry to return the copy of the object instead
        directly return the student object. (means see the get() method of studentRegistry of this example.
        we can remove .copy() method from there, & here in the client code we can write
        Student st2 = registry.get("Aprl2024").copy()

        above is also correct. But issue we are facing sometimes is, sometimes people are changing the
        prototype itself inside the registry by modifying it. So to prevent them doing it, from the registry itself
        we are returning copy of the prototype object instead of returning directly prototype object.

        - Next point is, always try to keep key of Hashmap of registry as the kinds of main entity.
        means for example here, we want to store different students based on Batches. so which all batches
        types are available inside code in the form of ENUM type generally. for example with ENUM class name
        of StudentBatchType.(we haven't created it in this sample code to keep it simple & understandable. But
        in normal production grade code this is the practice we are following. So in that case, always try to create
        the HashMap with <StudentBatchType, Student>.

         */

    }
}

// Conclusion  of Prototype & Registry:-
/*
- Prototype is just to create copy of objects. Now how you are implementing copy that is also upto you like directly
creating new object st2=new student() inside copy method, or by passing the callingObject this inside copy constructor
(similar as we have implemented), or directly using args inside the constructor etc etc...
- Registry is nothing but simply Data Storage to store something. Now you can use this Registry pattern with any other
pattern like Registry + Prototype (stores different prototype inside Registry) or
Registry + Factory (stores Factory objects inside Registry).
etc etc...
 */

