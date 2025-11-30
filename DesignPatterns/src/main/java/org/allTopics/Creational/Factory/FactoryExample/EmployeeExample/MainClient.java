package org.allTopics.Creational.Factory.FactoryExample.EmployeeExample;


public class MainClient {

    public static void main(String[] args){
        //    Employee emp1 = new WebDeveloper();
        //    Employee emp2 = new AndroidDeveloper();

    /*
    So above there is 1 super/parent class - Employee. and it has 2 sub/child classes. AndroidDeveloper and
    WebDeveloper.
    (Pls always remember whenever there comes superclass-subclass relationship, always create super class
    either as Abstract class or an Interface. because it is representing something or some object. And it can
    have many children, means child classes).

    Now here above there are only 2 subclasses for keeping it simple. But thing of an Vehicle or Developer
    or Language as super class then it can have so many child classes. So to get object of child type,
    client has to create so many objects from itself.

    So here Factory Design Pattern comes into the picture.
    Always remember, wherever you need to deal with superclass-subclass (parent-childclass) relationship,
    you can use Factory Design Pattern.

    Again let's go with the name only. Factory
    means it is generating so many things and distributing further to the users as per their requirement.
    So here same principal is there.
    - In Factory Method Design Pattern, we will create 1 Factory class corresponding to super class. And
    that factory class can have static method so that client can call it directly from class name without
    creating the objects. that method should return super typed object (here Employee) and it should take
    something as input so that client can call by passing argument of whichever type of sub class object it
    needs.


    What Factory Design Pattern (In Technical language)?
    when there is superclass and multiple subclasses and we want to get object of subclasses based on input
    and requirement. Then we always create Factory class which takes the responsibility of creating object
    of class based on input.

    Advantages of Factory Design Pattern
    - Focus on creating object for interface rather than implementation.
    - Loose coupling hence more robust code.
     */
        EmployeeFactory ef = new EmployeeFactory();

        Employee emp1 = ef.getEmployee("Web Developer");
        Employee emp2 = ef.getEmployee("Android Developer");
        System.out.println(emp1.getSalary());
        System.out.println(emp2.getSalary());

        // So this is all about factory method design pattern. Let's conclude it.
        /*
        - create a Factory class corresponding to super class.
        - And create 1 method inside it to get the different subtypes of objects anytime from the Factory class
         based on the requirement.
         */
    }
}
