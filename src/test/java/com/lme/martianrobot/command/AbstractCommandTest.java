package com.lme.martianrobot.command;

import com.lme.martianrobot.grid.*;
import org.junit.jupiter.api.BeforeEach;

public class AbstractCommandTest {

    Grid grid;
    Robot robot;

    @BeforeEach
    public void beforeTest() {
        grid = new Grid(new Coordinate(4, 4));
        robot = new Robot();
        grid.addRobot(robot, new Position(new Coordinate(2, 2), Orientation.NORTH));
    }
}
