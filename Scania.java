package grupp47_lab1;

import java.awt.*;

public class Scania extends Truck {
    public Scania(){
        super(2,125, Color.white,"Scania");
        stopEngine();
    }

    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }
}
