package com.lme.martianrobot;

import com.lme.martianrobot.command.Command;
import com.lme.martianrobot.command.CommandRegistry;
import com.lme.martianrobot.grid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class GridController {

    private final CommandRegistry commandRegistry;
    private Grid grid = null;
    private Robot robot;

    @Autowired
    public GridController(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

    void interpretCommandSequence(String line) throws GridControllerException {
        line = line.trim().replaceAll(" +", " ");

        if (line.length() > 100) {
            throw new GridControllerException("line length should not exceed 100 characters - ignoring sequence");
        }
        if (grid == null) {
            grid = new Grid(parseGridCoords(line));
        } else if (robot == null) {
            robot = new Robot();
            grid.addRobot(robot, parseRobotPosition(line.split(" ")));
        } else {
            for (char ch : line.toCharArray()) {
                Command commandFor = commandRegistry.getCommandFor(ch);
                if (commandFor == null) {
                    throw new GridControllerException("Unknown command: " + ch);
                } else {
                    commandFor.accept(grid, robot);
                }
            }
            robot = null;
        }
    }

    private Position parseRobotPosition(final String[] component) throws GridControllerException {
        if (component.length != 3) {
            throw new GridControllerException("Invalid position, expected 2 coordinates and an orientation but found " +
                    Arrays.toString(component));
        }
        try {
            if (component[2].length() != 1) {
                throw new GridControllerException("Invalid orientation:" + component[2]);
            }
            Orientation orientation = Orientation.lookupByCode(component[2].charAt(0));
            if (orientation == null) {
                throw new GridControllerException("Unknown orientation:" + component[2]);
            }
            return new Position(new Coordinates(Integer.parseInt(component[0]), Integer.parseInt(component[1])),
                    orientation);
        } catch (NumberFormatException exception) {
            throw new GridControllerException("Invalid start position for robot: " + Arrays.toString(component));
        }
    }

    private Coordinates parseGridCoords(final String next) throws GridControllerException {
        String[] gridCoords = next.trim().split(" ");
        if (gridCoords.length == 2) {
            try {
                return new Coordinates(parseInt(gridCoords[0]), parseInt(gridCoords[1]));
            } catch (NumberFormatException e) {
                throw new GridControllerException("Could not parse grid coordinates: " + Arrays.toString(gridCoords),
                        e);
            }
        }
        throw new GridControllerException("Expected grid size [X Y]");
    }

    List<String> getRobotStatuses() {
        if (grid == null) {
            return Collections.singletonList("Grid yet to be initialized");
        } else {
            List<String> result = new ArrayList<>();
            for (Robot robot : grid.getRobots()) {
                result.add(grid.getPositionFor(robot).getShortDescription());
            }
            return result;
        }
    }

    public Grid getGrid() {
        return grid;
    }
}
