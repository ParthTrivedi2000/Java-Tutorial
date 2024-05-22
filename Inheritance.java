public class Inheritance {
    // - Inheritance is also known as 'IS-A relationship'.
    // - main advantage of inheritance is code reusability.
    // - by using 'extends' keyword, we can implements the inheritance concept.


}

class P{
    public void p1(){
        System.out.println("Parent");
    }
}
// When we use extends keyword, all the methods and variables of parent class are available to the child class as well.
// this concept is known as Inheritance.
class C extends P{
    public void p2(){
        System.out.println("Child");
    }
}
Class Test{
    public static void main(String args[]){
        P p = new P();
        p.m1(); // Will work
        p.m2(); // Compilation Error

        C c = new C();
        c.m1(); //will work
        c.m2(); //will work

        // So 1st imp conclusion :- on the parent reference, child specific methods or child specific variables we can not call.
        // On child class reference, parent and child both the class's method and variables can be called.

        // 2nd imp conclusion :-  Parent reference can be used to hold the child object. but remember we can't call the child
        // specific methods and variables on parent referenced object.
        P p = new C();
        p.m1(); // Will work
        p.m2(); // Compilation Error

        // 3rd Conclusion :- Child reference can not be used to hold the parent object.
        C c = new P(); // Compilation Error
    }
}


// Types of Inheritances :-

// 1) Single Inheritance :-
// If only one child class extends only one parent class then, this is known as Single Inheritance.
// All the languages are providing support for this type of inheritance.
class B extends class A {}

// 2) Multiple Inheritances :-
// The process of extending more than 1 parent class at a time such type of inheritance is known as Multiple Inheritance.
// Java won't provide support for multiple inheritances for classes. why that we will discuss later. but yes interfaces in java is
// is providing support for multiple inheritances. 
class C extends A,B {} // Compilation error.

// 3) Multi Level Inheritance :- 
class B extends A {}
class C extends B {}

// 4) Hierarchical Inheritance :-
// It is counter part of Multiple Inheritance.
// In multiple Inheritance we can have multiple parent classes extended by 1 child class ryt. but in Hierarchical Inheritance
// 1 parent class is extended by more than 1 child classes.
// Java is supporting this type of inhritance.
class A{}
class B extends A{}
class C extends A{}
class D extends A{}
// Or we can say group of Single Inheritance type is called as Hierarchical Inheritance type.

// 5) Hybrid Inheritance :-
// can have different types of inheritances.
// Java is not supporting hybrid Inheritance for class as it is not supporting multiple Inheritance so. but for interfaces
// it is supporting.

// Why Java is not supporting of Multiple Inheritances for classes?
// So for examp.:- there are 3 classes. P1, P2 and C. suppose C is extending from p1 as well and from p2 as well. now suppose
// there is 1 method named m1() present in both the class P1 and P2. Now as Class C is the child class of P1 and P2 hence
// it can have access for m1 method from both the classes. now if we write c.m1() then, which method should be called or
// executed? class P1 or class P2's m1() method? So there is ambiguty to identify which method child class C is calling.
// Hence Java is not supporting multiple inheritance. This problem is also known as 'Dimond Access Issue' or 'Ambiguity
// Issue' as well.

// But Java is providing support of multiple inheritance for Interfaces how?
// Listen very carefully. As we know in Interfaces methods are public and abstract weather we are declaring or not ryt. Now
// those methods are abstract it means there is only declaration of methods not implementation. implementation is given
// by child interface or child class which will be called as implementation class. 
// So for examp.:- we are having 2 interfaces PI1 and PI2 and suppose both the interfaces having method m1(). now there
// is 1 implementaion class Test which is implementing method m1. so here now child class has only 1 m1 method right which 
// will be called on child class object. in case of interface suppose reference is given by any interface bt object
// creation is with child class only hence whenever we are calling any methods those will be on child class only.
// So now there is no ambiguity to identify from multiple methods as there is only 1 method implementation written so.
// PI1 p1 = new Test()
// p1.m1();
interface P1{}
interface P2{}
interface C extends P1,P2{} // No C.E. program will run successfully.

// So conclusion :- Java is providing Multiple Inheritance for Interfaces not for Classes. reason is already discussed above
// like in classes we will be having ambiguity problem but in Interfaces we don't have that problem.

// VVIMP Interview Question :-
// So after asking above question like weather by default java support multiple inheritance or not ?:- you will give
// answer like not for classes but yes for interfaces concept with reason in detail. then interviewer might ask this
// question like, as we know whole Java API is child class of root 'Object' class ryt? so if you write like,
// class B extends A{};
// then here Class B is child class of parent 'Object' class and of parent 'A' class as well. So java is providing
// multiple inheritance. Can you please justify it? or what is your thought on this? this is the next question
// from interviewer.

// Solution :- So solution is whenever any class in not extending any other class then only it is directly child class of
// 'Object' class. for examp :- class B{}. In this case class B is directly child class of root 'Object' class. 
// But if class is extending any other class then it is indirect child of 'Object' class. and direct child of it's extended
// or parent class. for examp:-
// class A{}
// class B extends A{}
// in this case Class A is direct child of Object. and the class B is direct child of A. hence indirect child of 'Object' class.
// class Object
//      |
//      |
// Class A
//      |
//      |
// Class B

// Hierarchy is not like below. Hierarchy is like above.

// Class Object     Class A
//      \           /
//       \         /
//          Class B
// Hence this is the type of multilevel inheritance not multiple inheritance.  this should be your answer to interviewer.


// Note :- JFYI, python language support multiple inheritance concept in very beautiful way. by using sequence in which
// we are extending class. in python for extending class we have to pass it in braces as an argument to the class.

// Class P1:
//      def m1():
//          print('P1 method')
// Class P2:
//      def m1():
//          print('P2 method')
// Class C(P1,P2):
//      pass

// c = C()  // Object creation in python (which we can see is very simpler in comparison to java)
// c.m1()  // m1 method of P1 will be executed as class C is extending P1 first and then P2 so.

// if I will write:- class C(P2, P1): nd then create object of this class and call m1() method then, m1 method of
// class P2 will be executed.



// --------------------- Cyclic Inheritance ------------------------------------------------
// 1st thing I want to clear is this type of Inheritance is not supported in Java. but we must know or aware about which types
// of concepts exists as we are covering topic Inheritance so.
class A extends A{};  // Compilation Error
// bec what does it mean is child Class A requires all the variables and methods of parent class A. So class A's all the
// members are already available to class A. then what does it means of extending ryt. 

// or 

class A extends B{};
class B extends A{};  // Compilation Error
// Bec what does it means is child class A requires all data members and methods of parent class B. and below line's
// meaning is class B requires all the data members and methods of parent class A. Now if all the data members and 
// methods are commonly requried then create once class only n why to create 2 classes.
// So java doesn't support cyclic Inheritance. even almost none of the languages support this type of cyclic inheritance. Not
// Python as well.



// So we have covered Abstraction then Encapsulation then Inheritance in very detailed. Now it's time for 
// Polymorphysom. but in it we will be covering Method Overloading and Method Overriding. so before Jumping 
// into it we must understand about Method Signature.

// ------------------------------- Method Signature -----------------------------------------------------
// public int m1(int a, float b);
// So what is 'Method Signature' in above case?
// So pls remember Method Signature contains method name followed by argument's data types (remeber sequence also should be same)
// passed to it. it means for above case
// Method Signature is m1(int,float).
// JFYI, in C++ return type is also additionaly part of Method Signature. but in Java, only method name and argument types
// is part of method signature not return type of method.

// Next who is going to use Method Signature? I mean why we are focusing on it?
// So Compiler uses the Method Signature while resolving method execution calls.
// for exa:-
class Test{
    public void m1(int i){};
    public void m2(String s){};
}
Test t = new Test();
t.m1(10);
t.m2('Parth');

// So above we have 2 method calls. so how compiler will compile it?
// Pls understand very carefully. So for every Class compiler will maintain the Method table. and in Method table it stores
// the Method Signature. so in above case Compiler is having one Method Table:-
// which contains 2 rows. in 1st row, m1(int) was written and in 2nd raw m2(String) was written. Now whenever compiler will
// be having object creation nd then after object creation whenver it will be having any method call then how it will be resolving.
// so it will be check like this. here m1 is called by object t ryt? so which type of object t is? it is of type T ryt.
// so it will go to class T's Method Table. so it will check like is there any method m1 available in Method Table of class T
// which can take argument of int type. So if m1 will present and it's argument type matches with the called method then it will
// not give any error and move ahead and compiled successfully. else it will give appropriate error.

// Next MMIMP point about Method Signature :-
class Test{
    public void m1(int i){};    // Method Signature would be :- m1(int)
    public int m1(int j){      // Method Signature would be m1(int)
        return 10;
    }
}

// So what about above case?
// So for above case we are getting Compilation Error. why ? bec compiler is confused like which method to call ryt? bec
// one method with return type void and another method with return type int is available in class.
// So pls pls remember, very important conclusion is:-
// Within the same class, 2 method of same signature is not allowed. fir bhale hi with different return type ho. but if by
// mistake you will do, then you will get compilation error.


// -------------------------- Overloading Concept ------------------------------------------------------------
// Very imp concept wrt to interview and OOPS.
// What is Overloading?
// m1(int);
// m1(long); 
// 2 methods are said to be overloaded if nd only if both the methods are having same name but argument types are different.
// So in C lang, we don't have this concept as C is not Object Oriented Programming language. So in C if you want to apply
// abs method to int and to apply abs to float we must have different method name. means with the same method name and 
// different data type is not possible in C.
// abs(int)
// fabs(float)
// labs(long)

// So programming complexity increases as developer should remember 3 method names for 3 different data types or differnt
// method names for different data types.
// But same is not the case with Java. in java we can have same method name with different data types as an argument.
// abs(int)
// abs(long)
// abs(float)
// this concept is known as 'Method Overloading'. Biggest advantage of Overloding is programming complexity reduced for
// developer.
class Test{
    public void m1(){
        System.out.println('void type arg')
    }
    public void m1(int){
        System.out.println('int type arg')
    }
    public void m1(long){
        System.out.println('long type arg')
    }
    public void m1(double){
        System.out.println('double type arg')
    }
    // So from defination discussed above, we can say that above methods are said to be 'Overloaded Methods' as 
    // all of them are having same method name and different argument data type.

    public static void main(String args[]){
        Test t = new Test();
        // So now pls try to change the nerrative of seeing all the lines present inside the class or method.
        // in above line we are having reference type as 'Test' and Run time Object type also 'Test' (but as we know
        // both can be different ryt. like P p = new Test(). so here reference type of object p is 'P' but runtime
        // object type is 'Test' ok.)
        t.m1(); // void type arg
        t.m1(10); //int type method will be called hence o/p wolud be int type arg.
        t.m1(10.5); // double type method will be called. hence i/p would be double type arg.

        // So how resolution of method calls will be done in these cases are based on the object's reference type(here
        // it it type 'Test' and the Method Signature it means method name and data type of passed arguments.) and
        // the method with the arguments' data type.

        // MMIMP Conclusion :- In 'Overloading', Method Resolution always takes care by compiler based on the 
        // 'Reference Type' of Object (not the Run time type of object). 
        // So overloading is also known as 'Compile Time Polymorphysome' or 'Static Polymorphysom' or 'Early Binding
        // Polymorphysom'.

        // So here Run time object type is dummy and JVM is not responsible for Method Resolution. but Reference type is
        // considered and Compiler is responsible for Method Resolution.
    } 
}

// There are multiple cases for Overloading. Let's discuss those one by one.
    
// Case - 1 :- 
class Test{
    public void m1(int){
        System.out.println('int type arg')
    }
    public void m1(float){
        System.out.println('float type arg')
    }
    public static void main(String[] args){
        Test t = new Test();
        t.m1(10); // int type arg
        t.m1(10.5f); // float type arg
        t.m1('a');
    }
// Now what compiler will do in the above case?
// So compiler won't give directly Compilation Error. 
// So in 'Overloading', if exact match method is not available then compiler won't raise Compilation Error immediately, 1st
// compiler promote this argument to next level type of argument.
// byte --> short byte 
//                    \
//                     int --> long --> float --> double
//          char _____/

// So in above case for char, as we know char is promoted to int. then compiler will check, is there any method present with same
// name and which take int type as argument, if yes then compiler will execute it. So this thing is known as 
// 'Automatic Promotion concept' in Overloading. if int type method won't present then it promotes to next data type automatically
// nd check. After checking all levels if nothing is present then only it will raise an C.E.
t.m1('a'); // o/p:- int type arg
t.m1(7L); // o/p:- float type arg (as long type method is not available hence promoted to float type and it exists so it will be executed)
t.m1(10.5) // Compilation Error. 
// bec 10.5 is by default double type in java ryt. now double type method is not available, so compiler
// tried to promote it's data type bt next promotion data type is also not avialble so now compiler will raise C.E.
}


// Case - 2 :-
Class Test{
    public void m1(Object o){
        System.out.println('Object Version');
    }
    public void m1(String s){
        System.out.println('String Version');
    }
    public static void main(String[] args){
        Test t = new Test();

        t.m1(new Object()); // Object Version
        t.m1('Parth');  // String Version
        // Bec we know in Overloading exact match will be having highest priority ryt. So above will be my o/p.
        t.m1(null);
    }
// What should be the output in the above case?
// Null is a valid value for any type of Object Reference. So it is valid for Object Reference and also for String Reference as well.

// So as we know Object is parent class for String ryt. so here it is like
// Object
//   |
//   |
// String

// So in Overloading, Parent as argument and Child as argument both are there, then which argument gets the highest priority?
// Child Argument gets the highest priority when compared with parent argument. So in this case t.m1(null). so argument null
// is matched with both the method's argument Object and String. So priority will be given to String as it is the child of
// Object. hence o/p will be :- String Version
// This case you can think of collector and peun. for any small work which can be done by both collector and peun, we won't 
// go to directly collector ryt as work is small nd can be done by peun then no need to go with collector directly ryt.

// Conclusion :- in oveloading, exact match of type will be always given highest priority. next if parent nd child both methods get 
// matched, both argument methods matched, priority given to Child argument method. if child class argument method is not matched then 
// parent class argument matched method will be given priority.

}


// Case - 3 :-
class Test{
    public void m1(String s){
        System.out.println('String Version');
    }
    public void m1(StringBuffer sb){
        System.out.println('StringBuffer Version');
    }
    public static void main(String[] args){
        Test t = new Test();
        t.m1('Parth'); // String Version
        t.m1(new StringBuffer('Parth')); // StringBuffer Version
        t.m1(null);
    }
// What would be the output for above case?
// So previously what happens is we will be having Parent class and Child class relationship between arguments' typed classes.
// but here below is the case. both are the eqaual child classes of object.
//      Object
//      /   \
// String  StringBuffer

// So in this case compiler can't choose the method and it will give C.E. 
// nd got error msg like :- method m1 is ambiguous to identify. Both the m1 methods are matched.

// Concluion :- So pls remember, exact argument match will be given highest priority, parent and child case will be there then
// child will be given priority. But multiple methods matched and there is no relation between argument then we will get C.E.

}


// Case - 4 :-
class Test{
    public void m1(int i){
        System.out.println('General Version');
    }
    public void m1(int... i){
        System.out.println('Variable arg Version');
        // in case of variable argument you can pass any number of arg. 0,1,2,3...etc any. So m1(), m1(5), m1(6,4)... all are valid
    }
    public static void main(String[] args){
        Test t = new Test();
        t.m1(); // Variable arg Version
        t.m1(10,20); // Variable arg Version
        t.m1(10);
    }
// What would be output for above case?
// So last method call, matches for both General method and Variable arg method. but variable argument concept comes in
// Java version 1.5 while general argument concept was there from Java version 1.0 
// So in this case Old version concept will be given priority. In java remember Old is gold.
// So o/p will be :- General Method.

// Apart from this, in general saying 
// please remember this point:- variable argument method is generally given least priority. if no other method matched then only
// variable argument method will be given priority. it can be remembered as switch statement. as in switch clause, we will be having 
// different case values ryt. but at last we will be having default. so if switch(x), value x is not matching with any of the case
// then default will be executed. same here as well if no any other matched method found, then only variable argument method
// will be given priority. 
// Even compiler has already set the variable argument method as least priority methods.
}


// Case - 5 :-
Class Test{
    public void m1(int i, float f){
        System.out.println('int-float Version');
    }
    public void m1(float f, int i){
        System.out.println('float-int Version');
    }
    // 1st of all can we say above 2 methods as overloaded? so from the defination of overloading if method is having same
    // name but with different argument types. so here name is same and arguments types are not exact same. means sequence
    // is different ryt. So yes these methods can be considered as Overloaded methods.
    public static void main(String[] args){
        Test t = new Test();
        t.m1(10,10.5F); // int-float version
        t.m1(10.5F,10); // float-int version
        t.m1(10,10);
    }
// What would be output in above case?
// So 1st thing is we haven't eaxct match m1(int,int) ryt. so now we can think of compiler is promoted to 2nd int to float and 
// int float version will be printed. or compiler can promote 1st int to float and float-int version will be printed. So
// again in this case compiler is confused as it is not able to found the matched method hence it will give C.E. with
// this err msg: reference to m1 is ambiguous to identify.
// So remember we don't have any precedence of Left to Right or Right to Left here in this case.

t.m1(10.5F,10.5F); // C.E. with msg: cannot find Symbol like m1(float, float)
// so pls understand the reason of error. in above 1st case, both the methods are matches hence giving C.E. bt in 2nd case
// this type of method is not found as float can not be promoted to int so it will be check as it is m1(float,float) which
// is not present so give C.E.
}


// Case - 6:-
class Animal{}
class Monkey extends Animal{}
class Test{
    public void m1(Animal a){
        System.out.println('Animal Version');
    }
    public void m1(Monkey m){
        System.out.println('Monkey Version');
    }
    public static void main(String[] args){
        Test t = new Test();

        // case - 1]
        Animal a = new Animal();
        t.m1(a); // Animal version

        // case - 2]
        Monkey m = new Monkey();
        t.m1(m); // Monkey Version

        // case - 3]
        Animal a1 = new Monkey();
        t.m1(a1);
// What would be the output in above case?
// so here pls pls pls don't think anything, this is the very base concept of 'Oveloading' ryt. pls recall for overloading we have
// started from here only like:- in 'Overloading', Compiler is responsible for method resolution based on 'Reference Type'. no use
// of Run time object type as those can be considered as dummy in case of 'overloading concept'.
// So here o/p will be:- Animal Version
    }
}



// ---------------------- Overriding Concept -----------------------------------------------------------
// So as we know parent class methods are by default available to child class by using concept of inheritance. So methods
// are available to child without re writing. But sometimes what happens is child is not satisfied with the implementation
// of method of parent class. so child class is allowed to redefine the implementation of methods as per it's requirement. This concept
// is known as 'Oveririding'. The method of parent which is overridden is known as 'Overridden Method'. And the method in child
// which is overriding the parent's method is known as 'Overriding Method'.

// Now how Method Resolution will work in Overriding?
class Parent{
    public void property(){
        System.out.println('Cash + Gold + Land');
    }
    public void marry(){
        System.out.println('Subblaxmi');
    }
}

class C extends Parent{
    public void marry(){
        System.out.println('Kiara');
    }
}

Class Test{
    public static void main(String[] args){
        Parent p = new Parent();
        p.marry();  // Parent class's method will be priority and executed.

        C c = new C();
        c.marry(); // Child class's method will be given priority and executed.

        Parent p1 = new C();
        p1.marry();
    }
// Now what will be output of above program?
// here we are using 'Overriding' concept. which method will get chance to execute? what is the role of compiler and what
// is the role of JVM here?

// Now let's go step by step. So here marry method is called on which object? on p1 ryt. p1 is of what type? p1 is of type
// Parent ryt. so compiler will check weather marry method is available in the Parent class or not. till here it's compiler's
// task to check nd gives green signal. if marry method is not present then we got CE. if it's present we got green signal
// from Compiler.
// So after compilation, now JVM will check what is the run time object here. so run type object is type 'C' ryt or we can 
// say it is child class object. so now JVM will check in the child class C weather any overriding method is availabel in the
// Child class 'C' or not. so if overriding (here marry()) method is present, then JVM give priority to that 'Overriding Method'
// of child class to execute.

// So Conclusion :- in concept of 'Overriding', Method Resolution always takes care by 'JVM' and that is based on 'Run Time Object'.
// Hence 'Overriding' is also known as 'Run Time Polymorphysom' or 'Dynamic Polymorphysom' or 'Late Binding Polymorphysom'.
}


// -------------------- Rules of Method Overriding :- ------------------------------------------
// So actually in 'Overloading', rule is we just need to check method name and argument's types. so it is simple. but in
// 'Overriding' so many things to check like modifier, return type etc etc... So let's see the rules of method Overriding.

// Rule - 1:-
// So method name should be same. it's argument's types also should be the same including order or sequence. So this is
// nothing but called 'Method Signature' ryt. so for 'Overriding', 'Method Signature' should be the same. what about return
// type of the methods? So till version 1.4 it is required to have the same return type in Parent and Child classes' to
// be called as 'Overriding Methods'. but from version 1.5 onwards return type could be 'Co-Varient'. What 'Co-Varient'
// means is, Child class's method's return type need not to be same as Parent class's method's return type. but it could
// be same or parent return type's child types. let's understand through example.
class P{
    public Object m1(){
        return null;
    }
}
class C extends P{
    public String m1(){
        return null;
    }
}
// Above is valid. but if it's reverse, it means P has return type String and C has return type Object, then compiler 
// will raise C.E.. as Parent has return type String, then my child class methods return type can be any of the Child datatypes
// of String. but here Object was return which is actually not child bt parent of String type. This is called the
// 'Co-Varient Type Concept'.

// 2nd thing is 'Co-Varient Concept' is applicable to Object types only not primitive types. it means suppose in above case
// P is having return type double, and C is having return type int, then compiler will raise CE. as those are we are trying to
// map relationship between 2 primitive types. So in case of primitive return type of parent, child method's return type
// also must be the same primitive type. But in case of Object type, 'Co-Varient Concept' is allowed.

// if Parent return type :- Object 
// Then Child can have :- Object, String, StringBuffer

// if Parent Return Type :- Number
// Then Child can have :- Number, shortbyte, int, long, float, double



// Rule - 2 :-
// Now we understand 3 things for overriding. method name, arguments and return type. now let's move ahead.
class P{
    private void m1(){}
}
class C extends P{}

// In above scenario forget about the 'Overriding concept'. but think if child class is able to access the parent class methods
// and then if child is not satisfied then it can redefine ryt. but in above case, method m1 is not even accessible to child.

// So IMP Conclusion :- 'Overriding Concept' is not applicable for 'private' methods.

class P{
    private void m1(){}
}
class C extends P{
    private void m1(){}
}
// So what about above scenario?
// nothing. we can create the same method with the same name, arg nd return type in child class. as that are private method so both
// the methods are independent from each other. 
// So next Question is what if I will write in class Test like
// P p = new C();
// p.m1();

// what would be the output for above lines?
// So compiler give CE. as m1 method is private so it can't accessible outside that class itself. so it will give CE.

// Conclusion :- Private methods are not visible to child classes. hence 'Overriding concept' is not applicatble for
// 'private methods'. but yes certainely we can create the same private method in the child class as well.

// So above analysis is for 'private modifier'. Now let's check for 'final modifier'.
class P{
    public final void m1(){}
}
class C extends P{
    public void m1(){}
}
// So for above code, compiler will raise the CE.
// bec final means it can not be changed further anymore. Now if Parent has defined it as final then it means it can not be
// modifiable. So child can't redefine it. Hence 'Overriding Concept' is not applicable for 'final modifier' as well. So another
// question might be like parent is having that method 'final' and in child also I am re defining the same method with 'final'
// then also compiler will give CE. bec once it is declared as 'final' in parent, it could not be redefinable ok.
// But yes if reverse was the case, like parent was having non-final method and ten child is overriding it as 
// final then it will work fine. there is no CE.

// 'Abstract Modifier'
abstract class P{
    public abstract void m1();
}
class C extends P{
    public void m1(){}
}
// above abstract to non-abstract for corresponding parent to child is 100% valid as for any of the abstract method of parent
// class, child class is the only responsible to implement the abstract method hence we can say like child is overriding the
// parent's abstract method.
class P{
    public void m1(){}
}
abstract class C extends P{
    public abstract void m1(){}
}
// Weather above is valid or not?
// So above non-abstract to abstract for corresponding parent to child is also valid. as here what happens just try to
// understand. 1st method is defined in parent. now child is not satisfied with that method so it wants to modify or 
// redefine the method. But it doesn't know exactly what to modify it. so it can redefine it as abstract and it wants
// it's child to provide the implementation for this method. So it's compiled successfully. won't give any CE.

// Remaining modifiers are :- Synchronised, Native, Strictfp not so important but still rememeber for knowledge sake.

// for synchronised to non-synchronised and vice versa also for it's corresponding to parent to child is valid. and even if
// suppose parent is used keword synchronised, then it is not necessary to use synchronised keyword in child. So basically
// both ways working valid for 'synchronised modifier'
// Same for 'native modifier' as well. it valid in both the ways native to non-native for corresponding parent to child
// and vice versa is also valid. 
// Same for 'strictfp modifier' as well. it valid in both the ways strictfp to non-strictfp for corresponding parent to child
// and vice versa is also valid. 

// Conclusion :- so if you observe, for almost all the modifiers except final will be valid in both the ways. but
// if parent method is 'final' then it can't be overwrite by child.
// for 'private modifier' we have already covered seperately. And now only 1 modifier will be remaining that is static.
// That we will discuss soon.


// Rule - 3 :-
class P{
    public void m1(){}
}
class C extends P{
    private void m1(){}
}
// Above is the valid 'Overriding' or not?
// No. for above code compiler will give CE. bec remember very very very impotant conclusion is:- while 'Overriding'
// methods, we can't reduce the scope of the methods. we can expand the scope of methods bt can't reduce it.
// So in above case we have tried to reduce the scope of the methods from 'public' to 'private'. so compiler
// will raise CE.

// Note :- 
// Access Scope of modifiers are:- private < default < protected < public

class P{
    private void m1(){}
}
class C extends P{
    private void m1(){}
}
// this we have already covered ryt. this is perfectly valid. means compiler won't give CE.

class P{
    private void m1(){}
}
class C extends P{
    public void m1(){}
}
//  what about this case?
// so for this case we are incresing the scope. bt rule is we can't decrese the scope but here we are increasing the scope.
// so this is also perfectly fine. and compiler won't give CE.

// Parent method modifier :- public
// Then Child method modifier can be :- public (as we can't decrease scope. and public is having highest scope so)

// Parent method modifier :- protected
// Then Child method modifier can be :- protected, public

// Parent method modifier :- default
// Then Child method modifier can be :- default, protected, public

// Parent method modifier :- private
// Then Child method modifier can be :- there is no 'Overriding Concept' in case of parent has 'private modifier'.


// Rule - 4 :-
// This rule is about how and when can we use throws or exceptions for 'Overriding' or not.

// So as we know 'Throwable' is the root class of all the Exceptions and errors. Throwable has mainly 2 child classes.
// Exception and Error. Exception is having multiple child classes (RE(Runtime Exe), IO(Input Output E), IE(Interupted E
// which is very common exception in Multithreading), SE(Servelet Exception) etc etc...)
// now under RE class we are having multiple childs ( AE(Arithmetic E), NPE(Null Pointer E), CCE ...)
// Similarly IO Exceptions has many exception classes (FNFE(File not Found E), EOFE(End of file E)...)

// Under Error we are having multiple classes. (VMError(Virtual Machine Error)...)
// Under VMError we are having multiple classes.(OutofMemory error, StackOverFlow Error...)

// Now our motive is to identify which are checked Exceptions and which are unchecked Exceptions bec on basis of that we
// will move ahead for 'Overriding'.

// So RE class and it's child classes, and Error Class and it's child classes are 'Unchecked'(UC). except these remaining
// all classes under 'Throwable' are 'checked'. So now we have checked and unchecked exceptions. so let's go for
// 'Overriding' rule.

// Rule is:- if Child class method throws any checked exception, then compulsorily parent class method should throws
// same checked exception or it's parent exception. else compiler will give CE. And for 'Unchecked' exceptions there
// are no rules. it can be used anywhere any time.

// 1) P : public void m1() throws Exception
//    C : public void m1() {}
// Yes it's valid as child class has not thrown any exceptions so compiler won't give any CE.

// 2) P : public void m1() 
//    C : public void m1() throws Exception
// Invalid. as child has exception b parent has not thrown any exception so compiler will give CE.

// 3) P : public void m1() throws Exception
//    C : public void m1() throws Exception
// Valid

// 4) P : public void m1() throws Throwable
//    C : public void m1() throws Exception
// Valid. as parent class has thrown parent exception of 'Exception' thrown by child class.

// 5) P : public void m1() throws Exception
//    C : public void m1() throws IOException
// Valid

// 6) P : public void m1() throws IOException
//    C : public void m1() throws Exception
// InValid

// 7) P : public void m1() throws IOException
//    C : public void m1() throws EOFException, FNFE
// Valid

// 8) P : public void m1() throws IOException
//    C : public void m1() throws EOFException, InterruptedException
// InValid as child class have thrown 2 'checked' exceptions bt parent class has thrown only 1 parent exception of 1 of
// the child exceptions. but for 'IE' parent hasn't take care so compiler will give CE.

// 9) P : public void m1() throws IOException, InterruptedException
//    C : public void m1() throws EOFException, InterruptedException
// Valid

// 10) P : public void m1() throws Exception
//     C : public void m1() throws EOFException, InterruptedException
// Valid as parent class has thrown 1 exception only bt that 1 is already parent exception of both the child exceptions.

// 11) P : public void m1() throws IOException
//     C : public void m1() throws EOFException, NPE
// Valid as parent class has already thown parent exception of one of it's  checked child exception of child class. and another
// exception thrown by child class is Unchecked. so no need to worry about it hence compiler won't give CE.

// 12) P : public void m1() throws IOException
//     C : public void m1() throws AE, NPE
// Valid as both exception thrown by child class are unchecked. so no need to check for any rules for parent class.


// Next point is what is the behaviour of Overriding for static methods?
// what is the main difference between Instance method and Static method?
// So Static Method is class level. no where related to Object. But Instance method is the Object related method.
class P{
    public static void m1(){};
}
class C extends P{
    public void m1(){};
}
// So here what happens is, we are trying to override static method to non static method.
class P{
    public void m1(){};
}
class C extends P{
    public static void m1(){};
}
// in above case we are trying to override the non static method to static method.

// So for both the above case compiler will give CE. bec static methods are class level methods and non static methods
// are Object level methods. So we can't override any class level methods with Object level methods or vice versa. hence
// it's not valid and compiler will complain you.

// Conclusion :- static method with non static or not static method with static, 'Overriding' is not possible.

class P{
    public static void m1(){};
}
class C extends P{
    public static void m1(){};
}
// So above code is 100% valid as we are trying to override static method with static method. But in this case (static to static)
// it is not overriding. but it is called 'Method Hiding Concept'.

// What is the difference between 'Overriding' and 'Method Hiding'?
class P{
    public static void m1(){
        System.out.println('Parent');
    };
}
class C extends P{
    public static void m1(){
        System.out.println('Child');
    };
}
class Test{
    public static void main(String[] args){
        P p = new P();
        p.m1(); // o/p:- Parent

        C c = new C();
        c.m1(); // o/p:- child

        P p1 = new C();
        p1.m1();

// Now if you are saying this is 'Overriding' then my o/p in above case would be 'Child' as JVM should take care based on
// the Run time object in case of overriding. but in this case if you run, o/p will be Parent.

// So we have already discussed, for 'static' method it is not concept of 'Overriding', but it is concept of
// 'Method Hiding'. And pls pls remember for Method Hiding, method resolution is taken care by 'Compiler' based on
// the 'Reference Type' of object. So in above case o/p would be 'Parent'.
    }
}

// Summarize the diffn betn Method Hiding and Overriding :-
// Method Hiding :-
// - Both the Parent class and Child Class methods should be Static.
// - Method resolution always taken care by Compiler based on the Reference type.
// - Method Hiding is 'Compile Time Polymorphism' or 'Static Polymorphism' or 'Early Binding Polymorphism'.

// Overriding :-
// - Both the Parent class and Child Class methods should be non Static.
// - Method resolution always taken care by JVM based on the Run Time Object type.
// - Method Hiding is 'Run Time Polymorphism' or 'Dynamic Polymorphism' or 'Late Binding Polymorphism'.



// Overriding w.r.t var-arg methods :-
class P{
    public void m1(int... i){
        System.out.println('Parent');
    }
}
class C extends P{
    public void m1(int i){
        System.out.println('Child');
    }
}
class Test{
    public static void main(String[] args){
        P p = new P();
        p.m1(); // Parent

        C c = new C();
        c.m1(); // Child

        P p1 = new C();
        p1.m1();
// So in these cases what happens is, we were having var arg method in parent. but in child we can see we don't have
// the var arg method. it means method name is same but arg types are different. it menans in these case, it is not called
// 'Method Overriding concept'. But it is called 'Method Overloading Concept'. So o/p in above case would be based on
// Reference Type it means 'Parent'.
    }
}

// But yes in above example, if I change the data type of child class from general to var-arg like int...i.
// Then 100% it will be 'Overriding Concept'. and in that case output is decided by JVM based on the Run time Object.
// it means o/p would be 'Child'.

// Conclusion :- we can't override the var-arg method with normal method. if we try to ovrride the var-arg method
// with normal method, then it will become OverLoading but not Overriding. so if you want to override the var-arg method
// then you can overide it with other var-arg method only not with normal method.



// Overriding w.r.t Variable :-
// So 1st thing from heading itself, overriding concept is only applicable for methods not for variables.
// Then how the variable resolution will be there?
// So pls pls remember this thing, Variable Resolution always takes care by compiler, and that is based on the 
// 'Reference Type'. And this rule is same for weather the variable is Instance variable or static variable.
class P{
    String s = 'Parent';
}
class C extends P{
    String s = 'Child';
}
// here both the declared variables are 'Instance Variable'. but rule is same for Instance or Static Variale. like 
// Variable Resolution is done by Compiler and based on the Reference Type.
class Test{
    public static void main(String[] args){
        P p = new P();
        System.out.println(p.s); // Parent
        C c = new C();
        System.out.println(c.s); // Child
        P p1 = new C();
        System.out.println(p1.s); //Parent
    }
}
// And above concept of defining same variable in the Child Class is known as 'Variable Hiding' or 'Shadowing'.

class P{
    static String s = 'Parent';
}
class C extends P{
    String s = 'Child';
}
class Test{
    public static void main(String[] args){
        P p = new P();
        System.out.println(p.s); // Parent
        C c = new C();
        System.out.println(c.s); // Child
        P p1 = new C();
        System.out.println(p1.s); //Parent
    }
}
// so as we know weather variable are static or instance either in Parent or in Child class, rule is same. variable
// resolution is taken care by compiler and based on reference type. So overriding concept is only applicable for
// Methods not for Variables.

// Next video 38:- covers difference between Overloading and Overriding in tabular format. So pls check it once and note it in notebook.


// Polymorphism Summary :-
// so now we know the concept of 'Overloading' and 'Overriding'. So let's keep everything under one roof polymorphism.
// Poly means many. morphs means forms. So polymorphism means many forms. So 1 name but multiple forms is the concept of
// 'Polymorphism'.
// For exap:-
// abs(int), abs(float), abs(long)
// here you can see same method name but with different args it means in different forms. which is called 'Overloading' 
// which is nothing but example of 'Polymorphism'.
// 2nd thing is 'Overriding', which is 

// Video 39 nd 40 are also whole theoritical. Pls re watch it and make note of it. it explains about the 3 main pillar of
// OOPS (Encapsulation(data hiding, abstraction) which provides Security, Inheritance which provides Reusability, 
// Polymorphism which provides Flexibility.)



// Object Typecasting :- it is also very important but confusive topic. we know how to typecast primitive types. so let's
// learn now for Object types.
Object o = new String('Patrh');
StringBuffer sb = (StringBuffer) o;
// Above is valid or not? 
// So lets learn 3 rules for Object Typecasting.

// Syntax for Object Typecast is:-
// A b = (C) d
// So whenever typecasting will be there, it is in above format.
// So what we are exactly doing in it is, we are converting 'd' type object into 'C' type. And then we are assigning this 'C'
// type object to the 'A' type reference variable.

// So to check it valid typecasting or not compiler will check for 2 conditions and JVM will check 1 conditions (i.t. total 3
// rules have been checked).

// Compiler Time Check - 1 :- 1st compiler will check weather from 'd' type to 'C' type conversion is legal or not?
// when can we say it legal?
// So type of 'd' and type of 'C' must have some relationship ok. either parent to child or child to parent or have the
// same type. If there are not relationship between them then compiler will give CE. with msg:- inconverteble type
// for examp:-
String s = new String('Parth');
StringBuffer sb = (StringBuffer) s;
// will give CE. as there is no any relationship between String type and StringBuffer.

// Compiler Check - 2 :-
// 2nd compiler will check assignment is legal or not?
// when can we say it legal?
// So as per above syntax, type 'C' should be either same as 'A'. or 'C' should be child type of 'A'.
// If this both conditions met then 100% code will compiled successfully.
Object o = new String('Patrh');
StringBuffer sb = (String) o;
// will give CE. as 1st condition satisfied. but 2nd condition is not satisfied as Sting type is not same as StringBuffer nor 
// child of StringBuffer.

// JVM Check :- 'Run time object type' of 'd' must be same as 'C' or it's child type. else we will get the RE (Run time exception)
// with msg:- CCE (Class Cast Exception).
Object o = new String('Patrh');
StringBuffer sb = (StringBuffer) o;
// so for this case, it will compile successfully. but it will give RE. as run time object type of o is String
// which is not same or child type of StringBuffer.

Object o = new String('Patrh');
String sb = (String) o;
// Compile successfully and also run successfully and code go for execution of next lines in program.

// MMIMP points :- 
// 1) in typecasting, after typecaste, even after any number of nested typecaste, reference type of object
// will be changed. but 'Run Time Object Type' of object will never be changed. it will be as it is. 
// 2) Because of Object Typecasting, we are not going to create any new Object in heap memory. For the existing object we
// are trying to provide new reference variable. So after typecasting mutiple or more than 1 reference variable are pointing
// out to the same Object which presents in heap memory.
String s = new String("parth")
Object o = (Object)s
// to check it you can System.out.println(s==o); // in java double equals sign will return true only if both the operand is
// referencing to the same object in the memory. double equals sign is used for Reference comparison.

// Q) guess th o/p.
class P{
    public void m1(){
        System.out.println('Parent');
    }
}
class C extends P{
    public void m2(){
        System.out.println('Child');
    }
}
class Test{
    public static void main(String[] args){
        C c = new C();

        c.m1(); // valid
        c.m2(); // valid
        ((P)c).m1(); // Valid
        ((P)c).m2(); // Invalid. so CE. as reference type is changed form c to P. and here reference type or we 
        // can say compiler is responsible to make the method resolution and hence reference type doesn't have access to
        // it's child's methods hence compiler give C.E.
    }
}

// Q) Guess the o/p.
class A{
    public m1(){
        System.out.println('A');
    }
}
class B extends A{
    public m1(){
        System.out.println('B');
    }
}
class C extends B{
    public m1(){
        System.out.println('C');
    }
}
class Test{
    public static void main(String[] args){
        C c = new C();

        c.m1();
        ((B)c).m1();
        ((A)((B)c)).m1();
    }
// So you can see above is the example of 'Method Overriding' ryt. so in case of overriding Method resolution takes care by
// JVM based on the 'Run Time Object Type'.
// Now for above all the 3 cases, run time object stays same even though we have performed the 'Object Typecasting' ryt. so
// o/p for all the 2 method calls would be :- C only.
}

// Q) same as above question only. but just changed the method types in all the classes to 'static modifiers'. now guess the o/p.
// So in that case it's not 'Overriding' but it is 'Method Hiding'. And in case of method hiding, method resolution takes care by
// Compiler and that is based on "reference Type". 
// So o/p of above code will be:
// C
// B
// A 

// Q) Guess the o/p.
class A{
    int x = 999;
}
class B extends A{
    int x = 888;
}
class C extends B{
    int x = 777;
}
class Test{
    public static void main(String[] args){
        C c = new C();

        System.out.println(c.x);
        System.out.println(((B)c).x);
        System.out.println(((A)((B)c)).x);
    }
// So in case of Variable Resolution, it is taken care by Compiler only and based on Reference type.
// So o/p would be :-
// 777
// 888
// 999
}