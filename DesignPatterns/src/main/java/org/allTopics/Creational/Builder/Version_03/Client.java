package org.allTopics.Creational.Builder.Version_03;
/*
So to resolve the above 2 issues with HashMap, Can you think of any Data Structure which can store the
data and also provide name checking + type checking.

- Correct, so there is no any specific DS which do above thing. But if you understand the core concept of
OOPS then class is doing the same thing (means recall, a class is actually storing info about any real life
object. And also provides name checking and type checking (bec we can't pass different type/ name to
the constructor of the class to create an object.

- So we will create a separate helper class (which basically act as DS for us to store all the attributes of the
class). All the required attributes of the Main entity/class (for which we are working i.e. here Student) are
passed to this helper class. This helper class is known as "Builder" class.
We will have all those attributes of Student class inside builder class, which Client is expecting to pass.

- we can perform the validation inside this. And if validation looks good then only we will create the object
of the main Student class.

(Go to Builder.java)

 */

class Client{
    public static void main(String args[]){
        Builder b = new Builder();
        b.setId(1);
        b.setName("Prashant");
        b.setGross_salary(150000.0);
        /*
                |
                |
                |
            15-20 more lines which setting up 15 different attributes.
         */

        Student student = new Student(b);
    }
}

/*
So above if you see, unless you create builder class and set attribute values, your Student object is not in
inconsistent state (see, even it was not created till that moment).

- Now we will pass this class to the Student.
- Now go to the Student class, since we had multi args constructor present over there, but now we need constructor
which accepts builder class as an arg and passing values to it. (Go to Student.java)

- If you see here, you can add easily new attribute to the Student entity without modifying code too much in
comparison with constructor based solution (version-1).

- What about validations?
You can do validation in the builder class's setters itself.
Or you can do validation in the Student class's constructor as well. (Just see Student class)

- So this is the basic version of Builder Design Pattern. Now from next version itself, we are syntactically
improving the code but conceptually, this is it. This is the concept of builder design pattern ( to store the
attributes in separate class as DS).
So let's do it.



So in above code if you see, as a new developer's perspective, untill line no 15 there is no code for student
class however we are working for Student class. (It might happen ki you feel it's easily understandable, but
think about 15-20 attributes, set over here manually in the code, so you must also get confused by seeing
in any new codebase). So any new person in project might also get confused ki what this is all about and
why/how it come here.
Another thing is, here above builder is something meant for helper as Student class, still client has to
remember about the builder class nd need to create object of builder to just some other class (here Student).

- So since builder is created for the Student, so let Student himself needs to provide it.

So please check next version of code.
 */