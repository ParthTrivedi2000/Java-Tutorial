/*
Making Constructor as private.
- Student Constru. private --> builder.build() not able to access. so---> making whole builder class as inner cls
- since by having Builder class as inner class, Student.getBuilder() method is giving beow error
"non-static can't referenced from static context"
- So making the inner Builder class as static.

Note :- Always remember, you can't declare outer classes as Static, but inner classes can be declared as static.
checkout for better understanding:-
Nested Classes:-
https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
 */

class Student{

    private int id;
    private String name;
    private double gross_salary;

    private Student(Builder b){
        this.id = b.id;
        this.name = b.name;
        this.gross_salary = b.gross_salary;
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


    public static class Builder{
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
            this.validate();
            return new Student(this);
        }
    }
}