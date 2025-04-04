package org.allTopics.ExceptionPractice;

public class Practice3 {
    public static void main(String[] args) throws MyCustomException {
        MyCustomException myCustomException = new MyCustomException();
        System.out.println(myCustomException.getMessage());
        throw new MyCustomException();
    }
}

class MyCustomException extends Exception {
    public MyCustomException() {}
}
