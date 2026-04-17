package org.pdas.practice.parkingLot;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = ParkingLot.getINSTANCE();
        parkingLot.createNByNParkingLot(5,5);
        Vehicle car = new Vehicle(123, VehicleType.MEDIUM);
//        Vehicle bike = new Vehicle(124, VehicleType.SMALL);
//        Vehicle bus = new Vehicle(125, VehicleType.LARGE);
//        for (int i = 0; i < 4; i++) {
//            Vehicle cai = new Vehicle(i, VehicleType.MEDIUM);
//            Vehicle biki = new Vehicle(i, VehicleType.SMALL);
//            Vehicle busi = new Vehicle(i, VehicleType.LARGE);
//            Ticket ticket = parkingLot.allowEntry(cai);
//            Ticket ticket2 = parkingLot.allowEntry(biki);
//            Ticket ticket3 = parkingLot.allowEntry(busi);
//            parkingLot.calculatePrice(ticket);
//            parkingLot.calculatePrice(ticket2);
//            parkingLot.calculatePrice(ticket3);
//
//        }
//        Ticket carTicket = parkingLot.allowEntry(car);
//        Ticket bikeTicket =parkingLot.allowEntry(bike);
//        Ticket busTicket =parkingLot.allowEntry(bus);
//        parkingLot.calculatePrice(carTicket);
//        parkingLot.calculatePrice(bikeTicket);
//        parkingLot.calculatePrice(busTicket);
//        parkingLot.displayCurrentStatus();
//        parkingLot.calculatePrice(bikeTicket);
//        parkingLot.calculatePrice(carTicket);
//        parkingLot.calculatePrice(busTicket);

    }
}
