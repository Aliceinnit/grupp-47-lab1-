package grupp47_lab1;

public class PlatformUpState implements TruckState{
    @Override
    public void raisePlatform(Truck truck) {
        System.out.println("Platform is already up!");
    }

    @Override
    public void lowerPlatform(Truck truck) {
        System.out.println("Lowering platform...");
        truck.setPlatformAngle(70);
        truck.setPlatformState(new PlatformDownState());
    }
}
