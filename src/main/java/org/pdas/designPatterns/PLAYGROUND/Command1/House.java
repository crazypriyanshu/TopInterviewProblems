package org.pdas.designPatterns.PLAYGROUND.Command1;

import java.util.ArrayList;
import java.util.List;

public class House {
    List<Room> rooms;
    public House(){
        rooms = new ArrayList<>();
    }
    public void addRoom(Room room){
        rooms.add(room);
    }
}
