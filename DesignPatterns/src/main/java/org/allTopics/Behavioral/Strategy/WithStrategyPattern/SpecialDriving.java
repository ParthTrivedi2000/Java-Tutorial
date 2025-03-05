package org.allTopics.Behavioral.Strategy.WithStrategyPattern;

public class SpecialDriving implements DrivingStrategy {
    @Override
    public void drive() {
        System.out.println("Special Driving Capabilities");
    }
}
