package grupp47_lab1;

import java.awt.*;

public class Saab95 extends PersonCar {

    private SaabTurboState turboState;
    //private boolean turboOn;

    public Saab95(){
        super(2,125,Color.red,"Saab95");
        turboState = new TurboOffState();
        stopEngine();
    }

    public void setTurboState(SaabTurboState state){
        this.turboState = state;
    }

    public void activateTurbo(){
        turboState.activateTurbo(this);
    }

    public void deactivateTurbo(){
        turboState.deactivateTurbo(this);
    }


    @Override
    protected double speedFactor(){
        double turboMultiplier = (turboState instanceof TurboOnState) ? 1.3 : 1.0;
        return getEnginePower() *0.01 * turboMultiplier;
    }

}
