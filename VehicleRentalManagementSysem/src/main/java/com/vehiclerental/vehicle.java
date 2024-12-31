package com.vehiclerental;

public abstract class vehicle {
    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;

    // Constructor
    public vehicle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        this.vehicleId = vehicleId;
        this.model = model;
        setBaseRentalRate(baseRentalRate);  // Use setter for validation
        this.isAvailable = isAvailable;
    }

    // Getters and setters
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate < 0) {
            throw new IllegalArgumentException("Rental rate cannot be negative");
        }
        this.baseRentalRate = baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    protected void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Abstract methods for rental calculation
    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();
}
