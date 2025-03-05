package grupp47_lab1;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class VehicleFactory {
    private static final Map<String, Supplier<Car>> vehicleRegistry = new HashMap<>();

    static {
        registerVehicle("Volvo240", Volvo240::new);
        registerVehicle("Saab95", Saab95::new);
        registerVehicle("Scania", Scania::new);
        registerVehicle("Transporter", Transporter::new);

    }

    public static void registerVehicle(String modelName, Supplier<Car> supplier){
        vehicleRegistry.put(modelName, supplier);
    }

    public static Car createVehicle(String modelName, double x, double y){
        Supplier<Car> supplier = vehicleRegistry.get(modelName);
        if (supplier == null){
            throw new IllegalArgumentException("Unknown vehicle model" + modelName);
        }
        Car vehicle = supplier.get();
        vehicle.setPosition(x,y);
        return vehicle;
    }
}
