package org.allTopics.Creational.Factory.FactoryExample.VehicleBookingSystem;

public abstract class Auto implements Vehicle{
    String shareType;
    int baseCost;
    int chargesPerUnitDistance;

    @Override
    public void book(int distance){
        setVehicleType();
        setBaseCost();
        setVehicleChargesPerUnitDistance();
        int cost = calculateCostOfBooking(distance);
        System.out.println("You have booked a " + shareType + " Autorickshaw for a distance of " + distance + " kms at a total cost of " + cost + ". ");
    }

    @Override
    public int calculateCostOfBooking(int distance){
        int serviceCharge = 1;
        return baseCost + chargesPerUnitDistance * distance + serviceCharge;
    }
}
