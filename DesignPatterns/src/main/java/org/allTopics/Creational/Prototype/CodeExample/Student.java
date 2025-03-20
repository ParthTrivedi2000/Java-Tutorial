package org.allTopics.Creational.Prototype.CodeExample;

public class Student {
    private String name;
    private int age;
    private String batch;

    public Student(){

    }

    // 1st Solution to implement copy.:- Just create Student object inside copy() method itself.
    /*
    public Student copy(){
        Student s = new Student();
        s.name = this.name;
        s.age = this.age;
        s.batch = this.batch;
        return s;
    }
     */

    // copy constructor
    public Student(Student s){
        this.name = s.name;
        this.age = s.age;
        this.batch = s.batch;
    }


    public Student copy(){
        Student s = new Student();
        return s;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
