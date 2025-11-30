package org.allTopics.Behavioral.Observer.NewsPaperPublisherExample.Version_02;

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
