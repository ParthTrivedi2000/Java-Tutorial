package org.allTopics.Behavioral.Strategy.WithStrategyPattern;

public class GoodsVehicle extends Vehicle {
    public GoodsVehicle() {
        super(new NormalDriving()); // Since passenger vehicle wants normal driving capabilities
    }
}
