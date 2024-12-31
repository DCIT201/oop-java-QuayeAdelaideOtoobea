package com.vehiclerental;

public class car extends vehicle implements rentable {

    public car(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate, true); // true means available by default
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days;  // Simple rental cost calculation
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable(); // Check availability
    }

    @Override
    public void rent(customer customer, int days) {
        if (isAvailableForRental()) {
            System.out.println("Car rented to " + customer.getName() + " for " + days + " days.");
            setAvailable(false);  // Mark car as unavailable after renting
        } else {
            System.out.println("Car is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        System.out.println("Car returned.");
        setAvailable(true);  // Mark car as available after returning
    }

    @Override
    public String toString() {
        return "Car [ID=" + getVehicleId() + ", Model=" + getModel() + ", Rate=" + getBaseRentalRate() + "]";
    }
}
