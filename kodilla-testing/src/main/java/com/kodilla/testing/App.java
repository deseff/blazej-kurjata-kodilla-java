package com.kodilla.testing;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        TicTacToeController controller = new TicTacToeController();

        for (int col = 0; col < 3; col++) {

            for (int row = 0; row < 3; row++) {

                Square square = new Square(col, row, Color.LIGHTSALMON, controller);
                grid.add(square, col, row);
                controller.addSquare(col + "-" + row, square);
            }
        }

        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setTitle("Test");
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
