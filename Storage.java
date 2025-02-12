package grupp47_lab1;

public interface Storage<T extends Car> {
    void loadCar(T car);

    void unloadCar();

    void getCars();
}
