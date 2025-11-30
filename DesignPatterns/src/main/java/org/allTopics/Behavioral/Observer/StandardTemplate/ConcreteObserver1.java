package org.allTopics.Behavioral.Observer.StandardTemplate;

public class ConcreteObserver1 implements Observer {

    private String observerName;
    private Subject subject;

    public ConcreteObserver1(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {

    }
}
