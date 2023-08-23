import java.util.HashMap;
import java.util.Map;

public class Floor {

    private int floorId;
    private Map<String,Vehicle> vehicleSlotMap;
    private Boolean []truckOccupied;
    private Boolean []carOccupied;

    private Boolean []bikeOccupied;
    private int freeTruckCount;
    private int freeBikeCount;
    private int freeCarCount;

    int totalFloorSize;
    String parkingId;

    public Floor(int floorId,int totalFloorSize,String parkingId)
    {
        this.floorId = floorId;
        this.truckOccupied = new Boolean[1];
        this.bikeOccupied = new Boolean[2];
        this.carOccupied = new Boolean[totalFloorSize - 3];
        for(int i=0;i<totalFloorSize - 3;i++)
        {
            carOccupied[i] = false;
        }
        for(int i=0;i<2;i++)
            bikeOccupied[i] = false;
        truckOccupied[0] = false;
        freeTruckCount = 1;
        freeBikeCount = 2;
        freeCarCount = totalFloorSize - 3;
        totalFloorSize = totalFloorSize;
        vehicleSlotMap = new HashMap<>();
        this.parkingId = parkingId;
    }

    public int getFreeTruckCount()
    {
        return freeTruckCount;
    }

    public int getFreeBikeCount()
    {
        return freeBikeCount;
    }

    public int getFreeCarCount()
    {
        return freeCarCount;
    }

    public Boolean[] getTruckOccupied() {
        return truckOccupied;
    }

    public Boolean[] getCarOccupied() {
        return carOccupied;
    }

    public Boolean[] getBikeOccupied() {
        return bikeOccupied;
    }

    public String parkVehicle(Vehicle vehicle)
    {
        if(vehicle.getVehicleType().getVehicleType().equals("CAR") )
        {
            int freeLot=0;
            for(int i=0;i<this.carOccupied.length;i++)
            {
                if(carOccupied[i] == false)
                {
                    freeLot = i+1+3;
                    carOccupied[i] = true;
                    freeCarCount--;
                    break;
                }
            }
            String floorStringId = Integer.toString(this.floorId);
            String parkingIdForVehicle = parkingId +"_"+floorStringId+ "_"+ Integer.toString(freeLot);
            vehicleSlotMap.put(parkingIdForVehicle,vehicle);
            return parkingIdForVehicle;
        }
        else if(vehicle.getVehicleType().getVehicleType().equals("BIKE"))
        {
            int freeLot = 0;
            for(int i=0;i<2;i++)
            {
                if(bikeOccupied[i] == false)
                {
                    freeLot = i+1+1;
                    bikeOccupied[i] = true;
                    freeBikeCount--;
                    break;
                }
            }
            String floorStringId = Integer.toString(this.floorId);
            String parkingIdForVehicle = parkingId +"_"+floorStringId+ "_"+ Integer.toString(freeLot);
            vehicleSlotMap.put(parkingIdForVehicle,vehicle);
            return parkingIdForVehicle;
        }
        else if(vehicle.getVehicleType().getVehicleType().equals("TRUCK"))
        {
            int freeLot = 0;
            for(int i=0;i<1;i++)
            {
                if(truckOccupied[i] == false)
                {
                    freeLot = i+1;
                    truckOccupied[i] = true;
                    freeTruckCount--;
                    break;
                }
            }
            String floorStringId = Integer.toString(this.floorId);
            String parkingIdForVehicle = parkingId +"_"+floorStringId+ "_"+ Integer.toString(freeLot);
            vehicleSlotMap.put(parkingIdForVehicle,vehicle);
            return parkingIdForVehicle;
        }
        else {
            return new String("Wrong Vehicle Format");
        }
    }

    public String unParkVehicle(String parkingid)
    {
        Vehicle currentVehicle;

        if(vehicleSlotMap.containsKey(parkingid)) {

            currentVehicle = vehicleSlotMap.get(parkingid);
            if(currentVehicle.getVehicleType().getVehicleType().equals("TRUCK"))
            {
                truckOccupied[0] = false;
                freeTruckCount++;
            }
            else if(currentVehicle.getVehicleType().getVehicleType().equals("CAR"))
            {
                String []inputs = parkingid.split("_");
                int slotId = Integer.parseInt(inputs[2]);
                carOccupied[slotId-4] = false;
                freeCarCount++;
            }
            else if(currentVehicle.getVehicleType().getVehicleType().equals("BIKE"))
            {
                String []inputs = parkingid.split("_");
                int slotId = Integer.parseInt(inputs[2]);
                bikeOccupied[slotId-1] = false;
                freeBikeCount++;
            }
            vehicleSlotMap.remove(parkingid);
            return new String(currentVehicle.getRegNo() +" and Color: " + currentVehicle.getColor());
        }
        else
            return new String("Invalid Ticket");

//        return new String("Invalid slot id");
    }
}
