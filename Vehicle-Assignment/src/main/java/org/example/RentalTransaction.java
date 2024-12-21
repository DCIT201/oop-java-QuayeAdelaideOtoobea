package com.vehicleRental;

import java.time.LocalDate;

public class RentalTransaction {
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate rentalDate;
    private int rentalDays;

    public RentalTransaction(Customer customer, Vehicle vehicle, int rentalDays) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.rentalDate = LocalDate.now();
    }

    public String generateInvoice() {
        double totalCost = vehicle.calculateRentalCost(rentalDays);
        return String.format("Invoice:\nCustomer: %s\nVehicle: %s\nRental Days: %d\nTotal Cost: %.2f",
                customer.getName(), vehicle.getModel(), rentalDays, totalCost);
    }
}