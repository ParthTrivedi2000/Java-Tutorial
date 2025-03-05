package org.allTopics.Behavioral.Strategy.WithStrategyPattern;

public class Vehicle {
    DrivingStrategy drivingObject;

    Vehicle(DrivingStrategy drivingObject) {
        this.drivingObject = drivingObject;
    }

    public void drive() {
        drivingObject.drive();
    }
}
