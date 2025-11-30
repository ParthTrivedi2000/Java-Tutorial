package org.allTopics.Behavioral.Observer.NewsPaperPublisherExample.Version_03;

public class User implements Observer {

    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String newsPaperName, String latestNews) {
        display(newsPaperName, latestNews);
    }

    private void display(String newsPaperName, String latestNews) {
        System.out.println("Hey, " + userName + " received news from " + newsPaperName + ": " + latestNews);
    }
}
