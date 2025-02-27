package grupp47_lab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;

public class EventHandler {
    private final Controllable controller; //interfacet som CarController implementerar

    //konstruktor
    public EventHandler(Controllable controller){
        this.controller = controller;
    }

    //kopplar actionListeners till rätt knappar och anropar Controllable via CarController
    public void attachListeners(JButton gasButton, JButton brakeButton,
                                JButton startButton, JButton stopButton,
                                JButton turboOnButton, JButton turboOffButton,
                                JButton liftBedButton, JButton lowerBedButton,
                                JButton turnRightButton, JButton turnLeftButton,
                                JSpinner gasSpinner) {


        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gasAmount = (int) gasSpinner.getValue();
                controller.gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int gasAmount = (int) gasSpinner.getValue();
                controller.brake(gasAmount);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startEngine();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.stopEngine();
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.turboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.turboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.raisePlatform();
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.lowerPlatform();
            }
        });

        turnRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.turnRight();
            }
        });

        turnLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.turnLeft();
            }
        });
    }
}
