package grupp47_lab1;

import java.util.Stack;

public class CarWorkshop<T extends Car> implements Storage<T>{
    private Stack<T> storage = new Stack<>();

    @Override
    public void loadCar(T car) {
        if (storage.size() < 20){
            storage.push(car);
        }
    }

    @Override
    public void unloadCar() {
        if (!storage.isEmpty()){
            storage.pop();
        }
    }

    @Override
    public Stack<T> getCars() {
        return storage;
    }
}
