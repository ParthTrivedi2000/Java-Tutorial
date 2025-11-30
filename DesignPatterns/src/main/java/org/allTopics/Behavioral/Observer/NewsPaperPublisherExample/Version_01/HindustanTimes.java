package org.allTopics.Behavioral.Observer.NewsPaperPublisherExample.Version_01;

import java.util.ArrayList;
import java.util.List;

public class HindustanTimes implements Subject {

    private String newsPaperName;
    private List<Observer> observers;

    public HindustanTimes(String newsPaperTitle) {
        this.newsPaperName = newsPaperTitle;
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if(index>0) observers.remove(index);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {observer.update("NewsPaper "+ newsPaperName + " published for today");}
    }
}
