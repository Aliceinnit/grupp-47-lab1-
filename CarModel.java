package grupp47_lab1;

import java.util.Stack;

public class CarModel extends Observable {
    private final Stack<Car> cars = new Stack<>();
    private final WorkshopHandler workshopHandler = new WorkshopHandler();

    public CarModel() {
        cars.add(VehicleFactory.createVehicle("Saab95", 100, 140));
        cars.add(VehicleFactory.createVehicle("Scania", 0, 200));
        cars.add(VehicleFactory.createVehicle("Volvo240", 200, 0));
    }

    public Stack<Car> getCars() {
        return cars;
    }

    public WorkshopHandler getWorkshopHandler() {
        return workshopHandler;
    }

    public void addCar(Car car) {
        if (cars.size() < 10) {
            cars.push(car);
            notifyObservers();
        } else {
            System.out.println("Car limit reached!");
        }
    }

    public void removeCar() {
        if (!cars.isEmpty()) {
            cars.pop();
            notifyObservers();
        }
    }

    public void moveCars() {
        Stack<Car> carsToRemove = new Stack<>();
        for (Car car : cars) {
            if (workshopHandler.checkCollisionWithWorkshop(car)) {
                carsToRemove.add(car);
                continue;
            } else if (car instanceof Truck truck && truck.getCurrentPlatformState() instanceof PlatformDownState) {
                continue;
            } else {
                car.move();
            }

            boolean turned = false;
            if (car.getY() > 400) {
                car.setPosition(car.getX(), 400);
                turned = true;
            } else if (car.getY() < 0) {
                car.setPosition(car.getX(), 0);
                turned = true;
            } else if (car.getX() > 685) {
                car.setPosition(685, car.getY());
                turned = true;
            } else if (car.getX() < 0) {
                car.setPosition(0, car.getY());
                turned = true;
            }

            if (turned) {
                car.turnLeft();
                car.turnLeft();
                car.startEngine();
            }
        }
        cars.removeAll(carsToRemove);
        notifyObservers();
    }
}
