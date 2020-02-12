package com.lme.martianrobot.grid;

import java.util.HashMap;
import java.util.Map;

public class Grid {

    private final Coordinate gridSize;
    private Map<Robot, Position> positions = new HashMap<>();

    public Grid(Coordinate gridSize) {
        this.gridSize = gridSize;
    }

    public void addRobot(final Robot robot, final Position initialPosition) {
        this.positions.put(robot, initialPosition);
    }

    public Position getPositionFor(final Robot robot) {
        return this.positions.get(robot);
    }

    public void setRobotOrientation(Robot robot, Orientation orientation) {
        positions.put(robot, new Position(positions.get(robot).getCoordinate(), orientation));
    }

    public void setRobotCoordinates(final Robot robot, final Coordinate newCoordinates) {
        positions.put(robot, new Position(newCoordinates, positions.get(robot).getOrientation()));
    }
}