package com.lme.martianrobot.grid;

import org.junit.Test;

import static com.lme.martianrobot.grid.Orientation.*;
import static org.junit.Assert.assertEquals;

public class OrientationTest {

    @Test
    public void turnClockwise() {
        assertEquals(EAST, NORTH.turnClockwise());
        assertEquals(SOUTH, EAST.turnClockwise());
        assertEquals(WEST, SOUTH.turnClockwise());
        assertEquals(NORTH, WEST.turnClockwise());
    }

    @Test
    public void turnAntiClockwise() {
        assertEquals(WEST, NORTH.turnAntiClockwise());
        assertEquals(SOUTH, WEST.turnAntiClockwise());
        assertEquals(EAST, SOUTH.turnAntiClockwise());
        assertEquals(NORTH, EAST.turnAntiClockwise());
    }
}