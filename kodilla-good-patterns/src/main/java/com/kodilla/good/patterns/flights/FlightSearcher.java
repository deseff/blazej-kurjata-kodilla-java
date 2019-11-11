package com.kodilla.good.patterns.flights;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightSearcher {
    private Set<Flight> flightsList;

    public FlightSearcher(Set<Flight> flightsList) {
        this.flightsList = flightsList;
    }

    public void searchByDepartureAirport(String departureCity) {
        Optional<Flight> checkDepartureCity = flightsList.stream()
                .filter(f -> f.getDepartureAirport().equals(departureCity))
                .findAny();

        if (checkDepartureCity.isPresent()) {
            System.out.println("List of flights from " + departureCity + ":");
            flightsList.stream()
                    .filter(flight -> flight.getDepartureAirport().equals(departureCity))
                    .map(flight -> flight.toString())
                    .forEach(System.out::println);
            System.out.println();
        } else {
            throw new AirportNotFoundException("Departure airport not found. Please try again.");
        }
    }

    public void searchByArrivalAirport(String arrivalCity) {
        Optional<Flight> checkArrivalCity = flightsList.stream()
                .filter(f -> f.getArrivalAirport().equals(arrivalCity))
                .findAny();

        if (checkArrivalCity.isPresent()) {
            System.out.println("List od flights to " + arrivalCity + ":");
            flightsList.stream()
                    .filter(flight -> flight.getArrivalAirport().equals(arrivalCity))
                    .map(flight -> flight.toString())
                    .forEach(System.out::println);
            System.out.println();
        } else {
            throw new AirportNotFoundException("Arrival airport not found. Please try again.");
        }
    }

    public void searchWithStopover(String departureCity, String arrivalCity, String transferCity) {
        Optional<Flight> checkDepartureCity = flightsList.stream()
                .filter(f -> f.getDepartureAirport().equals(departureCity))
                .findAny();

        Optional<Flight> checkArrivalCity = flightsList.stream()
                .filter(f -> f.getArrivalAirport().equals(arrivalCity))
                .findAny();

        Optional<Flight> checkArrivalCityAsTransfer = flightsList.stream()
                .filter(f -> f.getArrivalAirport().equals(transferCity) && f.getDepartureAirport().equals(departureCity))
                .findAny();

        Optional<Flight> checkDepartureCityAsTransfer = flightsList.stream()
                .filter(f -> f.getDepartureAirport().equals(transferCity) && f.getArrivalAirport().equals(arrivalCity))
                .findAny();

        if (checkDepartureCity.isPresent() &&
                checkArrivalCity.isPresent() &&
                checkArrivalCityAsTransfer.isPresent() &&
                checkDepartureCityAsTransfer.isPresent()) {

            System.out.println("List of flights from " + departureCity + " to " + arrivalCity + " with stopover in " + transferCity + ":");
            List<Flight> flightsListWithStopover = flightsList.stream()
                    .filter(f -> f.getDepartureAirport().equals(departureCity) && f.getArrivalAirport().equals(transferCity))
                    .collect(Collectors.toList());
            flightsList.stream()
                    .filter(f -> f.getDepartureAirport().equals(transferCity) && f.getArrivalAirport().equals(arrivalCity))
                    .collect(Collectors.toCollection(() -> flightsListWithStopover));
            flightsListWithStopover.stream()
                    .forEach(System.out::println);
            System.out.println();
        } else {
            throw new AirportNotFoundException("At least one of entered airports not found " +
                    "or flight from " + departureCity + " to " + arrivalCity + " via " + transferCity + " is not possible. Please try again.");
        }
    }
}
