package com.lme.martianrobot.command;

import com.lme.martianrobot.grid.Orientation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RightCommandTest extends AbstractCommandTest {

    @Test
    public void accept() {
        RightCommand command = new RightCommand();
        command.accept(grid, robot);
        assertEquals(Orientation.EAST, grid.getPositionFor(robot).getOrientation());
    }
}