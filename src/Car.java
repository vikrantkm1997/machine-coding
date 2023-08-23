public class Car implements Vehicle{

    String regNo;

    VehicleType vehicleType;

    String color;

    public String getRegNo() {
        return regNo;
    }

    public String getColor() {
        return color;
    }

    public Car (String regNo, String color)
    {
        this.color = color;
        this.regNo = regNo;
        vehicleType = VehicleType.CAR;
    }
    @Override
    public void setVehicleType() {
        this.vehicleType = vehicleType.CAR;
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
    public VehicleType getVehicleType() {
        return this.vehicleType;
    }
}
