package org.allTopics.Behavioral.Observer.NewsPaperPublisherExample.Version_02;

import java.util.ArrayList;
import java.util.List;

public class HindustanTimes extends NewsPaper implements Subject{

    private List<Observer> observers;

    public HindustanTimes() {
        super("Hindustan Times");
        observers = new ArrayList<>();
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
        for (Observer observer : observers) {observer.update("NewsPaper "+ this.getNewsPaperName() + " published for today");}
    }
}
