package org.example;

public class Main {
    public static void main(String[] args) {

        // Create a Rental Agency
        RentalAgency agency = new RentalAgency("Super Rentals");

        // Create Vehicles
        Car car1 = Car.createCar("C001", "Toyota Corolla", 50);
        Car car2 = new Car("C002", "Honda Civic", 60, true, 35.0);
        Motorcycle moto1 = new Motorcycle("M001", "Yamaha R15", 40, 5.0);
        Truck truck1 = new Truck("T001", "Ford F-150", 80, 6.0);

        // Add vehicles
        agency.addVehicle(car1);
        agency.addVehicle(car2);
        agency.addVehicle(moto1);
        agency.addVehicle(truck1);

        // Create Customers
        Customer Kofi = new Customer("Kofi Sarpong");
        Customer Adelaide = new Customer("Adelaide");

        // Set ratings
        Kofi.setRating(5);
        Adelaide.setRating(5);

        // Print available vehicles
        agency.printAvailableVehicles();
        System.out.println();

        // Rent a car to Kofi
        RentalTransaction tx1 = agency.rentVehicle("C001", Kofi, 3);
        if (tx1 != null) {
            System.out.println("Total cost for John: " + tx1.getTotalCost());
        }
        System.out.println();

        // Rent a truck to Adelaide
        RentalTransaction tx2 = agency.rentVehicle("T001", Adelaide, 5);
        if (tx2 != null) {
            System.out.println("Total cost for Jane: " + tx2.getTotalCost());
        }
        System.out.println();

        // Print available vehicles after renting
        agency.printAvailableVehicles();
        System.out.println();

        // Kofi returns the car
        agency.returnVehicle("C001", Kofi);
        System.out.println();

        // Print all transactions
        agency.printAllTransactions();
        System.out.println();

        // Check loyalty points
        System.out.println(Kofi.getName() + " Loyalty Points: " + Kofi.getLoyaltyPoints());
        System.out.println(Adelaide.getName() + " Loyalty Points: " + Adelaide.getLoyaltyPoints());

        // Demonstrate method overloading in Car
        System.out.println("\nOverloaded cost calculation for " + car2.getVehicleId() +
                " (5 days, extra coverage): " + car2.calculateRentalCost(5, true));
    }
}