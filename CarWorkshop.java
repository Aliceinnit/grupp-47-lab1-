package grupp47_lab1;

import java.util.ArrayList;
import java.util.Objects;

public class CarWorkshop<T extends Car> implements Storage<T>{
    private ArrayList<T> cars = new ArrayList();

    @Override
    public void loadCar(T car){
        if (cars.size() < 20 && !Objects.equals(car.getModelName(), "Scania")){
            cars.add(car);
        }
    }

    @Override
    public void unloadCar(){
        cars.removeLast();
    }

    public ArrayList<T> getCars() {
        return cars;
    }
}
