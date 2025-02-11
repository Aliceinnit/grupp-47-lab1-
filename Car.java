package grupp47_lab1;

import java.awt.Color;

public abstract class Car implements Movable {
    private final int nrDoors;
    private final double enginePower;
    private double currentSpeed;
    private final Color color;
    private final String ModelName;
    private double xPos;
    private double yPos;
    public enum Directions {
        NORTH(0),
        EAST(1),
        SOUTH(2),
        WEST(3);

        private int dirIndex;

        Directions(int dirIndex) {
            this.dirIndex = dirIndex;
        }

        public int getDirIndex() {
            return dirIndex;
        }
    }

    public Car(int doors, double power, Color clr, String name) {
        nrDoors = doors;
        enginePower = power;
        color = clr;
        ModelName = name;
    }

    private Directions dir = Directions.NORTH;


    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public String getModelName() {
        return ModelName;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
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

    protected void setPosition(double x, double y) {
        xPos = x;
        yPos = y;
    }

    public Directions getDir() {
        return dir;
    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount){
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    public void move() {
        switch (getDir()) {
            case SOUTH:
                yPos = getY() - getCurrentSpeed();
                break;
            case EAST:
                xPos = getX() + getCurrentSpeed();
                break;
            case WEST:
                xPos = getX() - getCurrentSpeed();
                break;
            default: // Default value is NORTH
                yPos = getY() + getCurrentSpeed();
        }
    }

    public void turnLeft(Directions dir) {
        dir = getDir();
        int newIndex = Math.floorMod(dir.getDirIndex()-1, 4);

        for (Directions d: Directions.values()) {
            if (d.getDirIndex() == newIndex) {
                this.dir = d;
            }
        }
    }

    public void turnRight(Directions dir) {
        dir = getDir();
        int newIndex = Math.floorMod(dir.getDirIndex()+1, 4);

        for (Directions d: Directions.values()) {
            if (d.getDirIndex() == newIndex) {
                this.dir = d;
            }
        }
    }
}
