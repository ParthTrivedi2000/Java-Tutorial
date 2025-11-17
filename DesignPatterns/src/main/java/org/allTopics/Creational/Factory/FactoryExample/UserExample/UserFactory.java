package org.allTopics.Creational.Factory.FactoryExample.UserExample;

public class UserFactory {

    public static User createUser(String user) {
        if (user.equals("Student")) {
            return new Student();
        }
        else if (user.equals("Teacher")) {
            return new Teacher();
        }
        else if (user.equals("Mentor")) {
            return new Mentor();
        }
        else {
            return null;
        }
    }
}
