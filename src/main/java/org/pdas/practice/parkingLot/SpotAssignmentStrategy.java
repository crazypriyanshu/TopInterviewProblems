package org.pdas.practice.parkingLot;

import java.util.List;

public interface SpotAssignmentStrategy {
    ParkingSpot findSpot(List<List<ParkingSpot>> levels, VehicleType vehicleType, List<Gate> gate);
}
