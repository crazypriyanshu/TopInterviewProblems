package org.pdas.LLD.ElevatorSystem.models;

import org.pdas.LLD.ElevatorSystem.enums.DOOR_ACTION;
import org.pdas.LLD.ElevatorSystem.enums.FLOOR_NUMBER;
import org.pdas.LLD.ElevatorSystem.interfaces.Panel;

import java.util.ArrayList;
import java.util.List;

public class InsidePanel implements Panel {
    private List<ElevatorButton> elevatorButtonList;
    private List<DoorButtons> doorButtons;

    public InsidePanel(){
        elevatorButtonList = new ArrayList<>();
        doorButtons = new ArrayList<>();
        for (int i = 0; i < FLOOR_NUMBER.values().length; i++) {
            elevatorButtonList.add(new ElevatorButton(false, FLOOR_NUMBER.values()[i].ordinal()));
        }
        for (int i = 0; i <3 ; i++){
            doorButtons.add(new DoorButtons(false, DOOR_ACTION.values()[i]));
        }
    }

    public boolean pressFloorButton(int floorNumber){
        return elevatorButtonList.get(floorNumber).press();
    }

    public boolean pressDoorButton(int doorNumber){
        return doorButtons.get(doorNumber).press();
    }
}
