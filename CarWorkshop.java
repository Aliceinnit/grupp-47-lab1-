package grupp47_lab1;

import java.util.Stack;

public class CarWorkshop<T extends PersonCar> {
    private final Storage<T> storage = new Storage<>();

    public void loadCar(T car) {
        if (storage.getCars().size() < 20){
            storage.loadCar(car);
        }
    }

    public void unloadCar() {
        storage.unloadCar();
    }

    public Stack<T> getCars() {
        return storage.getCars();
    }
}
