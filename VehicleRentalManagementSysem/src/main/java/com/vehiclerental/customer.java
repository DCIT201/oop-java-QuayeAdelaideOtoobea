package com.vehiclerental;

import java.util.ArrayList;
import java.util.Collection;

public class customer {
    private final String name;
    private final ArrayList<vehicle> rentedVehicles;

    // Constructor
    public customer(String name) {
        this.name = name;
        rentedVehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void rentVehicle(vehicle vehicle, int days) {
        if (vehicle.isAvailableForRental()) {
            rentedVehicles.add(vehicle);
            System.out.println(name + " rented a " + vehicle.getModel() + " for " + days + " days.");
            // Cast the vehicle to Rentable to use rent method
            if (vehicle instanceof rentable) {
                ((rentable) vehicle).rent(this, days);
            }
        }
    }

    public void returnVehicle(vehicle vehicle) {
        rentedVehicles.remove(vehicle);
        // Cast the vehicle to Rentable to use returnVehicle method
        if (vehicle instanceof rentable) {
            ((rentable) vehicle).returnVehicle();
        }
        System.out.println(name + " returned the " + vehicle.getModel() + ".");
    }

    public Collection<Object> getRentedVehicles() {
        return java.util.List.of();
    }
}
