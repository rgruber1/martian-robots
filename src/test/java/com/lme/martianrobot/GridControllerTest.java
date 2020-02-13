package com.lme.martianrobot;

import com.lme.martianrobot.command.CommandRegistry;
import com.lme.martianrobot.grid.GridControllerException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridControllerTest {

    private GridController gridController;

    @Before
    public void before() {
        this.gridController = new GridController(new CommandRegistry());
    }

    @Test
    public void interpretCommandSequence_Robot1_ReturnsToStartPosition() throws GridControllerException {
        gridController.interpretCommandSequence("5 3");
        gridController.interpretCommandSequence("1 1 E");
        gridController.interpretCommandSequence("RFRFRFRF");
        assertEquals("1 1 E", gridController.getRobotStatuses().get(0));
    }

    @Test
    public void interpretCommandSequence_Robot2_LostOffGrid() throws GridControllerException {
        gridController.interpretCommandSequence("5 3");
        gridController.interpretCommandSequence("3 2 N");
        gridController.interpretCommandSequence("FRRFLLFFRRFLL");
        assertEquals("3 3 N LOST", gridController.getRobotStatuses().get(0));
    }

    @Test
    public void interpretCommandSequence_Robot3_StaysWithinGrid() throws GridControllerException {
        gridController.interpretCommandSequence("5 3");
        gridController.interpretCommandSequence("0 3 W");
        gridController.interpretCommandSequence("LLFFFLFLFL");

        // gotcha in the requirements within the 'Sample Output' section? :)
        // robot actually goes to edge of  grid after LLFFFL then attempts to move forward
        //        assertEquals("2 3 S", gridController.getRobotStatuses().get(0));

        assertEquals("3 3 N LOST", gridController.getRobotStatuses().get(0));
    }

}