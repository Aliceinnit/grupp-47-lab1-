package grupp47_lab1;

import java.awt.*;
import java.util.*;

public class Transporter<T extends Car> extends Scania implements Storage<T>{
    private Stack<T> cars = new Stack<>();
    public enum platformState {
        UP,
        DOWN
    }
    private platformState state = platformState.UP;

    @Override
    public void loadCar(T car){
        if (getPlatformState() == platformState.DOWN &&
                cars.size() < 9 &&
                !Objects.equals(car.getModelName(), "Scania") &&
                Math.abs(getY() - car.getY()) <= 5 &&
                Math.abs(getX() - car.getX()) <= 5){
            cars.push(car);
            car.setPosition(getX(), getY());
        }

    }

    @Override
    public void unloadCar(){
        if (getPlatformState() == platformState.DOWN) {
            cars.pop();
        }
    }

    @Override
    public Stack<T> getCars() {
        return cars;
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
    public void move() {
        super.move();
        for (T car: cars) {
            car.setPosition(getX(), getY());
        }
    }
}
