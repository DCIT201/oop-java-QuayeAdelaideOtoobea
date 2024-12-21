package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer implements LoyaltyProgram {

    private String name;
    private int loyaltyPoints;
    private int rating; // 0-5 rating

    // Composition: Customer "has a" list of Vehicles they're renting
    private List<Vehicle> currentRentals;

    public Customer(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
        this.currentRentals = new ArrayList<>();
        this.loyaltyPoints = 0;
        this.rating = 0;
    }

    public String getName() { return name; }

    // LoyaltyProgram interface
    @Override
    public int getLoyaltyPoints() { return loyaltyPoints; }

    @Override
    public void addLoyaltyPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative.");
        }
        this.loyaltyPoints += points;
    }

    public int getRating() { return rating; }
    public void setRating(int rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5.");
        }
        this.rating = rating;
    }

    public List<Vehicle> getCurrentRentals() { return currentRentals; }
    public void addRental(Vehicle vehicle) {
        if (!currentRentals.contains(vehicle)) {
            currentRentals.add(vehicle);
        }
    }
    public void removeRental(Vehicle vehicle) {
        currentRentals.remove(vehicle);
    }
}