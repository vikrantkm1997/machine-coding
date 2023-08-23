import com.sun.source.tree.ReturnTree;

public enum VehicleType {
    CAR("CAR"),TRUCK("TRUCK"),BIKE("BIKE");

    String type;
    VehicleType(String type)
    {
        this.type = type;
    }

    public String getVehicleType()
    {
        return this.type;
    }
}
