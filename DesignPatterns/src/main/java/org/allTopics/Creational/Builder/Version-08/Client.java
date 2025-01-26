/*
So to prevent the Object Creation without attributes validation, we are making Student constructor
as private. (Go to Student.java class)

Now as soon as we made student constructor private, even Builder.build() method is not able to create and return
the Student object. beacause Builder class is also an extrenal guy for Student. And since Student constructor
is private, it's only accessible to inner guys of the Student class.

- Hence as a solution we are keeping whole Builder class as an inner class of Student class.

 */
class Client{
    public static void main(String args[]){

        Student student = Student
                .getBuilder()
                .setId(1)
                .setName("Prashant")
                .setGross_salary(150000.0)
                .build();
    }
}


// This is the final version of Builder Design Pattern code.