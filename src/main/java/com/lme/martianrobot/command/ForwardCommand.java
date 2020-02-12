package com.lme.martianrobot.command;

import com.lme.martianrobot.grid.*;

public class ForwardCommand implements Command {

    @Override
    public void accept(final Grid grid, final Robot robot) {
        Position position = grid.getPositionFor(robot);
        grid.setRobotCoordinates(robot, getMoveForwardCoordinates(position));
    }

    static Coordinate getMoveForwardCoordinates(final Position position) {
        switch (position.getOrientation()) {
            case NORTH:
                return new Coordinate(position.getCoordinate().getX(), position.getCoordinate().getY() + 1);
            case EAST:
                return new Coordinate(position.getCoordinate().getX() + 1, position.getCoordinate().getY());
            case SOUTH:
                return new Coordinate(position.getCoordinate().getX(), position.getCoordinate().getY() - 1);
            case WEST:
                return new Coordinate(position.getCoordinate().getX() - 1, position.getCoordinate().getY());
            default:
                return position.getCoordinate();
        }
    }
}
