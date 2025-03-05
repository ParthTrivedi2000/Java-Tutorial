package org.allTopics.Behavioral.Strategy.WithStrategyPattern;

public class Client {
    public static void main(String[] args) {
        Vehicle vh1 = new SportyVehicle();
        vh1.drive();
    }
}


/*
Conclusion:-
So whenever 1 or more child wants same functionality which can't be overridden from parent. means if child
want same functionality as parent then even we don't need to provide separate implementation, we can directly
call the parent implemented behaviors directly since those are already available to child due to inheritance.

But since child wants some different features or updated functionalities for that behavior, hence they are
overriding behaviors from parent. Now here if there are 1 or more child wants same functionalities then there
will be code duplication since we are writing same updated behavior in both the children.

So in these cases to prevent code duplication in case of 2 or more children wants to have same functionalities,
we have to use Strategy pattern. We have to create the interface for that updated functionality. And we can
have concrete classes for normal and updated functionalities. then Parent class can have constructor injection
of these strategy object. And corresponding children can use those by passing required capabilities object into
constructor.
 */
