package org.allTopics.Behavioral.Strategy.WithStrategyPattern;

public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SpecialDriving()); // Since Sporty Vehicle wants special driving capabilitise;
    }
}
