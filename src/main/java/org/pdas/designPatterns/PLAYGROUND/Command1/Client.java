package org.pdas.designPatterns.PLAYGROUND.Command1;

import org.pdas.designPatterns.PLAYGROUND.Command1.commands.Command;
import org.pdas.designPatterns.PLAYGROUND.Command1.commands.SwitchLightCOmmand;

public class Client {
    public static void main(String[] args) {
        House house = new House();
        house.addRoom(new BedRoom());
        house.addRoom(new Bathroom());
        house.addRoom(new Kitchen());
        FloorLamp floorLamp = new FloorLamp();
        floorLamp.switchLight();
        BedRoom bedRoom = new BedRoom();
        Command command = new SwitchLightCOmmand(new Light());
        Light light = new Light();
        System.out.println(light.isSwitchedOn());
        bedRoom.setCommand(command);
        Kitchen kitchen = new Kitchen();
        kitchen.setCommand(new SwitchLightCOmmand(light));

        kitchen.executeCommand();

    }
}
