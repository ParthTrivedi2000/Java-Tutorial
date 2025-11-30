package org.allTopics.Behavioral.Observer.NewsPaperPublisherExample.Version_03;

public interface Subject {
    public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);
    public void notifyObservers();
}
