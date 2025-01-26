/*
So now as discussed above, Student class itself will be providing builder object.
(Go to Student.java)
 */

class Client{
    public static void main(String args[]){


        Builder b = Student.getBuilder();
        b.setId(1);
        b.setName("Prashant");
        b.setGross_salary(150000.0);

        /*
        So now from above code, if any new to this unknown codebase will see, then also atleast he came
        to know ki yes this builder is coming from Student/ or means this builder b obj is somewhere
        related to Student.

        So now let's go with next version of improvement.
         */

        Student student = new Student(b);
    }
}

/*
Above code is better understandable than prev versions. But if you see here, I have to write this
b.setAttribute(); in each new line for so many times (think about if 15-20 attributes are there).

if you recall Streams ---> then in streams we can do like -->
Stream<Integer> s = List.of(1,2,3,4,5).stream();
s.map().filter().findfirst();

So in above streams we can access everything by using dot(.) for any new action item on the same set of data.
Why?
bec each intermediate function of Stream is actually again returning the Stream object only. So that's
why you can call any other method of stream on it.
This is also known as Chaining of the Methods (in which each method is returning same Object to perform next
action item.

- So please see next version of code.

 */