package grupp47_lab1;

import java.awt.*;

public abstract class Truck extends Car{
    private TruckState platformState; //förvarar current state
    public Truck(int doors, double power, Color clr, String name) {
        super(doors, power, clr, name);
        this.platformState = new PlatformUpState();
        this.platformAngle = 0;
    }

    public TruckState getCurrentPlatformState() {
        return platformState;
    }

    private double platformAngle;

    public double getCurrentAngle() {
        return platformAngle;
    }

    public void setPlatformState(TruckState state) {
        this.platformState = state;
    }

    public void setPlatformAngle(double angle){
        this.platformAngle = angle;
    }
    public void raisePlatform() {
        if (getCurrentSpeed() == 0){
            platformState.raisePlatform(this);
        } else {
            System.out.println("Cannot raise platform while moving!");
        }
    }

    public void lowerPlatform() {
        if (getCurrentSpeed() == 0) { // Ensures truck is stationary
            platformState.lowerPlatform(this);
        } else {
            System.out.println("Cannot lower platform while moving!");
        }
    }

    @Override
    public void gas(double amount) {
        if (platformState instanceof PlatformUpState) {
            super.gas(amount);
        } else {
            System.out.println("You cannot accelerate when platform is lowered.");
        }
    }

    @Override
    public void startEngine() {
        if (getCurrentAngle() == 0) {
            super.startEngine();
        }
        else{
            System.out.println("You cannot start Engine when platform is lowered.");
        }
    }

    @Override
    public void move() {
        if (getCurrentAngle() == 0) {
            super.move();
        } else {
            System.out.println("You cannot move if platform is lowered.");
        }
    }
}
