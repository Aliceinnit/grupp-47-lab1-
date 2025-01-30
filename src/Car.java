import java.awt.*;

public abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    public String ModelName; // The car model name ???
    private int x;
    private int y;
    private Direction direction;

    public enum Direction{
        North, South, East, West
    }

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
}