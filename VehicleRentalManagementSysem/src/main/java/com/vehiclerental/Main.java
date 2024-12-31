package com.vehiclerental;

public class Main {
    public static void main(String[] args) {
        // Create vehicles
        vehicle car = new car("C001", "Sedan", 50.0);
        vehicle motorcycle = new motorcycle("M001", "Harley", 30.0);
        vehicle truck = new truck("T001", "BigRig", 100.0);

        // Create rental agency and add vehicles
        rentalAgency agency = new rentalAgency();
        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
        agency.addVehicle(truck);

        // Create a customer
        customer customer = new customer("Alice");

        // Display fleet
        agency.displayFleet();

        // Rent a car
        customer.rentVehicle(car, 5);  // Rent the car for 5 days

        // Rent a motorcycle
        customer.rentVehicle(motorcycle, 3);  // Rent the motorcycle for 3 days

        // Try to rent a truck
        customer.rentVehicle(truck, 7);  // Rent the truck for 7 days

        // Return the car
        customer.returnVehicle(car);

        // Display updated fleet
        agency.displayFleet();
    }
}
