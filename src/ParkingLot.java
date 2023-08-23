import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Integer,Floor> floorMap;
    private Floor floor;
    private String parkingLotId;
    private int floorCount;

    public ParkingLot(String parkingLotId,int floorCount,int floorSize)
    {
        this.parkingLotId = parkingLotId;
        this.floorCount= floorCount;
        floorMap = new HashMap<>();
        for(int i=0;i<floorCount;i++)
        {
            floorMap.put((i+1),new Floor((i+1),floorSize,parkingLotId));
        }
        this.parkingLotId = parkingLotId;
    }

    public void getEmptyCarSlots()
    {
        int allOccupiedCount=0;
        for(int i=0;i<floorCount;i++)
        {
            floor = floorMap.get(i+1);
            int freeCarCount = floor.getFreeCarCount();
            if(freeCarCount!=0)
                System.out.println("No. of free slots for CAR on Floor "+(i+1) +":" +freeCarCount);
            else
             allOccupiedCount++;
        }
        if(allOccupiedCount ==floorCount)
            System.out.println("All floor occupied");

    }

    public void getEmptyBikeSlots()
    {
        int allOccupiedCount=0;
        for(int i=0;i<floorCount;i++)
        {
            floor = floorMap.get(i+1);
            int freeBikeCount = floor.getFreeBikeCount();
            if(freeBikeCount!=0)
                System.out.println("No. of free slots for BIKE on Floor "+(i+1) +":" +freeBikeCount);
            else
                allOccupiedCount++;
        }
        if(allOccupiedCount ==floorCount)
            System.out.println("All floor occupied");
    }
    public void getEmptyTruckSlots()
    {
        int allOccupiedCount=0;
        for(int i=0;i<floorCount;i++)
        {
            floor = floorMap.get(i+1);
            int freeTruckCount = floor.getFreeTruckCount();
            if(freeTruckCount!=0)
                System.out.println("No. of free slots for TRUCK on Floor "+(i+1) +":" +freeTruckCount);
            else
                allOccupiedCount++;
        }
        if(allOccupiedCount ==floorCount)
            System.out.println("All floor occupied");
    }
    public void parkVehicle(VehicleType vehicleType,String regNo, String color)
    {

        if(vehicleType.getVehicleType().equals("CAR")) {
            String parkingTickedId = null;
            Vehicle vehicle= new Car(regNo,color);
            for(int i=0;i<floorCount;i++)
            {
                if(floorMap.get(i+1).getFreeCarCount()!= 0)
                {
                    parkingTickedId = floorMap.get(i+1).parkVehicle(vehicle);
                    break;
                }
            }
            if (parkingTickedId!=null)
            {
                System.out.println("Parked vehicle. Ticket ID: "+parkingTickedId);
            }
            else
            {
                System.out.println("All floor occupied");
            }
        }
        else if (vehicleType.getVehicleType().equals("BIKE"))
        {
            String parkingTickedId = null;
            Vehicle vehicle= new Bike(regNo,color);
            for(int i=0;i<floorCount;i++)
            {
                if(floorMap.get(i+1).getFreeBikeCount()!= 0)
                {
                    parkingTickedId = floorMap.get(i+1).parkVehicle(vehicle);
                    break;
                }
            }
            if (parkingTickedId!=null)
            {
                System.out.println("Parked vehicle. Ticket ID: "+parkingTickedId);
            }
            else
            {
                System.out.println("All floor occupied");
            }
        }
        else if(vehicleType.getVehicleType().equals("TRUCK"))
        {
            String parkingTickedId = null;
            Vehicle vehicle= new Truck(regNo,color);
            for(int i=0;i<floorCount;i++)
            {
                if(floorMap.get(i+1).getFreeTruckCount()!= 0)
                {
                    parkingTickedId = floorMap.get(i+1).parkVehicle(vehicle);
                    break;
                }
            }
            if (parkingTickedId!=null)
            {
                System.out.println("Parked vehicle. Ticket ID: "+parkingTickedId);
            }
            else
            {
                System.out.println("All floor occupied");
            }
        }
    }

    public void unparkVehicle(String ticketId)
    {
        String []strings = ticketId.split("_");
        int floorId;
        if(strings.length==3)
        {
            try{
                floorId=Integer.parseInt(strings[1]);
            }catch (NumberFormatException e)
            {
                System.out.println("Parking id not valid");
                return;
            }
        }
        else
        {
            System.out.println("Parking id not valid");
            return;
        }
        if(floorMap.containsKey(floorId))
        {
            floor = floorMap.get(floorId);
            String unparkingMessage =floor.unParkVehicle(ticketId);
            if(unparkingMessage.equals("Invalid Ticket"))
            {
                System.out.println(unparkingMessage);
            }
            else {
                System.out.println("Unparked vehicle with Registration Number: "+unparkingMessage);
            }

        }
    }

    public void getFreeSlots(VehicleType vehicleType)
    {
        if(vehicleType.getVehicleType().equals("CAR"))
        {
            for(int i=0;i<floorCount;i++)
            {
                System.out.print("Free slots for CAR on Floor " +(i+1)+": ");
                Boolean []CarOccupied = floorMap.get(i+1).getCarOccupied();
                for(int j=0;j<CarOccupied.length;j++)
                {
                    if(CarOccupied[j] ==false) {
                        System.out.print(j+4+",");
                    }
                }
                System.out.println();
            }
        }
        else if (vehicleType.getVehicleType().equals("BIKE"))
        {
            for(int i=0;i<floorCount;i++)
            {
                System.out.print("Free slots for BIKE on Floor " +(i+1)+": ");
                Boolean []bikeOccupied = floorMap.get(i+1).getBikeOccupied();
                for(int j=0;j<bikeOccupied.length;j++)
                {
                    if(bikeOccupied[j] ==false) {
                        System.out.print(j+2+",");
                    }
                }
                System.out.println();
            }
        }
        else
        {
            for(int i=0;i<floorCount;i++)
            {
                System.out.print("Free slots for TRUCK on Floor " +(i+1)+": ");
                Boolean []truckOccupied = floorMap.get(i+1).getTruckOccupied();
                for(int j=0;j<truckOccupied.length;j++)
                {
                    if(truckOccupied[j] ==false) {
                        System.out.print(j+1+",");
                    }
                }
                System.out.println();
            }
        }
    }

}
