package org.allTopics.Behavioral.Strategy.WithStrategyPattern;

public class PassengerVehicle extends Vehicle {
    public PassengerVehicle() {
        super(new NormalDriving()); // Since passenger vehicle wants normal driving capabilities
    }

}
