package org.allTopics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /*
    public static void main(String[] args) {
//        Student s1 = new Student();
        Integer[] numera = {1,2,3,6,54};
        int[] numerat = {1,2,0,5,11};

//        System.out.println(numerat); // [I@7b23ec81
//        System.out.println(numera); // [Ljava.lang.Integer;@6acbcfc0
//        System.out.println(s1);

        // Just a small question :- why both are different?
        // Always remember, println function will always call toString method of class of the argument type

        // So If I want to print something elese for my class objects, then I have to override the method
        // toString() in my class else by default it will run the toString() method from Object class.

//        Student s1 = new Student();
////        s1.getId();
////        s1.setId(12);
////        s1.getId();

//        for (int i = 0; i < numera.length; i++) {
//            System.out.println(divide(numera[i], numerat[i]));
//        }
//        System.out.println("You are done!");


        // Here in below code, once Arithmatic and all those exceptions are handled in divide method. But
        // here there is IndexOutOfBound exception is there. So we have to handle here as well. then only
        // last line ("You are done" wali line) tk code reach ho payega else it will disrupt in between.
        for (int i = 0; i < 10; i++) {
            try{
                System.out.println(divide(numera[i], numerat[i]));
            }
            catch (Exception e1){
                System.out.println(e1);
            }
        }
        System.out.println("You are done!");

        // Now all the exceptions which we have checked are not checked by Compiler as we have seen like
        // it is allowing to write me to code successfully but won't prevent me. And eventually at Run time
        // JVM is throwing exception.
        // So long story short, here above exceptions are not checked by complier hence all those are
        // known as Unchecked Exceptions.

        // There is other category of exception which are Checked exception which are checked by compiler
        // at compile time only. For example for file reader, like i have created below object for start reafing
        // file.
//        FileReader fr = new FileReader("myfile.txt");

        // So here just after writing this line, compiler showing me error with red line. And if you hover
        // it says you haven't catch the exception file not found it means compiler says ki you have written
        // this line of code which is perfectly valid but when I will going to check for file and if it's not
        // there then what, then I won't be able to proceed further ryt. So compiler says as a developer you
        // have to handle it otherwise I won't allow you to compile this code.

        try{
            FileReader fr = new FileReader("myfile.txt");
        }
        catch(Exception e){
            System.out.println("mentioned file is not found.");
        }

        // So now compiler is not complaining since we have handled it. we can write IOException as well which
        // is immediate parent of FileNotFound Exception Object.

        // So this is one way to handle the checked exceptions means compile time possible mistakes.
        // Another way is see below. like we can mention exception the method itself. So caller of this
        // method beforehand came to know  like this method i am using but it might give this particular
        // exception so I have to handle it into my code while using this method.
    }
     */

    public static void main(String[] args) {
        try{
            method2();
        }
        catch(IOException e){
            System.out.println("File is not found. Saying from main method.");
        }

        // Note:- So always remember ki for any checked exceptions you can do 2 things like at the
        // same line you can handle the exception via try catch block. But if I don't want to handle
        // then you have to notify the caller of this method via mentioning the exception in the method
        // signature. So anyone who awnts to use this method that needs to handle. Means last tk
        // kisi na kisi ek method ko to handle krna hi hoga (means try catch me dalna hi hoga) else
        // last me JVM will handle by disruption code in between.


        // There is one more keywork throw which is used to throw new exception. (this I have to revise
        // from somewhere).

        // finally:- there is one keyword finally. which we usually write after the try catch block.
        // So weather try block runs, or catch block runs, but whatever written in finally will
        // certainly runs.

        // Generally finally block is used to write things ki jisme me return ho gya method se either
        // from try or catch still I want to run things those will be mentioned in the finally block.
        // like database connection close, or other resource colse like reader.close etc etc.
        /*
        try{
            something;
            return;
        }
        catch(){
            some exception print things;
            return;
        }
        finally{
            reader.close();
            connection.close();
            sc.close(); {consider sc as Scanner class object}
        }
         */

        // So in Java 7 they have provided 1 more feature with try-with resource to handle this
        // resource closing and anything to do with the resources. So here we are writing finally for
        // some resources then in case of try-with-resources we even don't need to write finally
        // like resource handling we can do in the try-with-resources block only.
        try(BufferedReader br1 = new BufferedReader(new FileReader("myfile.txt"))){

        }
        catch(IOException e){
            System.out.println("Mentioned file is not found.");
        }

        // So above is the syntax of try-with-resource. means simply we have to create the resource
        // in the braces of try(){}. So what JVM will do is suppose if any resource is mentioned in the try
        // braces and if resource creation class ne agr AutoClosable interface ko implements kiyabhoga (which
        // is the case generally) then JVM will close it irrespective of try block runs or catch block runs.

        // Custom Exceptions :-
        // For that I am creating BankAccount class and handling custom exception from that class.

    }

    public static void method2() throws FileNotFoundException{
        fileRead();
    }

    public static void fileRead() throws FileNotFoundException {
        FileReader fr = new FileReader("myfile.txt");
    }

    public static int divide(Integer a, int b){
        try{
//            Student s1 = null;
////            Student s1 = new Student();
//            s1.setId(12);

            return a/b;
        }
//        catch (Exception e) {
//            System.out.println(e);
//            return -1;
//        }
        // Showing error bec we have catched Parent Exception above as Exception class is parent of all the
        // exception. (Hierarchy :- Objects --> Throwable --> Exception --> Runtime and etc etc )
        // So whatever catch statements written below wll never execute. hence no need of writing it below
        // parent type exception either if you want to write and do seperately for any exception, you can
        // write it just above the parent exception.
        catch (ArithmeticException e1){
            System.out.println("There is an Arithmatic Exception");
            System.out.println("args are:"+ a+ " " + b);
            return -1;
        }
        catch(NullPointerException nle){
            System.out.println("There is a Null Pointer Exception");
            System.out.println("args are:"+ a+ " " + b);
            return -1;
        }

        catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }
}

class Student{
    private int id;

    public int getId() {
//        System.out.println(this);
//        System.out.println(id);
//        System.out.println(this.id);
        return this.id;
    }

    public void setId(int x){
        this.id = x;
    }
}