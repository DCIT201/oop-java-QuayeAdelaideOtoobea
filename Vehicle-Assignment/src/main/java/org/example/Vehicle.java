package org.example;

public abstract class Vehicle implements Rentable {

    private final String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String model, double baseRentalRate) {
        if (vehicleId == null || vehicleId.isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be null or empty.");
        }
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be > 0.");
        }

        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true;
    }

    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();

    // Implementations of rent(...) and returnVehicle() are in child classes.

    // Getters / Setters (Encapsulation)
    public String getVehicleId() { return vehicleId; }
    public String getModel() { return model; }
    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be null or empty.");
        }
        this.model = model;
    }
    public double getBaseRentalRate() { return baseRentalRate; }
    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be > 0.");
        }
        this.baseRentalRate = baseRentalRate;
    }
    public boolean getIsAvailable() { return isAvailable; }
    public void setAvailability(boolean isAvailable) { this.isAvailable = isAvailable; }

    // equals, hashCode, toString
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehicle)) return false;
        Vehicle other = (Vehicle) obj;
        return this.vehicleId.equals(other.vehicleId);
    }
    @Override
    public int hashCode() { return vehicleId.hashCode(); }
    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", model='" + model + '\'' +
                ", baseRentalRate=" + baseRentalRate +
                ", isAvailable=" + isAvailable +
                '}';
    }
}