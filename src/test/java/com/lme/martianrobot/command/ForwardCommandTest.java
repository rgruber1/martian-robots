package com.lme.martianrobot.command;

import com.lme.martianrobot.grid.Coordinates;
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
        assertEquals(new Coordinates(2, 2), positionFor.getCoordinates());

        command.accept(grid, robot);
        assertEquals(new Coordinates(2, 3), grid.getPositionFor(robot).getCoordinates());
    }

    @Test
    public void get() {
        assertEquals(new Coordinates(2, 3), getMoveForwardCoordinates(new Position(new Coordinates(2, 2), NORTH)));
        assertEquals(new Coordinates(3, 2), getMoveForwardCoordinates(new Position(new Coordinates(2, 2), EAST)));
        assertEquals(new Coordinates(2, 1), getMoveForwardCoordinates(new Position(new Coordinates(2, 2), SOUTH)));
        assertEquals(new Coordinates(1, 2), getMoveForwardCoordinates(new Position(new Coordinates(2, 2), WEST)));
    }
}