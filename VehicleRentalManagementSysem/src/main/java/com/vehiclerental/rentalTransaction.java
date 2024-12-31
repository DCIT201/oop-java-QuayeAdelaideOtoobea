package com.vehiclerental;

public class rentalTransaction {
    private final com.vehiclerental.vehicle vehicle;
    private final int rentalDays;

    public rentalTransaction(vehicle vehicle, int rentalDays) {
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public com.vehiclerental.vehicle getVehicle() {
        return vehicle;
    }

    public com.vehiclerental.customer getCustomer() {
        return null;
    }
}

