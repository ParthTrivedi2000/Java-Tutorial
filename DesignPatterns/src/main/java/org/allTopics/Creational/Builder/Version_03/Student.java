package org.allTopics.Creational.Builder.Version_03;

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
}
