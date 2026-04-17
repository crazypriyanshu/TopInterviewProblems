package org.pdas.practice.parkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * What all parking lot has ?
 * 1. Should have an entry and exit - Gate - EntryGate, ExitGate
 * 2. Should have levels - like level1, level2
 * 3. Should have parkingSpots - ParkingSpots - parking spot can be for a type of Vehicle
 * 4. At entry - it should create a ticket
 * 5. At exit - it should give a price to pay, based on the timing
 * */
public class ParkingLot {
    public static volatile ParkingLot INSTANCE;
    List<List<ParkingSpot>> parkingSpotLevel;
    private final ReentrantLock lock = new ReentrantLock();
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private List<Gate> gates = new ArrayList<>();
    /**
     * Parking lot should be a singleton instance
     * */
    private ParkingLot(){
        this.gates = new ArrayList<>();
        this.spotAssignmentStrategy = new NearestSpotStrategy();
        this.parkingSpotLevel = new ArrayList<>();

    }


    public static ParkingLot getINSTANCE() {
        if (INSTANCE == null){
            synchronized (ParkingLot.class){
                if (INSTANCE == null){
                    INSTANCE = new ParkingLot();
                }
            }
        }
        return INSTANCE;
    }

    public Ticket allowEntry(Vehicle vehicle){
        VehicleType vehicleType = vehicle.getVehicleType();
        lock.lock();
        try {
            ParkingSpot spot = spotAssignmentStrategy.findSpot(parkingSpotLevel, vehicleType, gates);
            if (spot != null){
                spot.setParkingSpotStatus(ParkingSpotStatus.BOOKED);
                return new Ticket(new Spot(spot.rowNumber, spot.colNumber), vehicleType);
            }
            throw new RuntimeException("Parking not allowed, as parking is full for: "+ vehicleType);


        } finally {
            lock.unlock();
        }

    }

    public void displayCurrentStatus(){
        int n = this.parkingSpotLevel.size();
        int m = this.parkingSpotLevel.get(0).size();
        int emptyMediumSpaces = 0;
        int emptyLargeSpaces = 0;
        int emptySmallSpaces = 0;
        int totalSPace = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                totalSPace++;
                if (parkingSpotLevel.get(i).get(j).parkingSpotStatus == ParkingSpotStatus.AVAILABLE){
                    if (parkingSpotLevel.get(i).get(j).vehicleType == VehicleType.MEDIUM){
                        emptyMediumSpaces++;
                    } else if (parkingSpotLevel.get(i).get(j).vehicleType == VehicleType.LARGE) {
                        emptyLargeSpaces++;
                    } else if (parkingSpotLevel.get(i).get(j).vehicleType == VehicleType.SMALL) {
                        emptySmallSpaces++;
                    }
                }
            }

        }
        System.out.println("************************************");
        System.out.println("Total space: "+totalSPace);
        System.out.println("Total empty small: "+emptySmallSpaces);
        System.out.println("Total empty large: "+emptyLargeSpaces);
        System.out.println("Total empty medium: "+emptyMediumSpaces);
        System.out.println("Total occupied at this time: "+(totalSPace-(emptyLargeSpaces+emptyMediumSpaces+emptySmallSpaces)));
        System.out.println("**************************************");
    }

    public int calculatePrice(Ticket ticket){
        long duration = System.currentTimeMillis() - ticket.getEntryTime();
        double hours = duration/(1000.00*60*60*100);
        double rate = switch (ticket.vehicleType){
            case MEDIUM -> 10.45;
            case SMALL -> 10.25;
            case LARGE -> 10.55;
            case GATE_ENTRY -> 0.0;
            case GATE_EXIT -> 0.0;
        };
        System.out.println("Ticket id: "+ticket.getId()+ " has to pay: Rs "+((int) rate*hours));
        markExit(ticket);
        return (int) ((int) rate*hours);
    }

    private void markExit(Ticket ticket){
        int row = ticket.spot.getRow();
        int col = ticket.spot.getCol();
        System.out.println("Making row: "+row+" col: "+col+" as AVAILABLE");
        this.parkingSpotLevel.get(row).get(col).parkingSpotStatus = ParkingSpotStatus.AVAILABLE;
        displayCurrentStatus();
    }

    /**
     * has to be executed first as this creates a parking lot with entry and exit gates
     * */
    public void createNByNParkingLot(int rows, int cols){
        if (rows <= 1 && cols <= 1) {
            throw new RuntimeException("Cannot create any parking lot with less than 2*2");
        }

        this.parkingSpotLevel = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<ParkingSpot> currentLevel = new ArrayList<>();

            for (int j = 0; j < cols; j++) {
                ParkingSpot spot = new ParkingSpot(i, j);
                // top left or bottom right are entry gates
                if ((i == 0 && j == 0) || (i == rows-1 && j == cols-1)){
                    gates.add(new Gate(i, j));
                    spot.setParkingSpotStatus(ParkingSpotStatus.ENTRY_GATE);
                }
                // bottom left or top right are exit gates always
                else if ((i== rows-1 && cols == 0) || (i == 0 && cols == cols-1)){
                    gates.add(new Gate(i, j));
                    spot.setParkingSpotStatus(ParkingSpotStatus.EXIT_GATE);
                }
                else {
                    spot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
                    if (j%2 == 0){

                    }
                }

            }
            this.parkingSpotLevel.add(currentLevel);
        }

        System.out.println("Created "+rows+"*"+cols+" parking lot");
        displayParkingLot();

    }

    private void displayParkingLot(){
        for (int i = 0; i < parkingSpotLevel.size(); i++) {
            for (int j = 0; j < parkingSpotLevel.getFirst().size(); j++) {
                System.out.print(" ||"+parkingSpotLevel.get(i).get(j).parkingSpotStatus+"||  ");
            }
            System.out.println();
        }
    }





}
