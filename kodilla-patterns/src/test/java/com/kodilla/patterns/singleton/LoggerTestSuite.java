package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("This is the very last log");
        //When
        String log = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("This is the very last log", log);
    }
}
