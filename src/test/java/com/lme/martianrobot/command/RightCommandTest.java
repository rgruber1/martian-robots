package com.lme.martianrobot.command;

import com.lme.martianrobot.grid.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RightCommandTest extends AbstractCommandTest {

    @Test
    void accept() {
        RightCommand command = new RightCommand();
        command.accept(grid, robot);
        assertEquals(Orientation.EAST, grid.getPositionFor(robot).getOrientation());
    }
}