package grupp47_lab1;

public class PlatformDownState implements TruckState{
    @Override
    public void raisePlatform(Truck truck) {
        System.out.println("Raising platform...");
        truck.setPlatformAngle(0);
        truck.setPlatformState(new PlatformUpState());

    }

    @Override
    public void lowerPlatform(Truck truck) {
        System.out.println("Platform is already down!");
    }
}
