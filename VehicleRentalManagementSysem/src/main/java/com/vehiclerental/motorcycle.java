package com.vehiclerental;

    public class motorcycle extends vehicle implements rentable {

        public motorcycle(String vehicleId, String model, double baseRentalRate) {
            super(vehicleId, model, baseRentalRate, true); // Available by default
        }

        @Override
        public double calculateRentalCost(int days) {
            return getBaseRentalRate() * days * 0.8;  // Discounted rate for motorcycles
        }

        @Override
        public boolean isAvailableForRental() {
            return isAvailable();
        }

        @Override
        public void rent(customer customer, int days) {
            if (isAvailableForRental()) {
                System.out.println("Motorcycle rented to " + customer.getName() + " for " + days + " days.");
                setAvailable(false);  // Mark motorcycle as unavailable after renting
            } else {
                System.out.println("Motorcycle is not available for rental.");
            }
        }

        @Override
        public void returnVehicle() {
            System.out.println("Motorcycle returned.");
            setAvailable(true);  // Mark motorcycle as available after returning
        }

        @Override
        public String toString() {
            return "Motorcycle [ID=" + getVehicleId() + ", Model=" + getModel() + ", Rate=" + getBaseRentalRate() + "]";
        }
    }
