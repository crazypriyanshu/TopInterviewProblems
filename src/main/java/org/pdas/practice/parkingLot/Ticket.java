package org.pdas.practice.parkingLot;

public class Ticket {
    private String id;
    Spot spot;
    long entryTime;
    VehicleType vehicleType;

    Ticket(Spot spot, VehicleType vehicleType){
        this.id = "TICKET"+System.currentTimeMillis();
        this.entryTime = System.currentTimeMillis();
        this.spot = spot;
        this.vehicleType = vehicleType;
        System.out.println("Ticket created: "+toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", spot=" + spot +
                ", entryTime=" + entryTime +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
