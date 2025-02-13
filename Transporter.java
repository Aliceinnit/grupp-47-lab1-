package grupp47_lab1;

import java.awt.*;
import java.util.*;

public class Transporter<T extends PersonCar> extends Truck {
    private final Storage<T> storage = new Storage<>();
    public Transporter() {
        super(2, 125, Color.cyan, "Transformer");
    }

    public enum platformState {
        UP,
        DOWN
    }
    private platformState state = platformState.UP;

    public void loadCar(T car){
        if (getPlatformState() == platformState.DOWN &&
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
        if (getPlatformState() == platformState.DOWN) {
            storage.unloadCar();
        } else {
            throw new IllegalStateException("You cannot unload a car right now.");
        }
    }

    public Stack<T> getCars() {
        return storage.getCars();
    }
    public platformState getPlatformState() {
        return state;
    }

    public void platformSwitch(platformState nextState) {
        state = nextState;
    }

    public void changeState() {
        if (getCurrentSpeed() == 0){
            switch(getPlatformState()) {
                case DOWN:
                    while (getCurrentAngle() < 70) {
                        lowerPlatform();
                    }
                    break;
                case UP:
                    while (getCurrentAngle() > 0) {
                        raisePlatform();
                    }
                    break;
            }

        }
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
