package grupp47_lab1;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(){
        super(2,Color.red,125,"Saab95");
        turboOn = false;
        stopEngine();
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        if (currentSpeed < getEnginePower()) {
            currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        }
    }

    public void decrementSpeed(double amount){
        if (currentSpeed > 0) {
            currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        }
    }

    public void gas(double amount){
        if (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        } else{
            System.out.println("Gas amount must be between 0 and 1.");
        }

    }

    public void brake(double amount){
        if (amount >= 0 && amount <= 1){
            decrementSpeed(amount);
        } else{
            System.out.println("Brake amount must be between 0 and 1.");
        }
    }
    public boolean isTurboOn() {
        return turboOn;
    }
}
