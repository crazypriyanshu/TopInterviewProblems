package org.pdas.LLD.ElevatorSystem.models;

import org.pdas.LLD.ElevatorSystem.enums.DIRECTIONS;
import org.pdas.LLD.ElevatorSystem.interfaces.Panel;

import java.util.ArrayList;
import java.util.List;

public class OusidePanel implements Panel {
    private List<HallButton> hallButtons;
    public OusidePanel() {
        hallButtons = new ArrayList<>();
        hallButtons.add(new HallButton(false, DIRECTIONS.UP));
        hallButtons.add(new HallButton(false, DIRECTIONS.IDLE));
        hallButtons.add(new HallButton(false, DIRECTIONS.DOWN));
    }

    public void moveUp(){

    }

    public void moveDown(){

    }
}
