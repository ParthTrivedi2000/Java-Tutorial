package org.allTopics.Creational.Builder.Version_06;
/*
Adding method to build Student class object and return it.
 */

class Builder{
    private int id;
    private String name;
    private double gross_salary;

    public int getId() {
        return id;
    }

    public Builder setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public double getGross_salary() {
        return gross_salary;
    }

    public Builder setGross_salary(double gross_salary) {
        this.gross_salary = gross_salary;
        return this;
    }

    public Student build(){
        // Now what this Student method expecting in arg?
        // Builder object ryt? so how to pass it?
        // if you see carefully, we are inside builder class only, so how this method will be called?
        // by any builder object only ryt? so we can use that calling object only.(And here again
        // basics of OOPS:- this keyword represents the calling object).
        return new Student(this);
    }
}