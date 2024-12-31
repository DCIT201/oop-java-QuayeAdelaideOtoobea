package org.example;

public class Car extends Vehicle {

    private boolean hasSunroof;
    private double insuranceFee;

    // Example static factory method
    public static Car createCar(String vehicleId, String model, double baseRentalRate) {
        // default insurance fee 30.0, no sunroof
        return new Car(vehicleId, model, baseRentalRate, false, 30.0);
    }

    public Car(String vehicleId, String model, double baseRentalRate,
               boolean hasSunroof, double insuranceFee) {
        super(vehicleId, model, baseRentalRate);
        this.hasSunroof = hasSunroof;
        this.insuranceFee = insuranceFee;
    }

    @Override
    public double calculateRentalCost(int days) {
        // cost = (base rate * days) + insuranceFee
        return (getBaseRentalRate() * days) + insuranceFee;
    }

    @Override
    public boolean isAvailableForRental() {
        return getIsAvailable();
    }

    @Override
    public void rent(Customer customer, int days) throws VehicleNotAvaliableException {
        if (!isAvailableForRental()) {
            throw new VehicleNotAvaliableException("Car " + getVehicleId() + " is not available.");
        }
        setAvailability(false);
        System.out.println("Car " + getVehicleId() + " rented to " + customer.getName() +
                " for " + days + " day(s).");
    }

    @Override
    public void returnVehicle() {
        setAvailability(true);
        System.out.println("Car " + getVehicleId() + " has been returned.");
    }

    // Method Overloading (extra param)
    public double calculateRentalCost(int days, boolean addExtraCoverage) {
        double extra = addExtraCoverage ? 20.0 : 0.0;
        return calculateRentalCost(days) + extra;
    }

    // Getters / Setters
    public boolean hasSunroof() { return hasSunroof; }
    public void setHasSunroof(boolean hasSunroof) { this.hasSunroof = hasSunroof; }
    public double getInsuranceFee() { return insuranceFee; }
    public void setInsuranceFee(double insuranceFee) {
        if (insuranceFee < 0) {
            throw new IllegalArgumentException("Insurance fee cannot be negative.");
        }
        this.insuranceFee = insuranceFee;
    }
}