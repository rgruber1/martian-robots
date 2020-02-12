package com.lme.martianrobot.grid;

public class GridException extends Exception {

    public GridException(final String message, final Exception e) {
        super(message, e);
    }

    public GridException(final String message) {
        super(message);
    }
}
