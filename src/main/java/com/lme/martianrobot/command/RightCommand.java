package com.lme.martianrobot.command;

import com.lme.martianrobot.grid.Grid;
import com.lme.martianrobot.grid.Position;
import com.lme.martianrobot.grid.Robot;

public class RightCommand implements com.lme.martianrobot.command.Command {

    @Override
    public void accept(final Grid grid, final Robot robot) {
        Position position = grid.getPositionFor(robot);
        grid.setRobotOrientation(robot, position.getOrientation().turnClockwise());
    }

}