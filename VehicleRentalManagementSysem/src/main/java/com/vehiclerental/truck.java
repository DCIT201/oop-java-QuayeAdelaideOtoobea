package com.vehiclerental;

public class truck extends vehicle implements rentable {

    public truck(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate, true); // Available by default
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 1.5;  // Increased rate for trucks due to their size
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(customer customer, int days) {
        if (isAvailableForRental()) {
            System.out.println("Truck rented to " + customer.getName() + " for " + days + " days.");
            setAvailable(false);  // Mark truck as unavailable after renting
        } else {
            System.out.println("Truck is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        System.out.println("Truck returned.");
        setAvailable(true);  // Mark truck as available after returning
    }

    @Override
    public String toString() {
        return "Truck [ID=" + getVehicleId() + ", Model=" + getModel() + ", Rate=" + getBaseRentalRate() + "]";
    }
}
