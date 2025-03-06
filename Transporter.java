package grupp47_lab1;

import java.awt.*;
import java.util.*;

public class Transporter<T extends PersonCar> extends Truck {
    private final Storage<T> storage = new Storage<>();
    public Transporter() {
        super(2, 125, Color.cyan, "Transformer");
    }



    public void loadCar(T car){
        if (getCurrentPlatformState() instanceof PlatformDownState &&
                storage.getCars().size() < 9 &&
                Math.abs(getY() - car.getY()) <= 5 &&
                Math.abs(getX() - car.getX()) <= 5){
            storage.loadCar(car);
            car.setPosition(getX(), getY());
        } else {
            throw new IllegalStateException("You cannot load a car right now.");
        }

    }

    public void unloadCar(){
        if (getCurrentPlatformState() instanceof PlatformDownState) {
            storage.unloadCar();
        } else {
            throw new IllegalStateException("You cannot unload a car right now.");
        }
    }

    public Stack<T> getCars() {
        return storage.getCars();
    }




    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void move() {
        super.move();
        for (T car: storage.getCars()) {
            car.setPosition(getX(), getY());
        }
    }
}
