package grupp47_lab1;

import java.util.*;

public class Transporter extends Scania implements Storage<Car>{
    private ArrayList<Car> cars = new ArrayList<>(9);
    public enum platformState {
        UP,
        DOWN
    }
    private platformState platformState;

    @Override
    public void loadCar(Car car){
        if (getPlatformState() == platformState.DOWN && cars.size() < 10 && !Objects.equals(car.getModelName(), "Scania") && Math.abs(getY() - car.getY()) <= 5 && Math.abs(getX() - car.getX()) <= 5){
            cars.add(car);
            car.setPosition(getX(), getY());
        } else {
            System.out.println("Platform is not lowered.");
        }
    }

    @Override
    public void unloadCar(){
        if (getPlatformState() == platformState.DOWN) {
            cars.removeLast();
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public platformState getPlatformState() {
        return platformState;
    }

    public void platformSwitch(platformState nextState) {
        platformState = nextState;
    }

    public void changeState() {
        if (getCurrentSpeed() == 0.0){
            switch(getPlatformState()) {
                case DOWN:
                    while (getCurrentAngle() < 70) {
                        lowerPlatform();
                        System.out.println("HELLO");
                        System.out.println(getCurrentAngle());
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
        for (Car car: cars) {
            car.setPosition(getX(), getY());
        }
    }
}
