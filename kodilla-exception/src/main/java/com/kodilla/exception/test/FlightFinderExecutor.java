package com.kodilla.exception.test;

public class FlightFinderExecutor {
    public static void main(String[] args) throws RouteNotFoundException {

        Flight flight1 = new Flight("Warsaw", "New York City");
        Flight flight2 = new Flight("Warsaw", "Munich");
        Flight flight3 = new Flight("New York City", "Warsaw");
        Flight flight4 = new Flight("New York City", "Munich");
        Flight flight5 = new Flight("Munich", "Warsaw");
        Flight flight6 = new Flight("Munich", "New York City");
        Flight flight7 = new Flight("Warsaw", "Palma De Mallorca");
        Flight flight8 = new Flight("Munich", "Lodz");

        FlightFinder flightFinder = new FlightFinder();

        try {
            flightFinder.findFlight(flight8);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
