package com.kodilla.good.patterns.flights;

public class Application {
    public static void main(String[] args) {
        FlightsRetriever flightsRetriever = new FlightsRetriever();
        FlightsCreator flightsCreator = flightsRetriever.retrieve();

        FlightSearcher flightSearcher = new FlightSearcher(flightsCreator.getFlightsList());
        flightSearcher.searchByDepartureAirport("Warszawa");
        flightSearcher.searchByArrivalAirport("Gdańsk");
        flightSearcher.searchWithStopover("Kraków", "Wrocław", "Łódź");
    }
}
