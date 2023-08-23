public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot("PR1234" ,2,6);
        parkingLot.getEmptyCarSlots();
        parkingLot.getEmptyBikeSlots();
        parkingLot.getEmptyTruckSlots();
        parkingLot.getFreeSlots(VehicleType.CAR);
        parkingLot.getFreeSlots(VehicleType.TRUCK);
        parkingLot.getFreeSlots(VehicleType.BIKE);
        parkingLot.parkVehicle(VehicleType.CAR,"KA-01-DB-1234","red");
        parkingLot.parkVehicle(VehicleType.CAR,"KA-01-DB-1234","red");
        parkingLot.parkVehicle(VehicleType.CAR,"KA-01-DB-1133", "black");
        parkingLot.parkVehicle(VehicleType.CAR,"KA-05-HJ-8432", "white");
        parkingLot.parkVehicle(VehicleType.CAR,"WB-45-HO-9032" ,"white");
        parkingLot.parkVehicle(VehicleType.CAR,"KA-01-DF-8230", "black");
        parkingLot.parkVehicle(VehicleType.CAR,"KA-21-HS-2347" ,"red");
        parkingLot.getEmptyCarSlots();
        parkingLot.getEmptyBikeSlots();
        parkingLot.getEmptyTruckSlots();
        parkingLot.unparkVehicle("PR1234_2_5");
        parkingLot.unparkVehicle("PR1234_2_5");
        parkingLot.unparkVehicle("PR1234_2_7");
        parkingLot.getEmptyCarSlots();
        parkingLot.getEmptyBikeSlots();
        parkingLot.getEmptyTruckSlots();
        parkingLot.getFreeSlots(VehicleType.CAR);
        parkingLot.getFreeSlots(VehicleType.TRUCK);
        parkingLot.getFreeSlots(VehicleType.BIKE);
        parkingLot.parkVehicle(VehicleType.BIKE,"KA-01-DB-1541","black");
        parkingLot.parkVehicle(VehicleType.TRUCK,"KA-32-SJ-5389","orange");
        parkingLot.parkVehicle(VehicleType.TRUCK,"KL-54-DN-4582","green");
        parkingLot.parkVehicle(VehicleType.TRUCK,"KL-12-HF-4542","green");
        parkingLot.getEmptyCarSlots();
        parkingLot.getEmptyBikeSlots();
        parkingLot.getEmptyTruckSlots();
        parkingLot.getFreeSlots(VehicleType.CAR);
        parkingLot.getFreeSlots(VehicleType.TRUCK);
        parkingLot.getFreeSlots(VehicleType.BIKE);
//        park_vehicle BIKE KA-01-DB-1541 black
//        park_vehicle TRUCK KA-32-SJ-5389 orange
//        park_vehicle TRUCK KL-54-DN-4582 green
//        park_vehicle TRUCK KL-12-HF-4542 green
//        unpark_vehicle PR1234_2_5
//        unpark_vehicle PR1234_2_5
//        unpark_vehicle PR1234_2_7
//        CAR KA-01-DB-1234 black
// park_vehicle CAR KA-01-DB-1234 black
//        park_vehicle CAR KA-02-CB-1334 red
//  park_vehicle CAR KA-01-DB-1133 black
//  park_vehicle CAR KA-05-HJ-8432 white
//  park_vehicle CAR WB-45-HO-9032 white
//  park_vehicle CAR KA-01-DF-8230 black
//  park_vehicle CAR KA-21-HS-2347 red
    }
}