package com.kodilla;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public String generateToken() {
        Random random = new Random();
        /*byte bytes[] = new byte[1];
        random.nextBytes(bytes);
        String token = bytes.toString();*/

        int leftLimit = 48; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;

        String token = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
        String tokenTime = timeStamp.format(timeFormatter);
        //String to = tokenTime.toString();
        return token + tokenTime;
    }
}


class Counting {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sum = calculator.add(2, 3);
        int difference = calculator.substract(2, 3);

        System.out.println(sum);
        System.out.println(difference);

        System.out.println("Token: " + calculator.generateToken());
    }
}