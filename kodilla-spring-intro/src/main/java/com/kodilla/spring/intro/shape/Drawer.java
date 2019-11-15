package com.kodilla.spring.intro.shape;

public class Drawer {
    final Shape shape;

    public Drawer(final Shape shape) {
        this.shape = shape;
    }

    public String doDrawing() {
        return shape.draw();
    }

    /*public void doDrawing() {

        //z poliformizmem
        Shape shape;

        shape = new Circle();
        shape.draw();

        shape = new Triangle();
        shape.draw();*/


    //bez poliformizmu
        /*Circle circle = new Circle();
        Triangle triangle = new Triangle();

        circle.draw();
        triangle.draw();*/
}
