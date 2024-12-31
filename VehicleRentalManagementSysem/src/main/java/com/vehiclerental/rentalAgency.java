package com.vehiclerental;

import java.util.ArrayList;
import java.util.Collection;

public class rentalAgency {
    private final ArrayList<vehicle> fleet;

    // Constructor
    public rentalAgency() {
        fleet = new ArrayList<>();
    }

    public void addVehicle(vehicle vehicle) {
        fleet.add(vehicle);
    }

    public void displayFleet() {
        for (vehicle vehicle : fleet) {
            System.out.println(vehicle);  // Uses the toString method of each vehicle
        }
    }

    public Collection<Object> getFleet() {
        return java.util.List.of();
    }
}
