package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        World world = new World();

        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent africa = new Continent("Africa");

        BigDecimal countryPopulation = new BigDecimal("111111111");

        Country poland = new Country("Poland", countryPopulation);
        Country germany = new Country("Germany", countryPopulation);
        Country spain = new Country("Spain", countryPopulation);

        Country japan = new Country("Japan", countryPopulation);
        Country china = new Country("China", countryPopulation);
        Country mongolia = new Country("Mongolia", countryPopulation);

        Country egypt = new Country("Egypt", countryPopulation);
        Country morocco = new Country("Morocco", countryPopulation);
        Country ghana = new Country("Ghana", countryPopulation);

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);

        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(spain);
        asia.addCountry(japan);
        asia.addCountry(china);
        asia.addCountry(mongolia);
        africa.addCountry(egypt);
        africa.addCountry(morocco);
        africa.addCountry(ghana);

        //When
        BigDecimal worldPeopleQuantity = world.getPeopleQuantity();
        BigDecimal expectedWorldPeopleQuantity = new BigDecimal("999999999");

        //Then
        Assert.assertEquals(expectedWorldPeopleQuantity, worldPeopleQuantity);

    }
}
