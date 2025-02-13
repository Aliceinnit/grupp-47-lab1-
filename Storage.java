package grupp47_lab1;

import java.util.ArrayList;
import java.util.Stack;

public class Storage<T extends PersonCar> {
    private final Stack<T> storage = new Stack<>();
    private T unloadedCar;
    void loadCar(T car) {
        storage.push(car);
        car.load();
    }

    void unloadCar() {
        if (!storage.isEmpty()) {
            unloadedCar = storage.pop();
            getUnloadedCar().unload();
        }
    }

    public T getUnloadedCar() {
        return unloadedCar;
    }

    public Stack<T> getCars() {
        return storage;
    }
}
