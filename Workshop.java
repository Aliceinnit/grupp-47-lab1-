package grupp47_lab1;

import java.util.Stack;

public interface Workshop {
    void loadCar(PersonCar car);
    void unloadCar();
    Stack<? extends PersonCar> getCars();
}
