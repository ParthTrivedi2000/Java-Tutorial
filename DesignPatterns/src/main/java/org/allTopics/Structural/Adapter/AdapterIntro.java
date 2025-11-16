package org.allTopics.Structural.Adapter;

/*
The Adapter Design Pattern is a powerful and essential tool for software developers. It helps to create flexible and
maintainable code by allowing objects with incompatible interfaces to work together seamlessly. In this comprehensive
guide, we will explore the Adapter Design Pattern in depth, covering its key concepts, benefits, and real-world
examples. We will also look at its implementations and how it can be used to solve common software design problems.

What is Adapter Design Pattern -:
Adapter design pattern is one of the structural design pattern and it is used so that two unrelated interfaces can work
together. It is often used to make existing classes work with others without modifying their source code. The pattern
involves creating an adapter class that bridges the gap between the interfaces, allowing them to communicate effectively.

One real-world example of the Adapter Design Pattern is a mobile charger. Mobile chargers act as adapters between the
power socket and the mobile device, converting the voltage to a suitable level for charging the device. In software
development, the Adapter Design Pattern follows the same concept by introducing an additional adapter class between an
existing interface and a class that needs to work with it.


The Problem the Adapter Design Pattern Solves -:
The Adapter Design Pattern addresses several common issues in software development:

- How can a class be reused if it does not have an interface that a client requires?
- How can classes with incompatible interfaces work together?
- How can an alternative interface be provided for a class?
The Adapter Design Pattern solves this problem by defining a separate adapter class that converts the incompatible
interface of a class (called the “adaptee”) into another interface (called the “target”) that clients require.


The Components of the Adapter Design Pattern -:
The Adapter pattern involves three main components -:
a) Target: This represents the interface or class that the client code expects to work with. It defines the operations
that the client can use.
b) Adaptee: This refers to the existing class or interface that needs to be adapted. It has a different interface that
is incompatible with the client’s expectations.
c) Adapter: This is the class that bridges the gap between the Target and Adaptee. It implements the Target interface
and internally uses an instance of the Adaptee to perform the desired operations. The Adapter class acts as a wrapper
or translator, adapting the Adaptee’s interface to match the Target interface.


Different implementations of Adapter Design Pattern -:
There are two main approaches to implementing the Adapter Design Pattern: the class adapter pattern and the
object adapter pattern. Both approaches produce the same result, but they use different techniques.

Class Adapter Pattern
In a class adapter, the Adapter class extends both the Target interface and the Adaptee class. It inherits the behavior
of the Adaptee and adapts it to match the Target interface. However, this approach requires multiple inheritance, which
may not be supported in some programming languages.

Object Adapter Pattern
In an object adapter, the Adapter class implements the Target interface and contains an instance of the Adaptee class.
It delegates the calls from the Target interface to the Adaptee object, adapting its interface to match the Target
interface. This approach uses composition instead of inheritance, making it more flexible and compatible with different
programming languages.


Real life examples of Adapter Design Pattern -:
The Adapter pattern can be applied in various scenarios. Here are a few real-world examples:

a) Database Adapters: When working with different database systems, each may have its own specific API. An adapter can
be used to convert the operations and queries from one database system to another, allowing the client code to work
with a common interface.

b) Legacy System Integration: When integrating new software components with existing legacy systems, the Adapter pattern
can be used to translate the legacy system’s interface into a more modern and compatible one.

c) Plug Adapters: In electrical systems, different countries may have different types of electrical outlets. Plug
adapters allow devices with one type of plug to be used with different outlet types by adapting the plug to fit the
specific outlet.

d) Java’s InputStreamReader and OutputStreamWriter : The java.io.InputStreamReader and java.io.OutputStreamWriter
classes act as adapters that convert an InputStream into a Reader and an OutputStream into a Writer, respectively.
These adapters allow for seamless data conversion between different formats, making it easier to work with various
types of input and output streams.

e) Java’s Arrays.asList() Method :The java.util.Arrays.asList() method is another example of the Adapter Design Pattern
in action. This method converts an array into a List object, allowing for easier manipulation and processing of the data.

Benefits and Drawbacks of the Adapter Pattern -:
Benefits -:
Promotes code reusability by adapting existing components instead of rewriting them.
Enables collaboration between incompatible interfaces, fostering interoperability.
Allows the client code to work with a common interface, regardless of the underlying implementation.
Drawbacks -:
Can introduce additional complexity if not used judiciously.
May result in performance overhead due to the translation between interfaces.
Increases the number of classes and complexity in the codebase.
Conclusion -:
The Adapter design pattern is a powerful tool for bridging the gap between incompatible interfaces. By providing a
translation layer, it allows objects with different interfaces to collaborate and work together seamlessly. Whether
you’re integrating legacy systems or working with third-party libraries, the Adapter pattern offers an elegant solution
to ensure compatibility and reusability in your software projects.


Reference (Please read more about it):-
1) https://medium.com/@akshatsharma0610/adapter-design-pattern-in-java-fa20d6df25b8
2) https://www.baeldung.com/java-adapter-pattern
3) https://www.scaler.com/topics/design-patterns/adapter-design-pattern/
4) https://refactoring.guru/design-patterns/adapter/java/example
5) https://qbalsdon.github.io/patterns/programming/adapter/android/kotlin/focus/2020/11/19/adapter-pattern.html
 */

public class AdapterIntro {
}
