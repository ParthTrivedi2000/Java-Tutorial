package org.allTopics.Behavioral.Observer.NewsPaperPublisherExample.Version_01;

public class User implements Observer {

    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String msg) {
        display(msg);
    }

    private void display(String msg) {
        System.out.println("Hey, " + userName + " : " + msg);
    }
}
