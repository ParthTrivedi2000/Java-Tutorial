package org.allTopics.Creational.Factory.FactoryExample.VehicleBookingSystem;

public class MicroCar extends Car {
    public MicroCar(){};

    @Override
    public void setVehicleType(){
        carType = "Micro";
    }

    @Override
    public void setBaseCost(){
        baseCost = 50;
    }

    @Override
    public void setVehicleChargesPerUnitDistance(){
        chargesPerUnitDistance = 10;
    }
}
