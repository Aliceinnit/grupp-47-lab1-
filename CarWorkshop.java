package grupp47_lab1;
import java.util.Stack;

public class CarWorkshop<T extends PersonCar> implements Workshop{
    private final Storage<T> storage = new Storage<>();

    public void loadCar(PersonCar car) {
        if (car != null && storage.getCars().size() < 20){
            storage.loadCar((T) car);
        }
    }
    public void unloadCar() {
        storage.unloadCar();
    }

    public Stack<T> getCars() {
        return storage.getCars();
    }

}
