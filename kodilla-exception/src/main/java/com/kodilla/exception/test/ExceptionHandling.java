package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(1.0, 1.0);
        } catch (Exception e) {
            System.out.println("Variable x or/and variable y are out of range. Error:" + e);
        } finally {
            System.out.println("Spies like us");
        }
    }
}
