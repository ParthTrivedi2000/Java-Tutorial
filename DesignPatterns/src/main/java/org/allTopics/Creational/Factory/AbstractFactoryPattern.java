package org.allTopics.Creational.Factory;

// Please visit the FactoryPatternIntro.java file before continuing for better understanding.

public class AbstractFactoryPattern {

    /*
    So let's increase complexity a bit.
    - What happens in the factory method is, Based on one class we are creating the object of another class so
    that we can give the responsibility of returning created object to that class itself using a factory method
    which needs to be overridden by each and every class.
    - DBType:- Query, Transaction, Updator

    - But now suppose on basis of DataBase type, you need Query object. similarly Transaction object also
    needs to be created on basis of what db instance is. And similarly suppose Updator object is also
    depends on the DataBase object.
    Now just think, for each of this 3 dependent objects you have to write 3 times if else for the same
    value of db bec since you can't have single if like db==MySQL and generate all the 3 instance, bec since
    other query can have other transaction/updator instance support as well so inshort you need to have
    if else for each of these 3 dependent objects.

    - So one solution is, we can have 3 different methods inside the DataBase classes. like createQueryFactory(),
    createTransactionFactory(), createUpdatorFactory().

    Note:- always all the method of interface is not called the Factory Method. But only those methods which
    generates the different types of objects is called the Factory Method.

    - But obviously DataBase having it's own other logical methods to deal/work with db like connect(), increasePool()
    etc etc. so my DataBase interface having factory methods + it's own logical methods
    interface DataBase{
        createQuery();
        createTransation();
        createUpdator();
        connect();
        increasePool();
        getUrl();
        getVersion();
    }

    - So if you see here, means basically DataBase abstract class is meant to deal with db not to control
    the objects of other classes' objects. means even you can consider here DB class is violating SRP since
    it is performing multiple responsibilities above.
    - Means previously in Simple Factory Design method there was only 1 dependent object that's why we can
    put it into the same db only. but here there are 3. that is also only for example, I mean there might be
    5/7/10 dependent objects, so for all those we are writing methods into this same db abstract class/interface.
    Don't you feel the DataBase class is bloated up. and hence also concrete class which needs to provide the
    implementation of all the methods.

    - So solution is, we can seperate out this responsibility. means we can have <<DataBaseFactory>> interface/
    abstract class which contains all the factory methods for db instance.

    DataBase{                                 DataBaseFactory{
        connect();                               createQuery();
        increasePool();         ==>              createTransation();
        getUrl();                                createUpdator();
        getVersion();
    }                                          }


    - Now if you think we can have those same concrete class which implements both DataBase and DataBaseFactory
    then, you should rethink. means 2 issues
        - you have assumed DataBase and DataBaseFactory is an interface. What if those are abstract classes.
        then in java we don't have concept of multiple inheritance.
        - Another thing is, those concrete classes will still be bloated ryt. means anyhow they have to
        unnecessarily override all the methods.
        - So as discussed we are having DataBaseFactory, and we can have it'e concrete implementation classes
        seperately, like mysqlfactory, postgresqlfactory and mongodbfactory.

        - Now if you think mySql class to inherits the mysqlFactory class, then here there is some missing concept.
        Means another very important point is, inheritance should always be logical. if you inherited something
        illogical just for sake for fulfilling any single requirement, then it will make trouble going forward.
        So just mean to say that here please think is there any Parent child relationship between mysql and
        mysqlFactory ? --> No ryt. means then ideally you should never apply inheritance over here (pls recall
        even in case of previous all the example like Animal <-- Dog, Bird <-- Pegion, Vehicle <-- Bus or
        anything, they are having logical relation of parent child hence we did that.

        - Now see requirement is mysql needs it's corresponding factory method, same postgres needs only
        it's corresponding factory and same for others if exists. but we have completely moved factory in
        some another place. then how to provide only mysql factory to mysql, postgresfactory to postgres?

        - So yes we can have createFactory() -> {returns Factory} in the DataBase Interface/Abstract class
        which concrete class needs to implement. So now inside mySql implementation class, it can provide
        implementation of createDBFactory() Method:-
        createDBFactory(){
            return new MySQLFactory();
        }

        - So simply here if you notice, DB interface/abstract class is just rerouting. Or you can consider
        this example to remember, means suppose there is one very rich person involved in so many multiple
        things like land ownership, lend money/ low/ businesses etc etc...now since he is your friend and
        you want to buy a land so you go to him and tell him that I want to buy land in some area. So that
        rich person has told you to that ok instead of having me to come with you, I can call one person
        who is handling my land related things, and he will help to get what you want.

        - Client file looks like:-
        DataBase db = new MySQL();
        DataBaseFactory dbFactory = db.createFactory();
        // now just get whatever instances you want from this factory which would be dependent on db instance.
        dbFactory.createTransaction()
        dbFactory.createUpdator()
        dbFactory.createQuery()


        - This above design is known as Abstract Factory Design Pattern. in which we are creating the seperate
        abstract class/interface and which has the concreate implementation of same classes which eventually
        provides the objects.

        - Real World Usecase:-
        for example Flutter/React Native. means you are working on flutter or react native library. Now since
        they are library, it is having different UI based on Platform. like Android, IOS. So now suppose if
        you are creating button like createButton() method, then it depends on what's the value of Platform
        object. And based on it you have to define. same for Menu component. same for dropdown. so all these
        objects are dependent on Platform's object. So here we can use the Factory design pattern in which we
        will be having Pattern abstract class which is implemented by Android and IOS. And platform class having
        abstract method of createUIFactory() method which needs to be implemented by concrete classes. And
        there will <<UIComponentFactory>> which was having createButton(), createMenu(), createDropdown() etc
        etc...which will be implemented by AndroidFactory and IOSFactory classes.

        Note:- in almost use case you will be using Simple Factory. Only 4-5 times in your coding journey, it
        might happen that you are using Abstract Factory Pattern.

        - And again here from the name itself you can understood like since factory method counts are increasing
        that's why you created separate Abstract Factory class like DataBaseFactory/ UIComponentFactory which
        contains all the factory methods hence the name is Abstract Factory Pattern.

        Reference :- Please read it in your free time
        - https://medium.com/@akshatsharma0610/abstract-factory-design-pattern-in-java-45a326c8fc9f
        - Refactorung Guru

     */

}
