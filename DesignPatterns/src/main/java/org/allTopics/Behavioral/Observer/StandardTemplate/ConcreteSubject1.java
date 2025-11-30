package org.allTopics.Behavioral.Observer.StandardTemplate;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject1 implements Subject {

    private List<Observer> observers;

    public ConcreteSubject1() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index >0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}
