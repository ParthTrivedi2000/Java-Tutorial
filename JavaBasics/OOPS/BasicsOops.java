
// Video - 1 :-
// Concept :- Java Source File Structure

// In a single java program (it means single file) , we can have any number of multiple classes.
class A{

}
class B{
    
}
class C{
    
}
class D{
    
} 

// Then next question is, with which class name I should save the file bec we have been always told to save the file with the 
// class name ryt nd here in one file suppose I am having Class A, Class B, Class C, and Class D then what should be my file name? 
// - so answer is, we can give any name for this file like B.Java ya parth.Java or any name. 
// - But remember most important thing, my java file can contains atmost one public class only ok... It means either 0 or 1 public class. 
// - and if you are having only Class C as public, then it is must to save filename with C.Java else compiler will give error. 

// So conclusion is any java program can have multiple classes but only 1 public class maximum. Public means outside of this java file 
// someone can access it. And if there is any public class in the program then program name must be same as class name it means else 
// compliler will give error if you won't save program by that public class name. 

class A{
    public static void main(String[] args)
    (
        System.out.println ('A class main method');
    )
}
class B{
    public static void main(String[] args)
    (
        System.out.println ('B class main method');
    )
}
class C{
    public static void main(String[] args)
    (
        System.out.println ('C class main method');
    )
}
class D{
    
}

// - next thing is now suppose our program has 4 classes A, B, C and D. And consider A, B, and C classes contains main method and class D 
// doesn't have main method. And I have named this program file as Parth.Java. So whenever we complie or run 
// our program file it means java source file, it will always generate    .Class file for each class available inside it. 
// - now if we run A.Class file then, only A class ki main method execute hogi. Same B.Class file run krne pe B class ki Main method run hogi. 
// Same for class C as well. Now whenever we run D.Class file, java will give error saying something:- class doesn't have any Main method 
// to execute. Please define it. 
// - and if we run Parth.Class file then also java will give error saying something:- Parth name se koi class available hi nh h aesa ku6... 




// Video - 2:-
// Concept :- Import Statement

// - if we write, 
// Scanner scn = new Scanner();

// Then java will give error at compile time by saying :- Cannot find symbol Scanner. Bec java doesn't know what Scanner is. 

// now if we use fully qualified name here then java won't give any error and successfully compile the java source code. For exa:-
// Java.Util.Scanner scn = new java.Util.Scanner() 

// Above thing will run perfectly. But the problem is like evertime use of fully qualified name is not the best way ryt. It will increase 
// the length of code and decrease the readability. 

// - so now solution is to use import statement. If we write, 
// Import java.Util.Scanner; at the top of the program, then I can use short name (Scanner) anywhere in the file and java will 
// compiled it successfully as well. 


// - there are 2 types of import. 
// Explicit import :- import java. Util. Scanner;
// Implicit import :- import java. Util. *;

// - next question is, from above both the imports which import is recommend to be used? 
// - we should go for explicit import always bec it improves the readability and understandablity about the class we have 
// used is actually present in which module. 


// Video - 3 :- please rewatch it and make proper notes. 

// - below are the 2 interfaces available in java for which we don't need to import any classes from them if we want to use 
// any from them but by default all those classes are available for any of the java program. 
// - 1st interface is :- java.lang
// - suppose i am creating new object for string. ( JFYI This class is from java.lang interface) 
// String s = new String() 
// So i don't have to explicitly import it bt by default it is available to use as almost all the java program requires it so. 

// - 2nd is : default package:- it means from Cureent Working Directory. 
// it means if I am having another package or .java file placed inside the same folder then I can direclty 
// utilize it's class in my file. I don't need to explicitely import it.


// - whenever we are importing any java package, all the classes and interfaces available inside that package are availabel 
// but not the sub packages level classes. If you want to use sub package level classes and interfaces, we have to write import 
// statement till sub package level. (For example :- if I want to use pattern class from regex sub pacakge to create new pattern instance then, 
// import java.Util.Regex.*   :- correct
// Import java.Util.*                :- will give error of cannot find symbol Pattern. 
// Pattern p = new Pattern();



// Video - 4 :-
// Concept :- package statements

// - any java program file (it means java source file) can have at most 1 package statement only. 
// Package pack1; 

// - order of writing statements is also very important. It means if you have written like below:-

// Import java. Util. *;
// Package pack1;
// Public class myClass{}; 

// It will give error. Bec in any of the java source file if you want to include package statement then, package statement must 
// be 1st non comment statement in the file. 

// -------------------------------------------- Class Modifiers -----------------------------------------------
// Video - 5 Class Level Modifier Concept :-

// Whenever we are defining any class, we have to provide some information to the JVM like weather this class can be accessible from
// anywhere or not, weather child class can be created from this class or not, weather object creation is possible or not.
// So how you can provide these kind of information to JVM is by using modifiers while creating class.

// Modifiers describe the behaviour of the class.
// Suppose for exa. :-
// public class Test {} :- so modifier 'public' represents or tells JVM that this class can be accessible from anywhere in the same 
// package or from outside the package or anywhere. there is no restriction of using this class from anywhere.
// modifier 'default' provide info that this class can be accessible only within the package.
// so default access is also known as package level access.
// Pls note here that by default for any class if we won't specify any thing, it will be accessible in the same package only.


// Now Object creation is possible or not, how to provide this info?
// for exa :_
// abstract class Test{ }
// So modifier 'abstract' will provide info. like Object creation (or Instantiation) should not be possible for this 
// class if abstract is written. else 
// object creation is possible.

// now weather child class creation is possible or not?
// final class Test{}
// So modifier 'final' provide info that Child class is not possible for this class.

// So which are all different modifiers which can be applicable for Top Level Classes?
// Only applicable modifiers for Top Level Classes are :-
// public
// default
// abstract
// final
// strictfp


// So we are having inner classes as well right (which you can refere as nested classes as well). So for any inner classes,
// all the above modifiers are valid + few more we can use for any inner class.
// private
// protected
// static


// Abstract Modifier in detail :-
// 1) So where we can use 'abstract' ? :- it can be used for Methods, Classes. but not for Variables.
// Now Abstract from word itself we can undestand it like abstract means something not clear or not completed ryt. or we can say
// partially completed it means abstract ryt.

// So sometimes what happens is we are not sure about implementation. So in this case we can use abstract method'. means
// remember one thing that abstract method has only declaration is possible bt not implementation. So even remeber this 
// thing as well, abstract method ends with semicolumn (;) not curly braces({}).
// for exa:-
// public class Vehicles{
//     public abstract getNoOfWheels();
// }

// Note :- Child classes are responsible for the implementation.
// So Conclusion is :- the method which has only declaration but not the implementation is known as abstract method. And abstract
// method always ends with semicolumn. absrtact method doesn't have body (curly braces).

// Note :- If there is atleast 1 abstract method in my class then, compulsorily I have to declare that class as abstract.


// ----- Abstract Class :-
// Same as previous, abstract is something not completed or partially completed. So abstract classes are those which are
// partially implemented class.
// Few more points:-
// If class is declared as abstract then, no one is able to instantiate or create the object of that class.
// exa:- Test a = new Test(); is not possible. it will give error if class Test is defined abstract.

// If class is declared as abstract then, no one is able to call any of it's methods directly.
// exa:-a.getWheels(); won't possible if class 'a' is declared as abstract.

// Abstract Class vs Abstract Methods :-
// 1) if class contains atleast 1 abstract method then, class must have been declared as 'abstract'. reason is as it
// is partially implemented, not fully implemented. hence can't create object of it or can't call any method from that class.

// 2) if class doesn't have any abstract method, still can I declare it as abstract class? :- yes if class doesn't have 
// any abstract method, but you feel there is incorrect implementation or dummy implementation in this class, you
// can prevent for object creation or class instantiation by declaring that class as 'abstract'. So abstract class
// can have 0 abstract method.

// 3) any class is called adapter class if it fullfill above 2nd point.

// 4) very Imp Point :- child class is responsible for implementation of any abstract parent class's abstract methods. so for exa:-
// abstract class Test{
//     public abstract void m1();
//     public abstract void m2();
// }

// class subTest extends Test{
//     public void m1(){

//     }
// }

// So above code is valid or not? :- no, bec subTest is child class ryt...but it is providing implementation of only 1 abstract
// method m1() not for other abstract method m2() of parent class.

// So conclusion is :- if child class is extending any abstract class, then child class must provide implementation of each and
// every abstract method of parent abstract class.

// for above code, we will get compile time error. so now there are 2 solutions. 1st one is I should provide implementation
// of that m1 method. 2nd solution is, I don't know the implementation of 2nd method so in this case where I can't
// provide implementation of any abstract method of parent class in sub class, I should declare subclass also as abstract class.
// but then who is responsible for providing implementation of method m2()? so in this case next level child is responsible for 
// providing implementation of method m2.

// Meaningful Example for understanding :-
// abstract class Vehicle{
//     public abstract int getNoOfWheels();
// } 
// class Bus extends Vehicle{
//     public int getNoOfWheels(){
//         return 6;
//     }
// }
// class Auto extends Vehicle{
//     public int getNoOfWheels(){
//         return 3;
//     }
// }

// class Test{
//     public static void main(String[] args){
//         Bus a = new Bus();
//         System.out.println(a.getNoOfWheels());

//         Auto b = new Auto();
//         System.out.println(b.getNoOfWheels());
//     }
// }

// Now suppose if you remove getNoOfWheels() method from that abstract class then also code is going to run bec parent is
// abstract class nd it is not required that it have to have any method ryt. So what is the advantage of declaring that
// abstract method in that class? so answer is:- main advantage is like if we won't define this method in class Vehicle, then
// any of it's child class may or may not provide the implementation of the getNoOfVehicle() method. but if we define it 
// in Vehicle as abstract method, then any of the child classes must have to provide implementation of that abstract method.



// ----------------------- Member Modifiers -------------------------------------------------
// So we have seen class level modifiers. but now let's check member modifiers. member modifiers means those modifiers
// which are applicable to members of class such as on methods and variables.
// There are total 12 memeber modifiers. but we will check only few of them. public, private, protected, default, abstract, final etc

// Public :-
// if member is declared with 'public' modifier then, we can access it anywhere it means within the class, outside the class
// withing the package or outside the package as well. but one thing we need to take care is, if class is not accessible then
// my any of the member is also not accessible even though I have declared it with 'public'. 
// So imp conclusion is, always 1st check class visibility, then only check member visibility.

// Default :- 
// if we haven't specify anything as modifier for any member then, by defualt it will be 'default' modifier. else you can 
// specify 'default' keyword as well. so those members are accessible within the same package only. even default access is 
// also called as package level access.

// Private :-
// 'private' from name itself we can understand it is private to something ryt. So 'private' members are only accessible
// within the same class only. So private will provide the class level accessibility.

// Note :- 
// public :- Global Level
// default :- Package level
// private :- Class level

// For any Data Members (i.e. Variables of the class): it is recommanded to use 'private' modifier as we can not expose data
// to outside anywhere not out of the class as well. this concept is known as "Data Hiding" which we will see in detail.
// For any Services (i.e. Methods of the class): it is recommanded to use 'public' modifier as everyone should be use methods
// of the class.


// Protected :-
// if members of class has 'protected' modifiers it means those are accessible anywhere within the same package and outside
// of the package it can be accessible to child classes only.
// protected = <default> + kids (i.e. child or childern) // this is how you can remember.

// remember for child class, they can access everything of their parent class means all the methods of their parent.
// and also can reference the parent class's methods as well.

// Note:- Always remember one thing that, even child class can inherit all from parent class, but child class won't be
// able to access private members of parent class since private member meant to be accessible withing the current same
// class only. Not for any other class. If you want that member to be accessible by child class as well, then you need
// to change modifiers from private to protected for those members.

// class A {
//     public void m1(){

//     }
// }
// class B extends A{

// }
// A a = new A();  // parent reference = parent object
// a.m1(); // Valid
// B b = new B(); // child reference = child object
// b.m1(); // Valid

// parent reference can be used to hold the child class object. see below line is valid.
// A a1 = new B(); // Valid // parent reference = child object
// a1.m1(); // Valid

// M M Imp point :- for the protected members, from outside package you can access within the child class only (within
// the package you can access anywhere) bt outside package only in child class and twist is compulsorily we
// should use child class reference only. from outside of the package, we can't use parent reference to access protected
// members.

// Most accessible modifier is 'public' and Least accessible or most restricted modifier is 'private'. 
// comparison of Most restricted scope for modifiers :- private < default < protected < public
// above line is used further in Overriding concept in OOPS. so pls understand above all things very clearly.



// Interface :- Interface is nothing but just requirements Specifications. it won't provide the implementation. But class provide
// implementation for the interfaces. It just provides the requirements Specifications only.

// interface Interf{
//     public void m1();
//     public void m2();
// }

// class ServiceProvider implements Interf{
//     void m1(){

//     }
// }

// Above is the valid implementation of interface or not?
// So we made 2 mistakes. each mistake is very important conclusion.
// Each method inside interface is public and abstract weather we are declaring or not or pls remember this. 
// So we have to endwith ; in interface which is correct. but while implementing interface method,
// compulsorily we have to implement method as 'public' during implementation. which we haven't done above you can see.
// So it is like parent class method we are implementing in child class ryt. so always remember like
// while overriding, we can't reduce the scope of the modifiers. in above case, we are overriding (it means
// using same method of another class and make changes in them ) ryt. so during overriding we can't reduce the scope
// in OOPS java. above we are reducing scope from 'public' to 'default'. so it will give error. so solution
// is to declare m1 method inside child class serviceprovider as 'public'. 
// interface Interf{
//     public void m1();
//     public void m2();
// }

// class ServiceProvider implements Interf{
//     public void m1(){

//     }
// }

// 2nd mmistake we did is, like whenever we are providing implementation to an interface, a Class must provide
// implementation of each and every abstract method of an interface. but here we haven't provide for all the 
// abstract methods of interface Interf. m2() method is remaining. so solution is we have to provide
// implementation of method m2() as well in the class ServiceProvider. then it will going to work fine.
// Another solution for this 2nd problem is, we won't provide implementation of 1 or more methods of an
// interface and declare this class as 'Abstract'. So abstract means partially implemented class. and it means
// it can contains atleast 1 or more abstract methods. But remember in this case child class is responsible
// to provide the implementation of abstract methods of parent class.
// interface Interf{
//     public void m1();
//     public void m2();
// }
// class ServiceProvider implements Interf{
//     public void m1(){};
//     public void m2(){};
// }

// or
// interface Interf{
//     public void m1();
//     public void m2();
// }

// abstract class ServiceProvider implements Interf{
//     public void m1(){};
// }

// or
// interface Interf{
//     public void m1();
//     public void m2();
// }

// abstract class ServiceProvider implements Interf{
//     public void m1(){};
// }

// or

// interface Interf{
//     public void m1();
//     public void m2();
// }
// abstract class ServiceProvider implements Interf{
//     public void m1(){};
// }
// class SubServiceProvider extends ServiceProvider{
//     public void m2(){};
// }
// So Conclusion :- whenever we are implementing any interface method, compulsorily that method should be declared as 'public'
// 2nd point is whenever we are implementing an interface, for each nd every method of an interface we should provide the
// implementation. if you are unable to provide the implementation for atleast one abstract method, declare the class as 
// 'Abstract'.


// -------------------------------- OOPS -------------------------------------------

// 1st OOPS feature we are going to discuss is
// 1) Data Hiding :- So data hiding menas hiding of data. so our internal data should not go out directly. it means
// outside person should not access the our internal data directly. We have to hide our data. for exam:- mailbox. if
// we write www.gmail.com we won't get data directly ryt. 1st we have to provide our mail nd pwd nd if it is correct then 
// only it will give data. so meaning is some sort of validation is required before giving data to anyone. so this type
// of validation or authentication we can apply through this beautiful concept of 'Data Hiding' in java. So how to do 
// it programatically?
// for exa:-
class Account{
    // every account must have balance ryt.
    private double balance;
    // So above you have hide the balance data from everyone. private declared means only accessible for internal use.
    // now suppose person wants to know balance of his account how he came to know? he must have call the method which
    // is available as 'public'. and we have to provide the valiadtion or authentication in that method, then if it's
    // valid then only we have to return the balance.
    public double getBalance(){
        // Validation or Authentication code
        if valid 
            return balance;
    }
}

// So how to implement Data Hiding ? :-  By declareing data member as 'private'. 
// So biggest advanatage of data hiding is security. 

// Note :- highly recommanded modifier for any variable is 'private' in java.

// 2nd feature is 
// 2) Abstraction :- here abstraction means hiding internal implementation. it means it will surely tell like this
// services I am offering. but if you ask how you have implemented? it will say sorry for security reason I can't
// share the implementation with you. So hiding the internal implementation of services and just highlight the set of
// services which are going to offer is the concept of abstraction. 
// By using interface concept we can implement the abstraction.
// Advantage of abstraction :- 
// - Security
// - Enhancement is become very easy
// - Maintainability is improved.
// - Modularity is improvised.

// 3) Encapsulation :-
// The process of grouping combining the data members and corresponding methods or behaviour into a single unit is called
// 'Encapsulation'. Every java class is an example of encapsulation. for examp class Student. it will contain the student
// related infor in terms of data members and corresponding methods as well nd whole things are grouped into one class.
// So class is good example of encapsulation.
// If any component which follows data hiding and encapsulation then that component is said to be encapsulated comp.
// Data Hiding + Abstraction = Encapsulation
// it means if there is hiding and abstraction then we can say that component as encapsulated.
// if any of the above 2 defination is there (1 is grouping or another is hiding,abstraction), 
// then we can say component is encapsulated.
class Account{
    private double balance;

    public double getBalance(){
        // Validation
        return balance;
    }
    public void setBalance(double amount){
        // validation
        this.balance = this.balance + amount;
    }
}
// data is hiding behind the methods is the concept of encapsulation.

// Advantages :-
// - Security
// - Enhancement is very easy without effecting outside person or client side appliaction or GUI.
// - Manintanability
// - Modularity

// Drawbacks :-
// - for every data member, we will be having getters and setter methods to call from client side. and also we have to 
// perform validation in all those methods. it measn code becomes very lengthy as we have to do it for each nd every data member.
// so it increases length of the code and slows down the execution. so performance is down.

// Tightly Encapsulated Class :- 
// Every class in Java can be considered as encapsulated class. but tightly encapsulated class means what?
// The class is said to be tightly encapsulated class if and only if each and every variable present inside it is 'private'.
// IMP Conclusion :- if parent class is not tightly encapsulated, then no child class is tightly encapsulated.

public class BasicsOops {

}
