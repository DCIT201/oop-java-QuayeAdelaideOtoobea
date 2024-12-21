package com.vehicleRental;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> fleet;

    public RentalAgency() {
        fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public Vehicle findAvailableVehicle(String model) {
        return fleet.stream()
                .filter(vehicle -> vehicle.isAvailable() && vehicle.getModel().equalsIgnoreCase(model))
                .findFirst()
                .orElse(null);
    }

    public void processRental(Customer customer, Vehicle vehicle, int days) {
        if (!vehicle.isAvailable()) {
            throw new IllegalStateException("Vehicle is not available");
        }
        vehicle.setAvailable(false);
        customer.addRental(vehicle);
        System.out.printf("Rented %s to %s for %d days. Cost: %.2f%n",
                vehicle.getModel(), customer.getName(), days, vehicle.calculateRentalCost(days));
    }

    public void returnVehicle(Vehicle vehicle) {
        vehicle.setAvailable(true);
    }
}