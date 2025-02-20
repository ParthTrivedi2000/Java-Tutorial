package org.allTopics.Creational.Builder.Version_05;

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

    public static Builder getBuilder(){
        return new Builder();
    }
}