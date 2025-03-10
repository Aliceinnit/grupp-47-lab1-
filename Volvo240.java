package grupp47_lab1;

import java.awt.*;

public class Volvo240 extends PersonCar {

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4,100,Color.black,"Volvo240");
        stopEngine();
    }

    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
