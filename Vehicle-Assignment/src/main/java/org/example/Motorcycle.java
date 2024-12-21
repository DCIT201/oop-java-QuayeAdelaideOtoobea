package org.example;

public class Motorcycle extends Vehicle {

    private boolean requiresHelmet;
    private double helmetFeePerDay;

    public Motorcycle(String vehicleId, String model, double baseRentalRate, double helmetFeePerDay) {
        super(vehicleId, model, baseRentalRate);
        this.requiresHelmet = true; // assume all motorcycles require helmet
        this.helmetFeePerDay = helmetFeePerDay;
    }

    @Override
    public double calculateRentalCost(int days) {
        // cost = base rate * days + (helmetFeePerDay * days) if requiresHelmet
        return (getBaseRentalRate() * days) + (requiresHelmet ? (helmetFeePerDay * days) : 0.0);
    }

    @Override
    public boolean isAvailableForRental() {
        return getIsAvailable();
    }

    @Override
    public void rent(Customer customer, int days) throws VehicleNotAvaliableException {
        if (!isAvailableForRental()) {
            throw new VehicleNotAvaliableException("Motorcycle " + getVehicleId() + " is not available.");
        }
        setAvailability(false);
        System.out.println("Motorcycle " + getVehicleId() + " rented to " + customer.getName() +
                " for " + days + " day(s).");
    }

    @Override
    public void returnVehicle() {
        setAvailability(true);
        System.out.println("Motorcycle " + getVehicleId() + " has been returned.");
    }

    // Getters / Setters
    public boolean isRequiresHelmet() { return requiresHelmet; }
    public void setRequiresHelmet(boolean requiresHelmet) { this.requiresHelmet = requiresHelmet; }
    public double getHelmetFeePerDay() { return helmetFeePerDay; }
    public void setHelmetFeePerDay(double helmetFeePerDay) {
        if (helmetFeePerDay < 0) {
            throw new IllegalArgumentException("Helmet fee cannot be negative.");
        }
        this.helmetFeePerDay = helmetFeePerDay;
    }
}