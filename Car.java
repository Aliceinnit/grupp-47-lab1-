package grupp47_lab1;

import java.awt.Color;

public abstract class Car implements Movable {
    private int nrDoors;
    private double enginePower;
    public double currentSpeed;
    private Color color;
    private String ModelName;
    public double xPos;
    public double yPos;
    public enum Directions {
        SOUTH,
        NORTH,
        WEST,
        EAST
    }
    public Directions dir = Directions.NORTH;

    public int getNrDoors() {
        return nrDoors;
    }

    public void setNrDoors(int nbr) {
        nrDoors = nbr;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double power) {
        enginePower = power;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String name) {
        ModelName = name;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double getX() {
        return xPos;
    }

    public double getY() {
        return yPos;
    }

    public void setDir(Directions new_dir) {
        dir = new_dir;
    }

    public Directions getDir() {
        return dir;
    }

    public void move() {
        switch (getDir()) {
            case SOUTH:
                yPos = getY() - getCurrentSpeed();
                break;
            case EAST:
                turnRight();
                break;
            case WEST:
                turnLeft();
                break;
            default: // Default value is NORTH
                yPos = getY() + getCurrentSpeed();
        }
    }

    public void turnLeft() {
        xPos = getX() - getCurrentSpeed();
    }

    public void turnRight() {
        xPos = getX() + getCurrentSpeed();
    }
}

