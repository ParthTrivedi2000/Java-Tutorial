package org.allTopics.Creational.Factory.FactoryExample.VehicleBookingSystem;

public interface Vehicle {
    void book(int distance);
    void setVehicleType();
    void setBaseCost();
    void setVehicleChargesPerUnitDistance();
    int calculateCostOfBooking(int distance);
}
