public class Truck implements Vehicle{
    String regNo;

    VehicleType vehicleType;

    String color;

    public Truck (String regNo,String color)
    {
        this.color = color;
        this.regNo = regNo;
        vehicleType = VehicleType.TRUCK;
    }
    @Override
    public void setVehicleType() {
        this.vehicleType =VehicleType.TRUCK;
    }

    @Override
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getRegNo() {
        return regNo;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
}
