package com.lme.martianrobot.command;

import com.lme.martianrobot.grid.Orientation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeftCommandTest extends AbstractCommandTest {

    @Test
    public void accept() {
        LeftCommand command = new LeftCommand();
        command.accept(grid, robot);
        assertEquals(Orientation.WEST, grid.getPositionFor(robot).getOrientation());
    }
}