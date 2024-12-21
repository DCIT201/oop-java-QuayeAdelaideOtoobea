package org.example;

public class Main {
    public static void main(String[] args) {
        // Example: Create a rental agency and test it
        var agency = new RentalAgency();

        // Adding vehicles
        agency.addVehicle(new Car("C1", "Sedan", 50));
        agency.addVehicle(new Motorcycle("M1", "Sportbike", 30));
        agency.addVehicle(new Truck("T1", "Truck", 80));

        System.out.println("Available vehicles added to the system.");
    }
}