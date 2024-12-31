package com.vehiclerental;

public interface rentable {
    void rent(customer customer, int days);
    void returnVehicle();
}

