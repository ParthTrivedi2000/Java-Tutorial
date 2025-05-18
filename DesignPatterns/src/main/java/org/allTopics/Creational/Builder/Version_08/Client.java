package org.allTopics.Creational.Builder.Version_08;

/*
So to prevent the Object Creation without attributes validation, we are making Student constructor
as private. (Go to Student.java class)

Now as soon as we made student constructor private, even Builder.build() method is not able to create and return
the Student object. because Builder class is also an external guy for Student. And since Student constructor
is private, it's only accessible to inner guys of the Student class.

- Hence as a solution we are keeping whole Builder class as an inner class of Student class.
Go to Student.java file.

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


// This is the final version of Builder Design Pattern code.

// Steps to implement Builder Design Pattern:-
/*
1) jiske liye Builder pattern implement krna h uska class create kro.
2) Make sure to have private constructor of that class which takes Builder class as an argument. And inside that
constructor set the properties of the attributes.
3) create a static method getBuilder() which return Builder object.
4) create a static class Builder. Make sure to have no args constructor in it.
5) provide setters in builder class each with return type of Builder object.
6) create a method build() which should return the Object for which you are implementing the Builder design pattern.

or

Step 1: Create main class (e.g. Student)
- Identify all required attributes
- Make constructor private
- Add static getBuilder() method to return Builder instance

Step 2: Create Builder class (as static inner class)
- Copy all attributes from main class
- Make attributes private
- Add getters/setters for attributes
- Make setters return Builder instance (return this)
- Add build() method that:
- Validates attributes
- Returns new instance of main class
Step 3: In main class constructor:
- Accept Builder parameter
- Copy validated values from Builder to main class attributes


Note:-
- This point is very ery very important. Inner Builder class does not have to be all the attributes of the Student class,
It only need to have the attributes which are required to be constructed the Student object. It means simply Student
class k constructor me jitne h utne hi he dene h.
(Here in above case this point seems useless/senseless bec we are having all the attributes as constructor params, but
in so many cases same case will not be there. For example we have implemented Builder design pattern in the TicTacToe
design question. Please check it out.
- Builder class doesn't have the public constructor. It always have the private constructor.
Then how to get the Builder class's object? --> by having getBuilder() method as a static method in the parent/outer cls.
- Since Builder doesn't have the constructor, then how to pass values to the attributes in builder? --> Via setters for
each attribute available inside builder class
 */