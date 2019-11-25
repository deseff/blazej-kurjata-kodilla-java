package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING_TASK:
                return new ShoppingTask("Grocery", "Bread", 2.0);
            case PAINTING_TASK:
                return new PaintingTask("Landscape", "various colors", "Grand canyon");
            case DRIVING_TASK:
                return new DrivingTask("Journey", "Croatia", "Car");
            default:
                return null;
        }
    }
}
