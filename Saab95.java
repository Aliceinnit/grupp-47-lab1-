package grupp47_lab1;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(){
        super(2,125,Color.red,"Saab95");
        turboOn = false;
        stopEngine();
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    public boolean isTurboOn() {
        return turboOn;
    }
}
