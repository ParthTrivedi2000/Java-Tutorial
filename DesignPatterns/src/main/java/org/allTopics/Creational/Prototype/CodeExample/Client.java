package org.allTopics.Creational.Prototype.CodeExample;

/*
So for example, there is a student class. And it is having 3 types of student.
1) Intelligent Student, 2) Average Student  3) Sport Student

- Inherit all the 3 classes from Student class.

Now suppose we want to create copy of student object.
- So create copy() method inside Student class which actually returns the Student object.
similarly override the copy() method in Intelligent Student (and all the other types of student object).

// 1st Solution to implement copy.:- Just create Student object inside copy() method itself.
    public Student copy(){
        Student s = new Student();
        s.name = this.name;
        s.age = this.age;
        s.batch = this.batch;
        return s;
    }

And then inside IntelligentStudent class()

    // 1st method to create copy of the object.
    // below is the 1 solution. Now suppose someone says, copy() method of super class. then we can also call the
    // copy method from student class. but issue is, see copy method of the student class. it is actually creating
    // one more student class's object. (so if we call super class ki method, then in that case we eventually ends
    // with hme jo chahiye wo IntelligentStudent object + extra Student object everytime (it's like buy 1 get 1 free).

    public IntelligentStudent copy(){
        IntelligentStudent s = new IntelligentStudent();
        s.iq = this.iq;
        s.setName(this.getName());
        s.setAge(this.getAge());
        s.setBatch(this.getBatch());
        return s;
    }

    // So in the Student class, I don't want Student=new Student(), i.e. I don't want student object creation inside
    // copy() method, instead I want only copying attributes code inside copy() method.

Solution :-
So we can use the copy constructor to create copy of the object.
please go to Student class and all the children of Student class & create the copy constructor in each of them.
and then modify the copy() method.

    public Student(Student s){
        this.name = s.name;
        this.age = s.age;
        this.batch = s.batch;
    }

    public Student copy(){
        Student s = new Student();
        return s;
    }

in IntelligentStudent class:-

    public IntelligentStudent(IntelligentStudent intelligentStudent){
        super(intelligentStudent);
        this.iq = intelligentStudent.iq;
    }

    public IntelligentStudent copy(){
        IntelligentStudent s = new IntelligentStudent(this);
        return s;
    }

    So flow would be:-
    copy constructor :- is to actually copy the values of the attributes.
    copy method:- to manage the copying process.


 */

public class Client {
    public static void main(String[] args) {
        Student st = new Student();
        IntelligentStudent inst = new IntelligentStudent();

        // Creating new objects by copying the values from prototype objects.
        Student st2 = st.copy();
        IntelligentStudent inst2 = inst.copy();

        System.out.println(st);

    }
}


// This is all about Prototype Pattern.

// Now suppose we want to create Registry of the above ptototype objects.
// Please land to the Client.java inside Registry package.
