package org.allTopics.Creational.Builder.Version_04;
/*
Since student class needs to provide the builder object, let's create seperate method for it.
 */

class Student{

    private int id;
    private String name;
    private double gross_salary;

    Student(Builder b){
        this.id = b.getId();
        this.name = b.getName();
        // validation:-
        if(b.getGross_salary() >150000.0){
            throw new RuntimeException("Can't be considered as Student. He can be Professor or HOD");
        }
        this.gross_salary = b.getGross_salary();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGross_salary() {
        return gross_salary;
    }

    public void setGross_salary(double gross_salary) {
        this.gross_salary = gross_salary;
    }

    /*
    Now since if you check in the Client code, till the moment builder is not set up, means not returned the
    object and setup the values, Student object will not be present.

    Then how to call this method first to get the builder object?(bec we don't have s1 object to call this method)
     So we have to make this method as static to be accessible via class name.
     */

    public static Builder getBuilder(){
        return new Builder();
    }
}