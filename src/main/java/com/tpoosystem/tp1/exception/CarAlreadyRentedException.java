package com.tpoosystem.tp1.exception;

public class CarAlreadyRentedException extends RuntimeException {
    public CarAlreadyRentedException(String plateNumber, String endDate) {
        super("Car " + plateNumber + " already rented until " + endDate);
    }
}
