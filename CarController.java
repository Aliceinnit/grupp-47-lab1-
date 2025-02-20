package grupp47_lab1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Volvo240 volvo240 = new Volvo240();
        volvo240.setPosition(0,0);

        Saab95 saab95 = new Saab95();
        saab95.setPosition(120,100);

        Scania scania = new Scania();
        scania.setPosition(240,200);

        cc.cars.add(volvo240);
        cc.cars.add(saab95);
        cc.cars.add(scania);



        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        //calls this to ensure that the position of the cars are stored before drawing
        cc.frame.drawPanel.initializeCarPositions(cc.cars);
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for(Car car : cars) {
                boolean turned = false;

                if (car.getY() > 400) {
                    car.setPosition(car.getX(), 400);
                    turned = true;
                } else if (car.getY() < 0) {
                    car.setPosition(car.getX(), 0);
                    turned = true;
                } else if (car.getX() > 400) {
                    car.setPosition(400, car.getY());
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
                frame.drawPanel.moveit(x, y, car.getModelName());
                // repaint() calls the paintComponent method of the panel
            }
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.gas(gas);
            System.out.println("X: " + car.getX() + "Y: " + car.getY());
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }

    void startEngine() {
        for (Car car : cars
        ) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Car car : cars
        ) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95 saab){
                (saab).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car: cars){
            if (car instanceof Saab95 saab){
                (saab).setTurboOff();
            }
        }
    }

    void raisePlatform() {
        for (Car car: cars){
            if (car instanceof Scania scania){
                scania.raisePlatform();
            }
        }
    }

    void lowerPlatform() {
        for (Car car: cars){
            if (car instanceof Scania scania){
                scania.lowerPlatform();
            }
        }
    }

    void turnRight() {
        for (Car car : cars
        ) {
            car.turnRight();
        }
    }

    void turnLeft() {
        for (Car car : cars
        ) {
            car.turnLeft();
        }
    }
}

