package grupp47_lab1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController <Acar extends Car> {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private final Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    Stack<Acar> cars = new Stack<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Acar car : cars) {
                if (car.getY() > 400) {
                    car.setPosition(car.getX(), 400);
                    turnBack();
                } else if (car.getY() < 0) {
                    car.setPosition(car.getX(), 0);
                    turnBack();
                } else if (car.getX() > 400) {
                    car.setPosition(400, car.getY());
                    turnBack();
                } else if (car.getX() < 0) {
                    car.setPosition(0, car.getY());
                    turnBack();
                } else {
                    car.move();
                }
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Acar car : cars
        ) {
            car.gas(gas);
            System.out.println("X: " + car.getX() + "Y: " + car.getY());
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Acar car : cars
        ) {
            car.brake(brake);
        }
    }

    void startEngine() {
        for (Acar car : cars
        ) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Acar car : cars
        ) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Acar car : cars) {
            if (car instanceof Saab95 saab){
                (saab).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Acar car: cars){
            if (car instanceof Saab95 saab){
                (saab).setTurboOff();
            }
        }
    }

    void raisePlatform() {
        for (Acar car: cars){
            if (car instanceof Scania scania){
                scania.raisePlatform();
            }
        }
    }

    void lowerPlatform() {
        for (Acar car: cars){
            if (car instanceof Scania scania){
                scania.lowerPlatform();
            }
        }
    }

    void turnRight() {
        for (Acar car : cars
        ) {
            car.turnRight();
        }
    }

    void turnLeft() {
        for (Acar car : cars
        ) {
            car.turnLeft();
        }
    }

    void turnBack() {
        for (Acar car : cars
        ) {
            car.turnLeft();
            car.turnLeft();
            car.startEngine();
        }
    }
}

