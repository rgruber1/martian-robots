package com.lme.martianrobot.grid;

import org.junit.jupiter.api.Test;

import static com.lme.martianrobot.grid.Orientation.*;
import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {

    @Test
    void turnClockwise() {
        assertEquals(EAST, NORTH.turnClockwise());
        assertEquals(SOUTH, EAST.turnClockwise());
        assertEquals(WEST, SOUTH.turnClockwise());
        assertEquals(NORTH, WEST.turnClockwise());
    }

    @Test
    void turnAntiClockwise() {
        assertEquals(WEST, NORTH.turnAntiClockwise());
        assertEquals(SOUTH, WEST.turnAntiClockwise());
        assertEquals(EAST, SOUTH.turnAntiClockwise());
        assertEquals(NORTH, EAST.turnAntiClockwise());
    }
}