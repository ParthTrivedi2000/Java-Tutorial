package org.allTopics.Creational.Factory.FactoryExample.VehicleBookingSystem;

public class MiniCar extends Car{
    public MiniCar(){};

    @Override
    public void setVehicleType(){
        carType = "Mini";
    }

    @Override
    public void setBaseCost(){
        baseCost = 100;
    }

    @Override
    public void setVehicleChargesPerUnitDistance(){
        chargesPerUnitDistance = 20;
    }
}
