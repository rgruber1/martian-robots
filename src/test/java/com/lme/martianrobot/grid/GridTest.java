package com.lme.martianrobot.grid;

import org.junit.jupiter.api.Test;

import static com.lme.martianrobot.grid.Orientation.*;
import static com.lme.martianrobot.grid.Orientation.EAST;
import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void setRobotCoordinates_ValidMove() {
        Grid grid = new Grid(new Coordinate(4, 4));
        Robot robot = new Robot();
        grid.addRobot(robot, new Position(new Coordinate(2, 2), NORTH));
        grid.setRobotCoordinates(robot, new Coordinate(2, 3));
        assertEquals(new Coordinate(2, 3), grid.getPositionFor(robot).getCoordinate());
        assertFalse(grid.getPositionFor(robot).isLost());
    }

    @Test
    void setRobotCoordinates_MoveOffGrid_MarkAsLostAndImmovable() {
        Grid grid = new Grid(new Coordinate(4, 4));
        Robot robot = new Robot();
        grid.addRobot(robot, new Position(new Coordinate(4, 4), NORTH));
        assertFalse(grid.getPositionFor(robot).isLost());

        grid.setRobotCoordinates(robot, new Coordinate(4, 5));
        assertEquals(new Coordinate(4, 5), grid.getPositionFor(robot).getCoordinate());
        assertTrue(grid.getPositionFor(robot).isLost());

        grid.setRobotCoordinates(robot, new Coordinate(4, 4));
        assertEquals(new Coordinate(4, 5), grid.getPositionFor(robot).getCoordinate());
        assertTrue(grid.getPositionFor(robot).isLost());

        grid.setRobotOrientation(robot, EAST);
        assertEquals(NORTH, grid.getPositionFor(robot).getOrientation());
    }

}