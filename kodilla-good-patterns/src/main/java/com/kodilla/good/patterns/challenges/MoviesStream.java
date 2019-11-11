package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class MoviesStream {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        String titlesAndExclamations = movieStore.getMovies().entrySet().stream()
                .flatMap(movies -> movies.getValue().stream())
                .collect(Collectors.joining("!"));

        System.out.println(titlesAndExclamations);
    }
}
