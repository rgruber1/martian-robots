package com.lme.martianrobot.grid;

public class Position {

    private final boolean isLost;
    private Coordinate coordinate;
    private Orientation orientation;

    public Position(Coordinate coordinate, Orientation orientation) {
        this.coordinate = coordinate;
        this.orientation = orientation;
        this.isLost = false;
    }

    public Position(Coordinate coordinate, Orientation orientation, boolean isLost) {
        this.coordinate = coordinate;
        this.orientation = orientation;
        this.isLost = isLost;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public boolean isLost() {
        return isLost;
    }
}
