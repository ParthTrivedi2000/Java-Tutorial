/*
So to actually perform the building of some class, since this particular builder class is meant for help in
building Student class, instead Client is returning Student object, my Builder class should return the Student
object.

So let's modify the builder class. (go to Builder.java).
 */

class Client{
    public static void main(String args[]){
        /*
        Now instead of creating Student object seperately in below line, we can use that build method.
        And make sure to capture it in Student object since it is now returning the Student not Builder obj.
         */
        Student student = Student
                .getBuilder()
                .setId(1)
                .setName("Prashant")
                .setGross_salary(150000.0)
                .build();

    }
}

/*
Now if you see from line 12 to 20 (consider 15 attributes then till line 32), did you as a new person to current
codebase ever feel like there might present some builder class and all in between ? --> No ryt.
Actually it makes more sense and giving impression ki yes I am creating something student object and
passing values to it,that's it.

- So flow above is:-
we are asking to Student class --> give me builder obj --> passing attr1 and asking give me modified builder obj
--> setting attr2 ................. --> at last after setting all attr, give me student obj.

- Good question:-
How can we solve the problem of required attributes are being set mandatory?
Soln:- in builder it is not mandatory to check attributes since it is not required. But in student you can check
like if that attribute is passed or not. for example I want name to be set by client/user as mandatory
then i can perform validation on name as well. (Go to Student.java and check it).

- Now if you think my Student Constructor is blotted up and looks very dirty (just again check Student class)
bec of those validations for 8-9 attributes out of 15-20, --> check the next version of code.
 */


