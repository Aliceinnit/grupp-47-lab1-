package grupp47_lab1;

import java.awt.*;

public abstract class PersonCar extends Car{
    public PersonCar(int doors, double power, Color clr, String name) {
        super(doors, power, clr, name);
    }
    private boolean loaded;

    public boolean loadedOrNot() {
        return loaded;
    }

    public void load() {
        loaded = true;
    }

    public void unload() {
        loaded = false;
    }

    @Override
    public void startEngine() {
        if (!loadedOrNot()) {
            super.startEngine();
        }
    }
}
