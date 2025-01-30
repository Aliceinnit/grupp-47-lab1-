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
    private enum Directions {
        SOUTH,
        NORTH,
        WEST,
        EAST;
    }

    Directions dir;

    public Car() {
    }

    public int getNrDoors() {
        return this.nrDoors;
    }

    public void setNrDoors(int nbr) {
        this.nrDoors = nbr;
    }

    public double getEnginePower() {
        return this.enginePower;
    }

    public void setEnginePower(double power) {
        this.enginePower = power;
    }

    public String getModelName() {
        return this.ModelName;
    }

    public void setModelName(String name) {
        this.ModelName = name;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color clr) {
        this.color = clr;
    }

    public void startEngine() {
        this.currentSpeed = 0.1;
    }

    public void stopEngine() {
        this.currentSpeed = (double)0.0F;
    }

    public double getX() {
        return this.xPos;
    }

    public double getY() {
        return this.yPos;
    }

    public void move() {
        switch (dir) {
            case NORTH:
                this.yPos = this.getY() + this.getCurrentSpeed();
            case SOUTH:
                this.yPos = this.getY() - this.getCurrentSpeed();
            case EAST:
                this.turnRight();
            case WEST:
                this.turnLeft();
            default:
        }
    }

    public void turnLeft() {
        this.xPos = this.getX() + this.getCurrentSpeed();
    }

    public void turnRight() {
        this.xPos = this.getX() - this.getCurrentSpeed();
    }
}
