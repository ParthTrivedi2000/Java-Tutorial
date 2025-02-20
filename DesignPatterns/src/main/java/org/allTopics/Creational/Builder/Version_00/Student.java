package org.allTopics.Creational.Builder.Version_00;
class Student{
    private int attr1;
    private String attr2;
    private double attr3;

    // Constructor with no args
    Student(){
    }

    // Constructor with All Args
    Student(int a1, String a2, double a3){
        this.attr1 = a1;
        this.attr2 = a2;
        this.attr3 = a3;
    }

    // Constructor with required args
    Student(int a1){
        this.attr1 = a1;
    }

    Student(String a2){
        this.attr2 = a2;
    }

    Student(double a3){
        this.attr3 = a3;
    }

    Student(int a1, String a2){
        this.attr2 = a2;
        this.attr1 = a1;
    }

    Student(String a2, double a3){
        this.attr3 = a3;
        this.attr2 = a2;
    }

    Student(int a1, double a3){
        this.attr1 = a1;
        this.attr3 = a3;
    }
}


// Just for Knowledge:-

/*
What is Telescoping Constructor?

Student(id){
    this.id = id;
}

Student(a1,a2){
    this(a1);
    this.a2 = a2;
}
Student(a1,a2,a3){
    this(a1,a2);
    this.a3 = a3;
}
Student(a1,a2,a3,a4){
    this(a1,a2,a3);
    this.a4 = a4;
}

- As shown above, sequence of constructors in which each constructor is calling above constructor with
corresponding argument to set, and current constructor is responsible to set only single argument. This
is known as Telescoping Constructor.

Checkout for better understanding:- https://www.vojtechruzicka.com/avoid-telescoping-constructor-pattern/

 */