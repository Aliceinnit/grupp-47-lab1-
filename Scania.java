package grupp47_lab1;

import java.awt.*;

public class Scania extends Car {
    public Scania(){
        super(2,125, Color.white,"Scania");
        stopEngine();
    }

    private double flatbedAngle;

    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }

    public double getCurrentAngle() {
        return flatbedAngle;
    }

    public void lowerFlatbed() {
        if (getCurrentSpeed() == 0) {
            flatbedAngle = Math.max(getCurrentAngle() - 2, 0);
        }
    }

    public void raiseFlatbed() {
        if (getCurrentSpeed() == 0) {
            flatbedAngle = Math.min(getCurrentAngle() + 2, 70);
        }
    }

    @Override
    public void gas(double amount) {
        if (getCurrentAngle() == 0) {
            super.gas(amount);
        }
    }

    @Override
    public void startEngine() {
        if (getCurrentAngle() == 0) {
            super.startEngine();
        }
    }
}
