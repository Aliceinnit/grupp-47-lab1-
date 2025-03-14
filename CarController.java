package grupp47_lab1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());

    CarModel model;
    // The frame that represents this instance View of the MVC pattern
    CarView view;
    // A list of cars, modify if needed
    //Stack<Car> cars = new Stack<>();
    //private final WorkshopHandler workshopHandler;


    //methods:

    public CarController(CarModel model){
        // Start a new view and send a reference of self
        this.model = model;
    }
    public void setView(CarView view){
        this.view = view;
    }

    public void startTimer(){
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.moveCars();
            if (view != null){
                view.update();
            }
        }
    }
    public void attachListeners() {
        view.gasButton.addActionListener(e -> model.getCars().forEach(car -> car.gas((int) view.gasSpinner.getValue() / 100.0)));
        view.brakeButton.addActionListener(e -> model.getCars().forEach(car -> car.brake((int) view.gasSpinner.getValue() / 100.0)));
        view.startButton.addActionListener(e -> model.getCars().forEach(Car::startEngine));
        view.stopButton.addActionListener(e -> model.getCars().forEach(Car::stopEngine));
        view.turboOnButton.addActionListener(e -> model.getCars().forEach(car -> {
            if (car instanceof Saab95 saab) saab.activateTurbo();
        }));
        view.turboOffButton.addActionListener(e -> model.getCars().forEach(car -> {
            if (car instanceof Saab95 saab) saab.deactivateTurbo();
        }));
        view.liftBedButton.addActionListener(e -> model.getCars().forEach(car -> {
            if (car instanceof Scania scania) scania.raisePlatform();
        }));
        view.lowerBedButton.addActionListener(e -> model.getCars().forEach(car -> {
            if (car instanceof Scania scania) scania.lowerPlatform();
        }));
        view.turnRightButton.addActionListener(e -> model.getCars().forEach(Car::turnRight));
        view.turnLeftButton.addActionListener(e -> model.getCars().forEach(Car::turnLeft));
        view.addCarButton.addActionListener(e -> {
            String[] models = {"Volvo240", "Saab95", "Scania"};
            String selectedModel = models[new java.util.Random().nextInt(models.length)];
            double x = Math.random() * 700;
            double y = Math.random() * 400;
            model.addCar(VehicleFactory.createVehicle(selectedModel, x, y));
        });
        view.removeCarButton.addActionListener(e -> model.removeCar());
    }

    public void gas(int amount) {
        double gasAmount = ((double) amount) / 100;
        for (Car car : model.getCars()) {
            car.gas(gasAmount);
        }
    }

    public void brake(int amount) {
        double brakeAmount = ((double) amount) / 100;
        for (Car car : model.getCars()) {
            car.brake(brakeAmount);
        }
    }

    public void startEngine() {
        for (Car car : model.getCars()) {
            car.startEngine();
        }
    }

    public void stopEngine() {
        for (Car car : model.getCars()) {
            car.stopEngine();
        }
    }

    public void turboOn() {
        for (Car car : model.getCars()) {
            if (car instanceof Saab95 saab) {
                saab.activateTurbo();
            }
        }
    }

    public void turboOff() {
        for (Car car : model.getCars()) {
            if (car instanceof Saab95 saab) {
                saab.deactivateTurbo();
            }
        }
    }

    public void raisePlatform() {
        for (Car car : model.getCars()) {
            if (car instanceof Scania scania) {
                scania.raisePlatform();
            }
        }
    }

    public void lowerPlatform() {
        for (Car car : model.getCars()) {
            if (car instanceof Scania scania) {
                scania.lowerPlatform();
            }
        }
    }

    public void turnRight() {
        for (Car car : model.getCars()) {
            car.turnRight();
        }
    }

    public void turnLeft() {
        for (Car car : model.getCars()) {
            car.turnLeft();
        }
    }

    public void addCar() {
        String[] models = {"Volvo240", "Saab95", "Scania"};
        String selectedModel = models[new java.util.Random().nextInt(models.length)];
        model.addCar(VehicleFactory.createVehicle(selectedModel, Math.random() * 700, Math.random() * 400));
    }

    public void removeCar() {
        model.removeCar();
    }

}


