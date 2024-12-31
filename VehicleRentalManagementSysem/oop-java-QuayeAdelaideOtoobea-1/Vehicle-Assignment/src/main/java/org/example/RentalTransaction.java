package org.example;

public class RentalTransaction {

    private Customer customer;
    private Vehicle vehicle;
    private int days;
    private double totalCost;
    private boolean isReturned;

    public RentalTransaction(Customer customer, Vehicle vehicle, int days, double totalCost) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
        this.totalCost = totalCost;
        this.isReturned = false;
    }

    public Customer getCustomer() { return customer; }
    public Vehicle getVehicle() { return vehicle; }
    public int getDays() { return days; }
    public double getTotalCost() { return totalCost; }
    public boolean isReturned() { return isReturned; }

    public void markReturned() {
        this.isReturned = true;
    }

    @Override
    public String toString() {
        return "RentalTransaction{" +
                "customer=" + customer.getName() +
                ", vehicle=" + vehicle.getVehicleId() +
                ", days=" + days +
                ", totalCost=" + totalCost +
                ", isReturned=" + isReturned +
                '}';
    }
}