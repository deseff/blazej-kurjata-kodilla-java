package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;

public class ShapeCollectorTestSuite {
    public static int testCounter = 0;

    @Before
    public void before() {
        System.out.println("Test case: begin");
    }

    @After
    public void after() {
        System.out.println("Test case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test suite: end");
    }

    @Test
    public void testAddFigure() {
        //Given
        Circle theShape = new Circle(2);
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addFigure(theShape);
        //Then
        Assert.assertEquals(theShape, shapeCollector.getFigure(0));
    }

    @Test
    public void testRemoveFigure() {
        //Given
        Square theShape = new Square(2);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(theShape);
        //When
        boolean result = shapeCollector.removeFigure(theShape);
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testRemoveFigureWhenListIsEmpty() {
        //Given
        Square theShape = new Square(4);
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        boolean result = shapeCollector.removeFigure(theShape);
        //Then
        Assert.assertFalse(result);
    }
    @Test
    public void testRemoveFigureOutOfRange() {
        //Given
        Square theShape = new Square(6);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(theShape);
        //When
        boolean result = shapeCollector.removeFigure(new Square(3));
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void setGetFigure() {
        //Given
        Triangle theShape = new Triangle(3,6);
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addFigure(theShape);
        //Then
        Assert.assertEquals(theShape, shapeCollector.getFigure(0));
    }

    @Test
    public void testShowFigures() {
        //Given
        Triangle theShape = new Triangle(2,4);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(theShape);
        //When
        ArrayList<Triangle> expectedResultList = new ArrayList<>();
        expectedResultList.add(theShape);
        //Then
        Assert.assertEquals(expectedResultList, shapeCollector.showFigures());
    }
}