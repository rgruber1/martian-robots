package com.lme.martianrobot;

import com.lme.martianrobot.command.Command;
import com.lme.martianrobot.command.CommandRegistry;
import com.lme.martianrobot.grid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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

    void interpretCommandSequence(final String line) throws GridControllerException {
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
        }
    }

    private Position parseRobotPosition(final String[] line) throws GridControllerException {
        if (line.length != 3 || line[2].length() != 1) {
            throw new GridControllerException(
                    "Invalid position, expected 2 coordinates and an orientation but found " + Arrays.toString(line));
        }
        try {
            return new Position(new Coordinate(Integer.parseInt(line[0]), Integer.parseInt(line[1])),
                    Orientation.valueOf(line[2]));
        } catch (NumberFormatException exception) {
            throw new GridControllerException("Invalid start position for robot: " + Arrays.toString(line));
        }
    }

    private Coordinate parseGridCoords(final String next) throws GridControllerException {
        String[] gridCoords = next.trim().split(" ");
        if (gridCoords.length == 2) {
            try {
                return new Coordinate(parseInt(gridCoords[0]), parseInt(gridCoords[1]));
            } catch (NumberFormatException e) {
                throw new GridControllerException("Could not parse grid coordinates: " + Arrays.toString(gridCoords),
                        e);
            }
        }
        throw new GridControllerException("Expected grid size [X Y]");
    }
}
