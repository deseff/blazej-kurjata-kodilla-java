package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("sesame")
                .burgers(2)
                .sauce("standard")
                .ingredient("salad")
                .ingredient("onion")
                .ingredient("bacon")
                .ingredient("cheese")
                .build();
        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        int howManyBurgers = bigmac.getBurgers();
        String bunType = bigmac.getBun();
        String sauceType = bigmac.getSauce();

        //Then
        Assert.assertEquals(4, howManyIngredients);
        Assert.assertEquals(2, howManyBurgers);
        Assert.assertEquals("sesame", bunType);
        Assert.assertEquals("standard", sauceType);
    }
}
