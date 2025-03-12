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


    //methods:

    public CarController(){
        // Start a new view and send a reference of self
        this.workshopHandler = new WorkshopHandler();


        //Lägg in de förskapade bilarna i listan och kalla på VehicleFactory för att skapa de
        cars.add(VehicleFactory.createVehicle("Saab95", 100, 140));
        cars.add(VehicleFactory.createVehicle("Scania", 0, 200));
        cars.add(VehicleFactory.createVehicle("Volvo240", 200, 0));

        this.frame = new CarView("CarSim 1.0", this, cars, workshopHandler);

        attachListeners(frame);
        addObserver(frame);
    }
    public void attachListeners(CarView frame) {

        this.frame.gasButton.addActionListener(e -> gas((int) this.frame.gasSpinner.getValue()));
        this.frame.brakeButton.addActionListener(e -> brake((int) this.frame.gasSpinner.getValue()));
        this.frame.startButton.addActionListener(e -> startEngine());
        this.frame.stopButton.addActionListener(e -> stopEngine());
        this.frame.turboOnButton.addActionListener(e -> turboOn());
        this.frame.turboOffButton.addActionListener(e -> turboOff());
        this.frame.liftBedButton.addActionListener(e -> raisePlatform());
        this.frame.lowerBedButton.addActionListener(e -> lowerPlatform());
        this.frame.turnRightButton.addActionListener(e -> turnRight());
        this.frame.turnLeftButton.addActionListener(e -> turnLeft());
        this.frame.addCarButton.addActionListener(e -> {
                String[] models = {"Volvo240", "Saab95", "Scania"};
                String selectedModel = models[new java.util.Random().nextInt(models.length)];
                double x = Math.random() * 700;
                double y = Math.random() * 400;
                addCar(VehicleFactory.createVehicle(selectedModel, x, y), x, y);

        });
        this.frame.removeCarButton.addActionListener(e -> {
                if (!getCars().isEmpty()){
                    Car lastCar = (Car) getCars().peek();
                    removeCar(lastCar);
                }
        });
    }

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
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

                frame.update();

            }
            for (Car car: carsToRemove){
                removeCar(car);
            }
            notifyObservers();
        }
    }

    @Override
    public Stack<Car> getCars() {
        return cars;
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
                saab.activateTurbo();
            }
        }
    }
    @Override
    public void turboOff() {
        for (Car car: cars){
            if (car instanceof Saab95 saab){
                (saab).deactivateTurbo();
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


    public void addCar(Car car, double x, double y){
        if (cars.size() < 10){
            cars.push(car);
            notifyObservers();
        } else {
            System.out.println("Car limit reached!");
        }

    }

    public void removeCar(Car car){
        if (cars.remove(car)){
            //carPositions.remove(car);
            notifyObservers();
        } else {
            System.out.println("Car not found!");
        }
    }

}

