package org.example;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JewelsAndStonesTest {
    @Test
    public void testCountJewelsInStones() {

        assertEquals(3, JewelsAndStones.countJewelsInStones("aA", "aAAbbbb"));

        assertEquals(0, JewelsAndStones.countJewelsInStones("z", "ZZ"));
    }
}
