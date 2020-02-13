package com.lme.martianrobot.grid;

public enum Orientation {

    NORTH('N'), EAST('E'), SOUTH('S'), WEST('W');

    private static Orientation[] values = values();

    private char code;

    Orientation(final char code) {
        this.code = code;
    }

    public static Orientation lookupByCode(final char character) {
        for (Orientation e : values()) {
            if (e.code == character) {
                return e;
            }
        }
        return null;
    }

    public Orientation turnClockwise() {
        return values[(this.ordinal() + 1) % values.length];
    }

    public Orientation turnAntiClockwise() {
        return values[this.ordinal() - 1 >= 0 ? this.ordinal() - 1 : values().length - 1];
    }

    public char getCode() {
        return code;
    }
}
