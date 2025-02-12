package grupp47_lab1;

import java.util.ArrayList;

public interface Storage<T extends Car> {
    void loadCar(T car);

    void unloadCar();

    ArrayList<T> getCars();
}
