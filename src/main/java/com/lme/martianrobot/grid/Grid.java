package com.lme.martianrobot.grid;

import java.util.*;

public class Grid {

    private final Coordinates gridSize;
    private Map<Robot, Position> positions = new LinkedHashMap<>();

    public Grid(Coordinates gridSize) {
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

        positions.put(robot, new Position(positions.get(robot).getCoordinates(), orientation));
    }

    public void setRobotCoordinates(final Robot robot, final Coordinates newCoordinates) {
        Position position = positions.get(robot);
        if (position.isLost()) {
            return;
        }

        if (isLostCoordinates(newCoordinates)) {
            positions.put(robot, new Position(position.getCoordinates(), position.getOrientation(), true));
        } else {
            positions.put(robot, new Position(newCoordinates, position.getOrientation(), position.isLost()));
        }
    }

    private boolean isLostCoordinates(final Coordinates coordinates) {
        return coordinates.getX() > gridSize.getX() || coordinates.getY() > gridSize.getY();
    }

    public List<Robot> getRobots() {
        return new ArrayList<>(positions.keySet());
    }
}
