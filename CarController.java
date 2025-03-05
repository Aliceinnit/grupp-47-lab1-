package grupp47_lab1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class CarController extends Observable implements Controllable {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    Stack<Car> cars = new Stack<>();
    private final WorkshopHandler workshopHandler;
    private final CarPositionHandler positionHandler;

    //methods:

    public CarController(){
        // Start a new view and send a reference of self
        this.positionHandler = new CarPositionHandler(cars);
        this.frame = new CarView("CarSim 1.0", this, cars, positionHandler);
        this.workshopHandler = new WorkshopHandler();

        //Lägg in de förskapade bilarna i listan och kalla på VehicleFactory för att skapa de
        //cars.add(VehicleFactory.createCar("Volvo240", 100, 0));
        cars.add(VehicleFactory.createVehicle("Saab95", 100, 140));
        cars.add(VehicleFactory.createVehicle("Scania", 0, 200));
        cars.add(VehicleFactory.createVehicle("Volvo240", 200, 0));

    }

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.positionHandler.initializeCarPositions(cc.cars);
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Stack<Car> carsToRemove = new Stack<>();
            for(Car car : cars) {
                if (workshopHandler.checkCollisionWithWorkshop(car)){
                    carsToRemove.add(car);
                    positionHandler.removeCarFromUI(car.getModelName());
                } else {
                    car.move();
                    positionHandler.moveit((int) car.getX(), (int) car.getY(), car.getModelName());
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
                } else {
                    car.move();
                }
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.updateCarPosition(x, y, car.getModelName());
                // repaint() calls the paintComponent method of the panel
            }
            cars.removeAll(carsToRemove);
            frame.updateUI();
        }
    }
    @Override
    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
        }
    }

    @Override
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    @Override
    public void startEngine() {
        for (Car car : cars) {
            car.startEngine();
        }
    }
    @Override
    public void stopEngine() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }
    @Override
    public void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95 saab){
                (saab).setTurboOn();
            }
        }
    }
    @Override
    public void turboOff() {
        for (Car car: cars){
            if (car instanceof Saab95 saab){
                (saab).setTurboOff();
            }
        }
    }
    @Override
    public void raisePlatform() {
        for (Car car: cars){
            if (car instanceof Scania scania){
                scania.raisePlatform();
            }
        }
    }
    @Override
    public void lowerPlatform() {
        for (Car car: cars){
            if (car instanceof Scania scania){
                scania.lowerPlatform();
            }
        }
    }
    @Override
    public void turnRight() {
        for (Car car : cars) {
            car.turnRight();
        }
    }
    @Override
    public void turnLeft() {
        for (Car car : cars) {
            car.turnLeft();
        }
    }

    @Override
    public void addCar(Car car){
        cars.push(car);
    }

    @Override
    public void removeCar(){

    }

}

