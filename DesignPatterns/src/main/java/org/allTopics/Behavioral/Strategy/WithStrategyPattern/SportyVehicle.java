package org.allTopics.Behavioral.Strategy.WithStrategyPattern;

public class SportyVehicle extends Vehicle {
    public SportyVehicle() {
        super(new SpecialDriving()); // Since Sporty Vehicle wants special driving capabilitise;
    }
}
