package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.Set;

public class FlightsCreator {
    private Set<Flight> flightsList = new HashSet<>();

    public boolean addFlight(Flight flight) {
        flightsList.add(flight);
        return true;
    }

    public Set<Flight> getFlightsList() {
        return flightsList;
    }
}
