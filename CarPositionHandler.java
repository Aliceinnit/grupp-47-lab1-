package grupp47_lab1;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CarPositionHandler {
    private final Map<String, Point> carPositions;

    public CarPositionHandler(Stack<Car> cars){
        carPositions = new HashMap<>();
        initializeCarPositions(cars);
    }
    public void initializeCarPositions(Stack<Car> cars) {
        for (Car car : cars) { //Loop through all the cars
            // stores the car's position in the HashMap carPositions
            // returns the car's name and creates a point (x,y) where the car will be drawn
            carPositions.put(car.getModelName(), new Point((int) car.getX(), (int) car.getY()));
        }
    }


    public void moveit(int x, int y, String model){
        //checks if the car exists in the hashmap carPositions
        if (carPositions.containsKey(model)) {
            //updates the car's position
            carPositions.get(model).setLocation(x, y);
        }
    }

    public void removeCarFromUI(String modelName) {
        carPositions.remove(modelName);
    }

    public Map<String, Point> getCarPositions() {
        return new HashMap<>(carPositions); // Return a copy to prevent modification
    }
}
