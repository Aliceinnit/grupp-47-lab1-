package grupp47_lab1;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CarPositionHandler {
    private final Map<Car, Point> carPositions;

    public CarPositionHandler(Stack<Car> cars){
        carPositions = new HashMap<>();
        initializeCarPositions(cars);
    }
    public void initializeCarPositions(Stack<Car> cars) {
        for (Car car : cars) { //Loop through all the cars
            // stores the car's position in the HashMap carPositions
            // returns the car's name and creates a point (x,y) where the car will be drawn
            carPositions.put(car, new Point((int) car.getX(), (int) car.getY()));
        }
    }

    public void addCar(Car car, double x, double y){
        carPositions.put(car,new Point((int) x, (int)y));
    }


    public void moveit(int x, int y, Car car){
        //checks if the car exists in the hashmap carPositions
        if (carPositions.containsKey(car)) {
            //updates the car's position
            carPositions.get(car).setLocation(x, y);
        }
    }

    public void removeCar(Car car) {
        carPositions.remove(car);
    }

    public Map<Car, Point> getCarPositions() {
        return new HashMap<>(carPositions); // Return a copy to prevent modification
    }
}
