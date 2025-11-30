package org.allTopics.Behavioral.Observer.NewsPaperPublisherExample.Version_03;

import java.util.ArrayList;
import java.util.List;

public abstract class NewsPaper implements Subject {

    private String newsPaperName;
    private List<Observer> observers;
    private String latestNews;

    public NewsPaper(String newsPaperName) {
        this.newsPaperName = newsPaperName;
        observers = new ArrayList<>();
    }
    public String getNewsPaperName() {return newsPaperName;}

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        int index = observers.indexOf(observer);
        if(index>0) observers.remove(index);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {observer.update(newsPaperName, latestNews);}
    }

    public void publishNews(String updatedNews) {
        this.latestNews = updatedNews;
        notifyObservers();
    }

}
