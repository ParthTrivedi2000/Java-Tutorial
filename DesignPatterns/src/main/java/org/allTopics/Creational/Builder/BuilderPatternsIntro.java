class BuilderPatternsIntro{
/*
 - Adding info about what builder pattern is, And when to use it.
 - And please follow versions to get better and better in each version, and you can see the last/latest
 version to get updated solution of builder pattern.
 - Please land on the Client.java file as starting point for each Version directory.

 */


/*

The Builder Design Pattern is a creational design pattern designed to provide a flexible solution to constructing
complex objects. Its main goal is to separate the construction of a complex object from its representation,
allowing the same construction process to create various representations.


## Why Use Builder Design Pattern?

### The Problems with Constructors and Setters

1. **Telescoping Constructors**:
   - When a class has multiple constructors, each requiring different parameters, it can lead to the
   telescoping constructor anti-pattern. E.g., 1-param constructor calls 2-param constructor, which calls
   3-param constructor, and so on.

2. **Setters Leading to Inconsistent States**:
   - Using setters can leave an object in an inconsistent state until all necessary variables have been set. An
   object can be considered incomplete if required fields haven't been set before use.

3. **Validation Issues**:
   - With both constructors and setters, validating all prerequisites before object creation can be cumbersome.
   For example, ensuring certain fields are non-null or specific values meet particular criteria may require
   additional logic spread across multiple setters.

## The Builder Solution

### Concept Overview

- **Separation of Concerns**:
  - The Builder pattern separates the construction of a complex object from its representation. This allows the
  construction process to be more controlled and flexible.

- **Use of a 'Builder' Class**:
  - A separate `Builder` class is used to construct parts of the `Student` object. Once all parts are set,
  the `build()` method of the `Builder` class is called to create the `Student` instance.


Advantages of Builder Pattern :-
1) Builder Class For Complex Object Construction:
- Ensures that an object is instantiated only after passing through necessary validations, thereby precluding
an inconsistent state of the main object.
2) Code Readability and Maintainability:
- Enhances code readability and maintainability by providing better control over the construction process of
the object. Reduces the need for numerous constructors and setters.
3) Flexibility and Scalability:
- Allows for the flexibility to add additional attributes without significantly altering the existing
implementation. Changes are generally confined to the builder class without affecting the clients that use it.


Common Use Cases:-
1) When the construction process of an object is complex:
- When multiple parameters (with some being optional) need to be set during object creation.
2) When validation is crucial:
- When an object’s state needs comprehensive validation before it's considered complete and usable .
3) When immutability and consistency are essential:
- Ensures the created object is immutable and consistency is maintained throughout its lifecycle.


Conclusion:-
The Builder Design Pattern is an effective creational pattern frequently used in production environments to
handle complex object creation processes. It provides an elegant approach to managing construction, validation,
and the immutability of objects, making code more readable, maintainable, and flexible.

 */

}