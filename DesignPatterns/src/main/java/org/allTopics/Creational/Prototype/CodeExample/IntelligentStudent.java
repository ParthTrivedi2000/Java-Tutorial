package org.allTopics.Creational.Prototype.CodeExample;

public class IntelligentStudent extends Student {
    private int iq;

    public IntelligentStudent() {}

    // 1st method to create copy of the object.
    // below is the 1 solution. Now suppose someone says, copy() method of super class. then we can also call the
    // copy method from student class. but issue is, see copy method of the student class. it is actually creating
    // one more student class's object. (so if we call super class ki method, then in that case we eventually ends
    // with hme jo chahiye wo IntelligentStudent object + extra Student object everytime (it's like buy 1 get 1 free).

    // So in the Student class, I don't want Student=new Student(), i.e. I don't want student object creation inside
    // copy() method, instead I want only copying attributes code inside copy() method.

    /*
    public IntelligentStudent copy(){
        IntelligentStudent s = new IntelligentStudent();
        s.iq = this.iq;
        s.setName(this.getName());
        s.setAge(this.getAge());
        s.setBatch(this.getBatch());
        return s;
    }
     */

    // So solution is to use the copy constructor.

    // is to actually copy the values of the attributes.
    public IntelligentStudent(IntelligentStudent intelligentStudent){
        super(intelligentStudent);
        this.iq = intelligentStudent.iq;
    }

   // to manage the copying process.
    public IntelligentStudent copy(){
        IntelligentStudent s = new IntelligentStudent(this);
        return s;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
