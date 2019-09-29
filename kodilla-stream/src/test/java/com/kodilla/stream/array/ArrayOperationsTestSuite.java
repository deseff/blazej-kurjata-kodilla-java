package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int numbers[] = {1, 2, 3, 4, 5};
        double averageExpected = 3.0;

        //When
        double average = ArrayOperations.getAverage(numbers);

        //Then
        Assert.assertEquals(averageExpected, average, 0.001);
    }
}
