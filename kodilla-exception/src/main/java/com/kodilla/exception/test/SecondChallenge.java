package com.kodilla.exception.test;

public class SecondChallenge {
    public String probablyIWillThrowException (Double x, double y) throws Exception {
        if(x >= 2 || x < 1 || y == 1.5) {
            throw new Exception( );
        }
        return "Done!";
    }
}
