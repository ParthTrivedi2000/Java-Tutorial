package org.allTopics;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        /*
        Reference:- https://engineeringdigest.medium.com/generics-b158a743d18f

        Generics :-

        - Introduced in :- Version Java 5.
        - Issue before Java 5 in Collections / Need of Generics due to these issues in collections:-
            1) Manual Typecasting while retrieving from collection.
            2) There was No Type Safety.
            3) No compile time checking. while retreiving
        Let's see with below example, exactly what do I mean by above 3 issues.
        And we will also understand exactly what Generic means from below examples.
         */


//        ArrayList al = new ArrayList();
        // Before Generics in Java 5, we only have option to create any collection class/ Interface
        // without using generic type.

//        al.add("Hello"); // String - Object type element
//        al.add(456);     // Integer - Object Type element hence valid
//        al.add(6.89);    // Double - Object type element hence valid

        // So I can add any type of Object in the al. Since from declaration you can see, we haven't mentioned
        // any specific type hence ArrayList al will store Object type elements by default. And all the child
        // class like Integer, String, Double, Long etc etc have already extended the Object class (means as we
        // know from Java fundamentals like Object class is parent class for all the other child classes) So
        // I can add all these child ype objects in al.

        // Now when I retreive back the Object type element from collection, it
        // returns the Object type element but as a developer I want it to be a String type hence I have to
        // typecast it. Suppose if you write below like you get compile time error bec reference is child type
        // and returned object is parent type so means child type can not hold objects for parent types (basic
        // OOPS).
//        String str = al.get(0);

        // So have to typecast the Objects manually everytime whenever I want to retrieve back from collection.
//        String str = (String) al.get(0);

        // Now 2nd issue is, as a developer as per the business requirement I know like all the elems in the
        // al should be of type String only hence , and I have written like below line. (But actually list is
        // having mixed types of elems)
//        String elem = (String) al.get(1);
        // So above line is not giving any Compile time error since child type is holding child type object
        // But if you run above line then, at Run time you will get Exception like class Integer can not
        // be converted to class String something like that. So just mean to say that this is the 2nd issue
        // like without Generics, there was no compile time checking previously hence incorrect code might
        // deployed and at run time shows error.

        // And 3rd issue is also shown with above example like there is No type safety like all the elems
        // present in the al are considered as type Objects only weather it is Integer, String,Float, boolean etc
//        Integer elem = (Integer) al.get(1); // (Valid)


        // All the above 3 issues can be solved by Generics :-
        // So from Java 5 once Generics available, then what generics says like it will allow to mention
        // the types while creating collection instance itself. Previously hm ku6 bhi type ka data dal rhe
        // the and ku6 bhi type ka retrieve kr rhe the hence getting issue of types mismatch and all those
        // things. But here java put restriction at add time only. So now if you write below lines
//        ArrayList<String> al1 = new ArrayList<>();
//        al1.add("heello");
//        al1.add("there");
//        al1.add(456); // Invalid. Checking at compile time and preventing me to add hence get error at compile
        // time only.


        // Now let's understand more about the Generics.

        // Now I am creating class of Box.
        // Let's play with it

        // I am having 1 object for that class. which is type Object. So now again I can get the object
        // from box class via getters. And set it also via setters.
//        Box b1 = new Box();
//        int x = b1.getBox(); //(Invalid as op object is type Object but receiver is of type int)
//        int x = (int) b1.getBox(); // (Valid)

//        b1.setBox("Hey"); // I am setting value as String still no error.

        // Now again if by mistake, I wrote line like above of
//        Integer x1 = (Integer) b1.getBox();
        // above line will generate error at Run time since I am having string in that box class but I am
        // trying to get it as Integer.

        // So now what is the solution? Solution is to make the Box class as Generic type.

        // Now very very very important thing. How to make Box class as generic.
        // Note:-
        // before to go there,:- what are the generics? class,interface, methods or what?
        // Generic types allow you to define a class, interface, or method with placeholders (type parameters)
        // for the data types they will work with. This enables code reusability and type safety, as it allows
        // you to create classes, interfaces, or methods that can operate on various types without needing
        // to rewrite the code for each type.

        // So A generic type is a class or interface that is parameterized over types. For example, a
        // generic class can work with any type specified by the user, and that type can be enforced at
        // compile time.

        // Syntax to make any class as of Generic Type:- Simply we need to make class with placeholder and
        // I have to mention the <T> in the placeholder. i.e. I am saying ki Box ke ander objects h wo
        // T type k hoge. Please note, here it gives flexibility to choose the corresponding data type
        // at compile time i.e. whenever you are using this class for instance creation. At that time
        // whatsoever Type you mention that will be applicable to the objects of class Box. And see
        // carefully, while setting, at that time also I have to provide the type T values only. means those
        // values only can be applicable to objects of Box class. And for getters also if you see, like we are
        // returning T type objects only.

        // Note:- you can write any letter while creating generic types class means it is not necessary
        // to write T only, you can write P,Q,R anything but convention is to write T hence we also wrote
        // T only.

        /*
        public class Box<T> {
            private T box;

            public T getBox() {
                return box;
            }

            public void setBox(T box) {
                this.box = box;
            }
        }

         */

        // Now if I will again write above lines, it will give me error at compile time only. means now
        // my class is Type Safe. I can't add / retrieve anything from class Box. for example:-
//        Box<Integer> b1 = new Box<>();
//        b1.setBox(10);
////        b1.setBox("Hey"); // giving error
//        Integer x1 = (Integer) b1.getBox();



        // So what's the benefit? are actually there is so much benefit bec suppose as per the use case,
        // I want to have class of String, myType and Integer types. So after having generics, I don't
        // have to create separate 3 classes just due to datatypes. (And during actual application development
        // I can have much more datatypes).

        // Same you can mention any number of types while creating class.
        /*
        public class Pair<K,V> {
            private K key;
            private V value;

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }
        }
         */


    }
}