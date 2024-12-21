package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<Vehicle> rentalHistory;

    public Customer(String customerId, String name) {
        if (customerId == null || name == null) {
            throw new IllegalArgumentException("Invalid customer details");
        }
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void addRental(Vehicle vehicle) {
        rentalHistory.add(vehicle);
    }

    public List<Vehicle> getRentalHistory() {
        return new ArrayList<>(rentalHistory);
    }
}