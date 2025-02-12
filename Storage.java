package grupp47_lab1;

import java.util.ArrayList;
import java.util.Stack;

public interface Storage<T extends Car> {
    void loadCar(T car);

    void unloadCar();

    Stack<T> getCars();
}
