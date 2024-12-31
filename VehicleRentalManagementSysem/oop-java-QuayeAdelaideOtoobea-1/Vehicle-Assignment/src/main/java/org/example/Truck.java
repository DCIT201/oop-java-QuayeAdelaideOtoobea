package org.example;

public class Truck extends Vehicle {

    private double loadCapacity; // e.g. in tons

    public Truck(String vehicleId, String model, double baseRentalRate, double loadCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        // cost = base rate * days + extra fee if capacity > 5.0
        double extraFee = (loadCapacity > 5.0) ? 50.0 : 20.0;
        return (getBaseRentalRate() * days) + extraFee;
    }

    @Override
    public boolean isAvailableForRental() {
        return getIsAvailable();
    }

    @Override
    public void rent(Customer customer, int days) throws VehicleNotAvaliableException {
        if (!isAvailableForRental()) {
            throw new VehicleNotAvaliableException("Truck " + getVehicleId() + " is not available.");
        }
        setAvailability(false);
        System.out.println("Truck " + getVehicleId() + " rented to " + customer.getName() +
                " for " + days + " day(s).");
    }

    @Override
    public void returnVehicle() {
        setAvailability(true);
        System.out.println("Truck " + getVehicleId() + " has been returned.");
    }

    public double getLoadCapacity() { return loadCapacity; }
    public void setLoadCapacity(double loadCapacity) {
        if (loadCapacity < 0) {
            throw new IllegalArgumentException("Load capacity cannot be negative.");
        }
        this.loadCapacity = loadCapacity;
    }
}