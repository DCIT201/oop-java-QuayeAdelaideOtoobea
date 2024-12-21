package com.rental.model;

public abstract class vehicle implements Rentable {
     private final String numberPlate;
     private  String model ;
     private  boolean isAvailable;
     private double baseRate;
    private Cutomer currentRenter;

     protected vehicle(String numberPlate, String model, boolean isAvailable, int carCondition, double baseRate, Cutomer currentRenter) {
         if(numberPlate ==null || numberPlate.trim().isEmpty()){
             throw new IllegalArgumentException("There is no number plate");
         }
         this.numberPlate = numberPlate;

s
         this.model = model;
         this.isAvailable = isAvailable;
         this.baseRate = baseRate;
         this.currentRenter = currentRenter;
     }
 }

