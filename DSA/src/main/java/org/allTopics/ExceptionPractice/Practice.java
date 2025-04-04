package org.allTopics.ExceptionPractice;

public class Practice {
    public static void main(String[] args) {
        System.out.println("Program Started");
        Test t1 = new Test();
        System.out.println("Function is called from Practice");
        int x=0;
        try {
            x = t1.divison(5,0);
            System.out.println("inside try: " + x);
        }
        catch (ArithmeticException e) {
            System.out.println("inside catch: " + x);
            System.out.println("Division by zero happened, Please try again");
        }
        System.out.println("Program ended");
    }
}


class Test{
    int divison(int a, int b){
        System.out.println("Method is called from Test");
        System.out.println("Dividing " + a + " by " + b);
        try {
            System.out.println("And result is: " + a/b);
        }
        catch (ArithmeticException e) {
            System.out.println("Division by zero happened from Test class, Please try again");
        }
        return a/b;
    }
}