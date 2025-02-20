package org.allTopics.Creational.Builder.Version_07;
/*
So to make Student Constructor cleaner and easily readable, we can create separate method
for validation in the Builder class, And call that validate() method before returning the
Student object from build class. (Go to Builder.java).
 */

class Client{
    public static void main(String args[]){

        Student student = Student
                .getBuilder()
                .setId(1)
                .setName("Prashant")
                .setGross_salary(150000.0)
                .build();
    }
}

/*
- So till this point, this is the too good version of builder design pattern. And you will find this version
in so many codebases.

- But tell me, we have given facility to get the Student object via above .build() method, still what if someone
wrote Student s = new Student(new Builder());
means who will prevent me to write that, so someone can write it ryt?
And consequence is attributes are not validated, and object is available directly to the client without
validating those mandatory attribute validation.

So we want to restrict them to do this ryt?
How can we restrict anyone to prevent the Object creation?
- correct. by making constructor private.

So please check the next version of code.
 */



