package com.lme.martianrobot.command;

import com.lme.martianrobot.grid.*;
import org.junit.Before;

public class AbstractCommandTest {

    Grid grid;
    Robot robot;

    @Before
    public void beforeTest() {
        grid = new Grid(new Coordinates(4, 4));
        robot = new Robot();
        grid.addRobot(robot, new Position(new Coordinates(2, 2), Orientation.NORTH));
    }
}
