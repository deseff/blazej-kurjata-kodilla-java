package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain<substractingResult> {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania.");

        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //pierwszy test jednostkowy

        System.out.println("Pierwszy test jednostkowy: kalkulator");
        System.out.println("Adding");

        Calculator calculator = new Calculator();
        int addingResult = calculator.add(3, 2);
        if (addingResult == 5) {
            System.out.println("Adding test OK.");
        } else {
            System.out.println("Adding test NOK.");
        }


        System.out.println("Substructing");

        Calculator calculator1 = new Calculator();
        int substractingResult = calculator1.subtract(3, 2);
        if (substractingResult == 1) {
            System.out.println("Substracting test OK");
        } else {
            System.out.println("Substracting test NOK");
        }

    }
}
