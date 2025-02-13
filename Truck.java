package grupp47_lab1;

import java.awt.*;

public abstract class Truck extends Car{
    public Truck(int doors, double power, Color clr, String name) {
        super(doors, power, clr, name);
    }

    private double platformAngle;

    public double getCurrentAngle() {
        return platformAngle;
    }

    public void raisePlatform() {
        if (getCurrentSpeed() == 0) {
            platformAngle = Math.max(getCurrentAngle() - 2, 0);
        } else {
            throw new IllegalStateException("Cannot raise platform when moving.");
        }
    }

    public void lowerPlatform() {
        if (getCurrentSpeed() == 0) {
            platformAngle = Math.min(getCurrentAngle() + 2, 70);
        } else {
            throw new IllegalStateException("Cannot lower platform when moving.");
        }
    }

    @Override
    public void gas(double amount) {
        if (getCurrentAngle() == 0) {
            super.gas(amount);
        } else {
            throw new IllegalStateException("You cannot accelerate when platform is lowered.");
        }
    }

    @Override
    public void startEngine() {
        if (getCurrentAngle() == 0) {
            super.startEngine();
        }
        else{
            throw new IllegalStateException("You cannot start Engine when platform is lowered.");
        }
    }

    @Override
    public void move() {
        if (getCurrentAngle() == 0) {
            super.move();
        } else {
            throw new IllegalStateException("You cannot move if platform is lowered.");
        }
    }
}
