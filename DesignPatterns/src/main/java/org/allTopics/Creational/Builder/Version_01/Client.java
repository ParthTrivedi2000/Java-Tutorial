package org.allTopics.Creational.Builder.Version_01;
/*
Now apart from constructor, another solution is to use the Setters to fulfill the requirements. it means to set the
attribute's values.
 */

class Client{
    public static void main(String[] args){
        Student student = new Student();

        student.setAttr1(3);
        student.setAttr2("Prashant");
        student.setAttr3(1000000.0);
    }
}

/*
So far so good ryt. Now above what happens is, object is already created first if you see carefully. So anyone
can play with it.

Means now suppose requirement is, you are having 15 attributes in the class. But you only have to create
Object if this 4 attributes having values greater than something. So just mean to say that suppose out of
all the attributes, 1st we want to validate 4 attributes and if those 4 attributes are validated then only
object should be created.

Now if it would be fixed like which 4 attributes needs to be validated, then we can try to think of a solution
means simply we can create a method in the client and validate those 4 attributes' values before passing to
Student.

But since is next time user want to validate any other 3 attributes. If those are validated and upto the mark
then only user want to create the object. And there also he wants to pass/set values of any other 5 attributes
out of 15 (so i.e. for remaining 7 attributes should hold the default values).

now how to handle this requirements?

Please move to next version of solution.
 */