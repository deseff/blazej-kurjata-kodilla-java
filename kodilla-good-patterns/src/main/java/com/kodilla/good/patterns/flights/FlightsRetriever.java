package com.kodilla.good.patterns.flights;

public class FlightsRetriever {
    FlightsCreator flightsCreator = new FlightsCreator();

    public FlightsCreator retrieve() {
        String city1 = "Łódź";
        String city2 = "Gdańsk";
        String city3 = "Warszawa";
        String city4 = "Kraków";
        String city5 = "Wrocław";

        flightsCreator.addFlight(new Flight(city1, city2));
        flightsCreator.addFlight(new Flight(city1, city3));
        flightsCreator.addFlight(new Flight(city1, city4));
        flightsCreator.addFlight(new Flight(city1, city5));

        flightsCreator.addFlight(new Flight(city2, city1));
        flightsCreator.addFlight(new Flight(city3, city1));
        flightsCreator.addFlight(new Flight(city4, city1));
        flightsCreator.addFlight(new Flight(city5, city1));

        flightsCreator.addFlight(new Flight(city3, city2));
        flightsCreator.addFlight(new Flight(city4, city2));
        flightsCreator.addFlight(new Flight(city5, city2));


        return flightsCreator;
    }
}
