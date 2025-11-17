package org.allTopics.Creational.Factory.FactoryExample.UserExample;

public class Client {
    public static void main(String[] args) {
        // Since I need User. But User is of 3 types. STUDENT, TEACHER, MENTOR
        // So instead of creating User user = new Student(); we can implement Factory Design Pattern since I don't
        // want my Client to know the exact class name of the Object I am creating (i.e. user is created by Student
        // class or Mentor class or Teacher class).

        User user = UserFactory.createUser("Student");

    }
}
