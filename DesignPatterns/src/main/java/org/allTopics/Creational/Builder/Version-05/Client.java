/*
So now as discussed in prev version, to apply Method Chaining to get advantage of readability and better
understandability by looking at code, need to return the Builder object for each .setAttriubte method
instead of returning specific datatype values.

So let's do it.
(Go to Builder.java)
 */

class Client{
    public static void main(String args[]){

        /*
        Now since all the setters are returning the Builder object only, I can write like below.
         */

        Builder b = Student
                .getBuilder()
                .setId(1)
                .setName("Prashant")
                .setGross_salary(150000.0);

        Student student = new Student(b);

        /*
        So now is code looks cleaner and more readable than prev versions?
         */
    }
}

/*
Now by looking at the code, responsibility of builder class is helper of Student class. but from name
itself it is not giving feeling of actually building something instead looks only of helping someone.

So check next vesion for better builder code.
 */
