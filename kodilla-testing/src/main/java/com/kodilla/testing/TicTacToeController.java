package com.kodilla.testing;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.paint.Color;

public class TicTacToeController {

    private Map<String, Square> squares = new HashMap<>();

    void addSquare(String coordinates, Square square) {
        squares.put(coordinates, square);
    }

    public void handleOnMouseClicked(Square square) {

        int col = square.getCol();
        int row = square.getRow();

        System.out.println("Clicked col " + col + " row " + row);

        if (square.getFill().equals(Color.BLACK)) {
            square.setFill(Color.ORANGERED);
        } else {
            square.setFill(Color.BLACK);
        }
    }
}
