package com.lme.martianrobot.grid;

public class GridControllerException extends Exception {

    public GridControllerException(final String message, final Exception e) {
        super(message, e);
    }

    public GridControllerException(final String message) {
        super(message);
    }
}
