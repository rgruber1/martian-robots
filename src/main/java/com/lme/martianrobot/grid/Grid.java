package com.lme.martianrobot.grid;

import java.util.*;

public class Grid {

    private final Coordinate gridSize;
    private Map<Robot, Position> positions = new LinkedHashMap<>();

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
        if (positions.get(robot).isLost()) {
            return;
        }

        positions.put(robot, new Position(positions.get(robot).getCoordinate(), orientation));
    }

    public void setRobotCoordinates(final Robot robot, final Coordinate newCoordinates) {
        Position position = positions.get(robot);
        if (position.isLost()) {
            return;
        }

        if (isLostCoordinates(newCoordinates)) {
            positions.put(robot, new Position(position.getCoordinate(), position.getOrientation(), true));
        } else {
            positions.put(robot, new Position(newCoordinates, position.getOrientation(), position.isLost()));
        }
    }

    private boolean isLostCoordinates(final Coordinate coordinate) {
        return coordinate.getX() > gridSize.getX() || coordinate.getY() > gridSize.getY();
    }

    public List<Robot> getRobots() {
        return new ArrayList<>(positions.keySet());
    }
}
