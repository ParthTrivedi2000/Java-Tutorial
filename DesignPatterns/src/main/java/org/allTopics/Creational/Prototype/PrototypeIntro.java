package org.allTopics.Creational.Prototype;

// What is prototype?
// So prototype is sample or copy or skeleton from which you can crete/generate something new actual one ryt.

// Problem Statement :-
// So you have been given an Object. You have to create copy of that Object.

// Now how to do it?

//Student st = new Student();
//Student st1 = st;

// Above is totally wrong. As we know above 2 lines, only copies the reference of the object.
// Not the actual object. means we need to have new actual object.


// Another way:-
//Student st = new Student();
//
//Student st1 = new Student();
//st1.name = st.name;
//st1.age = st.age;
//st1.email = st.email;

// So what's the issue with above approach?
// - need to put so much effort, bec assigning values manually. Think about 15-20 attributes everywhere, everytime have
// to write it. Means think any Gaming application. in that you need to create lots of Tree Object/ Bullet Object etc
// and everytime in each file (Service class/character class/enemy class/hero class) everywhere you will have to write
// this new copying object code manually. So it is basically, we don't have code reusability.
// - another thing is, here Client is creating the copy of the object ryt/ or means particular service is creating
// object, then that client/service need to know everything about the object. means internal attributes, then only
// it will be able to assign the values ryt(for example:- st1.name=st.name).

// There are majorly 3 issues with above approach:-
// 1) Not reusable. if next time, at ay place we need, then again have to write all the lines of code.
// 2) Since client is creating this object, it needs to know about whole Student class, like all the attributes
// and behaviours.
// 3) Now above we have written st1.name. But what if few attributes are private (and even general practice to
// make the attributes private). --> Then you might say that using getters & setters. Again what if getters
// & setters are not available? then we even not able to write above lines ryt.


// Then what's the solution?

// May be you think of Copy Constructor.
//class Student{
//    Student(Student other){
//        this.name = other.name;
//        this.age = other.age;
//        this.email = other.email;
//    }
//}

//class Client{
//    public static void main(String args[]){
//        Student st = new Student();
//        Student st2 = new Student(st);
//    }
//}

// Yes Copy Constructor can be one of the solution. But there is a catch over here.
// Now Suppose, you student class has child classes like for exa:- IntelligentStudent has inherited the class
// Student.

// Now in this case what happens is, copy constructor (Student(Student other)) would be fine if someone passes
// child class object then also. means someone passes IntelligenetStudent as other object
// (Student(IntelligentStudent Ist)), then also my code won't stop it and won't give error and keep continue running
// since parent can hold the child object so it won't give error.
// - In this case you have to check manually inside the copy constructor for each and every child classes available
// of parent Student class. And if there are multiple child classes, then you have to write many if-else clauses
// inside copy constructor. which is actually not a good practice correct.

/*
Student(Student other){
    if(other is instanceof Student){
        Student st = new Student();
        this.id = other.id;
        this.name = other.name;
        this.age = other.age;
        this.email = other.email;
    }
    if(other is instanceof IntelligentStudent){
        Intelligentstudent st = new IntelligentStudent();
        this.id = other.id;
        this.name = other.name;
        this.age = other.age;
        this.email = other.email;
    }
    if(...){}
    etc etc...
}

 */




// So instead we can have another solution.

// So from above 3rd point itself you might understood that since it might happen that variables are private and setters
// are not available, then we can access those attributes inside the class only.
// - So solution would be to instead of creating object externally means by client/service or someone, instead we can
// outsource this copy/object creation task to that class itself. i.e. to create the copy of Student, we can create some
// method inside the Student class and sending back the copy of student object whenever method was called.

/*
class Client{
    public static void main(String args[]){
        Student st = new Student();
        Student st2 = st.copyObject();
    }
}

class Student{
    Student(){}

    Student copyObject(){
        Student st = new Student();
        st.name = this.name;
        st.age = this.age;
        st.email = this.email;
        return st;
    }
}

 */

// With above solution you can see, above mentioned 3rd issue is also resolved even my client also don't need to
// know about the class. Similarly 1st issue also resolved since now I don't have to write all the above lines
// to copy the values of attributes everywhere, we just need to call the copy() method wherever needed. And also
// 2nd issue is resolved.

// And if there is inheritance present, i.e. any class has extended this copy method, then also it would be fine
// ryt. means simply that child class needs to override the copy() method. So now if someone has called copy()
// on IntelligentStudent object then it will return the copy of object IntelligentStudent.

/*
class Student{
    copy(){

    }
}

class IntelligentStudent{
    copy(){

    }
}

class Client{
    public static void main(String args[]){
        st.copy();
        // Now here whichever object st is typeof there (like Student st or IntelligentStudent st), that particular copy
        // method will be executed.
    }
}

 */

// This is all about Prototype Design Pattern. which is basically meant for how to create a new object using
// existing object in the best possible manner (Since this is creational design pattern, this is also related
// to creation of object)

// JFYI :- clone() method in Java is example of Prototype design pattern.

// But why we need this Prototype design pattern?
// So actually there are lot of places where there is need of copying existing objects.
// For example:- mainly in Gaming , UI Component Libraries etc etc (bec in game what we do is, we are having
// 100+ entities, so we create a one and then we keep copying the same whenever required, same with UI comp
// library, there is a component, now whenever need the same, then keep copying from prev one.


// So whenever someone is saying copy the object (weather it's shallow or deep), it is upto developer
// how he writes the copying mechanism, inside the Client itself, or in the copy constructor, or with separate
// copy() method which can be overridden by child etc etc.... So above is provided the best way for
// copying mechanism.

class PrototypeIntro {

}