package grupp47_lab1;

import java.util.Stack;

public interface Controllable {
    
    void gas(int amount);
    void brake(int amount);
    void startEngine();
    void stopEngine();
    void turboOn();
    void turboOff();
    void raisePlatform();
    void lowerPlatform();
    void turnRight();
    void turnLeft();
    void addCar(Car car, double x,double y);
    void removeCar(Car car);

    Stack<Car> getCars();
}
