package grupp47_lab1;

import java.awt.*;

public class Scania extends Car {
    public Scania(){
        super(2,125, Color.white,"Scania");
        stopEngine();
    }

    private double platformAngle;

    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }

    public double getCurrentAngle() {
        return platformAngle;
    }

    public void raisePlatform() {
        if (getCurrentSpeed() == 0) {
            platformAngle = Math.max(getCurrentAngle() - 2, 0);
        }
    }

    public void lowerPlatform() {
        if (getCurrentSpeed() == 0) {
            platformAngle = Math.min(getCurrentAngle() + 2, 70);
        }
    }

    @Override
    public void gas(double amount) {
        if (getCurrentAngle() == 0) {
            super.gas(amount);
        } else {
            System.out.println("Platform is lowered.");
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
        }
    }
}
