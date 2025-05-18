package org.allTopics.Creational.Factory;

/*
Factory means what? means what comes to your mind when someone says factory.
- Factory means creation of some things ryt.

- Now in the world of Object Oriented Programming, everything is Object correct, so in case of Object Oriented Programing
Factory means some code unit which leads to creation of Objects ryt. we don't know which objects & how code unit
written to generate these objects, but only knows that,
Factory Pattern means Code Unit to create the Objects, very simple!!

Doubt:-
Builder is also used for object creation ryt?
--> yes, but actually builder is also providing other features while creating objects using Builder pattern for example
Chaining, immutability of objects etc etc... But factory method is not applying any logic to create object or on
object, it simply creates the object.

Let's see how Factory pattern create objects?

--> Suppose for example, you want to create the DataBase. But problem is you have to create the database object based
on som String provided by user.
means for example if user passes typeOfDb="MySQL", then you have to return mysqldb() instance, if user asks for
"postgres" then you have to return postgresdb(), if user passes "mongo", you have to return mongodb() instance.

- So for example there is string typeOfDb in the code.
String typeOfDb = "MySQL"

now suppose, you are already having classes MySQL(), PostgreSQL(), MongoDb().
But as we know in best coding practice, ideally we should never code to a class directly instead we should code to
an Interface ryt.
- So we will be having interface named "Database" which is implemented by all the above DB classes. And now inside
you client/service code, you need to have DB, so you can create instance of DataBase type and by checking the
input string you need to return the DB Instance.

- So what would be the simplest way to create this objects?

 private String typeOfDb = "MySql";
 private Database db;
 if(typeOfDb.equals("MySql")) return new MySql();
 else if(typeOfDb.equals("postrgres")) return new PostgreSql();
 else if(typeOfDb.equals("mongo")) return new MongoDb();

 So here simply we can think of to implement the Factory Design Pattern.
- So we need to create DatabaseFactory class (bec this class is creating different types of database objects based on the
input we provides)

class DatabaseFactory{
    createDatabase(String type){
        if(type.equals("Mysql") return new Mysql();
        else if(type.equals("postgres") return new postgreSQL();
        else if(type.equals("mongo") return new MondgoDB();
    }
}

- See now it remove code duplicacy, modifying/inserting DB won't change all the files of codebase, instead of
violating SRP by having this DB instance's if-else logic to identify type of db and creation of DB as one of the
responsibility in each class/ service, we have created separate class only which will take care as a primary responsibility
of this thing. etc etc..so many usecases.

Above is known as Simple Factory Method. And this simple factory method is the most practical use case
of Factory Pattern.

* When to use?(M. M. IMP for me)
- Whenever I have an Interface which is having multiple implementations. And then I might need to select one of the
implementations based on the value of some variable, at that time
rather than having a lot of if-else in each code file to create object of this Interface type (which is having multiple
implementations), just create separate Factory class. And the only purpose of that class is to identify what object
needs to be created.


Doubt:- Can we use Factory & Singleton together?
- No. generally/ideally not. means actually if you see carefully then,Factory always returns new Object each time but
singleton return same single object each time. So that is the main difference.

Q) But lets say in case of database, the implementation itself needs a singleton, then we have to go with
singleton + factory ryt?
- ok so what I mean to say is suppose in the code base, we my Mysql/postgres/mongo are singleton classes. And now
inside Factory class, in the if condition:- if(type=="mysql") return Mysql.getInstance();
if we do like this then?
- Yes, we can create in this way, but then it doesn't consider exactly as Factory. I mean this is not the usecase
of factory.

Q) maybe we can do something like --
"mysql"
return MYSQL.getinstance()
"postgres
return POSTGRES.getinstance()
where each of these have to be a singleton class which implement an interface
?
- yes, we can do like this.

But then a singleton class cannot implement an interface, ??
- yes, that will work, singleton can implement the interface.

Q) something like overloading can be done here?
yes factory class can have overloading methods. Means for example, DatabaseFactory class is there. Now you can have
any no. of methods which returns the Database type of object (note here database is an interface not concrete
class, instead it will be having multiple concrete implementation which needs to be returned based on some parameter
that is the main crucks for which we are going for factory pattern).


Q) MyDoubt :- what if we make above DatabaseFactory class itself as a singleton class? will that work?

Note:- Factory Pattern always returns the Interface kind of object, means not the child/or concrete implement type
of object, because by implementing factory we have also implemented Dependency Inversion which basically says that
don't code directly to concrete class, instead code to an interface.

** Benefits of Factory Design Pattern ** :-


 */

public class FactoryPatternIntroUpdated {
}


// Conclusion :- Important points
/*

### Practical Factory :-
- if name is XFactory, then return type of all the factory methods inside this class/interface will always be X only.
- Please see code sample of UIComponents example, & inside it check the ThemeFactory class present in the base package.

### Abstract Factory Method Design Pattern :-
- if name is XFactory, then return type of the factory methods will always be children/sub classes of X, but not X itself.
- Please see code sample of UIComponent example, & inside it check the ThemeComponentFactory interface present in the base package.
- All the methods inside the Abstract Factory/Simple Factory Design, will be called as Factory Methods since they
are returning the factories of object.

### Factory Method Design Pattern :-
- Single Factory is also possible which is returning factory objects, but class named as something else.
- Check the code of Theme class, inside it we are having createThemeComponentFactory() method.

Note:- So via Abstract Factory Pattern, we are returning Interfaces/abstract classes of different things
unlike returning concrete class objects from Simple Factory Pattern. This is the main/major difference between
Abstract Factory & Simple Factory.



Shortcut to remember :-

ShoeFactory :-
- All the methods returning Shoe.
==> Simple Factory

FootWear Factory:-
- All the methods returns either
Shoe((Sport:-Nike,Rebook,Adidas,speed),(Casual:-sketchers,adidas,speed))/Sandle(Speed, sketchers)/Slipper(Paragone)
==> Abstract Factory


HomeWork for me :-
- Design FootWear Shop (Just try to design, you will be having very good understanding of factory design pattern).
(And may be other different design pattern also might need to implement in this example, not sure).
 */