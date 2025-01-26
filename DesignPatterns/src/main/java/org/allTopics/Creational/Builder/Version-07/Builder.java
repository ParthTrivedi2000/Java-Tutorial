/*
Adding new method for validation to make code of Student constructor cleaner
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

    public void validate(){
        // Put all the validations over here.
        if(name==null) throw new RunTimeException("Name is mandatory to pass");

        if(gross_salary>150000.0){
            throw new RunTimeException("Can't be considered as Student. He can be Professor or HOD")
        }
    }

    public Student build(){
        // calling validate method before returning the student object.
        this.validate();
        return new Student(this);
    }
}