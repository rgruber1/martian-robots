package com.lme.martianrobot.command;

import com.lme.martianrobot.grid.Coordinate;
import com.lme.martianrobot.grid.Position;
import org.junit.Test;

import static com.lme.martianrobot.command.ForwardCommand.getMoveForwardCoordinates;
import static com.lme.martianrobot.grid.Orientation.*;
import static org.junit.Assert.assertEquals;

public class ForwardCommandTest extends AbstractCommandTest {

    @Test
    public void accept() {
        Position positionFor = grid.getPositionFor(robot);
        ForwardCommand command = new ForwardCommand();
        assertEquals(NORTH, positionFor.getOrientation());
        assertEquals(new Coordinate(2, 2), positionFor.getCoordinate());

        command.accept(grid, robot);
        assertEquals(new Coordinate(2, 3), grid.getPositionFor(robot).getCoordinate());
    }

    @Test
    public void get() {
        assertEquals(new Coordinate(2, 3), getMoveForwardCoordinates(new Position(new Coordinate(2, 2), NORTH)));
        assertEquals(new Coordinate(3, 2), getMoveForwardCoordinates(new Position(new Coordinate(2, 2), EAST)));
        assertEquals(new Coordinate(2, 1), getMoveForwardCoordinates(new Position(new Coordinate(2, 2), SOUTH)));
        assertEquals(new Coordinate(1, 2), getMoveForwardCoordinates(new Position(new Coordinate(2, 2), WEST)));
    }
}