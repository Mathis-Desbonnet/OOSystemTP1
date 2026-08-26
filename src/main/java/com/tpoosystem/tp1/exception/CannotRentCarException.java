package com.tpoosystem.tp1.exception;

public class CannotRentCarException extends RuntimeException {
    public CannotRentCarException() {
        super("Cannot rent car");
    }
}
