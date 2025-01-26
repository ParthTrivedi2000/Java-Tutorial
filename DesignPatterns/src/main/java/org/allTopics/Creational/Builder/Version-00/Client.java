/*
 Now for example, suppose we are having 15-20 attributes in our class. So to pass the
 values of those available attributes, we would be needing a constructor ryt.
 But problem is, requirement is saying, it is not fixed like which attrubite user/client wants
 to set the value of. means user can pass value of any 2 variables out of 15/ or 3 variables out of 15
 or 14 out of 15 or 15 out of 15.

 So for example suppose any class is having 3 attributes, then below would be constructor required
 to fulfill the requirements ryt. (No args constructor + All args constructor + Constructor with
 require arguments (but here reuiqred argument is not fixed so need to create for each combination)).
 (Go to Student.java)

 */

class Client{
    public static void main(String[] args){
        Student s = new Student(1,"parth",50000.0);
    }
}

/*
- So you can see above, there has to be Constructor Overloading to fulfill above requirements.
 Above you have seen by considering only 3 attributes. 3 attributes --> 2^3 constructors

- So now you can think like, if my class is having 15 attributes and I want to fulfill above requirements
then I have to write 2^15 constructors!!!!!!

- So we can't use above Constructor Solution to fulfill the given requirements.

So let's move to the next version.

 */
