package org.allTopics.Creational.Builder.Version_05;

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
}