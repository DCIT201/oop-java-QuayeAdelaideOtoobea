package org.example;

public interface Rentable {
    void rent(Customer customer, int days) throws VehicleNotAvaliableException;
    void returnVehicle();
}