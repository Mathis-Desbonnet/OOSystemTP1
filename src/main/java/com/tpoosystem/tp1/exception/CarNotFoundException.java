package com.tpoosystem.tp1.exception;

public class CarNotFoundException extends RuntimeException{

    public CarNotFoundException(String plateNumber) {
        super("Car not found with plate number " + plateNumber);
    }

}
