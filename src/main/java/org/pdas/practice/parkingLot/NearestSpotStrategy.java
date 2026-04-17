package org.pdas.practice.parkingLot;

import java.util.List;
import java.util.PriorityQueue;

public class NearestSpotStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSpot findSpot(List<List<ParkingSpot>> levels, VehicleType vehicleType, List<Gate> gates) {
        PriorityQueue<ParkingSpot> parkingSpots = new PriorityQueue<>((s1, s2) -> {
            int mind1 = Integer.MAX_VALUE;
            int mind2 = Integer.MAX_VALUE;
            for (Gate gate: gates){
                int d1 = calculateDistance(s1, gate);
                int d2 = calculateDistance(s2, gate);
                mind1 = Math.min(d1, mind1);
                mind2 = Math.min(d2, mind2);

            }

            return Integer.compare(mind1, mind2);
        });

        for (List<ParkingSpot> floor: levels){
            for (ParkingSpot spot: floor){
                if (spot.parkingSpotStatus == ParkingSpotStatus.AVAILABLE && spot.getVehicleType() == vehicleType){
                    parkingSpots.add(spot);
                }
            }
        }

        return parkingSpots.poll();
    }

    private int calculateDistance(ParkingSpot s, Gate g){
        return Math.abs(s.rowNumber- g.getRow()) + Math.abs(s.colNumber- g.getCol());
    }
}
