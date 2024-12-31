package com.vehiclerental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentableTest {

    private customer testCustomer;
    private car testCar;
    private motorcycle testMotorcycle;
    private truck testTruck;

    @BeforeEach
    void setUp() {
        // Initialize test data
        testCustomer = new customer("Alice");
        testCar = new car("C001", "Sedan", 50.0);
        testMotorcycle = new motorcycle("M001", "Harley", 30.0);
        testTruck = new truck("T001", "BigRig", 100.0);
    }

    @Test
    void testRentCar() {
        // Ensure the car is available initially
        assertTrue(testCar.isAvailable(), "Car should be available before renting.");

        // Rent the car for 5 days
        testCar.rent(testCustomer, 5);

        // Ensure the car is marked as unavailable after renting
        assertFalse(testCar.isAvailable(), "Car should be unavailable after renting.");
    }

    @Test
    void testReturnCar() {
        // Rent the car for 5 days
        testCar.rent(testCustomer, 5);

        // Ensure the car is unavailable after renting
        assertFalse(testCar.isAvailable(), "Car should be unavailable after renting.");

        // Return the car
        testCar.returnVehicle();

        // Ensure the car is available again after returning
        assertTrue(testCar.isAvailable(), "Car should be available after returning.");
    }

    @Test
    void testRentMotorcycle() {
        // Ensure the motorcycle is available initially
        assertTrue(testMotorcycle.isAvailable(), "Motorcycle should be available before renting.");

        // Rent the motorcycle for 3 days
        testMotorcycle.rent(testCustomer, 3);

        // Ensure the motorcycle is marked as unavailable after renting
        assertFalse(testMotorcycle.isAvailable(), "Motorcycle should be unavailable after renting.");
    }

    @Test
    void testReturnMotorcycle() {
        // Rent the motorcycle for 3 days
        testMotorcycle.rent(testCustomer, 3);

        // Ensure the motorcycle is unavailable after renting
        assertFalse(testMotorcycle.isAvailable(), "Motorcycle should be unavailable after renting.");

        // Return the motorcycle
        testMotorcycle.returnVehicle();

        // Ensure the motorcycle is available again after returning
        assertTrue(testMotorcycle.isAvailable(), "Motorcycle should be available after returning.");
    }

    @Test
    void testRentTruck() {
        // Ensure the truck is available initially
        assertTrue(testTruck.isAvailable(), "Truck should be available before renting.");

        // Rent the truck for 7 days
        testTruck.rent(testCustomer, 7);

        // Ensure the truck is marked as unavailable after renting
        assertFalse(testTruck.isAvailable(), "Truck should be unavailable after renting.");
    }

    @Test
    void testReturnTruck() {
        // Rent the truck for 7 days
        testTruck.rent(testCustomer, 7);

        // Ensure the truck is unavailable after renting
        assertFalse(testTruck.isAvailable(), "Truck should be unavailable after renting.");

        // Return the truck
        testTruck.returnVehicle();

        // Ensure the truck is available again after returning
        assertTrue(testTruck.isAvailable(), "Truck should be available after returning.");
    }
}
