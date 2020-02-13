package com.lme.martianrobot.grid;

public class Position {

    private final boolean isLost;
    private Coordinates coordinates;
    private Orientation orientation;

    public Position(Coordinates coordinates, Orientation orientation) {
        this.coordinates = coordinates;
        this.orientation = orientation;
        this.isLost = false;
    }

    public Position(Coordinates coordinates, Orientation orientation, boolean isLost) {
        this.coordinates = coordinates;
        this.orientation = orientation;
        this.isLost = isLost;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public boolean isLost() {
        return isLost;
    }

    public String getShortDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getCoordinates().getX()).append(" ").append(getCoordinates().getY()).append(" ")
                .append(getOrientation().getCode());
        if (isLost()) {
            stringBuilder.append(" LOST");
        }
        return stringBuilder.toString();
    }
}
