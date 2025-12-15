package org.pdas.LLD.ElevatorSystem2;

public class Request {
    private final int floor;
    private final DIRECTION direction;
    private final boolean isInternal;

    public Request(int floor, DIRECTION direction, boolean isInternal){
        this.floor = floor;
        this.direction = direction;
        this.isInternal = isInternal;
    }

    public int getFloor() {
        return floor;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public boolean isInternal() {
        return isInternal;
    }

    @Override
    public String toString() {
        return "Request{" +
                "floor=" + floor +
                ", direction=" + direction +
                ", isInternal=" + isInternal +
                '}';
    }
}
