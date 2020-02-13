package com.lme.martianrobot;

import com.lme.martianrobot.grid.GridControllerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MartianRobotApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(MartianRobotApplication.class);

    private final GridController gridController;

    @Autowired
    public MartianRobotApplication(GridController gridController) {
        this.gridController = gridController;
    }

    public static void main(String[] args) {
        SpringApplication.run(MartianRobotApplication.class, args);
        logger.info("Application started");
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            try {
                if ("STATUS".equals(line)) {
                    for (String robotStatus : gridController.getRobotStatuses()) {
                        System.out.println(robotStatus);
                    }
                } else if ("QUIT".equals(line)) {
                    System.exit(0);
                } else {
                    gridController.interpretCommandSequence(line);
                }
            } catch (GridControllerException e) {
                System.console().writer().write("Error:" + e.getMessage());
            }
        }
        scanner.close();
    }
}


