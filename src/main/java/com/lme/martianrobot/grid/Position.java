package com.lme.martianrobot.grid;

public class Position {

    private Coordinate coordinate;
    private Orientation orientation;

    public Position(Coordinate coordinate, Orientation orientation) {
        this.coordinate = coordinate;
        this.orientation = orientation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
