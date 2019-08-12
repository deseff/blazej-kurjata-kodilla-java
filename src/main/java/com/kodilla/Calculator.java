package com.kodilla;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }
}

class Counting {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sum = calculator.add(2, 3);
        int difference = calculator.substract(2, 3);

        System.out.println(sum);
        System.out.println(difference);
    }
}