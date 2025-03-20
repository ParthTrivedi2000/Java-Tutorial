package org.allTopics.Behavioral.Strategy.CodeExample;

/*
So we are taking example of Password Encoder.
Suppose you are having UserService. So create UserService class. And inside it create method register which takes
username, password and email as an argument.
- now I want to encode my password. And Suppose below is the implementation of password encoding.

class UserService{
    void register(String username, String password, String email){
        String encodedPassword = password + "something";
        encodedPassword += "everything";
    }
}

Now what is the issue with above code?
- Above we have implemented encoding in such a way that everyone can see it. So it should not be like that.
- Now next thing is, OCP is also violated. And also in other all the services, if I want to have the password, then
again I have to write the same lines of code there.

So next Solution is:- let's abstract out the encoding logic from here. And dump it into a separate class.

class EncodePasswordBehaviour{
    String encode(String password){
        String encodedPassword = password + "something";
        encodedPassword += "everything";
        return encodedPassword;
    }
}

class UserService{

    private EncodePasswordBehavior encodedPasswordBehavior = new EncodePasswordBehavior();

    void register(String username, String password, String email){
        encodePasswordBehavior.encode(password);
    }
}

But above solution is violating which design principle? --> So it is violating the Dependency Inversion design
principle. Because it clearly mentions that no 2 concrete class should dependent directly on each other. But above
UserService class is directly depending on the EncodePasswordBehavior class. they should depend on each other via
an Interface.

- So as a Solution, we can have Interface EncodePasswordBehavior, instead of class with that name. And there should
be separate 1 class which implements this behavior. So creating class with SimpleEncodePasswordBehavior.

Now further see code in actual codebase.

 */

public class Client {
    public static void main(String[] args) {
        UserService userService = new UserService(new SimpleEncodePasswordBehavior());
    }
}

// So above is simply Strategy design pattern implementation. (here we have used constructor injection (i.e. dependency
// injection based implementation of Strategy pattern, since any single password encoding strategy should be used
// across the whole application.
