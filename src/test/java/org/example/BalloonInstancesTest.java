package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BalloonInstancesTest {
    @Test
    public void testMaxNumberOfBalloons() {

        assertEquals(1, BalloonInstances.maxNumberOfBalloons("nlaebolko"));

        assertEquals(2, BalloonInstances.maxNumberOfBalloons("loonbalxballpoon"));

        assertEquals(0, BalloonInstances.maxNumberOfBalloons("leetcode"));
    }
}
