package org.allTopics.Creational.Factory.FactoryExample.VehicleBookingSystem;

public class PersonalAuto extends Auto{
    public PersonalAuto(){}

    @Override
    public void setVehicleType(){
        shareType = "Personal";
    }

    @Override
    public void setBaseCost(){
        baseCost = 10;
    }

    @Override
    public void setVehicleChargesPerUnitDistance(){
        chargesPerUnitDistance = 15;
    }
}
