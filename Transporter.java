package grupp47_lab1;

import java.awt.*;
import java.util.*;

public class Transporter<T extends Car> extends Scania implements Storage<T>{
    private ArrayList<T> cars = new ArrayList<T>();
    public enum platformState {
        UP,
        DOWN
    }
    private platformState platformState;

    public void loadCar(T car){
        if (getPlatformState() == platformState.DOWN && cars.size() < 10 && !Objects.equals(car.getModelName(), "Scania") && Math.abs(getY() - car.getY()) <= 5 && Math.abs(getX() - car.getX()) <= 5){
            cars.add(car);
            car.setPosition(getX(), getY());
        }

    }
    public void unloadCar(){
        if (getPlatformState() == platformState.DOWN) {
            cars.removeLast();
        }
    }
    public platformState getPlatformState() {
        return platformState;
    }

    public void platformSwitch(platformState nextState) {
        platformState = nextState;
    }

    public void changeState() {
        if (getCurrentSpeed() == 0){
            switch(getPlatformState()) {
                case DOWN:
                    while (getCurrentAngle() < 70) {
                        lowerPlatform();
                    }
                case UP:
                    while (getCurrentAngle() > 0) {
                        raisePlatform();
                    }
            }

        }
    }

    @Override
    public void move() {
        super.move();
        for (Car car: cars) {
            car.setPosition(getX(), getY());
        }
    }
}
