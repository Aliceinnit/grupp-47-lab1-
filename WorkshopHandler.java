package grupp47_lab1;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class WorkshopHandler {
    private final Map<String, Workshop> workshops = new HashMap<>();
    //private final CarWorkshop<Volvo240> volvoWorkshop;

    public WorkshopHandler(){
        workshops.put("Volvo240", new CarWorkshop<Volvo240>());
        workshops.put("Saab95", new CarWorkshop<Saab95>());

        //this.volvoWorkshop = new CarWorkshop<>();
    }
    public boolean checkCollisionWithWorkshop(Car car) {
        if (car instanceof PersonCar) {
            Workshop workshop = workshops.get(car.getModelName());
            Point workshopPos = getWorkshopPosition(car.getModelName());
            if (workshop != null && Math.abs(car.getY()-workshopPos.y) < 50 &&
                    Math.abs(car.getX()-workshopPos.x) < 50){
                workshop.loadCar((PersonCar) car);
                return true;
            }
        }
        return false;
    }

    public void unloadCarFromWorkshop(String modelName) {
        Workshop workshop = workshops.get(modelName);
        if (workshop != null){
            workshop.unloadCar();
        }
    }

    public Stack<? extends PersonCar> getCarsInWorkshop(String modelName) {
        return workshops.containsKey(modelName) ? workshops.get(modelName).getCars() : new Stack<>();
    }

    public Set<String> getAllWorkshopModels(){
        return workshops.keySet();
    }

    public Point getWorkshopPosition(String modelName){
        switch (modelName){
            case "Volvo240": return new Point(300, 300);
            case "Saab95": return new Point(300, 100);
            default: return new Point(100, 300);
        }
    }
}
