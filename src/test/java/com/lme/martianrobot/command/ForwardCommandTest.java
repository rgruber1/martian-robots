package com.lme.martianrobot.command;

import com.lme.martianrobot.grid.*;
import org.junit.jupiter.api.Test;

import static com.lme.martianrobot.command.ForwardCommand.*;
import static com.lme.martianrobot.grid.Orientation.*;
import static com.lme.martianrobot.grid.Orientation.NORTH;
import static org.junit.jupiter.api.Assertions.*;

class ForwardCommandTest extends AbstractCommandTest {

    @Test
    void accept() {
        Position positionFor = grid.getPositionFor(robot);
        ForwardCommand command = new ForwardCommand();
        assertEquals(NORTH, positionFor.getOrientation());
        assertEquals(new Coordinate(2, 2), positionFor.getCoordinate());

        command.accept(grid, robot);
        assertEquals(new Coordinate(2, 3), grid.getPositionFor(robot).getCoordinate());
    }

    @Test
    void get() {
        assertEquals(new Coordinate(2, 3), getMoveForwardCoordinates(new Position(new Coordinate(2, 2), NORTH)));
        assertEquals(new Coordinate(3, 2), getMoveForwardCoordinates(new Position(new Coordinate(2, 2), EAST)));
        assertEquals(new Coordinate(2, 1), getMoveForwardCoordinates(new Position(new Coordinate(2, 2), SOUTH)));
        assertEquals(new Coordinate(1, 2), getMoveForwardCoordinates(new Position(new Coordinate(2, 2), WEST)));
    }
}