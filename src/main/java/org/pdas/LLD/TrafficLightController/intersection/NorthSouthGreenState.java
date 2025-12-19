package org.pdas.LLD.TrafficLightController.intersection;

import org.pdas.LLD.TrafficLightController.Direction;
import org.pdas.LLD.TrafficLightController.LightColor;

public class NorthSouthGreenState implements IntersectionState{
    @Override
    public void handle(IntersectionController context) throws InterruptedException {
        System.out.printf("\n --- Intersection %d : Cycle start -> NORTH-SOUTH-GREEN --- \n", context.getId());

        // turn north and south green and east and west Red
        context.getLight(Direction.NORTH).startGreen();
        context.getLight(Direction.SOUTH).startGreen();
        context.getLight(Direction.EAST4).setCurrentColor(LightColor.RED);
        context.getLight(Direction.WEST).setCurrentColor(LightColor.RED);

        // keep lights open till the greenDuration
        Thread.sleep(context.getGreenDuration());
        // after this duration :
        context.getLight(Direction.NORTH).transition();
        context.getLight(Direction.SOUTH).transition();
        Thread.sleep(context.getYellowDuration());
        // After yellow, transition to Red
        context.getLight(Direction.NORTH).transition();
        context.getLight(Direction.SOUTH).transition();
        context.setCurrentState(new EastWestGreenState());

    }
}
