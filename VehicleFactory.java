package grupp47_lab1;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
        Random random = new Random();
        double rangeMin = 0;
        double rangeMax = 300;
        Supplier<Car> supplier = vehicleRegistry.get(modelName);
        if (supplier == null){
            throw new IllegalArgumentException("Unknown vehicle model" + modelName);
        }
        Car vehicle = supplier.get();
        double randomValuex = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
        double randomValuey = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
        vehicle.setPosition(randomValuex,randomValuey);
        return vehicle;
    }
}
