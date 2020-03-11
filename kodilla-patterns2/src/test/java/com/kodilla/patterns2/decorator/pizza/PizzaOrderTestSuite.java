package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), theCost);

    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Your ordered pizza", description);
    }

    @Test
    public void testBasicPizzaOrderTakeAwayPackageAndDeliveryGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new BoxToGo(theOrder);
        theOrder = new FreeDeliveryDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(16), theCost);

    }

    @Test
    public void testBasicPizzaOrderTakeAwayPackageAndDeliveryGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new BoxToGo(theOrder);
        theOrder = new FreeDeliveryDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Your ordered pizza + box + free delivery", description);
    }

    @Test
    public void testBasicPizzaOrderDoubleCheeseHamMushroomsDriedTomatoesBoxToGoAndDeliveryGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new DoubleCheeseDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        theOrder = new MushroomsDecorator(theOrder);
        theOrder = new DriedTomatoesDecorator(theOrder);
        theOrder = new BoxToGo(theOrder);
        theOrder = new FreeDeliveryDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(26), theCost);

    }

    @Test
    public void testBasicPizzaOrderDoubleCheeseHamMushroomsDriedTomatoesBoxToGoAndDeliveryGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new DoubleCheeseDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        theOrder = new MushroomsDecorator(theOrder);
        theOrder = new DriedTomatoesDecorator(theOrder);
        theOrder = new BoxToGo(theOrder);
        theOrder = new FreeDeliveryDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Your ordered pizza " +
                "+ double cheese + ham + mushrooms + dried tomatoes " +
                "+ box + free delivery", description);
    }

}
