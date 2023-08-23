public class Bike implements Vehicle{

    String regNo;

    VehicleType vehicleType;

    String color;

    public Bike(String regNo,String color)
    {
        this.color= color;
        this.regNo = regNo;
        vehicleType = VehicleType.BIKE;
    }
    @Override
    public void setVehicleType() {
        this.vehicleType = vehicleType.BIKE;
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


    public Bike getVehicle() {
        return this;
    }
}
