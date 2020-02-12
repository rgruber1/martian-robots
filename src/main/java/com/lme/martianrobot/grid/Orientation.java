package com.lme.martianrobot.grid;

public enum Orientation {

    NORTH, EAST, SOUTH, WEST;

    private static Orientation[] values = values();

    public Orientation turnClockwise() {
        return values[(this.ordinal() + 1) % values.length];
    }

    public Orientation turnAntiClockwise() {
        return values[this.ordinal() - 1 >= 0 ? this.ordinal() - 1 : values().length - 1];
    }
}
