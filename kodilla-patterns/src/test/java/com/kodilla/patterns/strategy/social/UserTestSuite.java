package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User will = new Millenials("Will Smith");
        User charlize = new YGeneration("Charlize Theron");
        User harrison = new ZGeneration("Harrison Ford");

        //When
        String willShares = will.sharePost();
        System.out.println("Will shares on " + willShares);
        String charlizeShares = charlize.sharePost();
        System.out.println("Charlize shares on " + charlizeShares);
        String harrisonShares = harrison.sharePost();
        System.out.println("Harrison shares on " + harrisonShares);

        //Then
        Assert.assertEquals("Facebook", willShares);
        Assert.assertEquals("Twitter", charlizeShares);
        Assert.assertEquals("Snapchat", harrisonShares);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User will = new Millenials("Will Smith");

        //When
        String willShares = will.sharePost();
        System.out.println("Will shares on " + willShares);
        will.setSocialPublisher(new TwitterPublisher());
        willShares = will.sharePost();
        System.out.println("Now Will shares on " + willShares);

        //Then
        Assert.assertEquals("Twitter", willShares);
    }
}
