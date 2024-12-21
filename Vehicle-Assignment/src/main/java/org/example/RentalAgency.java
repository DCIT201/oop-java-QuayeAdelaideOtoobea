package org.example;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {

    private String agencyName;
    private List<Vehicle> vehicleFleet;
    private List<RentalTransaction> transactions;

    public RentalAgency(String agencyName) {
        if (agencyName == null || agencyName.isEmpty()) {
            throw new IllegalArgumentException("Agency name cannot be null or empty.");
        }
        this.agencyName = agencyName;
        this.vehicleFleet = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public String getAgencyName() { return agencyName; }

    public void addVehicle(Vehicle vehicle) {
        if (!vehicleFleet.contains(vehicle)) {
            vehicleFleet.add(vehicle);
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicleFleet.remove(vehicle);
    }

    public RentalTransaction rentVehicle(String vehicleId, Customer customer, int days) {
        Vehicle vehicle = findVehicleById(vehicleId);
        if (vehicle == null) {
            System.out.println("Vehicle with ID " + vehicleId + " not found.");
            return null;
        }
        try {
            vehicle.rent(customer, days);
            double cost = vehicle.calculateRentalCost(days);

            RentalTransaction tx = new RentalTransaction(customer, vehicle, days, cost);
            transactions.add(tx);

            // Link vehicle to customer
            customer.addRental(vehicle);

            // Award loyalty points (example: 10 points per rental)
            customer.addLoyaltyPoints(10);

            return tx;
        } catch (VehicleNotAvaliableException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void returnVehicle(String vehicleId, Customer customer) {
        Vehicle vehicle = findVehicleById(vehicleId);
        if (vehicle == null) {
            System.out.println("Vehicle with ID " + vehicleId + " not found.");
            return;
        }

        vehicle.returnVehicle();
        customer.removeRental(vehicle);

        RentalTransaction tx = findOpenTransaction(customer, vehicle);
        if (tx != null) {
            tx.markReturned();
        }
    }

    private Vehicle findVehicleById(String vehicleId) {
        for (Vehicle v : vehicleFleet) {
            if (v.getVehicleId().equals(vehicleId)) {
                return v;
            }
        }
        return null;
    }

    private RentalTransaction findOpenTransaction(Customer customer, Vehicle vehicle) {
        for (RentalTransaction rt : transactions) {
            if (rt.getCustomer().equals(customer) &&
                    rt.getVehicle().equals(vehicle) &&
                    !rt.isReturned()) {
                return rt;
            }
        }
        return null;
    }

    public void printAllTransactions() {
        System.out.println("----- All Rental Transactions -----");
        for (RentalTransaction rt : transactions) {
            System.out.println(rt);
        }
    }

    public void printAvailableVehicles() {
        System.out.println("----- Available Vehicles -----");
        for (Vehicle v : vehicleFleet) {
            if (v.getIsAvailable()) {
                System.out.println(v);
            }
        }
    }
}