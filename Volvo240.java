package grupp47_lab1;

import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4,100,Color.black,100,Volvo240);
        stopEngine();
    }

    private double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
        if (currentSpeed < getEnginePower()) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
        }
    }

    public void decrementSpeed(double amount){
        if (currentSpeed > 0) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }
    }

    public void gas(double amount){
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
        else{
            System.out.println("Gas amount must be between 0 and 1.");
        }
    }

    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
        else{
            System.out.println("Brake amount must be between 0 and 1.");
        }
    }
}
