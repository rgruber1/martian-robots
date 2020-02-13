package com.lme.martianrobot.grid;

import org.junit.Test;

import static com.lme.martianrobot.grid.Orientation.EAST;
import static com.lme.martianrobot.grid.Orientation.NORTH;
import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void setRobotCoordinates_ValidMove() {
        Grid grid = new Grid(new Coordinates(4, 4));
        Robot robot = new Robot();
        grid.addRobot(robot, new Position(new Coordinates(2, 2), NORTH));
        grid.setRobotCoordinates(robot, new Coordinates(2, 3));
        assertEquals(new Coordinates(2, 3), grid.getPositionFor(robot).getCoordinates());
        assertFalse(grid.getPositionFor(robot).isLost());
    }

    @Test
    public void setRobotCoordinates_MoveOffGrid_MarkAsLost_ShouldNotAllowCoordinatesChange() {
        Grid grid = new Grid(new Coordinates(4, 4));
        Robot robot = new Robot();
        grid.addRobot(robot, new Position(new Coordinates(4, 4), NORTH));
        assertFalse(grid.getPositionFor(robot).isLost());

        grid.setRobotCoordinates(robot, new Coordinates(4, 5));
        assertEquals(new Coordinates(4, 4), grid.getPositionFor(robot).getCoordinates());
        assertTrue(grid.getPositionFor(robot).isLost());

        grid.setRobotCoordinates(robot, new Coordinates(4, 3));
        assertEquals(new Coordinates(4, 4), grid.getPositionFor(robot).getCoordinates());
        assertTrue(grid.getPositionFor(robot).isLost());
    }

    @Test
    public void setRobotCoordinates_MoveOffGrid_MarkAsLost_ShouldNotAllowOrientationChange() {
        Grid grid = new Grid(new Coordinates(4, 4));
        Robot robot = new Robot();
        grid.addRobot(robot, new Position(new Coordinates(4, 4), NORTH));
        assertFalse(grid.getPositionFor(robot).isLost());

        grid.setRobotCoordinates(robot, new Coordinates(4, 5));
        assertEquals(new Coordinates(4, 4), grid.getPositionFor(robot).getCoordinates());
        assertTrue(grid.getPositionFor(robot).isLost());

        grid.setRobotOrientation(robot, EAST);
        assertEquals(NORTH, grid.getPositionFor(robot).getOrientation());
        assertTrue(grid.getPositionFor(robot).isLost());
    }

}