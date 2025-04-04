package org.allTopics.ExceptionPractice;

public class Practice2 {
    public static void main(String[] args) {
        System.out.println("Main Method Started");
        Practice2Test p = new Practice2Test();
        int ans=0;
        try {
            ans = p.function(5,0);
        }
        catch (ArithmeticException e) {
            System.out.println("inside catch: " + e);
//            e.printStackTrace();
        }
        System.out.println(ans);
        System.out.println("We don't need to handle the exception, since it is handled in the function " +
                "method of PracticeTest");
        System.out.println("Main Method Finished");


    }
}

class Practice2Test{
    int function(int a, int b) throws ArithmeticException {
        System.out.println("Function Called");
        int x=0;
        try{
            if(b==0){
                System.out.println("Arithmetic Exception Occured");
//                throw new ArithmeticException();
            }
            x = a/b;
        }
        catch(ArithmeticException e){
            System.out.println("Arithmetic Exception Handled");
            e.printStackTrace();
            throw new ArithmeticException();
//            e.printStackTrace();
        }
        finally {
            System.out.println("Closing something");
        }

        System.out.println("Since Exception Handled, flow execution continued");
        System.out.println(x);

        return x;
    }
}
