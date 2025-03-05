package org.allTopics.Behavioral.Strategy.WithStrategyPattern;

public class NormalDriving implements DrivingStrategy {
    @Override
    public void drive() {
        System.out.println("Normal Driving Capabilities");
    }
}
