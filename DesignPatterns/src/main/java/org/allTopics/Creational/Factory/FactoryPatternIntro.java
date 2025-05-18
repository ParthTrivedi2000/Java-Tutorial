package org.allTopics.Creational.Factory;

public class FactoryPatternIntro {
    /*
    - Again it is one the creational design patterns.
    - There are mainly 3 design patterns for factory.
        - Simple Factory Design
        - Factory Design
        - Abstract Factory Design

    Generally in everywhere you will be seen Simple Factory Design only. But for high level codebase
    Factory Design Pattern and Abstract Factory Design Patterns are also very much useful.
     */



}

// So suppose we are having UserService
// class UserService{
// which has method of create user. And we have used dependency inversion principle by creating
// dependencies of required db and all those things externally and passing it into the method call.

// here just for now I hardcoded the db instance as MySql. else it will came from externally means via
// admin or via springboot DI, or anywhere. so jst mean to say that instance can be of any type of DB.

//    DataBase db = new MySql();
//    createUser(){
//        if(db is instance of MySql){
//            Query q = new SQLquery();
//        }
//        else if(db is instance of MongoDb){
//            Query q = new NoSQLquery();
//        }
//        else if{
//            ...
//        }
//        ...
//        q.execute("Insert User(id,name) values(1,'something')");
//    }

// Note:- consider here DataBase and Query as interfaces/abstract classes, since we already learnt ryt
// like in the cases where we can have multiple implementation at those places we should use interface
// instead of direct concrete implementation. Or you can understand like as per the
// Liskov's Sub. principle, we should not have direct/concrete implementation of classes since it will
// make code tightly coupled.


    /*
    Now if you see above code of createUser() method or we can say UserService, then it is violating the
    design principles. like SRP and OCP. since it is responsible for so many things like creating db connection
    query creation, query execution etc etc instead of only userCreation.
    And it is also not extensible, means if I want to make change in the code from MySQL to Postgres or like
    means other DB then also i have to perform so many code changes.

    - And if you see carefully, one more main problem is, to have a object of some class, it is dependent on
    some other class's object/instance. means above, query object is dependent on the db object provided.
    So is there any better way to handle it?

    Solution:- So yes. means think what actually is happening over here. like everytime query object is dependent
    on the db object ryt. hence we have to write multiple if else to check which db instance is there and
    correspondingly I am providing the query object. Now since query object is dependent on the db, why can't
    we give this query object returning responsibility to the db itself. means bhai tu hi decide kr rha h ki
    knse type ki query chahiye muje, then tu hi create krke de de n, why us to check the same and doing extra
    implementation everytime (generally in almost service we require db instance so) wherever we have to use
    any db instance.

    So since Database is an interface and Query is also an interface.
       <<DataBase>> (having createQuery()-> return instance of query)
       _____|_____________
       |      |          |
class:MySql  Postgres  MongoDB

        <<Query>>
       _____|______
       |          |
class:SQLQuery   NoSQLQuery


    - So we can have the DataBase interface having createQuery method declaration. And each db class has
    to provide the implementation of it. so for example

    class MySql implements DataBase{
        @Override
        public Query createQuery(){
            return new SQLQuery();
        }
    }

    And same for other concrete implementation classes.


    - Now in the UserService (or means any service which want db and want to query then) :-

    DataBase db = new MySql();
    Query q = db.createQuery();


    --> So here in above case createQuery() method is returning the object of Query object on basis of
    type of database.
    --> So this method createQuery() is called as Factory Method.
    --> So for Factory Design, from name itself, factory it means manufacturing unit which can generate
    different kind of objects/models. It means the thing (here method) which can generate different kind of
    objects is called as Factory Method.



    Conclusion :-
    - So whenever any object is dependent on any other object, then we have to write the if else in the code
    and handle based on the dependent object's value. So in this cases we can have this kind of Factory methods
    designing so that instead of us as users of that dependent Object, who needs to handle every where this
    if/else to have some another object, we have delegated this responsibility to that dependent object
    itself to provide it's corresponding dependent object.
    - So long story short, a factory method helps you to create object of another classes.

     */
// }
