package com.kodilla.good.patterns.flights;

public class AirportNotFoundException extends RuntimeException {
    public AirportNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
