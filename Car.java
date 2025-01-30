package grupp47_lab1;

import java.awt.*;

public abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String ModelName; // The car model name ???
    public double xPos;
    public double yPos;
    private enum Directions {
        SOUTH,
        NORTH,
        WEST,
        EAST
    }
    Directions dir;

    public int getNrDoors(){
        return nrDoors;
    }

    public void setNrDoors(int nbr) {
        nrDoors = nbr;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public void setEnginePower(double power) {
        enginePower = power;
    }

    public String getModelName() { return ModelName; }

    public void setModelName(String name) {
        ModelName = name;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double getX() { return xPos;}

    public double getY() { return yPos;}

    @Override
    public void move() {
        switch(dir) {
            case NORTH:
                yPos = getY() + getCurrentSpeed();
            case SOUTH:
                yPos = getY() - getCurrentSpeed();
            case EAST:
                turnRight();
            case WEST:
                turnLeft();
        }
    }

    @Override
    public void turnLeft() {
        xPos = getX() + getCurrentSpeed();
    }

    @Override
    public void turnRight() {
        xPos = getX() - getCurrentSpeed();
    }
}