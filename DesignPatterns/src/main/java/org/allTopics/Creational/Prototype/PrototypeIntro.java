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

/*
In one of the good interviews, interviewer has asked,
- Do the Low Level Design of Jira. There will be Task. And task can be of any of the below types
--> Task
    - Epic
    - Feature
    - Story
    - Bug

Solution :- simply you will have to create Template/Prototype of all the above objects in the HashMap (i.e. in Registry)
And return the copy of those whenever new Task is created, bec there will lots of Task generated in a single day by a
product owner. So in this case every time hitting a Jira API to create Task object (bec class Task is written in Jira
API codebase ryt) is very expensive (means aesa man lo ki it's expensive to hit the JIRA API and get new Task Object
everytime, so here in this case you should use the Prototype & Registry design pattern. You need to store the different
Task object in the 1st time hitting JIRA & store them as Prototype, & from next time onwards simply, you can create the
clone()/copy of that object & change the description attribute of it.
- So just explain the interviewer that there will be a CreateTask button in the frontend, which gives above 4 options.
And based on the click on the Task in the frontend, backend will go to the registry & get the copy of the corresponding
object.
Q) but by default how we see blank fields?
- So while creating copy, don't set all the attributes in for the new copied object. Instead keep description empty
if you want description field to be empty.

Please see the codebase example 2 of prototype.


Doubt:-
Q) When to use builder vs prototype?
- See we have to use the builder when we have to create an object starting from scratch. Whereas we use prototype
where template has already been created, we get that template and modify/add to that template.
- Another thing is generally Builder is used whenever you are having a lot more attributes, And also builder is used
where you want to have validation of few attributes before creating an object, if that validation goes correct, then
only you want to create the object, in this case Builder is used. And in case of Immutable Objects also, you use
the Builder, you cannot use the prototype for immutable objects. bec in prototype you get the template & then change
the class attrs.

Q) for complex attributes, we will have to call the corresponding clone methods ?
- yes, we will have to recursively call the clone() methods.

Question for us to think:-
- Can we use the Registry Design Pattern in Strategy? if yes, where & how ?
Solution:- Yes obviously. Rather than storing  Strategies in the Factory, Store them in a Registry. So simply we can
register all the behavior types (i.e. different behaviors) in the registry & in the Service class/Client class get
the instance from Registry whenever needed.

- But then now tell me what's the difference between Factory & Registry ?
Factory always creates the new Object of the class, while registry just returns the object that is already there.

So you can remember Registry like
Registry = Factory + Singleton
(Singleton basically have a internal object/instance to store the object, but registry has map to store the object
but means both are returning the same object).

Interview Question:-
Q) I have been asked, we are getting performance issues with hibernate, how to get rid of it? (Another person
have been asked the similar question like, we are getting performance issue with DB, how to resolve it?)
(below is the same answer for both of them.)
- There can be multiple reasons. Probably your db is already burdened. If that's the case then you need to shard the
DB. Another reason is the Query the hibernate is generating might be not the most efficient one. means hibernate
might not able to create the most efficient queries. Then probably we need to write the query by ourselves. This
can be a case, but generally this is not the case. Other reason might be your DB schema is not good for querying
purpose, so probably you might need to change the schema. And also other things may get involved like creating indexes
etc etc...


 */