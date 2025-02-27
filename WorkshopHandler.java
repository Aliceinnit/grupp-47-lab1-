package grupp47_lab1;

import java.util.Stack;

public class WorkshopHandler {

    private final CarWorkshop<Volvo240> volvoWorkshop;

    public WorkshopHandler(){
        this.volvoWorkshop = new CarWorkshop<>();
    }
    public boolean checkCollisionWithWorkshop(Car car) {
        if (car instanceof Volvo240) {
            if (Math.abs(car.getY()-DrawPanel.volvoWorkshopPoint.y) < 50 &&
                    Math.abs(car.getX()-DrawPanel.volvoWorkshopPoint.x) < 50){
                volvoWorkshop.loadCar((Volvo240) car);
                return true;
            }
        }
        return false;
    }

    public void unloadCarFromWorkshop() {
        volvoWorkshop.unloadCar();
    }

    public Stack<Volvo240> getCarsInWorkshop() {
        return volvoWorkshop.getCars();
    }
}
