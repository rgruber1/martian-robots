package com.lme.martianrobot.command;

import com.lme.martianrobot.grid.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeftCommandTest extends AbstractCommandTest {

    @Test
    void accept() {
        LeftCommand command = new LeftCommand();
        command.accept(grid, robot);
        assertEquals(Orientation.WEST, grid.getPositionFor(robot).getOrientation());
    }
}