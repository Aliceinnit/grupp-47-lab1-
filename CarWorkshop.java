package grupp47_lab1;
import java.util.ArrayList;

import java.util.List;

public class CarWorkshop<T extends Car> implements Storage<T>{
    private ArrayList<T> storage = new ArrayList<>();

    @Override
    public void loadCar(T car) {
        if (storage.size() < 10){
            storage.add(car);
        }
    }

    @Override
    public void unloadCar() {
        if (!storage.isEmpty()){
            storage.removeLast();
        }

    }
}
