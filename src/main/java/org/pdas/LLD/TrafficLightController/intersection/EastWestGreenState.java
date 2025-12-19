package org.pdas.LLD.TrafficLightController.intersection;

import org.pdas.LLD.TrafficLightController.Direction;
import org.pdas.LLD.TrafficLightController.LightColor;

public class EastWestGreenState implements IntersectionState{
    @Override
    public void handle(IntersectionController context) throws InterruptedException {
        System.out.printf("\n --- Intersection %d : Cycle start -> NORTH-SOUTH-GREEN --- \n", context.getId());

        // turn north and south green and east and west Red
        context.getLight(Direction.EAST4).startGreen();
        context.getLight(Direction.WEST).startGreen();
        context.getLight(Direction.NORTH).setCurrentColor(LightColor.RED);
        context.getLight(Direction.SOUTH).setCurrentColor(LightColor.RED);

        // keep lights open till the greenDuration
        Thread.sleep(context.getGreenDuration());
        // after this duration :
        context.getLight(Direction.EAST4).transition();
        context.getLight(Direction.WEST).transition();
        Thread.sleep(context.getYellowDuration());
        // After yellow, transition to Red
        context.getLight(Direction.EAST4).transition();
        context.getLight(Direction.WEST).transition();
        // change the intersection state to NorthSouthGreenState
        context.setCurrentState(new NorthSouthGreenState());
    }
}
