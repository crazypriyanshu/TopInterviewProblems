package org.pdas.arrays.mostAskedProblems.elevator;

public class Floor {
    private String floorName;
    private int floorPosition; // G - 0, 1st - 1, 2nd - 2 .. B1 - -1, B2 - -2 ...
    private Panel panel;

    public Floor(String floorName, int floorPosition){
        this.floorName = floorName;
        this.floorPosition = floorPosition;
        this.panel = new OutsidePanel();

    }
}
