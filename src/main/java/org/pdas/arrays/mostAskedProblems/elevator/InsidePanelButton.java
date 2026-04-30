package org.pdas.arrays.mostAskedProblems.elevator;

public class InsidePanelButton extends Button{
    private final int destinationFloor;
    public InsidePanelButton(int id, int floor) {
        super(id, String.valueOf(floor));
        this.destinationFloor = floor;
    }

    @Override
    public void onPress(){
        System.out.println("Inside Panel received request to go to floor: "+destinationFloor);
    }

}
