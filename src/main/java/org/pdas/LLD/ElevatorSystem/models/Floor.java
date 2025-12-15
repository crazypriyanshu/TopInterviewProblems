package org.pdas.LLD.ElevatorSystem.models;

import org.pdas.LLD.ElevatorSystem.enums.FLOOR_NUMBER;

public class Floor {
    private FLOOR_NUMBER floorNumber;
    private OusidePanel outSidePanel;

    public Floor(FLOOR_NUMBER floorNumber, OusidePanel ousidePanel){
        this.floorNumber = floorNumber;
        this.outSidePanel = ousidePanel;
    }

    public OusidePanel getOusidePanel() {
        return outSidePanel;
    }

    public void setOusidePanel(OusidePanel ousidePanel) {
        this.outSidePanel = ousidePanel;
    }

    public FLOOR_NUMBER getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(FLOOR_NUMBER floorNumber) {
        this.floorNumber = floorNumber;
    }



}
