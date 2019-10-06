package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    public void findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> arrivalAirports = new HashMap<>();
        arrivalAirports.put("Warsaw", true);
        arrivalAirports.put("New York City", true);
        arrivalAirports.put("Munich", true);
        arrivalAirports.put("Palma De Mallorca", false);

        String destination = flight.getArrivalAirport();

        if (!arrivalAirports.containsKey(destination)) {
            throw new RouteNotFoundException("The arrival airport " + destination + " does not exist in our database. \n" +
                    "Please enter another destination airport.");
        }
        if (arrivalAirports.get(destination)) {
            System.out.println("You can fly directly to " + destination + ".");
        } else {
            System.out.println("Flight to " + destination + " is not possible.");
        }
    }
}
